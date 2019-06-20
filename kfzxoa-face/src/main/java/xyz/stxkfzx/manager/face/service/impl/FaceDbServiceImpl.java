package xyz.stxkfzx.manager.face.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.stxkfzx.manager.common.enums.GeneralEnum;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.activemq.producer.IMessageProducerService;
import xyz.stxkfzx.manager.face.ai.pojo.AiAddFaceBase;
import xyz.stxkfzx.manager.face.ai.pojo.AiSelAllUserIdBase;
import xyz.stxkfzx.manager.face.request.ReqAddFace;
import xyz.stxkfzx.manager.face.request.ReqSelAllUserId;
import xyz.stxkfzx.manager.face.service.FaceDbService;
import xyz.stxkfzx.manager.face.utils.Base64Util;
import xyz.stxkfzx.manager.user.pojo.TUser;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class FaceDbServiceImpl implements FaceDbService {

    @Autowired
    ReqSelAllUserId reqSelAllUserId;

    @Autowired
    ReqAddFace reqAddFace;

    @Resource
    private IMessageProducerService messageProducer;

    @Override
    public int getGroupLastUserId(String groupId) {
        AiSelAllUserIdBase base = reqSelAllUserId.req(groupId);
        List<Integer> list = base.getResult().getUser_id_list();
        Collections.sort(list);
        return Integer.valueOf(list.get(list.size() - 1)) + 1;
    }

    @Override
    public FaceResult addFace(String img, String departmentId, String username) {
        //获取图片编码
        String imgBase64 = Base64Util.subImgBase64(img);
        //获取该组最后一个用户id
        String userId = String.valueOf(getGroupLastUserId(departmentId));
        //请求添加
        AiAddFaceBase base = reqAddFace.req(imgBase64, departmentId, userId, username);
        //成功
        if (base.getError_code() == 0) {
            TUser user = new TUser();
            user.setUsername(username);
            user.setUserId(Integer.valueOf(userId));
            //发送消息通知user模块更新此用户的jobId
            messageProducer.addFaceSendMessage(user);
            return new FaceResult(GeneralEnum.SUCCESS);
        } else {
            FaceResult result = new FaceResult();
            result.setStatus(base.getError_code());
            result.setMsg(base.getError_msg());
            return result;
        }
    }
}
