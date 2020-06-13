package wework.Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class backlog extends BasePage {

    private final By taskList = By.id("gw9");
    private final By gym = By.id("gym");
    private final By b2k = By.id("b2k");
    private final By xpath = By.xpath("//*[@text='参与人']");


    public backlog(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void addbacklog(String content, String name) {
        click(gym);
        sendKeys(b2k, content);
        click(xpath);
        click(By.id("gyr"));
        sendKeys(By.id("fn5"), name);
        find(By.className("android.widget.ImageView"));
        click(By.id("fq2"));
        click(By.id("fq1"));
        click(By.id("gxq"));

    }

    public List<String> getbacklog() {
        List<String> backlog = new ArrayList<>();
        for (Object element : driver.findElements(taskList)) {
            backlog.add(((WebElement) element).getText());
        }

        return backlog;
    }
}
