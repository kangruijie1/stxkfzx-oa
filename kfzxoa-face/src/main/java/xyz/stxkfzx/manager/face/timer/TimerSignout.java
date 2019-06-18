package xyz.stxkfzx.manager.face.timer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import xyz.stxkfzx.manager.face.mapper.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import org.springframework.scheduling.annotation.*;
import xyz.stxkfzx.manager.face.pojo.TSignItem;
import xyz.stxkfzx.manager.face.pojo.TSignItemNew;
import xyz.stxkfzx.manager.face.utils.GetWeek;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@Component
public class TimerSignout
{
    @Autowired
    private SignItemMapper signItemMapper;
    @Reference()
    private UserService userService;
    
    @Scheduled(cron = "0 50 22 * * ?")
    public void test2() {
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        String today = timeStamp.toString().split(" ")[0];
        String todayStart = GetWeek.getTodayStartDate();
        String todayEnd = GetWeek.getTodayEndDate();
        List<TUser> userList = userService.getAllTUser();
        for (TUser user : userList) {
            int id = user.getUserId();
            List<TSignItemNew> signItemList = this.signItemMapper.selSignItemNew(id, todayStart, todayEnd);
            if (signItemList != null) {
                if (signItemList.size() == 0) {
                    continue;
                }
                if (signItemList.get(signItemList.size() - 1).getSignOutTime()!=null) {
                    continue;
                }
                TSignItemNew signItem = signItemList.get(signItemList.size() - 1);
                Timestamp signInTime = signItem.getSignInTime();
                Date currentDate = new Date();
                Timestamp currentTime = new Timestamp(currentDate.getTime());
                long interval = currentTime.getTime() - signInTime.getTime();
                Double hour = Double.valueOf(interval / 3600000L);
                if (hour < 1.0) {
                    continue;
                }
                long minLong = signInTime.getTime() + 3600000L;
                Timestamp minTime = new Timestamp(minLong);
                signItem.setSignOutTime(minTime);
                this.signItemMapper.updateSignItem(signItem, todayStart, todayEnd);
            }
        }
    }
}
