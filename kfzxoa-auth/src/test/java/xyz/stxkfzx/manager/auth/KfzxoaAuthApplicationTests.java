package xyz.stxkfzx.manager.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.auth.config.AuthConfig;
import xyz.stxkfzx.manager.auth.entity.UserBase;
import xyz.stxkfzx.manager.auth.service.AuthService;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
//@MapperScan("xyz.stxkfzx.manager.auth.mapper")
public class KfzxoaAuthApplicationTests {
    @Autowired
    AuthConfig authConfig;
    @Test
    public void test() {
        System.out.println(authConfig.managerMethodList.toString());
    }
}
