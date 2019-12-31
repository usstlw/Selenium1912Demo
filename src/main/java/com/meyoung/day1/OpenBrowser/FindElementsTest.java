package com.meyoung.day1.OpenBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
//  设置chrome driver的路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\webdriver_demo\\chromedriver.exe");
        //打开chrome
        driver= new ChromeDriver();
    }

    @Test
    public void byIDTest(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw"));
    }

    @Test
    public void byNameTest(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.name("wd"));
    }

    @Test
    public void byLinkTest(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.linkText("新闻"));
    }

    @Test
    public void byXpath(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.xpath(".//*[@id='su']"));
    }

    @Test
    public void byXpath2(){
        driver.get("http://www.baidu.com");
        List<WebElement> list= driver.findElements(By.xpath(".//*[@id='u1']/a"));
        //String text = list.get(0).getText();
        for(int i=0;i<list.size();i++){
            String text=list.get(i).getText();
            System.out.println(text);
        }
    }


    @AfterMethod
    public void colsedBrowser(){
        driver.quit();
    }
}
