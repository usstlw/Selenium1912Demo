package com.meyoung.day1;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo1 {
    @BeforeTest
    public void beforetest(){
        System.out.println("这是befortest注解");
    }

    @BeforeMethod
    public void beforemethod(){
        System.out.println("这是beformethod注解");
    }



    @Test
    public void testTest1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("This is a testng test1 comment");
    }

    @Test
    public void testTest2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("This is a testng test2 comment");
    }
    @AfterTest
    public void aftertest() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@aftertest注解");
    }


    @AfterMethod
    public void afteremethod() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@aftermethod注解");
    }

}
