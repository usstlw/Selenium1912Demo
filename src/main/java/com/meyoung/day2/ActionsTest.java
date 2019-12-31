package com.meyoung.day2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {
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
    public void clickTest(){
        driver.get("http://www.baidu.com");
        WebElement newslink= driver.findElement(By.linkText("新闻"));
        //点击新闻链接
        newslink.click();
        //获取当前页面的url
        String url = driver.getCurrentUrl();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    @Test
    public void sendkeysTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement keys= driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");

        //定位百度一下按钮
        WebElement baidubutton=driver.findElement(By.id("su"));

        baidubutton.click();
        Thread.sleep(5000);
        //获取页面的title
        String title=driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    @Test
    public void clearTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement keys= driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        Thread.sleep(5000);
        keys.clear();
        Thread.sleep(3000);
    }

    @Test
    public void getTTexTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        String text1=driver.findElement(By.linkText("新闻")).getText();
        Assert.assertEquals(text1,"新闻");
    }

    @Test
    public void getTagNameTest(){
        driver.get("http://www.baidu.com");
        String tagName=driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input111");
    }

    @Test
    public void getATest(){
        driver.get("http://www.baidu.com");
        String attributeValue=driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attributeValue,"百度一下");
    }

    @Test
    public void idSelectTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        //Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
//点击
        element.click();
        Thread.sleep(5000);
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    @Test
    public void isEnabledTest(){
        driver.get("file:///C:/selenium_html/index.html");
        Boolean b = driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);

    }

    @Test
    public void shotTest(){
        driver.get("http://www.baidu.com");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        //把控制权交给alert
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void confirmTest() throws InterruptedException{
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);

    }

    @Test
    public void promptTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是prompt");
        alert.accept();
        Thread.sleep(3000);
    }




    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
