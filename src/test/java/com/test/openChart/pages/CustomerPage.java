package com.test.openChart.pages;

import FramesAndiframe.NestedFrame;
import Utils.BrowserUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;

public class CustomerPage {

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addNewButton;

    @FindBy(xpath= "//input[@name='firstname']")
    WebElement firstName;

    @FindBy(css = "#input-lastname")
    WebElement lastName;

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-telephone")
    WebElement telephoneNumber;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;

    @FindBy(css = "#input-newsletter")
    WebElement newsLetter;

    @FindBy(css = "#input-status")
    WebElement status;

    @FindBy(css = "#input-safe")
    WebElement safe;

    @FindBy(xpath = "//button[@type='submit']//i[@class='fas fa-save']")
    WebElement saveButton;

    @FindBy(xpath = "//div//div[@id='alert']")
    WebElement errorMessage;

     public void customerDetail(String firstname , String lastname , String email ,String telephoneNum) throws InterruptedException {
       addNewButton.click();
       Thread.sleep(2000);
       firstName.sendKeys(firstname);
         Thread.sleep(2000);
       lastName.sendKeys(lastname);
         Thread.sleep(2000);
       this.email.sendKeys(email);
         Thread.sleep(2000);
       telephoneNumber.sendKeys(telephoneNum);
         Thread.sleep(2000);




     }

     public void customerPassword(String password , String confirmPassword){
         this.password.sendKeys(password);
         this.confirmPassword.sendKeys(confirmPassword);
     }

     public void selectButton(WebDriver driver ) throws InterruptedException {

         BrowserUtils.scrollWithJS(driver,saveButton);

         Actions actions = new Actions(driver);
         if (!newsLetter.isSelected()){
             actions.click().perform();
         }
         if (! status.isSelected()){
             actions.click().perform();
         }
         if (! safe.isSelected()){
             actions.click().perform();
         }
         BrowserUtils.scrollWithJS(driver,saveButton);
         Thread.sleep(2000);
         saveButton.click();
         Thread.sleep(2000);




     }

     public void validateErrorMessage(String expectedErrorMessage){
         Assert.assertEquals(BrowserUtils.getText(errorMessage),expectedErrorMessage);
     }









     }
