package xyz.stxkfzx.manager.face.controller;

import org.springframework.stereotype.*;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.beans.factory.annotation.*;
import xyz.stxkfzx.manager.face.pojo.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class JudgeController {
	@Autowired
	private JudgeService judgeService;

	@RequestMapping({ "/judge/ip" })
	@ResponseBody
	public FaceResult judgeIp(String ip) {
	    FaceResult faceResult = judgeService.judgeIp(ip);
		return faceResult;
	}
}
