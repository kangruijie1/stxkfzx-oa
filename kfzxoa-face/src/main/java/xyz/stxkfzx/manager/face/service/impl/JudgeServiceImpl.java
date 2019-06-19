package xyz.stxkfzx.manager.face.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.stxkfzx.manager.common.enums.GeneralEnum;
import xyz.stxkfzx.manager.common.enums.SignEnum;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.config.IsKfzxIpConfig;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.stereotype.*;


@Service
public class JudgeServiceImpl implements JudgeService{
    @Autowired
    IsKfzxIpConfig isKfzxIpConfig;
    @Override
    public FaceResult judgeIp(String ip) {
        ip = ip.substring(0, ip.lastIndexOf("."));
        if (isKfzxIpConfig.getList().contains(ip)){
            return new FaceResult(GeneralEnum.SUCCESS);
        }else{
            return new FaceResult(SignEnum.SITE_NOT_IN_KFZX);
        }
    }
}
