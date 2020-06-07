package xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class BasePage {
    AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;
    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    public BasePage() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName","Android");
            caps.setCapability("deviceName","emulator-5554");
            caps.setCapability("appPackage","com.xueqiu.android");
            caps.setCapability("noReset","true");
            caps.setCapability("appActivity",".view.WelcomeActivityAlias");

            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        wait = new WebDriverWait(driver, 10);
    }
    public void quit() {
        driver.quit();
    }

    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }

    public void sendKeys(By by, String content) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(content);

    }
    public MobileElement find(By by){
        return driver.findElement(by);
    }
}
