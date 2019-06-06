package xyz.stxkfzx.manager.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import xyz.stxkfzx.manager.user.mapper.UserMapper;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public List<TUser> getTUsersByGroupId(String group_id) {
        TUser user = new TUser();
        user.setDepartmentId(group_id);
        List<TUser> tUsers = userMapper.selectUser(user);
        return tUsers;
    }

    @Override
    public TUser getTUserByUserInfo(String user_info) {
        TUser user = new TUser();
        user.setUsername(user_info);
        List<TUser> tUsers = userMapper.selectUser(user);
        if(!CollectionUtils.isEmpty(tUsers)){
            return tUsers.get(0);
        }
        return null;
    }

    @Override
    public TUser addUser(TUser user) {
        logger.info("用户{}开始注册", user);
        // 防止用户自定义id
        user.setUserId(null);
        if(checkUsernameIsRepeat(user.getUsername())){
            throw d
        }
    }

    @Override
    public List<TUser> getAllTUser() {
        return userMapper.selectUser(new TUser());
    }

    @Override
    public Boolean checkUsernameIsRepeat(String username) {
        return userMapper.selectUser()
    }

}
