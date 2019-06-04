package xyz.stxkfzx.manager.face.controller;

import org.springframework.stereotype.*;

import xyz.stxkfzx.manager.face.pojo.FaceResult;
import xyz.stxkfzx.manager.face.service.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping({ "/manager/xiaotiantian/sign" })
	@ResponseBody
	public FaceResult smallSweet(String user_info) throws InterruptedException {
		System.out.println(user_info);
		return managerService.mustSign(user_info);
	}
}
