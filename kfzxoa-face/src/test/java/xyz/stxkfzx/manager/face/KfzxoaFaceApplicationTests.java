package xyz.stxkfzx.manager.face;

import com.alibaba.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KfzxoaFaceApplicationTests {

    /*@Reference(version = "1.0.0")
    UserService userService;*/

    @Autowired
    RedisTemplate redisTemplate;

    /*@Test
    public void contextLoads() {
        List<TUser> allTUser = userService.getAllTUser();
        System.out.println(allTUser.toString());
    }*/

    @Test
    public void test() {

        redisTemplate.hasKey("6");
    }



}
