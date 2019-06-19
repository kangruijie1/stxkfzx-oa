package xyz.stxkfzx.manager.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.auth.config.PassToken;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @PassToken
    public FaceResult register(TUser user){
        return userService.addUser(user);
    }

    @GetMapping("/checkRepeat")
    @PassToken
    public FaceResult checkUserName(String username) {
        Boolean is = userService.checkUsernameIsRepeat(username);
        return new FaceResult().ok(is);
    }

    @PostMapping("/alert")
    public FaceResult updateUser(@RequestParam(value = "username", required = true) String username,
                                 @RequestParam(value = "password", required = false) String password,
                                 @RequestParam(value = "phoneNum" ,required = false) String phoneNum){
        TUser user = new TUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNum(phoneNum);
        return userService.updateUser(user);
    }
}
