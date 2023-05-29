package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {


    public int multiplication(int number1 ,int number2){

        return number1 * number2;


    }
    @Test
    public void validateMultiplication(){
        int actualResult = multiplication(3,4);
        int expectedResult = 12;
       // if(actualResult==expectedResult){
        //    System.out.println("Passed");
       // }else{
         //   System.out.println("Failed");
        //}

        Assert.assertEquals(actualResult,expectedResult);//does the same thing -->Assert is class --> assertEquals is overloading
        //Run and get green tick it mean passed


    }

    @Test
    public void validateZero(){

        int actual = multiplication(0,999);
        int expected = 0;
        Assert.assertTrue(actual==expected);//boolean
    }

    @Test
    public void validateNegativeWithPositive(){
      int actual = multiplication(-1,9);
      int expected=-9;
      Assert.assertFalse(actual!=expected);//assertFalse -->expected false

    }

    @Test
    public void validateNegativeWithNegative(){
     //int actual = multiplication(-1,-5);
     //int expected = 5;
     Assert.assertEquals(multiplication(-1,-5),5);  // for level 3 you can do this

    }













}
