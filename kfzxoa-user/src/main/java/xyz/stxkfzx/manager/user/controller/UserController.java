package xyz.stxkfzx.manager.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@RestController
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public FaceResult register(TUser user){
        return userService.addUser(user);
    }

    @GetMapping("/checkRepeat")
    public FaceResult checkUserName(String username) {
        Boolean is = userService.checkUsernameIsRepeat(username);
        return new FaceResult().ok(is);
    }
}
