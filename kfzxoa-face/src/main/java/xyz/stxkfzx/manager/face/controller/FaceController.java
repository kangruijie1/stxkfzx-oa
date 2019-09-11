package xyz.stxkfzx.manager.face.controller;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.ai.pojo.AiFaceUser;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.face.utils.Base64Util;

@RestController
public class FaceController {
    @Autowired
    private SignService signService;
    @Autowired
    private FaceDbService faceDbService;

    @RequestMapping({"user/search/face/multi"})
    public FaceResult searchMulti(@RequestParam("imgBase64") String imgBase64) {
        //去头
        imgBase64 = Base64Util.subImgBase64(imgBase64);
        //识别人脸
        List<AiFaceUser> userList = faceDbService.searchFaceDb(imgBase64);
        // 插入打卡记录
        FaceResult result = signService.sign(userList, imgBase64);

        return result;
    }

    @PostMapping("user/add/face")
    public FaceResult addFace(@RequestParam("imgBase64") String imgBase64,
                              @RequestParam("departmentId") String departmentId,
                              @RequestParam("username") String username){
        return faceDbService.addFace(imgBase64, departmentId, username);
    }


}
