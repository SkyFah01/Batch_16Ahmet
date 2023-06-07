package AlertInterface;

import Utils.BrowserUtils;
import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void AlertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();//come from selenium
        String actualText =alert.getText().trim();//will get the text from pop-up that i cannot inspect
        String expectedText ="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);

        //UnhandledAlertException --> pop-up that you not handle
        alert.accept();//will click ok button otherwise you will get UNHANDLED ALERT EXCEPTION
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);










    }
    @Test
    public void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        jsConfirm.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();

        WebElement message = driver.findElement(By.xpath("//p[contains(@id,'result')]"));
        String actualMessage = message.getText().trim();
        String expectedMessage ="You clicked: Cancel";
        Assert.assertEquals(actualMessage,expectedMessage);



    }
    @Test
    public void AlertSentKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("I love selenium");
        Thread.sleep(2000);
        alert.accept();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = message.getText().trim();
        String expectedMessage = "You entered: I love selenium";
        Assert.assertEquals(actualMessage,expectedMessage);




    }
}
