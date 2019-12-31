package com.meyoung.day1;

import org.testng.annotations.*;

public class TestNGDemo1 {
    @BeforeTest
    public void beforetest(){
        System.out.println("这是befortest注解");
    }

    @BeforeMethod
    public void beforemethod1(){
        System.out.println("这是beformethod1注解");
    }



    @Test
    public void testTest1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("This is a testng comment1");
    }

    @Test
    public void testTest2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("This is a testng comment2");
    }
    @AfterTest
    public void aftertest() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@aftertest注解");
    }
    @Test
    public void testCasea() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@Testcasea注解");
    }

    @Test
    public void testCaseb() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@Testcaseb注解,case3");
    }

    @AfterMethod
    public void afteremethod1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@aftermethod注解");
    }

}
