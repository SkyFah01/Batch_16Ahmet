package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void practiceMultipleWindows() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js=driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        //this work only 2 page
        String mainPageId = driver.getWindowHandle();
        Set<String> allPage = driver.getWindowHandles();
        for(String id: allPage){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;

            }
        }
        System.out.println(driver.getTitle());

        //this one work for everything >> more than 1 page
        BrowserUtils.switchByTitle(driver,"Contact");
        System.out.println(driver.getTitle());//Contact us
        System.out.println(driver.getCurrentUrl());//https://www.techtorialacademy.com/contact-us-techtorial
        Thread.sleep(2000);

        BrowserUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());
        BrowserUtils.switchByTitle(driver,"Courses");
        System.out.println(driver.getTitle());


    }
    @Test
    public void RealTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
                        /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */

        WebElement button4 = driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();

        BrowserUtils.switchByTitle(driver,"Basic Controls");

        WebElement firstName = driver.findElement(By.cssSelector("#firstName"));
        BrowserUtils.scrollWithJS(driver,firstName);
        firstName.sendKeys("Supattra");

        WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Boonchalee");

        WebElement gender = driver.findElement(By.cssSelector("#femalerb"));
        gender.click();
        Thread.sleep(2000);

        WebElement language = driver.findElement(By.cssSelector("#englishchbx"));
        language.click();
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("fah@hotmail.com");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("fah008");

        WebElement registerButton = driver.findElement(By.cssSelector("#registerbtn"));
        registerButton.click();
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.cssSelector("#msg"));
        String expectedMessage = "Registration is Successful";
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);

        BrowserUtils.switchByTitle(driver,"Window Handles");

        WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String expectedHeader = "Window Handles Practice";
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);

        BrowserUtils.switchByTitle(driver,"AlertsDemo");
        WebElement clickMeButton = driver.findElement(By.cssSelector("#alertBox"));
        clickMeButton.click();

        driver.quit();


    }

}
