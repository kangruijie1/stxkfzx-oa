package xyz.stxkfzx.manager.common.myException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.stxkfzx.manager.common.pojo.FaceResult;

@ControllerAdvice(basePackages = "xyz.stxkfzx.manager")
public class ExceptionHander {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHander.class);

    @ExceptionHandler(value = OAException.class)
    @ResponseBody
    public FaceResult exceptionHander(Exception e){
        log.error("error", e);
        FaceResult faceResult = new FaceResult();
        faceResult.setMsg(e.getMessage());
        faceResult.setStatus(500);
        return faceResult;
    }
}
