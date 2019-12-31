package com.meyoung.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\webdriver_demo\\chromedriver.exe");
        driver=new ChromeDriver();
        //driver=new FirefoxDriver();
    }

    @Test
    public void registertest() throws InterruptedException {
        driver.get("http://mail.163.com/");
        Thread.sleep(3000);

      //  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, 'x-URS-iframe')]")));
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, 'x-URS-iframe')]")));
//点击去注册按钮

        driver.findElement(By.xpath(".//*[@id='commonOperation']/a[2]")).click();

        //获取当前driver所在的handle值
        String handle1=driver.getWindowHandle();

        for (String handles:driver.getWindowHandles() ){
            if(handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles);
        }

        String time = String.valueOf(System.currentTimeMillis()/100);
        System.out.println(time);

        Thread.sleep(10000);
        driver.findElement(By.id("username")).sendKeys("usstlw2");
        driver.findElement(By.id("password")).sendKeys("zhanyi88");
        driver.findElement(By.id("phone")).sendKeys("18916593041");
        Thread.sleep(10000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[4]/span")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[5]/a[1]")).click();
        Thread.sleep(10000);
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div[2]")));


        String error=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div[2]")).getText();
        Assert.assertEquals(error,"手机验证码不正确，请重新填写");


    }



    @AfterMethod
    public void closed(){
        driver.quit();
    }

}
