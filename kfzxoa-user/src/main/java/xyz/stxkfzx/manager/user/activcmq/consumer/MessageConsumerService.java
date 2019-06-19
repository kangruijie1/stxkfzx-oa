package xyz.stxkfzx.manager.user.activcmq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

/**
 * @author KrjayDog
 * @version V1.0
 * @date 2019/6/19
 */
@Service
public class MessageConsumerService {
    @Autowired
    UserService userService;

    @JmsListener(destination="add.face.msg.queue")
    public void receiveMessage(TUser user) {    // 进行消息接收处理
        FaceResult faceResult = userService.updateUser(user);
    }
}
