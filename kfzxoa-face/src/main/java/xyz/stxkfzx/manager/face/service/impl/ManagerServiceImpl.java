package xyz.stxkfzx.manager.face.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.stxkfzx.manager.common.enums.UserEnum;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.ai.pojo.AiFaceUser;
import xyz.stxkfzx.manager.face.service.SignService;
import xyz.stxkfzx.manager.face.service.ManagerService;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Reference(version = "1.0.0")
	private UserService userService;
	@Autowired
	private SignService faceService;
	
	@Override
	public FaceResult mustSign(String user_info) {
		TUser tUser = userService.getTUserByUsername(user_info);
		if(tUser == null) {
			return new FaceResult(UserEnum.USERNAME_PASSWORD_IS_FALSE);
		}
		List<AiFaceUser> aiFaceUserList = new ArrayList<AiFaceUser>();
		AiFaceUser user = new AiFaceUser();
		user.setGroup_id(tUser.getDepartmentId());
		user.setUser_id(tUser.getJobId());
		user.setUser_info(tUser.getUsername());
		user.setScore(90);
		aiFaceUserList.add(user);
		FaceResult faceResult = faceService.sign(aiFaceUserList, null);
		return faceResult;
	}

}
