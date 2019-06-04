package xyz.stxkfzx.manager.face.service.impl;

import xyz.stxkfzx.manager.face.service.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.*;

import xyz.stxkfzx.manager.face.constant.SignContants;
import xyz.stxkfzx.manager.face.mapper.*;
import xyz.stxkfzx.manager.face.utils.*;
import xyz.stxkfzx.manager.face.pojo.*;
import java.util.*;

@Service
public class JudgeServiceImpl implements JudgeService{
    @Override
    public FaceResult judgeIp(String ip) {
        ip = ip.substring(0, ip.lastIndexOf("."));
       /* if (ip.equals("10.0.0") || ip.equals("59.48.111") 
        		|| ip.equals("10.10.15") || ip.equals("192.168.199")
        		|| ip.equals("10.0.1")) {*/
            return new FaceResult(SignContants.SUCCESS, "验证成功");
       /* }
        return new FaceResult(SignContants.FAIL, "请在指定地点签到！");*/
    }
}
