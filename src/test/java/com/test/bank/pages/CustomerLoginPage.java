package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;

public class CustomerLoginPage {

    public CustomerLoginPage(WebDriver driver){
        PageFactory.initElements(driver , this);

    }


    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName ;

     @FindBy(xpath = "//button[@type='submit']")
     WebElement loginButton;

     @FindBy(xpath = "//strong[contains(text(),'Welcome')] ")
     WebElement header;

     @FindBy(xpath = "//button[@ng-class='btnClass2']")
     WebElement depositButton;

     @FindBy (xpath = "//input[@placeholder='amount']")
     WebElement amountDeposit;

     @FindBy(xpath = "//button[@type='submit']")
     WebElement submitDepositButton;

     @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
     WebElement successMessage;

     @FindBy(xpath = "//button[contains(text(),'Withdraw')]")
     WebElement withdrawButton;

     @FindBy(xpath = "//input[@placeholder='amount']")
     WebElement withdrawAmount;

     @FindBy(xpath = "//button[@type='submit']")
     WebElement submitWithdrawButton;

    @FindBy (xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement balance;

     @FindBy(xpath = "//span[contains(text(),'Transaction')]")
     WebElement transactionSuccessful;

    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionButton;

     @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
     WebElement depositCredit;

     @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
     WebElement withDrawDebit;



    public void loginFunctionality(String name ,String expectedHeader ) throws InterruptedException {
        BrowserUtils.selectBy(customerName,name,"text");
        Thread.sleep(2000);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
    }


     public void depositFunctionality( String depositAmount , String expectedMessage) throws InterruptedException {
         depositButton.click();
         Thread.sleep(2000);
         amountDeposit.sendKeys(depositAmount);
         submitDepositButton.submit();
         Thread.sleep(2000);
         Assert.assertEquals(BrowserUtils.getText(successMessage),expectedMessage);
     }

     public void withDrawFunctionality(String withDrawAmount ,String expectedWithdrawMessage) throws InterruptedException {
         withdrawButton.click();
         Thread.sleep(2000);
         withdrawAmount.sendKeys(withDrawAmount);
         Thread.sleep(2000);
         submitWithdrawButton.submit();
         Thread.sleep(2000);
         Assert.assertEquals(BrowserUtils.getText(transactionSuccessful),expectedWithdrawMessage);
     }

    public void transactionFunctionality() throws InterruptedException {

        int actualBalance = Integer.parseInt(BrowserUtils.getText(balance));
        Thread.sleep(2000);
        transactionButton.click();
        Thread.sleep(2000);
        int expectedBalance =(Integer.parseInt(BrowserUtils.getText(depositCredit))-Integer.parseInt(BrowserUtils.getText(withDrawDebit)));
        Assert.assertEquals(actualBalance,expectedBalance);



    }

















}
