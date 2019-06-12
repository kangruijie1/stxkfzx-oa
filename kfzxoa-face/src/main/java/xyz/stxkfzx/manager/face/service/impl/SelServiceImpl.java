package xyz.stxkfzx.manager.face.service.impl;

import xyz.stxkfzx.manager.face.service.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import xyz.stxkfzx.manager.face.mapper.*;
import xyz.stxkfzx.manager.face.utils.*;
import java.sql.*;
import java.text.*;
import xyz.stxkfzx.manager.face.faceDbOperation.*;
import java.util.*;
import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.face.pojo.TSignItem;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@Service
public class SelServiceImpl implements SelService {
	@Autowired
	private SignItemMapper signItemMapper;
	@Autowired
	private UserService userService;

	@Override
	public List<SignItemResult> selDepartmentSignItem(int week, String group_id) throws ParseException {
		List<SignItemResult> signItemResultList = new ArrayList<SignItemResult>();
		TUser userTemp = new TUser();
		userTemp.setDepartmentId(group_id);
		List<TUser> userList = userService.getTUsersByGroupId(group_id);
		for (TUser user : userList) {
			SignItemResult itemResult = new SignItemResult();
			itemResult.setUser_info(user.getUsername());
			// 获取此周的起始和结束日期
			List<String> weekStartEndDate = (List<String>) GetWeek.getWeekStartEndDate(week);
			String todayStart = String.valueOf(weekStartEndDate.get(0)) + " 00:00:00.000";
			String todayEnd = String.valueOf(weekStartEndDate.get(1)) + " 23:59:59.999";
			// 查询该用户本周的签到记录
			int id = user.getUserId();
			List<TSignItem> signItems = this.signItemMapper.selSignItem(id, todayStart, todayEnd);
			Map<String, Object> weekMap = new HashMap<String, Object>();
			for (int i = 1; i < 8; ++i) {
				weekMap.put("week" + Integer.toString(i), 0.0);
			}
			if (signItems.size() != 0 && signItems != null) {
				double interval = 0.0;
				for (TSignItem signItem : signItems) {
					Timestamp signin = signItem.getSignin();
					String todayStr = signin.toString().split(" ")[0];
					int weekTemp = GetWeek.getWeekNumber(todayStr);
					long signTime = signItem.getSignin().getTime();
					long signouTime = 0L;
					if (signItem.getSignout() != null) {
						signouTime = signItem.getSignout().getTime();
						Double intervalDouble = Double.valueOf(signouTime - signTime);
						interval = intervalDouble / 3600000.0;
						String key = "week" + Integer.toString(weekTemp);
						if (weekMap.get(key) != null) {
							Double total = Double.valueOf(interval + ((Double) weekMap.get(key)).doubleValue());
							total = Math.round(total * 10.0) / 10.0;
							weekMap.put(key, total);
						} else {
							weekMap.put(key, Math.round(interval * 10.0) / 10.0);
						}
					}
				}
				for (int i = 1; i < 8; ++i) {
					if (((Double) weekMap.get("week" + Integer.toString(i))).doubleValue() == 0.0D) {
						weekMap.put("week" + Integer.toString(i), 0);
					}
				}
			}
			itemResult.setWeekMap(weekMap);
			signItemResultList.add(itemResult);
		}
		return signItemResultList;
	}

	@Override
	public List<TUser> getAllUsers() throws InterruptedException {
		List<TUser> userList = new ArrayList<TUser>();
		TUser user = new TUser();
		Groups groups = GetGroups.get();
		List<String> list = groups.getResult().getGroup_id_list();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String group_id : list) {
			Thread.sleep(500L);
			Group users = GetGroup.getUsers(group_id);
			List<String> user_id_list = users.getResult().getUser_id_list();
			map.put(group_id, user_id_list.size());
		}
		Set<String> keySet = map.keySet();
		for (String group_id2 : keySet) {
			Integer user_count = map.get(group_id2);
			for (int i = 1; i <= user_count; ++i) {
				Thread.sleep(500L);
				FaceUserResultUserList faceUserResultUserList = FaceUserInfo.get(group_id2, Integer.toString(i));
				user.setJobId(Integer.toString(i));
				String user_info = faceUserResultUserList.getResult().getUser_list().get(0).getUser_info();
				user.setDepartmentId(group_id2);
				user.setUsername(user_info);
				userList.add(user);
				System.out.println(user);
			}
		}
		return null;
	}

	@Override
	public void selFaceGroupInsertUsers(String group_id) throws InterruptedException {
		Group group = GetGroup.getUsers(group_id);
		List<String> user_id_list = group.getResult().getUser_id_list();
		for (final String user_id : user_id_list) {
			TUser user = new TUser();
			Thread.sleep(500L);
			FaceUserResultUserList faceUserResultUserList = FaceUserInfo.get(group_id, user_id);
			String user_info = faceUserResultUserList.getResult().getUser_list().get(0).getUser_info();
			user.setDepartmentId(group_id);
			user.setJobId(user_id);
			user.setUsername(user_info);
			userService.addUser(user);
		}
	}

	@Override
	public List<Map<String, String>> exportInfo(int week, String group_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void groupUsers(String group_id) {
		Group users = GetGroup.getUsers(group_id);
		List<String> user_id_list = users.getResult().getUser_id_list();
		List<TUser> userList = new ArrayList<TUser>();
		for (int i = 1; i <= user_id_list.size(); ++i) {
			TUser user = new TUser();
			try {
				Thread.sleep(500L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			FaceUserResultUserList faceUserResultUserList = FaceUserInfo.get(group_id, Integer.toString(i));
			user.setJobId(Integer.toString(i));
			String user_info = faceUserResultUserList.getResult().getUser_list().get(0).getUser_info();
			user.setDepartmentId(group_id);
			user.setUsername(user_info);
			userList.add(user);
		}
		for (TUser user : userList) {
			System.out.println(user);
			
		}
	}
}
