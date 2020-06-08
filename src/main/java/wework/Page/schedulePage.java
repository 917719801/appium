package wework.Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class schedulePage extends BasePage{
    private final By taskName = By.id("b2k");
    private final By save = byText("保存");
    private final By taskList = By.id("gg_");
    private By add =By.id("gym");

    public schedulePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public schedulePage addschedule(String name, String time){
        click(add);
        sendKeys(taskName, name);
        click(save);

        return this;
    }

    public List<String> getschedule(String day){
        if(day!=null){
            //todo:选择日期
        }
        return driver.findElements(taskList).stream().map(x->x.getText()).collect(Collectors.toList());
    }




}
