package xyz.stxkfzx.manager.face.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.stxkfzx.manager.common.enums.GeneralEnum;
import xyz.stxkfzx.manager.common.myException.OAException;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.activemq.producer.IMessageProducerService;
import xyz.stxkfzx.manager.face.ai.pojo.*;
import xyz.stxkfzx.manager.face.enums.FaceExceptionEnum;
import xyz.stxkfzx.manager.face.request.ReqAddFace;
import xyz.stxkfzx.manager.face.request.ReqSearchFaceDb;
import xyz.stxkfzx.manager.face.request.ReqSelAllUserId;
import xyz.stxkfzx.manager.face.service.FaceDbService;
import xyz.stxkfzx.manager.face.utils.Base64Util;
import xyz.stxkfzx.manager.face.utils.JsonUtils;
import xyz.stxkfzx.manager.user.pojo.TUser;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FaceDbServiceImpl implements FaceDbService {

    @Autowired
    ReqSelAllUserId reqSelAllUserId;

    @Autowired
    ReqAddFace reqAddFace;

    @Autowired
    ReqSearchFaceDb reqSearchFaceDb;

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
        //图片编码去头
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

    @Override
    public List<AiFaceUser> searchFaceDb(final String imgBase64) {
        List<AiFaceUser> resultList = new ArrayList<AiFaceUser>();

        // 远程搜索人脸库
        reqSearchFaceDb.setImgParm(imgBase64);
        String resultStr = reqSearchFaceDb.req();

        //转换结果集
        AiSearchBase searchResult = JsonUtils.jsonToPojo(resultStr, AiSearchBase.class);

        // 未检测到人脸，抛出异常
        if (searchResult.getError_code() == FaceExceptionEnum.NOT_CHECK_FACE.getErrorCode()) {
            throw new OAException(FaceExceptionEnum.NOT_CHECK_FACE.getErrorMsg());
        }

        // 返回结果中的人脸
        if (searchResult.getResult() != null) {
            List<AiFaceUserList> face_list = searchResult.getResult().getFace_list();
            for (AiFaceUserList face : face_list) {
                List<AiFaceUser> aiFaceUserList = face.getUser_list();
                resultList.addAll(aiFaceUserList);
            }
        }
        return resultList;
    }
}
