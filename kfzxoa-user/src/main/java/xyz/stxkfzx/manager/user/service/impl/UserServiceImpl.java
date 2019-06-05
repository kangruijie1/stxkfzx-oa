package xyz.stxkfzx.manager.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import xyz.stxkfzx.manager.user.mapper.UserMapper;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<TUser> getTUsersByGroupId(String group_id) {
        TUser user = new TUser();
        user.setGroup_id(group_id);
        List<TUser> tUsers = userMapper.selectUser(user);
        return tUsers;
    }

    @Override
    public int addTuser(TUser user) {
        int id = userMapper.insertUser(user);
        return id;
    }

    @Override
    public TUser getTUserByUserInfo(String user_info) {
        TUser user = new TUser();
        user.setUser_info(user_info);
        List<TUser> tUsers = userMapper.selectUser(user);
        if(!CollectionUtils.isEmpty(tUsers)){
            return tUsers.get(0);
        }
        return null;
    }

    @Override
    public List<TUser> getAllTUser() {
        return userMapper.selectUser(new TUser());
    }
}
