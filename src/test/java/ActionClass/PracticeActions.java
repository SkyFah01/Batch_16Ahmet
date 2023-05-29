package ActionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeActions {
    @Test
    public void practiceDragAndDrop() throws InterruptedException {

        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        String actualText = BrowserUtils.getText(dragMe);
        String expectedText="Drag me";
        Assert.assertEquals(actualText,expectedText);
        Thread.sleep(2000);
        WebElement dropAble = driver.findElement(By.xpath("//div[@class='simple-drop-container']/div[@id='droppable']"));
        String actualMessage= BrowserUtils.getText(dropAble);
        String expectedMessage = "Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, dropAble).perform();
        dropAble = driver.findElement(By.xpath("//div[@class='simple-drop-container']/div[@id='droppable']"));
        String actualAfterDragAndDrop = BrowserUtils.getText(dropAble);
        String expectedAfterDragAndDrop= "Dropped!";
        Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);
        Thread.sleep(2000);
        String actualColor = dropAble.getCssValue("background-color");
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);








    }
    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement acceptButton = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptButton.click();
        Thread.sleep(2000);
        WebElement notAccept = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String actualText= BrowserUtils.getText(notAccept);
        String expectedText = "Not Acceptable";
        Assert.assertEquals(actualText,expectedText);
        Thread.sleep(2000);
        WebElement box = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualMessage = BrowserUtils.getText(box);
        String expectedMessage= "Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);

        Actions actions = new Actions(driver); //action is interface
        actions.clickAndHold(notAccept).moveToElement(box).release().perform();
        String actualMessageAfterAction = BrowserUtils.getText(box);
        String expectedAfterAction ="Drop here";
        Assert.assertEquals(actualMessageAfterAction,expectedAfterAction);

    }
}
