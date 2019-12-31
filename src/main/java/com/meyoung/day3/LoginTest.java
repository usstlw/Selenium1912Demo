package com.meyoung.day3;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\webdriver_demo\\chromedriver.exe");
        driver=new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void LoginSuccess(){
        //driver控制权转交
        //*[@id="x-URS-iframe1577679786281.3098"]
        WebElement e = driver.findElement(By.xpath("//iframe[starts-with(@id, 'x-URS-iframe')]"));
        driver.switchTo().frame(e);
//        driver.findElement(By.id("switchAccountLogin")).click();
//        driver.findElement(By.name("email")).sendKeys("ffffff");
//        driver.findElement(By.name("password")).sendKeys("ffffff");
//        driver.findElement(By.id("dologin")).click();

        LoginTest.login(driver,"usstlw1","zhanyi88");
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String logout = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");
    }

    @Test
    public static void login(WebDriver driver,String email,String pwd){
        WebElement e = driver.findElement(By.xpath("//iframe[starts-with(@id, 'x-URS-iframe')]"));
        driver.switchTo().frame(e);
        driver.findElement(By.id("switchAccountLogin")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }

    @Test
    public static void loginPO(WebDriver driver,String email,String pwd){
        WebElement e = driver.findElement(By.xpath("//iframe[starts-with(@id, 'x-URS-iframe')]"));
        driver.switchTo().frame(e);
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        driver.findElement(LoginPage.loginButton).click();
        driver.findElement(By.id("dologin")).click();
    }


    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
