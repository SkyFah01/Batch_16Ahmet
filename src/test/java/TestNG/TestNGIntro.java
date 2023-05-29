package TestNG;

import org.testng.annotations.Test;

public class TestNGIntro {


    //NO MAIN METHOD ANYMORE --> @TEST(TESTNG ANNOTATIONS) ACT LIKE MAIN METHOD AND ALLOWS YOU TO CREATE
    //priority Keyword--> make our own order which one you want to run first by give the number -->priority =1
    //invocationCount --> It run as many as you want > you want to run 50 data so --> invocationCount = 50
    @Test(priority =1 ,invocationCount =10 ) // come from TestNG --> Run like a main method >> you can create  main method like you want
    public void test1(){
        System.out.println("I am test1");//This test will run 10 times by use -->invocationCount =10
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("I am test2");
    }

    //You can run one by one and run all
    @Test(priority = 3)
    public void test3 (){
        System.out.println("I am test3 ");
    }














}
