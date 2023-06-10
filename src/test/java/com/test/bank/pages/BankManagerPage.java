package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitAddCustomerButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')] \t\t")
    WebElement openAccountButton;

    @FindBy(css = "#userSelect")
    WebElement customerName;

    @FindBy(css = "#currency")
    WebElement currency;

    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')] ")
    WebElement customerButton;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchBox;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement> allInformation;

    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;

    public void addCustomerFunctionality(WebDriver driver,String firstName , String lastName ,String postCode ,String expectedMessage){//provide from test class , make it dynamic
        //provide driver because we need to call method in test class

        addCustomerButton.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitAddCustomerButton.submit();//when html have type of 'submit and under form >> use submit (act click)

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();


    }

    public void OpenAccountFunctionality(WebDriver driver,String name ,String currency ,String expectedMessage) throws InterruptedException {
        openAccountButton.click();
        BrowserUtils.selectBy(customerName,name,"text");
        BrowserUtils.selectBy(this.currency,currency,"value");
        processButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
        alert.accept();



    }

    public void customersButtonFunctionality(String customerName,String lastName , String postCode) throws InterruptedException {

        customerButton.click();

        searchBox.sendKeys(customerName);
        List<String> expectedNames = Arrays.asList(customerName,lastName,postCode);
        for(int i=0; i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedNames.get(i));
        }


    }

    public void clickHomeButton(){
        homeButton.click();
    }

}
