package xyz.stxkfzx.manager.face;

import org.junit.Test;
import xyz.stxkfzx.manager.face.utils.GetWeek;

public class GetWeekTest {

    @Test
    public void test(){
        System.out.println(GetWeek.getIntervalDay(GetWeek.getTodayStartDate(), GetWeek.getTodayEndDate()));
    }
}
