package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro2 {
    public static void main(String[] args) {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//fixing the bug
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();//it maximizes the screen
        driver.get("file:///Users/fah/Desktop/Techtorial.html");

        //LINK TEXT LOCATOR
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));//control f write //h1
        String actualHeader = javaHeader.getText().trim(); //from website/system
        String expectedHeader ="Java";
        System.out.println(actualHeader.equals(expectedHeader)? "CORRECT":"FALSE");//  call implementation ** important step



        //TASK
        /*
1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
2-Go back to the main page
3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
4-Go back to the main page
5-Click TestNG and validate(ternary) header -->TestNG
6-Go back to the main page
7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
 */


        driver.navigate().back();
        WebElement selenium = driver.findElement(By.linkText("Selenium"));
        selenium.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        String actualSeleniumHeader = seleniumHeader.getText().trim();
        String expectedSelenium ="Selenium automates browsers. That's it!";
        System.out.println(actualSeleniumHeader.equals(expectedSelenium)? "PASSED SELENIUM":"FALSE SELENIUM");
        driver.navigate().back();

        WebElement cucumber = driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        WebElement cucumberHeader = driver.findElement(By.tagName("h1"));
        String actualCucumber = cucumberHeader.getText().trim();
        String expectedCucumber ="Tools & techniques that elevate teams to greatness";
        System.out.println(actualCucumber.equals(expectedCucumber)? "PASSED CUCUMBER":"FALSE CUCUMBER");
        driver.navigate().back();


        WebElement testNG = driver.findElement(By.linkText("TestNG"));
        testNG.click();
        WebElement testNGHeader = driver.findElement(By.tagName("h2"));
        String actualTestNG = testNGHeader.getText().trim();
        String expectedTestNg="TestNG";
        System.out.println(actualTestNG.equals(expectedTestNg)?"PASSED TESTNG":"FALSE TESTNG");
        driver.navigate().back();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "file:///Users/fah/Desktop/Techtorial.html";
        System.out.println(actualUrl.equals(expectedUrl)? "URL PASSED":"URL FAILED");


        //LOCATOR PARTIALLINKTEXT:

        WebElement restApt = driver.findElement(By.partialLinkText("Rest"));
        restApt.click();
        System.out.println(driver.getTitle());


























    }
}
