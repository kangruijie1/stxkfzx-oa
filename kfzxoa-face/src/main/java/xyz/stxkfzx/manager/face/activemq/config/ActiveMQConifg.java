package xyz.stxkfzx.manager.face.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * @author VicterTian
 * @version V1.0
 * @date 2019/6/19
 */
@Configuration
@EnableJms
public class ActiveMQConifg {
    /**
     * 发送添加人脸库后的userId
     * @return
     */
    @Bean
    public Queue addFaceQueue() {
        return new ActiveMQQueue("add.face.msg.queue") ;
    }
}
