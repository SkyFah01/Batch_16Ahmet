package FileUpload;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        ChromeDriver driver = new ChromeDriver(options);
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile = driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/fah/Desktop/usa.png");
        WebElement uploadButton =driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();
        //to be able to use Submit button have 2 rule (act like click)
        //1-you have to have file that html under form
        //2-type html is Submit


        WebElement validateFileName = driver.findElement(By.cssSelector("#uploaded-files"));
        String actualName = BrowserUtils.getText(validateFileName);
        String exceptedName ="usa.png";
        Assert.assertEquals(actualName,exceptedName);



    }

    @Test
    public  void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        ChromeDriver driver = new ChromeDriver(options);
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");


        WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
        chooseFile.sendKeys("/Users/fah/Desktop/IMG_2211.JPG");

        WebElement validateMessage =driver.findElement(By.xpath("//b[.='Select file to send(max 196.45 MB)']"));
        String actualMessage = BrowserUtils.getText(validateMessage);
        String expectedMessage = "Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement acceptButton = driver.findElement(By.xpath("//input[@id='terms']"));
        if(acceptButton.isDisplayed() && !acceptButton.isSelected() && acceptButton.isEnabled()){
            acceptButton.click();
        }

        WebElement submitFile= driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitFile.click();
        Thread.sleep(2000);
        WebElement validate = driver.findElement(By.tagName("h3"));
        String actualValidate = BrowserUtils.getText(validate);
        String expectedValidate = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualValidate,expectedValidate);







    }
}
