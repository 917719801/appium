package wework.Page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class schedulePageTest {

    private static Wework wework;

    @BeforeAll
    static void beforeall() {
        wework = new Wework();
    }


    @Test
    void addschedule() {
        assertTrue(wework.schedule().addschedule("上班打卡", "8点").getschedule(null).contains("上班打卡"));

    }


    @Test
    void addbacklog() {
        assertTrue(wework.backlog().addbacklog("我要成长", "张三").getbacklog().contains("我要成长"));
        //assertTrue((wework.backlog().getbacklog(), "我要成长");
        //assertTrue(wework.backlog().getbacklog().contains("我要成长"));
    }

    @Test
    void adddaily() {
        wework.report().adddaily("各位同学打架好");
    }

}