package xyz.stxkfzx.manager.user;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.user.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KfzxoaUserApplicationTests {

    @Autowired
    UserMapper userMapper;

}
