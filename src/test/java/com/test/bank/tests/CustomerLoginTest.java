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

public class CustomerLoginTest extends BankTestBase{

    @Test
    public void validateCustomerLoginTransactions() throws InterruptedException {

         /*
TASK:
 1-Click homeButton from top(You can store in Manager Page or LoginPage)
 2-Click Customer Login
 3-Find Your name from the List
 4-Click Login
 5-Validate the "Welcome Your Name" from header
 6-Click Deposit and put 500
 7-Validate "Deposit Successful
 8-Click Withdrawl and put 300
 9-Validate "Transaction successful"
 10-Get the balance from the Customer Page(200)
 11-Click Transactions
 12-get the 500 and 300 from the table and substract them
 13-Validate balance from customer page amount(200) equals to transaction amount(500-300).
 14-Quit the driver

 NOTE:YOu should have another CustomerPage class and CustomerTest class and do your validation under customerTest
 */

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        BankLoginPage loginPage = new BankLoginPage(driver);

        loginPage.clickManagerButton();
        bankManagerPage.addCustomerFunctionality(driver,"Supattra","Boonchalee","45607","Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver,"Supattra Boonchalee","Dollar","Account created successfully with account Number ");
        bankManagerPage.customersButtonFunctionality("Supattra","Boonchalee","45607");



        bankManagerPage.clickHomeButton();
        loginPage.clickCustomerButton();
        customerLoginPage.loginFunctionality("Supattra Boonchalee","Welcome Supattra Boonchalee !!");
        customerLoginPage.depositFunctionality("500","Deposit Successful");
        customerLoginPage.withDrawFunctionality("300","Transaction successful");
        customerLoginPage.transactionFunctionality();







    }

}
