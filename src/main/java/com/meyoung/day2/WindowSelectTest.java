package com.meyoung.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowSelectTest {

    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\webdriver_demo\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void testWin() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
    //当前driver所在的页面的句柄值
        String handle1=driver.getWindowHandle();
        //for 循环判断 获取到的handles是否等于handle1
        for(String handles:driver.getWindowHandles()){
            if(handles.equals(handle1))
                continue;
            driver.switchTo().window(handles);
        }
        driver.findElement(By.linkText("baidu")).click();
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
