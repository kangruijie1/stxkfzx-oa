package xyz.stxkfzx.manager.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.common.utils.GetWeek;

import java.sql.Timestamp;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class KfzxoaCommonApplicationTests {

    @Test
    public void testGetWeek() {
        Timestamp timestamp = GetWeek.timeStrConverTimestamp("2019-07-11 19:34:54");
        System.out.println(timestamp.toString());
    }

}
