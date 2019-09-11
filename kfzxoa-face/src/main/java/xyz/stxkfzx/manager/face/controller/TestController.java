package xyz.stxkfzx.manager.face.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@RestController
public class TestController {
	@Autowired
	private SignService faceService;
	@Autowired
	private SelSignService selSignService;
	@Reference
	UserService userService;

	@RequestMapping({ "/sel/all" })
	public FaceResult group() {
		List<TUser> allTUser = userService.getAllTUser();
		return new FaceResult().ok(allTUser);
	}

}
