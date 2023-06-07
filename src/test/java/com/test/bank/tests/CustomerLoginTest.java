package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerLoginTest {

    @Test
    public void validateCustomerLoginFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver,"Supattra","Boonchalee","45607","Customer added successfully with customer id");

        bankManagerPage.OpenAccountFunctionality(driver,"Supattra Boonchalee","Dollar","Account created successfully with account Number ");


        bankManagerPage.customersButtonFunctionality("Supattra","Boonchalee","45607");

        loginPage.clickCustomerButton();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.customerLoginFunctionality("Supattra Boonchalee","Welcome Supattra Boonchalee !!","500","Deposit Successful","300","Transaction successful");
        customerLoginPage.calculateBalance();
        driver.quit();




    }

}
