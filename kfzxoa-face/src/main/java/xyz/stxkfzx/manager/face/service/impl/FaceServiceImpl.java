package xyz.stxkfzx.manager.face.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.besjon.pojo.AiBase;
import com.besjon.pojo.AiFaceUser;
import com.besjon.pojo.AiFaceUserList;
import xyz.stxkfzx.manager.common.enums.SignEnum;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.stereotype.*;

import org.springframework.beans.factory.annotation.*;
import xyz.stxkfzx.manager.face.mapper.*;

import java.util.*;
import java.sql.*;

import xyz.stxkfzx.manager.face.utils.*;
import xyz.stxkfzx.manager.face.pojo.TSignItem;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@Service
public class FaceServiceImpl implements FaceService {
    @Reference(version = "1.0.0")
    private UserService userService;
    @Autowired
    private SignItemMapper signItemMapper;

    @Override
    public List<AiFaceUser> searchMulti(final String imgBase64) {
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

            AiBase searchResult = (AiBase) JsonUtils.jsonToPojo(resultStr, AiBase.class);
            List<AiFaceUser> resultList = new ArrayList<AiFaceUser>();
            if (searchResult.getAiResult() != null) {
                List<AiFaceUserList> face_list = searchResult.getAiResult().getFace_list();
                for (AiFaceUserList face : face_list) {
                    List<AiFaceUser> aiFaceUserList = face.getFace_list();
                    resultList.addAll(aiFaceUserList);
                }
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public FaceResult sign(List<AiFaceUser> userList, String imgBase64) {
        FaceResult result = new FaceResult();
        List<FaceResult> resultDataList = new ArrayList<FaceResult>();
        // 获取今天的日期
        String todayStart = GetWeek.getTodayStartDate();
        String todayEnd = GetWeek.getTodayEndDate();
        // 如果有搜索结果
        if (userList != null && userList.size() != 0) {
            // 遍历搜索结果
            for (AiFaceUser aiFaceUser : userList) {
                // 人脸识别打分低于80分判定为找不到此人
                if (Double.valueOf(aiFaceUser.getScore()) <= 80.0) {
                    FaceResult faceResult = new FaceResult(SignEnum.NOT_INPUT_FACE);
                    resultDataList.add(faceResult);
                }
                // 否则判定为识别出此用户
                else {
                    // 获取此用户名查询出用户id
                    String user_info = aiFaceUser.getUser_info();
                    TUser user = userService.getTUserByUserInfo(user_info);
                    int id = user.getUserId();
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
                        FaceResult faceResult = new FaceResult(user_info, SignEnum.SIGN_IN_SUCCESS);
                        resultDataList.add(faceResult);

                    }
                    // 否则为下班,在最后一条打卡记录更新下班时间
                    else {
                        TSignItem item = new TSignItem();
                        item.setUid(id);
                        item.setSignout_img(imgBase64);
                        item.setSignout(new Timestamp(System.currentTimeMillis()));
                        signItemMapper.updateSignItem(item, todayStart, todayEnd);
                        FaceResult faceResult = new FaceResult(user_info, SignEnum.SIGN_OUT_SUCCESS);
                        resultDataList.add(faceResult);
                    }
                }
            }
            result.ok(resultDataList);
            return result;
        }
        // 没有搜索结果
        result.fail();
        return result;
    }
}
