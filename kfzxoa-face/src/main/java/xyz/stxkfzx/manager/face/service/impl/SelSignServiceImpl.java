package xyz.stxkfzx.manager.face.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.util.CollectionUtils;
import xyz.stxkfzx.manager.common.utils.GetWeek;
import xyz.stxkfzx.manager.face.service.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import xyz.stxkfzx.manager.face.mapper.*;

import java.util.*;

import xyz.stxkfzx.manager.face.pojo.*;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@Service
public class SelSignServiceImpl implements SelSignService {
    @Autowired
    private SignItemMapper signItemMapper;
    @Reference
    private UserService userService;

    public List<SignItemResult> selSignItem(String startTime, String endTime, List<TUser> userList){
        List<SignItemResult> signItemResultList = new ArrayList<>();
        for (TUser user : userList) {
            SignItemResult itemResult = new SignItemResult();
            itemResult.setUsername(user.getUsername());

            // 查询该用户此段时间的签到记录
            int id = user.getUserId();
            List<TSignItemNew> signItems = signItemMapper.selSignItemNew(id, startTime, endTime);
            //计算该时间段一共几天
            int intervalDay = GetWeek.getIntervalDay(startTime, endTime);
            //创建第几天对应的工作时间map
            Map<String, Double> weekMap = new LinkedHashMap<>();
            //赋初值
            for (int i = 1; i < intervalDay +1; ++i) {
                weekMap.put("day" + Integer.toString(i), 0.0);
            }
            if (!CollectionUtils.isEmpty(signItems)) {
                double intervalHours = 0.0;
                for (TSignItemNew signItem : signItems) {
                    //获取签到日期
                    String todayStr = signItem.getSignInTime().toString().split(" ")[0];
                    int weekTemp = 0;
                    //如果是获取用户当天考勤
                    if(intervalDay == 1){
                        weekTemp = 1;
                    }
                    //否则获取是周几
                    else{
                        weekTemp = GetWeek.getWeekNumber(todayStr);
                    }
                    // 获取此打卡记录的上班和下班时间
                    long signInTime = signItem.getSignInTime().getTime();
                    long signOutTime = 0;
                    if (signItem.getSignOutTime() != null){
                        signOutTime = signItem.getSignOutTime().getTime();
                        //计算差值
                        Double intervalDouble = Double.valueOf(signOutTime - signInTime);
                        //转换为小时
                        intervalHours = intervalDouble / 3600000.0;
                        //获取该天的key
                        String key = "day" + Integer.valueOf(weekTemp);
                        //累加时间
                        Double total = Double.valueOf(intervalHours + weekMap.get(key));
                        total = Math.round(total * 10.0) / 10.0;
                        //新的时间
                        weekMap.put(key, total);
                    }
                }
            }
            itemResult.setDayMap(weekMap);
            signItemResultList.add(itemResult);
        }
        return signItemResultList;
    }

    @Override
    public List<SignItemResult> selUserTodaySignItem(String username){
        List<TUser> userList = new ArrayList<>();
        TUser user = userService.getTUserByUsername(username);
        userList.add(user);
        //获取今天的开始和结束时间
        String startTime = GetWeek.getTodayStartDate();
        String endTime = GetWeek.getTodayEndDate();
        //查询打卡记录
        return selSignItem(startTime, endTime, userList);
    }

    @Override
    public List<SignItemResult> selUserWeekSignItem(String username, int week){
        List<TUser> userList = new ArrayList<>();
        TUser user = userService.getTUserByUsername(username);
        userList.add(user);
        // 获取此周的起始和结束日期
        String startTime = GetWeek.getWeekStartEndDate(week).get(0);
        String endTime = GetWeek.getWeekStartEndDate(week).get(1);
        //查询打卡记录
        return selSignItem(startTime, endTime, userList);
    }

    @Override
    public List<SignItemResult> selDepartmentSignItem(String startTime, String endTime, String departmentId) {
        //查询部门所有用户
        List<TUser> userList = userService.getTUsersByDepartmentId(departmentId);
        //查询打卡记录
        return selSignItem(startTime, endTime, userList);
    }
}
