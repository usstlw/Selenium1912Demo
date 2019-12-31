package com.meyoung.day1.OpenBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void  openChrome(){
        //  设置chrome driver的路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\webdriver_demo\\chromedriver.exe");
        //打开chrome
        driver= new ChromeDriver();
    }
    /*
    * 打开chrome浏览器，
    * 打开百度首页，
    * 等待5s，
    * 关闭浏览器
    * */
    @Test
    public void getTest() throws InterruptedException {
        //打开百度首页
        driver.get("https://www.baidu.com");
        //等待5s
        Thread.sleep(5000);
    }
    /*
     * 打开chrome浏览器，
     * 打开百度首页，
     * 等待3s，
     * 后退
     * 等待3s，
     * 关闭浏览器
     * */
    @Test
    public void backTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
    }


    @Test
    public void forwardtest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
    }

    @Test
    public void refreshTest() throws InterruptedException {
        driver.get("https://www.google.com.hk");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

    }

    @Test
    public void getURLTest(){
        driver.get("https://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.println("获取到的url是"+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
    }

    @AfterMethod
    public void closedBrowser(){
        driver.quit();
    }

}
