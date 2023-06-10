package com.test.openChart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//button[@class='btn-close']")
    WebElement xButton;
    @FindBy(xpath = "//ul[@id='menu']//a[contains(text(),'Customers')]")
    WebElement customersMenu;

    @FindBy(xpath = "//ul[@id='collapse-5']//li//a[contains(text(),'Customers')]")
    WebElement customerButton;





    public void customerHomePage() throws InterruptedException {
        xButton.click();
        customersMenu.click();
        Thread.sleep(2000);
        customerButton.click();


    }




}
