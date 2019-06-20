package xyz.stxkfzx.manager.face;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.face.activemq.producer.IMessageProducerService;
import xyz.stxkfzx.manager.user.pojo.TUser;

import javax.annotation.Resource;

/**
 * @author VicterTian
 * @version V1.0
 * @date 2019/6/19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MqTest {
    @Resource
    private IMessageProducerService messageProducer;

    @Test
    public void testSend() throws Exception {
        TUser user = new TUser();
        user.setUserId(23);
        user.setUsername("康瑞杰");
        user.setPassword("cf123456789");
        user.setJobId("23");
        this.messageProducer.addFaceSendMessage(user);
    }
}
