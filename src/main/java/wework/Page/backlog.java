package wework.Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class backlog extends BasePage{

    private final By taskList = By.id("gw9");


    public backlog(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void addbacklog(String content,String name) {
        click(By.id("gih"));
        sendKeys(By.id("b2k"),content);
        click(By.xpath("//*[@text='参与人']"));
        click(By.id("gyr"));
        sendKeys(By.id("fn5"),name);
        find(By.className("android.widget.ImageView"));
        click(By.id("fq1"));
        click(By.id("gxq"));

    }
    public List<String> getbacklog(){
        return driver.findElements(taskList).stream().map(x->x.getText()).collect(Collectors.toList());
    }
}
