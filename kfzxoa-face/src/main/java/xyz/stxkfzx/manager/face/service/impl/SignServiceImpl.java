package xyz.stxkfzx.manager.face.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import xyz.stxkfzx.manager.auth.enums.AuthEnum;
import xyz.stxkfzx.manager.common.enums.SignEnum;
import xyz.stxkfzx.manager.common.enums.WorkingEnum;
import xyz.stxkfzx.manager.common.myException.OAException;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.ai.pojo.AiSearchBase;
import xyz.stxkfzx.manager.face.ai.pojo.AiFaceUser;
import xyz.stxkfzx.manager.face.ai.pojo.AiFaceUserList;
import xyz.stxkfzx.manager.face.enums.FaceExceptionEnum;
import xyz.stxkfzx.manager.face.enums.ImgEnum;
import xyz.stxkfzx.manager.face.pojo.TSignItemImg;
import xyz.stxkfzx.manager.face.pojo.TSignItemNew;
import xyz.stxkfzx.manager.face.request.ReqSearchFaceDb;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.stereotype.*;

import org.springframework.beans.factory.annotation.*;
import xyz.stxkfzx.manager.face.mapper.*;

import java.util.*;

import xyz.stxkfzx.manager.face.utils.*;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@Service
public class SignServiceImpl implements SignService {
    private final Logger logger = LoggerFactory.getLogger(SignServiceImpl.class);
    @Reference
    private UserService userService;
    @Autowired
    private SignItemMapper signItemMapper;
    @Autowired
    private SignItemImgMapper signItemImgMapper;
    @Autowired
    ReqSearchFaceDb reqSearchFaceDb;

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

    @Override
    public FaceResult sign(List<AiFaceUser> userList, String imgBase64) {
        FaceResult result = new FaceResult();
        List<FaceResult> resultDataList = new ArrayList<FaceResult>();
        // 获取今天的日期
        String todayStart = GetWeek.getTodayStartDate();
        String todayEnd = GetWeek.getTodayEndDate();
        // 因为在搜索人脸库方法中就已经做了未搜索到人脸的处理，
        // 所以userList一定不为空，
        // 遍历搜索结果
        for (AiFaceUser aiFaceUser : userList) {
            // 人脸识别打分低于80分判定为找不到此人
            if (aiFaceUser.getScore() <= 80.0) {
                FaceResult faceResult = new FaceResult(SignEnum.NOT_INPUT_FACE);
                resultDataList.add(faceResult);
            }
            // 否则判定为识别出此用户
            else {
                // 获取此用户名查询出用户id
                String username = aiFaceUser.getUser_info();
                TUser user = userService.getTUserByUsername(username);
                if (!user.getStatus().equals(WorkingEnum.IN_THE_DEPARTMENT.getWorkingStatusCode())){
                    logger.error("用户已退部或者未激活");
                    FaceResult faceResult = new FaceResult();
                    faceResult.setData(username);
                    faceResult.setMsg(AuthEnum.USER_NOT_IN_DEPARTMENT.getMsg());
                    faceResult.setStatus(AuthEnum.USER_NOT_IN_DEPARTMENT.getCode());
                    resultDataList.add(faceResult);
                    continue;
                }
                int id = user.getUserId();
                // 查该用户今天打卡记录
                List<TSignItemNew> signItems = signItemMapper.selSignItemNew(id, todayStart, todayEnd);
                // 如果用户今天未打卡或者最后一条打卡记录下班时间不为空，则新增一条打卡记录，为上班
                if (CollectionUtils.isEmpty(signItems)
                        || signItems.get(signItems.size() - 1).getSignOutTime() != null) {
                    //设置签到记录属性
                    TSignItemNew item = new TSignItemNew();
                    item.setUserId(id);
                    item.setSignOutTime(GetWeek.getCurrentTime());
                    //插入图片
                    TSignItemImg signItemImg = new TSignItemImg(id, ImgEnum.SIGN_IN.getSignItemType(), imgBase64);
                    // 返回图片id
                    int execute = signItemImgMapper.insertSignItemImg(signItemImg);
                    item.setSignInImgId(signItemImg.getSignItemImgId());
                    item.setSignOutImgId(0);
                    int i = signItemMapper.insertSignItem(item);
                    if(i != 0){
                        FaceResult faceResult = new FaceResult(username, SignEnum.SIGN_IN_SUCCESS);
                        resultDataList.add(faceResult);
                    }else{
                        throw new OAException("插入上班记录失败");
                    }

                }
                // 否则为下班,在最后一条打卡记录更新下班时间
                else {
                    TSignItemNew item = new TSignItemNew();
                    item.setUserId(id);
                    item.setSignOutTime(GetWeek.getCurrentTime());
                    //插入图片
                    TSignItemImg signItemImg = new TSignItemImg(id, ImgEnum.SIGN_OUT.getSignItemType(), imgBase64);
                    // 返回图片id
                    int execute = signItemImgMapper.insertSignItemImg(signItemImg);
                    item.setSignOutImgId(signItemImg.getSignItemImgId());
                    int i = signItemMapper.updateSignItem(item, todayStart, todayEnd);
                    if(i != 0){
                        FaceResult faceResult = new FaceResult(username, SignEnum.SIGN_OUT_SUCCESS);
                        resultDataList.add(faceResult);
                    }else{
                        throw new OAException("更新下班记录失败");
                    }
                }
            }
        }
        result.ok(resultDataList);
        return result;
    }
}
