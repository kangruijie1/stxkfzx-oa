package xyz.stxkfzx.manager.face.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import xyz.stxkfzx.manager.face.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@RestController
public class TestController {
	@Autowired
	private FaceService faceService;
	@Autowired
	private SelSignService selSignService;
	@Reference
	UserService userService;

	@GetMapping({ "/sel/groupUsers" })
	public void groupUsers(String group_id) throws InterruptedException {
		selSignService.groupUsers(group_id);
	}

	@RequestMapping({ "/sel/all" })
	public void group() {
		List<TUser> allTUser = userService.getAllTUser();
		System.out.println(allTUser.toString());
	}
}
