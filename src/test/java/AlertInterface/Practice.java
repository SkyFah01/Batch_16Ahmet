package AlertInterface;

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

import java.time.Duration;

public class Practice {
    @Test
    public void  PracticeJSAlert() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertBox = driver.findElement(By.xpath("//button[contains(@id,'alertBox')]"));
        alertBox.click();
        Alert alert=driver.switchTo().alert();
        String alertBoxMessage = alert.getText().trim();
        String expectedAlertBoxMessage = "I am an alert box!";
        Assert.assertEquals(alertBoxMessage,expectedAlertBoxMessage);
        alert.accept();
        WebElement messageAlertBox = driver.findElement(By.xpath("//div[.='You selected alert popup']"));
        String actualMessageAlertBox = BrowserUtils.getText(messageAlertBox);
        String expectedAlertBox ="You selected alert popup";
        Assert.assertEquals(actualMessageAlertBox,expectedAlertBox);

        WebElement confirmBox = driver.findElement(By.xpath("//button[contains(@id,'confirmBox')]"));
        confirmBox.click();
        Alert alert1 = driver.switchTo().alert();
        String confirmBoxText = alert1.getText().trim();
        String expectedText = "Press a button!";
        Assert.assertEquals(confirmBoxText,expectedText);
        alert1.dismiss();

        WebElement confirmBoxMessage = driver.findElement(By.xpath("//div[contains(@id,'output')]"));
        String actualConfirmBoxMessage = BrowserUtils.getText(confirmBoxMessage);
        String expectedConfirmBox = "You pressed Cancel in confirmation popup";
        Assert.assertEquals(actualConfirmBoxMessage,expectedConfirmBox);

        WebElement promptBox = driver.findElement(By.xpath("//button[contains(@id,'promptBox')]"));
        promptBox.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Supattra");
        alert2.accept();

        WebElement promptBoxMessage = driver.findElement(By.xpath("//div[@id='output']"));
        String actualPromptBox = BrowserUtils.getText(promptBoxMessage);
        String expectedPromptBox ="You entered text Supattra in propmt popup";
        Assert.assertEquals(actualPromptBox,expectedPromptBox);






























    }
}
