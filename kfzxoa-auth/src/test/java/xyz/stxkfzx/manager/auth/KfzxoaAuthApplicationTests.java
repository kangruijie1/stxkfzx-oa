package xyz.stxkfzx.manager.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.auth.service.AuthService;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("xyz.stxkfzx.manager.auth.mapper")
public class KfzxoaAuthApplicationTests {

    @Autowired
    AuthService authService;
    @Test
    public void contextLoads() {
        authService.login("kkk", "cf123456789", null);
    }
}
