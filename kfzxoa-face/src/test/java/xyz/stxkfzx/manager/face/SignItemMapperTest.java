package xyz.stxkfzx.manager.face;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.stxkfzx.manager.face.mapper.SignItemMapper;
import xyz.stxkfzx.manager.face.pojo.TSignItemNew;
import xyz.stxkfzx.manager.common.utils.GetWeek;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SignItemMapperTest {
    @Autowired
    SignItemMapper signItemMapper;

    @Test
    public void test(){
        String todayStart = GetWeek.getTodayStartDate();
        String todayEnd = GetWeek.getTodayEndDate();
        long l = System.currentTimeMillis();
        List<TSignItemNew> list = signItemMapper.selSignItemNew(13, todayStart, todayEnd);
        long ll = System.currentTimeMillis();
        System.out.println(ll - l);
    }
}
