package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    /*
     * 点击百度首页的新闻按钮
     * */
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\webdriver_demo\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        //通过ID或者name方式转交控制权
        //driver.switchTo().frame("aa");
        //通过元素的方式
        WebElement iframe= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.linkText("baidu")).click();
        driver.findElement(By.id("kw")).sendKeys("ddddd");
        driver.findElement(By.id("su")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(10000);
    }


    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
