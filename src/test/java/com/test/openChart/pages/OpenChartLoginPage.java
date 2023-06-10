package com.test.openChart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenChartLoginPage {

    public OpenChartLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#input-username")
    WebElement userName;

    @FindBy(css = "#input-password")
    WebElement userPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginSubmitButton;


    @FindBy(css = "#alert")
    WebElement errorMessage;

    public void loginFunctionality(String userName ,String password ) throws InterruptedException {
        this.userName.sendKeys(userName);// if name same with constructor we need to use this.
        userPassword.sendKeys(password);
        loginSubmitButton.submit();Thread.sleep(2000);


    }
    public String errorMessage(){

        return BrowserUtils.getText(errorMessage);
    }






}
