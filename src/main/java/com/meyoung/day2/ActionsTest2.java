package com.meyoung.day2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ActionsTest2 {
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
    public void rightClickTest(){
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        //实例化actions类
        Actions actions=new Actions(driver);
        //再百度一下按钮 右键
        actions.contextClick(buttonBaidu).perform();

    }


    /**
     *打开百度页面，双击百度按钮
     **/
    @Test
    public void doubleClickTest(){
        driver.get("http://www.baidu.com");
        WebElement buttonBaidu=driver.findElement(By.id("su"));
        Actions actions=new Actions(driver);
        actions.doubleClick(buttonBaidu).perform();
    }

    @Test
    public void move() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));

        Actions actions =new Actions(driver);
        actions.moveToElement(element).perform();

        Thread.sleep(3000);
        String hello = driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();

        Assert.assertEquals(hello,"Hello World!");

    }

    @Test
    public void testDrop() throws InterruptedException {
        driver.get("file:///C:/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions= new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(10000);
    }

    @Test
    public void dropTest() throws InterruptedException{
        driver.get("file:///C:/selenium_html/dragAndDrop.html");
        WebElement el1 = driver.findElement(By.id("drag"));
        WebElement el2 = driver.findElement(By.xpath("/html/body/h1"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(el1).moveToElement(el2).release(el1).perform();
        Thread.sleep(10000);
    }

    @Test
    public void moreSelectTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));

        List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .click(list.get(0))
                .click(list.get(2))
                .keyUp(Keys.SHIFT)
                .perform();
        Thread.sleep(5000);

    }

    @Test
    public void moreSelectTest2() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));

        List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(list.get(2)).keyUp(Keys.CONTROL)
                .perform();
        Thread.sleep(5000);

    }

    @Test
    public void saveaHtml() throws InterruptedException, AWTException {
        driver.get("http://www.baidu.com");
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);

    }

    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\Administrator\\Desktop\\123.png");
        Thread.sleep(10000);
    }








    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
