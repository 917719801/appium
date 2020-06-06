package xueqiu.testcase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class alibabaDemo {
    private  static AppiumDriver driver;
    private WebDriverWait wait;
    @BeforeAll
    public static  void  Setup(){
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
//搜索阿里巴巴
    @Test
    void alibabaTest(){
        /*
        MobileElement el1 = (MobileElement) driver.findElementById("com.xueqiu.android:id/tv_search");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.xueqiu.android:id/search_input_text");
        el2.sendKeys("阿里巴巴");
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
        el3.click();*/
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("阿里巴巴");



    }
    
 /*   @AfterAll
    public void teatDown(){
        driver.quit();
  }*/

}
