package xyz.stxkfzx.manager.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import xyz.stxkfzx.manager.user.pojo.TUser;

import java.util.List;

@Mapper
public interface UserMapper
{
    int insertUser(TUser tUser);
    
    List<TUser> selectUser(TUser tUser);

    int updateUser(TUser user);
}
