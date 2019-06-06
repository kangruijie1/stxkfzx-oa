package xyz.stxkfzx.manager.face.controller;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.service.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping({ "/manager/xiaotiantian/sign" })
	public FaceResult smallSweet(String user_info) throws InterruptedException {
		return managerService.mustSign(user_info);
	}
}
