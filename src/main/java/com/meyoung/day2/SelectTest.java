package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\webdriver_demo\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /*
    * 打开我们的测试界面，
    * 下拉框选择vivo
    * 第二次选择华为
    * 第三次选择iphone
    * */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        WebElement selectEl=driver.findElement(By.id("moreSelect"));
        //实例化select类
        Select select= new Select(selectEl);
        //通过索引选择下拉框
        select.selectByIndex(2);
        Thread.sleep(3000);
        //通过属性value值选择下拉框
        select.selectByValue("huawei");
        Thread.sleep(3000);
        //通过文本值选择下拉框
        select.selectByVisibleText("iphone");

    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
