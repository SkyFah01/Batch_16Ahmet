package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeWork2 {
    public static void main(String[] args) throws InterruptedException {

       //TASK 1
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Supattra Boonchalee");

        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("sup@hotmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("234 Victoria Bc,Canada");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("234 Victoria Bc,Canada");
        Thread.sleep(2000);

        WebElement clickSubmit = driver.findElement(By.xpath("//button[.='Submit']"));
        clickSubmit.click();

         WebElement nameDisplay = driver.findElement(By.xpath("//p[@id='name']"));
         if(nameDisplay.isDisplayed() && nameDisplay.getText().trim().equals("Name:Supattra Boonchalee")){

             System.out.println("NAME PASSED");
         }else{
             System.out.println("NAME FAILED");
         }

         WebElement emailDisplay = driver.findElement(By.xpath("//p[@id='email']"));

         if(emailDisplay.isDisplayed() && emailDisplay.getText().trim().equals("Email:sup@hotmail.com")){

             System.out.println("EMAIL PASSED");
         }else{
             System.out.println("EMAIL FAILED");
         }

         WebElement currentAddressDisplay = driver.findElement(By.xpath("//p[@id='currentAddress']"));
         if(currentAddressDisplay.isDisplayed() && currentAddressDisplay.getText().trim().equals("Current Address :234 Victoria Bc,Canada")){
             System.out.println("currentAddress Passed");
         }else{
             System.out.println("currentAddress Failed");
         }

         WebElement permananetAddressDisplay = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
         if(permananetAddressDisplay.isDisplayed() && permananetAddressDisplay.getText().trim().equals("Permananet Address :234 Victoria Bc,Canada")){

             System.out.println("PermananetAddress Passed");
         }else{
             System.out.println("PermananetAddress Failed");
         }
         Thread.sleep(2000);
         driver.quit();


         //TASK 2

        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options2 = new ChromeOptions();
        options2.addArguments("--remote-allow-origins=*");
        WebDriver driver2 = new ChromeDriver(options2);
        driver2.manage().window().maximize();
        driver2.get("https://www.saucedemo.com/");

        WebElement userName = driver2.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement passWord = driver2.findElement(By.xpath("//input[@id='password']"));
        passWord.sendKeys("Selenium");
        Thread.sleep(2000);

        WebElement logInButton = driver2.findElement(By.xpath("//input[@id='login-button']"));
        logInButton.click();

        WebElement validate = driver2.findElement(By.xpath("//h3[@data-test='error']"));
        if(userName==passWord){
            System.out.println("Correct PassWord");

        }else{
            System.out.println("Validate"+"  " + validate.getText());
        }
        Thread.sleep(2000);
        driver2.quit();


        //TASK 3

        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options3 = new ChromeOptions();
        options3.addArguments("--remote-allow-origins=*");
        WebDriver driver3 = new ChromeDriver(options3);
        driver3.manage().window().maximize();
        driver3.get("https://www.saucedemo.com/");

        WebElement userName2 = driver3.findElement(By.id("user-name"));

        userName2.sendKeys("standard_user");

        WebElement password2 = driver3.findElement(By.xpath("//input[@name='password']"));

        password2.sendKeys("secret_sauce");
        Thread.sleep(2000);

        WebElement clickButton = driver3.findElement(By.xpath("//input[@value='Login']"));

        clickButton.click();

        System.out.println("Validate current url is " + driver3.getCurrentUrl());
        Thread.sleep(2000);
        driver3.quit();











    }
}
