package xyz.stxkfzx.manager.face.activemq.producer;

import xyz.stxkfzx.manager.user.pojo.TUser;

/**
 * @author VicterTian
 * @version V1.0
 * @Date 2019/6/19
 */
public interface IMessageProducerService {

    void addFaceSendMessage(TUser user) ;
}
