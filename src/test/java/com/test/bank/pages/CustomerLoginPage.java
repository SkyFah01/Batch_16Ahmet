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
    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName ;

     @FindBy(xpath = "//button[@type='submit']")
     WebElement loginSubmit;

     @FindBy(xpath = "//div//strong[contains(text(),'Welcome')] ")
     WebElement header;

     @FindBy(xpath = "//button[@ng-class='btnClass2']")
     WebElement clickDeposit;

     @FindBy (xpath = "//input[@placeholder='amount']")
     WebElement amountDeposit;

     @FindBy(xpath = "//button[@type='submit']")
     WebElement depositSubmit;

     @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
     WebElement depositSuccessful;

     @FindBy(xpath = "//button[contains(text(),'Withdraw')]")
     WebElement withdrawButton;

     @FindBy(xpath = "//input[@placeholder='amount']")
     WebElement withdrawAmount;

     @FindBy(xpath = "//button[@type='submit']")
     WebElement withdrawSubmit;

     @FindBy(xpath = "//span[contains(text(),'Transaction')]")
     WebElement transactionSuccessful;

     @FindBy(xpath = "//button[contains(text(),'Transactions')]")
     WebElement transactionButton;

     @FindBy(xpath = "//tr//td[contains(text(),'500')]")
     WebElement credit;

     @FindBy(xpath = "//tr//td[contains(text(),'300')]")
     WebElement debit;

     @FindBy (xpath = "//strong[contains(text(),'200')]")
     WebElement balance200 ;

     @FindBy(xpath = "//button[.='Back']")
     WebElement backButton;






    public void customerLoginFunctionality(String name,String expectedHeader ,String depositAmount ,String expectedMessage ,String withdraw ,String expectedTransactionMessage ) throws InterruptedException {
        //
     customerLoginButton.click();
     Thread.sleep(2000);
        BrowserUtils.selectBy(customerName,name,"text");
        loginSubmit.submit();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        clickDeposit.click();
        Thread.sleep(2000);
        amountDeposit.sendKeys(depositAmount);
        depositSubmit.submit();
        Thread.sleep(2000);

        Assert.assertEquals(BrowserUtils.getText(depositSuccessful),expectedMessage);
        withdrawButton.click();
        Thread.sleep(2000);
        withdrawAmount.sendKeys(withdraw);
        Thread.sleep(2000);
        withdrawSubmit.submit();
        Thread.sleep(2000);

        Assert.assertEquals(BrowserUtils.getText(transactionSuccessful),expectedTransactionMessage);
        Thread.sleep(2000);
        transactionButton.click();
        Thread.sleep(2000);



    }

    public void calculateBalance(){
        int calculate= (Integer.parseInt(credit.getText().trim())-(Integer.parseInt(debit.getText().trim())));
        String balance = String.valueOf(calculate);
        backButton.click();
        Assert.assertEquals(balance,BrowserUtils.getText(balance200));



    }










}
