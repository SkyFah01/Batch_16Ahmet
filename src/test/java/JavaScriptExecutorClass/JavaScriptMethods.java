package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import com.beust.ah.A;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptMethods {
    @Test
    public void getTitle(){

        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");

        System.out.println(driver.getTitle()+ "with Selenium Method");//if use java not working
        JavascriptExecutor js = (JavascriptExecutor) driver;//casting it
        System.out.println(js.executeScript("return document.title")+"with JavaScript");//then use JavaScript for find the title


    }
    @Test
    public void clickJS() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");

        WebElement aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
        Actions actions = new Actions(driver);
        actions.click(aboutUs).perform();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        aboutUs.click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",aboutUs);



    }
    @Test
    public void ScrollIntoView() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

       // WebElement findOutCourse = driver.findElement(By.xpath("//span[contains(text(),'");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true)",findOutCourse);
        Thread.sleep(2000);
        //findOutCourse.click();
    }
    @Test
    public void Practice2() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement copyRight= driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        System.out.println(copyRight.getText().trim());// in case if not coming we will do scroll
        BrowserUtils.scrollWithJS(driver,copyRight);
        Thread.sleep(2000);
        String actualMessage = BrowserUtils.getText(copyRight);
        String expectedMessage = "Copyright © 2023";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement applyNowButton = driver.findElement(By.linkText("Apply Now"));
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,applyNowButton);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver,applyNowButton);
        Thread.sleep(2000);

        String actualTitle = BrowserUtils.getTitleWithJS(driver);
        String expectedTitle="Apply Now";
        Assert.assertEquals(actualTitle,expectedTitle);

        List<WebElement> allInformation = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInformation = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for(int i=0; i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));

        }








    }
}
