package xyz.stxkfzx.manager.face.service.impl;

import xyz.stxkfzx.manager.common.contants.SignContants;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.stereotype.*;


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
