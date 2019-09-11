package xyz.stxkfzx.manager.face;

import org.junit.Test;
import xyz.stxkfzx.manager.common.utils.GetWeek;

public class GetWeekTest {

    @Test
    public void test(){
        System.out.println(GetWeek.getIntervalDay(GetWeek.getTodayStartDate(), GetWeek.getTodayEndDate()));
    }

    @Test
    public void test1(){
        System.out.println(GetWeek.dateAddDay("2019-6-20"));
    }

    @Test
    public void test2(){

        System.out.println(GetWeek.getWeekNumber("2019-6-20"));
    }

    @Test
    public void test3(){
        System.out.println(GetWeek.getHowWeek());
    }

    @Test
    public void test4(){
        System.out.println(GetWeek.getHowWeek("2019-6-20"));
    }
}
