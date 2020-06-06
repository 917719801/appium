package xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private  static AppiumDriver driver;
    private WebDriverWait wait;
    public MainPage(){
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
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public xueqiu.page.SearchPage toSearch(){
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        return  new SearchPage(driver);
    }

    public void toStock(){

    }
    public  void  tearDown(){
        driver.quit();
    }


}
