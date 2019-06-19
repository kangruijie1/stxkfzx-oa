package xyz.stxkfzx.manager.face.controller;

import xyz.stxkfzx.manager.auth.properties.JwtProperties;
import xyz.stxkfzx.manager.auth.utils.JwtUtils;
import xyz.stxkfzx.manager.common.pojo.FaceResult;
import xyz.stxkfzx.manager.face.config.DepartmentMapping;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.beans.factory.annotation.*;
import xyz.stxkfzx.manager.face.utils.*;

import java.util.*;

import xyz.stxkfzx.manager.face.pojo.*;

import java.text.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class SelController {
    @Autowired
    SelSignService selSignService;

    @GetMapping("user/sel/week/sign")
    public FaceResult selUserWeekSignItem(@RequestParam("username") String username,
                                          @RequestParam("week") int week) {
        if (week == 0) {
            week = GetWeek.getWeekNumber();
        }
        List<SignItemResult> signItemResults = selSignService.selUserWeekSignItem(username, week);
        return new FaceResult().ok(signItemResults);
    }

    @GetMapping("user/sel/today/sign")
    public FaceResult selUserTodaySignItem(@RequestParam("username") String username) {
        List<SignItemResult> signItemResults = selSignService.selUserTodaySignItem(username);
        return new FaceResult().ok(signItemResults);
    }
}
