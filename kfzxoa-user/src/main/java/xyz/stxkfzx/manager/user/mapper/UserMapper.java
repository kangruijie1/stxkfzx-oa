package xyz.stxkfzx.manager.user.mapper;

import org.springframework.stereotype.Component;
import xyz.stxkfzx.manager.user.pojo.TUser;

import java.util.List;

@Component
public interface UserMapper
{
    int insertUser(TUser tUser);
    
    List<TUser> selectUser(TUser tUser);
    
    List<String> selectUserTest();
}
