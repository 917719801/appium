package xueqiu.page;


import org.openqa.selenium.By;


public class MainPage extends BasePage {


    public MainPage(){

    }
    public xueqiu.page.SearchPage toSearch(){
        click(By.id("com.xueqiu.android:id/home_search"));
        //driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        return  new SearchPage(driver);
    }



    public void toStock(){

    }
    public  void  tearDown(){
        driver.quit();
    }


}
