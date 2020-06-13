package wework.Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public BasePage(String packageName, String activityName) {
        this.packageName = packageName;
        this.activityName = activityName;
        startApp(this.packageName,this.activityName);
    }

    String packageName;
    String activityName;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }


    public void startApp(String packageName, String activityName){
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName","Android");
            caps.setCapability("deviceName","emulator-5554");

            caps.setCapability("appPackage",packageName);
            caps.setCapability("noReset","true");
            caps.setCapability("appActivity", activityName);
            caps.setCapability("dontStopAppOnReset","true");
            caps.setCapability("skipLogcatCapture","true");

            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

    }


    public void quit() {
        driver.quit();
    }
    public By byText(String text){
        return By.xpath("//*[@text='"+ text + "']");
    }

    public void click(By by) {
        //wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }

    public void sendKeys(By by, String content) {
        //wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(content);

    }
    public MobileElement find(By by){
        return driver.findElement(by);
    }
}
