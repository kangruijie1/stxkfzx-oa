package xyz.stxkfzx.manager.face.controller;

import org.springframework.stereotype.*;

import xyz.stxkfzx.manager.face.service.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.user.pojo.TUser;

@Controller
public class TestController {
	@Autowired
	private FaceService faceService;
	@Autowired
	private SelService selService;

	@RequestMapping({ "/test" })
	@ResponseBody
	public void test() throws InterruptedException, UnsupportedEncodingException {
		List<TUser> batchAddFace = faceService.batchAddFace("F:\\0802");
		System.out.println(batchAddFace.toString());
	}

	@RequestMapping({ "/sel/groupUsers" })
	@ResponseBody
	public void groupUsers(String group_id) throws InterruptedException {
		selService.groupUsers(group_id);
	}
}
