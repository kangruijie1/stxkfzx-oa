package xyz.stxkfzx.manager.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@RestController
public class UserController {

    @Autowired
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

    @PostMapping("alert")
    public FaceResult updateUser(@RequestParam(value = "username", required = true) String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("phoneNum") String phoneNum){
        return userService.updateUser(username, password, phoneNum);
    }
}
