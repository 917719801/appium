package xueqiu.page;
/*
业务逻辑
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPage {
    private static AppiumDriver driver;
    private By nameLocator=By.id("name");

    public SearchPage(AppiumDriver driver) {
        this.driver = driver;
    }

    //搜索
    public SearchPage search(String keyword) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(keyword);
        return this;
    }

    //获取股价值
    public double getPrice() {
        driver.findElement(nameLocator).click();
        return Double.valueOf(driver.findElement(By.id("current_price")).getText());

    }

    public List<String> getSearchList() {
        List<String> nameList = new ArrayList<>();
        for (Object element : driver.findElements(nameLocator)) {
           nameList.add(((WebElement) element).getText());
        }
        return nameList;

    }
}
