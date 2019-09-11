package xyz.stxkfzx.manager.face.service;

import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.ai.pojo.AiFaceUser;

import java.util.List;

public interface FaceDbService {
    /**
     * 获取该人脸组添加人脸的userId参数
     * @param groupId 组id
     * @return userId参数
     */
    int getGroupLastUserId(String groupId);

    /**
     * 添加人脸
      * @param img 图片base64编码
     * @param departmentId 部门名称
     * @param username 用户名
     * @return 结果
     */
    FaceResult addFace(String img, String departmentId, String username);

    /**
     * 搜索人脸库
     * @param imgBase64 图片编码
     * @return 识别出的人脸结果集
     */
    List<AiFaceUser> searchFaceDb(String imgBase64);
}
