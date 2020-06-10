package wework.Page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class schedulePageTest {

    private static Wework wework;

    @BeforeAll
    static void beforeall(){
        wework = new Wework();
    }


    @Test
    void addschedule() {
       assertTrue(wework.schedule().addschedule("上班打卡","8点").getschedule(null).contains("上班打卡"));

    }


    @Test
    void addbacklog(){




        wework.backlog().addbacklog("我要成长", "阿乐");
    }

}