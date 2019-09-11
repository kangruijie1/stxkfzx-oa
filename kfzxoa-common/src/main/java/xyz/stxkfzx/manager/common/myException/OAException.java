package xyz.stxkfzx.manager.common.myException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class OAException extends RuntimeException{

    @Autowired
    Logger logger = LoggerFactory.getLogger(OAException.class);

    public OAException(String msg){
        super(msg);
    }
}
