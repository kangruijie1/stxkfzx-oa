package xyz.stxkfzx.manager.face.controller;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class JudgeController {
	@Autowired
	private JudgeService judgeService;

	@RequestMapping({ "/judge/ip" })
	public FaceResult judgeIp(String ip) {
	    FaceResult faceResult = judgeService.judgeIp(ip);
		return faceResult;
	}
}
