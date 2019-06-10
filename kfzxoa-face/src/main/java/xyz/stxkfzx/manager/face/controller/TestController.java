package xyz.stxkfzx.manager.face.controller;

import org.springframework.stereotype.*;

import xyz.stxkfzx.manager.face.service.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.user.pojo.TUser;

@RestController
public class TestController {
	@Autowired
	private FaceService faceService;
	@Autowired
	private SelService selService;

	@RequestMapping({ "/sel/groupUsers" })
	public void groupUsers(String group_id) throws InterruptedException {
		selService.groupUsers(group_id);
	}
}
