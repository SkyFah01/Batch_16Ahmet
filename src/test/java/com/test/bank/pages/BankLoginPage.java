package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {
    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);// it does same logic of driver.findElement
        //provide instanced variable -->constructor
    }

    @FindBy(css = ".mainHeading")
    WebElement header;

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;

    @FindBy(xpath = "//button[contains(text(),'Bank ')]")
    WebElement ManagerLogin;

    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;

    public void LoginPageComponentsValidation(String expectedHeader){//call from test class
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);//make it dynamic
        Assert.assertTrue(customerLogin.isDisplayed() && customerLogin.isEnabled());
        Assert.assertTrue(ManagerLogin.isDisplayed() && ManagerLogin.isEnabled());


        //Do not provide hard coding  >> providing value under methods
        //Assert.assertEquals(BrowserUtils.getText(header),"XYZ Bank");DO nOT
    }

    public void clickManagerButton(){
       ManagerLogin.click();

    }

    public void clickCustomerButton(){

        homeButton.click();
    }


}
