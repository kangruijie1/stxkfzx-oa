package xyz.stxkfzx.manager.face.service.impl;

import xyz.stxkfzx.manager.face.service.*;
import org.springframework.stereotype.*;

import com.besjon.pojo.Face_list;
import com.besjon.pojo.JsonRootBean;
import com.besjon.pojo.User_list;

import org.springframework.beans.factory.annotation.*;
import xyz.stxkfzx.manager.face.mapper.*;
import java.util.*;
import java.sql.*;
import xyz.stxkfzx.manager.face.utils.*;
import xyz.stxkfzx.manager.face.constant.SignContants;
import xyz.stxkfzx.manager.face.faceDbOperation.*;
import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.user.mapper.UserMapper;
import xyz.stxkfzx.manager.user.pojo.TSignItem;
import xyz.stxkfzx.manager.user.pojo.TUser;

import java.io.*;

@Service
public class FaceServiceImpl implements FaceService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SignItemMapper signItemMapper;

	@Override
	public List<User_list> searchMulti(final String imgBase64) {
		final String url = "https://aip.baidubce.com/rest/2.0/face/v3/multi-search";
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", imgBase64);
			map.put("liveness_control", "NORMAL");
			map.put("group_id_list", "0601,0602,0701,0702,0703,0801,0802,0803");
			map.put("max_face_num", 10);
			map.put("image_type", "BASE64");
			map.put("quality_control", "LOW");
			String param = GsonUtils.toJson((Object) map);
			String resultStr = HttpUtil.post(url, GetAccessToken.getAuth(), "application/json", param);

			JsonRootBean searchResult = (JsonRootBean) JsonUtils.jsonToPojo(resultStr, JsonRootBean.class);
			List<User_list> resultList = new ArrayList<User_list>();
			if (searchResult.getResult() != null) {
				List<Face_list> face_list = searchResult.getResult().getFace_list();
				for (Face_list face : face_list) {
					List<User_list> user_list = face.getUser_list();
					resultList.addAll(user_list);
				}
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public FaceResult sign(List<User_list> userList, String imgBase64) {
		FaceResult result = new FaceResult();
		List<FaceResult> resultDataList = new ArrayList<FaceResult>();
		// 获取今天的日期
		String todayStart = GetWeek.getTodayStartDate();
		String todayEnd = GetWeek.getTodayEndDate();
		// 如果有搜索结果
		if (userList != null && userList.size() != 0) {
			// 遍历搜索结果
			for (User_list faceUser : userList) {
				// 人脸识别打分低于80分判定为找不到此人
				if (Double.valueOf(faceUser.getScore()) <= 80.0) {
					FaceResult faceResult = new FaceResult();
					faceResult.setMsg("请先录入人脸库！");
					faceResult.setStatus(SignContants.NOT_INPUT_FACE);
					resultDataList.add(faceResult);
				}
				// 否则判定为识别出此用户
				else {
					// 获取此用户名查询出用户id
					String user_info = faceUser.getUser_info();
					TUser user = new TUser();
					user.setUser_info(user_info);
					user = this.userMapper.selectUser(user).get(0);
					int id = user.getId();
					// 查该用户今天打卡记录
					List<TSignItem> signItems = signItemMapper.selSignItem(id, todayStart, todayEnd);
					// 如果用户今天未打卡或者打卡次数为单数，则新增一条打卡记录，为上班
					if (signItems == null || signItems.size() == 0
							|| signItems.get(signItems.size() - 1).getSignout() != null) {
						// 用户今天没有签到记录，插入签到记录
						TSignItem item = new TSignItem();
						item.setUid(id);
						item.setSignin_img(imgBase64);
						item.setSignin(GetWeek.getTodayTime());
						signItemMapper.insertSignItem(item);
						FaceResult faceResult = new FaceResult();
						faceResult.setData(user_info);
						faceResult.setMsg("打卡(上班)成功！");
						faceResult.setStatus(SignContants.SIGN_SUCCESS);
						resultDataList.add(faceResult);

					}
					// 否则为下班,在最后一条打卡记录更新下班时间
					else {
						TSignItem item = new TSignItem();
						item.setUid(id);
						item.setSignout_img(imgBase64);
						item.setSignout(new Timestamp(System.currentTimeMillis()));
						signItemMapper.updateSignItem(item, todayStart, todayEnd);
						FaceResult faceResult = new FaceResult();
						faceResult.setData(user_info);
						faceResult.setMsg("打卡(下班)成功！");
						faceResult.setStatus(SignContants.SIGN_SUCCESS);
						resultDataList.add(faceResult);
					}
				}
			}
			result.setMsg("成功");
			result.setStatus(SignContants.SUCCESS);
			result.setData(resultDataList);
			return result;
		}
		// 没有搜索结果
		result.setMsg("未检测到人脸");
		result.setStatus(SignContants.NO_FACE_DETECTED);
		return result;
	}

	@Override
	public List<TUser> batchAddFace(final String path) throws UnsupportedEncodingException {
		final List<TUser> failUserList = new ArrayList<TUser>();
		final File dir = new File(path);
		final String group_id = dir.getName();
		final File[] listFiles = dir.listFiles();
		int index = 1;
		final TUser user = new TUser();
		File[] array;
		for (int length = (array = listFiles).length, i = 0; i < length; ++i) {
			final File imageFile = array[i];
			if (!imageFile.isHidden()) {
				final String imgBase64 = Base64Util.getImgBase64(imageFile.getPath());
				final String user_id = Integer.toString(index++);
				String user_info = imageFile.getName();
				user_info = user_info.substring(0, user_info.lastIndexOf("."));
				final FaceAddResult faceAddResult = FaceAdd.add(imgBase64, group_id, user_id, user_info);
				user.setGroup_id(group_id);
				user.setUser_id(user_id);
				user.setUser_info(user_info);
				if ("0".equals(faceAddResult.getError_code())) {
					this.userMapper.insertUser(user);
					System.out.println(
							"-" + group_id + "-" + user_id + "-" + user_info + "\u6dfb\u52a0\u6210\u529f\uff01");
				}
				if ("222304".equals(faceAddResult.getError_code())) {
					System.out.println("-" + group_id + "-" + user_id + "-" + user_info
							+ "\u6dfb\u52a0\u5931\u8d25\uff0c\u8bf7\u622a\u56fe\u540e\u91cd\u65b0\u6dfb\u52a0");
					failUserList.add(user);
				}
			}
		}
		return failUserList;
	}
}
