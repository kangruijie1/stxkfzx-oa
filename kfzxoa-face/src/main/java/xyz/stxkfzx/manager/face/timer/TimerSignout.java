package xyz.stxkfzx.manager.face.timer;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import xyz.stxkfzx.manager.face.mapper.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import org.springframework.scheduling.annotation.*;
import xyz.stxkfzx.manager.user.pojo.TSignItem;
import xyz.stxkfzx.manager.user.pojo.TUser;
import xyz.stxkfzx.manager.user.service.UserService;

@Component
public class TimerSignout
{
    @Autowired
    private SignItemMapper signItemMapper;
    @Autowired
    private UserService userService;
    
    @Scheduled(cron = "0 50 22 * * ?")
    public void test2() {
        final Date date = new Date();
        final Timestamp timeStamp = new Timestamp(date.getTime());
        final String today = timeStamp.toString().split(" ")[0];
        final String todayStart = String.valueOf(today) + " 00:00:00.000";
        final String todayEnd = String.valueOf(today) + " 23:59:59.999";
        final TUser userTemp = new TUser();
        List<TUser> userList = userService.getAllTUser();
        for (final TUser user : userList) {
            final int id = user.getUserId();
            final List<TSignItem> signItemList = this.signItemMapper.selSignItem(id, todayStart, todayEnd);
            if (signItemList != null) {
                if (signItemList.size() == 0) {
                    continue;
                }
                if (signItemList.get(signItemList.size() - 1).getSignout() != null) {
                    continue;
                }
                final TSignItem signItem = signItemList.get(signItemList.size() - 1);
                final Timestamp signinTime = signItem.getSignin();
                final Date currentDate = new Date();
                final Timestamp currentTime = new Timestamp(currentDate.getTime());
                final long interval = currentTime.getTime() - signinTime.getTime();
                Double hour = Double.valueOf(interval / 3600000L);
                if (hour < 1.0) {
                    continue;
                }
                final long minLong = signinTime.getTime() + 3600000L;
                final Timestamp minTime = new Timestamp(minLong);
                signItem.setSignout(minTime);
                this.signItemMapper.updateSignItem(signItem, todayStart, todayEnd);
            }
        }
    }
}
