package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        //yesButton.click();// try regural click
        //Actions actions = new Actions(driver); // try action click
        //actions.click(yesButton).perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",yesButton);
        WebElement headMessage = driver.findElement(By.cssSelector(".mt-3"));
        String actualHead1= BrowserUtils.getText(headMessage);
        String expectedHead1="You have selected Yes";
        Assert.assertEquals(actualHead1,expectedHead1);

        WebElement impressiveButton = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(impressiveButton.isEnabled());

        js.executeScript("arguments[0].click()",impressiveButton);

    }

}
