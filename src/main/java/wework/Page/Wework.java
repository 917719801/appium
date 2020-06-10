package wework.Page;

import org.openqa.selenium.By;

public class Wework extends BasePage{
    public Wework() {
        super("com.tencent.wework", ".launch.WwMainActivity");
    }
    public schedulePage schedule(){
        click(By.xpath("//*[@text='日程']"));
        return new schedulePage(driver);

    }
    public backlog backlog(){
        click(By.xpath("//*[@text='待办']"));
        return new backlog(driver);
    }
}
