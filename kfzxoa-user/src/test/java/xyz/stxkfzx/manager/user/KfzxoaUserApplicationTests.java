package xyz.stxkfzx.manager.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KfzxoaUserApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test() {

        redisTemplate.hasKey("6");
    }
}
