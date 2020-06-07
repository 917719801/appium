package xueqiu.page;
/*
业务逻辑
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;


import java.util.ArrayList;

import java.util.List;

public class SearchPage extends BasePage {
    private By nameLocator = By.id("name");

    public SearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    //搜索
    public SearchPage search(String keyword) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        do {
            sendKeys(By.id("com.xueqiu.android:id/search_input_text"),keyword);
            System.out.println("sendkeys");

        }while (driver.findElements(nameLocator).size() <=0);

        //driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(keyword);
        return this;
    }

//获取价格值
    public double getPrice() {
        click(nameLocator);
       // driver.findElement(nameLocator).click();
        //return Double.valueOf(driver.findElement(By.id("current_price")).getText());
        return Double.valueOf(find(By.id("current_price")).getText());
    }

    public List<String> getSearchList() {
        List<String> nameList = new ArrayList<>();
//        for (Object element : driver.findElements(nameLocator)) {
//            nameList.add(((WebElement) element).getText());
//        }
      driver.findElements(nameLocator).forEach(element -> nameList.add(element.getText()));
        return nameList;
    }

}
