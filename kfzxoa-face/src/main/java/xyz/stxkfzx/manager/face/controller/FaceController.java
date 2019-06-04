package xyz.stxkfzx.manager.face.controller;

import org.springframework.stereotype.*;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import java.io.*;
import org.springframework.web.bind.annotation.*;

import com.besjon.pojo.User_list;

import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.user.pojo.TUser;

import java.net.*;

@Controller
public class FaceController {
	@Autowired
	private FaceService faceService;

	@RequestMapping({ "/sign/multi" })
	@ResponseBody
	public FaceResult searchMulti(String imgBase64)
			throws UnsupportedEncodingException, FileNotFoundException {
		imgBase64 = imgBase64.substring(imgBase64.indexOf(44) + 1);
		List<User_list> userList = faceService.searchMulti(imgBase64);
		FaceResult result = faceService.sign(userList, imgBase64);
		System.out.println(result.toString());
		return result;
	}

	@RequestMapping({ "/face/batch/add" })
	@ResponseBody
	public List<TUser> betchAddFace(final String path) throws UnsupportedEncodingException {
		final String decode = URLDecoder.decode(path, "utf-8");
		System.out.println(decode);
		final List<TUser> failUserList = (List<TUser>) this.faceService.batchAddFace(decode);
		return failUserList;
	}
}
