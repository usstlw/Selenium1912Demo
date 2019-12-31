package com.meyoung.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    @DataProvider(name="data4")
    public Object[][] test1(){
        return new Object[][]{
                {"firefox","http://182.168.1.105:8888"},
                {"chrome","http://182.168.1.105:5556"}
        };
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser) throws MalformedURLException,InterruptedException{
        /*DesiredCapabilities fireFoxDC=DesiredCapabilities.firefox();
        //指定机器的ip和hub端口，wd/hub必须要写
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.191.3:4444/wd/hub"),fireFoxDC);*/
        DesiredCapabilities chromeDC=DesiredCapabilities.chrome();
        //指定机器的ip和hub端口，wd/hub必须要写
        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.16:4446/wd/hub"),chromeDC);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
    }

}
