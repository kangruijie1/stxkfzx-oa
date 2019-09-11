package xyz.stxkfzx.manager.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import xyz.stxkfzx.manager.auth.utils.CodecUtils;
import xyz.stxkfzx.manager.common.enums.UserEnum;
import xyz.stxkfzx.manager.common.enums.WorkingEnum;
import xyz.stxkfzx.manager.common.myException.OAException;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.common.utils.CopyColletion;
import xyz.stxkfzx.manager.user.enums.ManagerEnum;
import xyz.stxkfzx.manager.user.mapper.UserMapper;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;
import xyz.stxkfzx.manager.user.vo.GetAllUserRes;
import xyz.stxkfzx.manager.user.vo.TUserVO;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Value("${image.pre.url}")
    private String imgPreUrl;

    @Value("service.department")
    private String departmentStr;

    @Override
    public List<TUser> getTUsersByDepartmentId(String departmentId) {
        TUser user = new TUser();
        user.setDepartmentId(departmentId);
        List<TUser> tUsers = userMapper.selectUser(user);
        return tUsers;
    }

    @Override
    public TUser getTUserByUsername(String username) {
        TUser user = new TUser();
        user.setUsername(username);
        List<TUser> tUsers = userMapper.selectUser(user);
        if (!CollectionUtils.isEmpty(tUsers)) {
            return tUsers.get(0);
        }
        return null;
    }

    @Override
    public TUser getTUserByUserId(Integer userId) {
        TUser user = new TUser();
        user.setUserId(userId);
        List<TUser> tUsers = userMapper.selectUser(user);
        if(!CollectionUtils.isEmpty(tUsers)){
            return tUsers.get(0);
        }else{
            throw new OAException(UserEnum.USER_NOT_EXIST.getMsg());
        }
    }

    @Override
    public FaceResult addUser(TUser user) {
        logger.info("用户{}开始注册", user);
        // 防止用户自定义id
        user.setUserId(null);
        if (checkUsernameIsRepeat(user.getUsername())) {
            logger.info("用户名重复");
            return new FaceResult(UserEnum.USERNAME_REPEAT);
        }

        // 生成一段盐值
        String salt = CodecUtils.generateSalt(user.getUsername());

        // 对密码进行加密
        user.setPassword(CodecUtils.md5HexM(user.getPassword(), salt));

        //刚注册默认不激活
        user.setStatus(WorkingEnum.NOT_ACTIVE.getWorkingStatusCode());

        //刚注册默认为学员
        user.setManagerType(ManagerEnum.STUDENT.getManagerCode());

        //设置头像
        String iconUrl = imgPreUrl + "/" + user.getDepartmentId() + "/" + user.getUsername() + ".jpg";
        user.setIconUrl(iconUrl);

        int i = userMapper.insertUser(user);
        if (i != 1) {
            logger.info("插入用户失败");
            return new FaceResult(UserEnum.INSERT_USER_FAIL);
        }

        TUserVO userVO = new TUserVO();
        BeanUtils.copyProperties(user, userVO);

        logger.info("用户{}注册成功", user);

        return new FaceResult().ok(userVO);
    }

    @Override
    public List<GetAllUserRes> getAllTUser() {
        List<GetAllUserRes> resList = new ArrayList<>();
        String[] departments = departmentStr.split(",");
        for(String department : departments){
            GetAllUserRes res = new GetAllUserRes();
            res.setDepartment(department);
            TUser tUser = new TUser();
            tUser.setDepartmentId(department);
            List<TUser> tUsers = userMapper.selectUser(tUser);
            List<TUserVO> vos = CopyColletion.copyList(tUsers);
            res.setUserVOS(vos);

            resList.add(res);
        }

        return resList;
    }

    @Override
    public Boolean checkUsernameIsRepeat(String username) {
        TUser user = new TUser();
        user.setUsername(username);
        return !CollectionUtils.isEmpty(userMapper.selectUser(user));
    }


    @Override
    public FaceResult updateUser(TUser user) {
        if(!StringUtils.isEmpty(user.getPassword())){
            // 生成一段盐值
            String salt = CodecUtils.generateSalt(user.getUsername());
            // 对密码进行加密
            user.setPassword(CodecUtils.shaHex(user.getPassword(), null));
        }

        int i = userMapper.updateUser(user);

        if (i == 1){
            return new FaceResult().ok(true);
        }
        return new FaceResult().fail();
    }

}
