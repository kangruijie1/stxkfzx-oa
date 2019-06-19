package xyz.stxkfzx.manager.face.service;

import xyz.stxkfzx.manager.common.pojo.FaceResult;

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
}
