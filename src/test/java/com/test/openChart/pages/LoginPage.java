package com.test.openChart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "#input-username")
    WebElement userName;

    @FindBy(css = "#input-password")
    WebElement userPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginSubmitButton;


    public void LoinFunctionality(String name ,String password) throws InterruptedException {
        userName.sendKeys(name);
        userPassword.sendKeys(password);
        loginSubmitButton.click();
        Thread.sleep(2000);



    }




}
