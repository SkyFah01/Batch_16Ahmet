package SoftAssertClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Practice {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertBox = driver.findElement(By.cssSelector("#alertBox"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(alert.getText(),"I am an alert boxss!");
        alert.accept();
        WebElement alertMsg = driver.findElement(By.cssSelector("#output"));
        softAssert.assertEquals(BrowserUtils.getText(alertMsg),"You selected alert popup");

        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmBox"));
        confirmBox.click();
        Alert alert1 = driver.switchTo().alert();
        softAssert.assertEquals(alert1.getText(),"Press a button!ss");
        alert1.dismiss();
        WebElement confirmMsg = driver.findElement(By.cssSelector("#output"));
        softAssert.assertEquals(BrowserUtils.getText(confirmMsg),"You pressed Cancel in confirmation popup");

        WebElement promPtBox = driver.findElement(By.cssSelector("#promptBox"));
        promPtBox.click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("supattra");
        alert3.accept();
        WebElement promptMsg = driver.findElement(By.cssSelector("#output"));
        softAssert.assertEquals(BrowserUtils.getText(promptMsg),"You entered text supattra in propmt popup");

        softAssert.assertAll(); //need to put always// not show where is fail
    }
}
