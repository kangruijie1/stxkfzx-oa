package xyz.stxkfzx.manager.face.activemq.producer.impl;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import xyz.stxkfzx.manager.face.activemq.producer.IMessageProducerService;
import xyz.stxkfzx.manager.user.pojo.TUser;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * @author VicterTian
 * @version V1.0
 * @date 2019/6/19
 */
@Service
public class MessageProducerServiceImpl implements IMessageProducerService {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Queue addFaceQueue;
    @Override
    public void addFaceSendMessage(TUser user) {
        jmsMessagingTemplate.convertAndSend(addFaceQueue, user);
    }
}
