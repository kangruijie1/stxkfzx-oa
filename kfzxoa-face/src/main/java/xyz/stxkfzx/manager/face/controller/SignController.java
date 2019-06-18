package xyz.stxkfzx.manager.face.controller;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.ai.pojo.AiFaceUser;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.face.utils.Base64Util;

@RestController
public class SignController {
    @Autowired
    private SignService signService;

    @RequestMapping({"/sign/multi"})
    public FaceResult searchMulti(@RequestParam("imgBase64") String imgBase64) {
        //去头
        imgBase64 = Base64Util.subImgBase64(imgBase64);
        //识别人脸
        List<AiFaceUser> userList = signService.searchFaceDb(imgBase64);
        // 插入打卡记录
        FaceResult result = signService.sign(userList, imgBase64);

        return result;
    }
}
