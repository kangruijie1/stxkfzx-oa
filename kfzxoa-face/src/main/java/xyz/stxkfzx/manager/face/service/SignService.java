package xyz.stxkfzx.manager.face.service;

import java.util.*;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.ai.pojo.AiFaceUser;

public interface SignService
{
    /**
     * 搜索人脸库
     * @param imgBase64 图片编码
     * @return 识别出的人脸结果集
     */
    List<AiFaceUser> searchFaceDb(String imgBase64);

    /**
     * 打卡
     * @param userList 人脸集
     * @param imgBase64 图片编码
     * @return 统一结果
     */
    FaceResult sign(List<AiFaceUser> userList,String imgBase64);
}
