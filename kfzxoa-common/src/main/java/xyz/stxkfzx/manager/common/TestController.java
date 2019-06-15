package xyz.stxkfzx.manager.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.stxkfzx.manager.common.myException.OAException;

@RestController
public class TestController {
    @RequestMapping("test")
    public void test(){
        throw new OAException("33333333333333333333");
    }
}
