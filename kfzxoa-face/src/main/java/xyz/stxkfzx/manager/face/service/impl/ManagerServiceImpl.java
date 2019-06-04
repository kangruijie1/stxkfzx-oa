package xyz.stxkfzx.manager.face.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.besjon.pojo.User_list;

import xyz.stxkfzx.manager.face.constant.SignContants;
import xyz.stxkfzx.manager.face.pojo.FaceResult;
import xyz.stxkfzx.manager.face.service.FaceService;
import xyz.stxkfzx.manager.face.service.ManagerService;
import xyz.stxkfzx.manager.user.mapper.UserMapper;
import xyz.stxkfzx.manager.user.pojo.TUser;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private FaceService faceService;
	
	@Override
	public FaceResult mustSign(String user_info) {
		TUser tUser = new TUser();
		tUser.setUser_info(user_info);
		List<TUser> selectUser = userMapper.selectUser(tUser);
		if(selectUser.size() == 0 || selectUser == null) {
			return new FaceResult(SignContants.FAIL, "请输入正确的用户名！");
		}
		tUser = selectUser.get(0);
		List<User_list> user_list = new ArrayList<User_list>();
		User_list user = new User_list();
		user.setGroup_id(tUser.getGroup_id());
		user.setUser_id(tUser.getUser_id());
		user.setUser_info(tUser.getUser_info());
		user.setScore(90);
		user_list.add(user);
		FaceResult faceResult = faceService.sign(user_list, null);
		return faceResult;
	}

}
