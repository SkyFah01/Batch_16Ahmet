package FramesAndiframe;

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
import java.util.ArrayList;
import java.util.List;

public class FramePractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));

        driver.switchTo().frame("mce_0_ifr"); //hey you need to switch to frame by use name/id of frame or webElement
        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");
        //System.out.println(BrowserUtils.getText(header));//StaleElementReferenceException >> because you inside of frame
        driver.switchTo().parentFrame();//go to previous one
        header = driver.findElement(By.tagName("h3"));//reassign
        System.out.println(BrowserUtils.getText(header));




    }
    @Test
    public void Task() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

      /*
            TASK 1:
         1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
         2-Click pavilion (new tab will be opened, consider switch window)
         3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
         4-Validate the Header "Selenium-Python Tutorial"
         5-Print out(NO validation) all the links from website
         6-Wait for Second task
 */

        WebElement pavilion = driver.findElement(By.linkText("Pavilion"));
        pavilion.click();

        BrowserUtils.switchByTitle(driver,"qavalidation");
         WebElement selenium= driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
         Actions actions = new Actions(driver);
         actions.moveToElement(selenium).perform();

         WebElement seleniumPhyton = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']"));
         actions.click(seleniumPhyton).perform();

         WebElement header = driver.findElement(By.tagName("h1"));
         String actualHeader = BrowserUtils.getText(header);
         String expectedHeader = "Selenium-Python Tutorial";
        Assert.assertEquals(actualHeader,expectedHeader);

        List<WebElement> printOutAllLinks= driver.findElements(By.xpath("//p//a[@href]"));

        for(int i=0; i<printOutAllLinks.size();i++){
            System.out.println(printOutAllLinks.get(i).getAttribute("href"));
        }

        //Ahmet way
//        for(WebElement link : printOutAllLinks){
//            System.out.println(BrowserUtils.getText(link));
//
//        }

        /*
         TASK 2:
      1-Go back to the main page "iframe"
      2-click category 1
      3-Validate the header "Category Archives: SeleniumTesting"
      4-Print out all the headers of the contents(i will show you)
 */

        BrowserUtils.switchByTitle(driver,"iframes");//this is where my driver pointing
        driver.switchTo().frame("Frame1");//hey you need to switch to frame by use name/id of frame or webElement
        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();

        BrowserUtils.switchByTitle(driver,"SeleniumTesting");
        WebElement headerCategory1 = driver.findElement(By.tagName("h1"));
        String actualHeaderCategory = BrowserUtils.getText(headerCategory1);
        String expectedHeaderCategory = "Category Archives: SeleniumTesting";
        Assert.assertEquals(actualHeaderCategory,expectedHeaderCategory);
        Thread.sleep(2000);

        List<WebElement> allHeader = driver.findElements(By.xpath("//h3//a"));
        for(WebElement printAllHeader : allHeader){

            System.out.println(BrowserUtils.getText(printAllHeader));
        }

        /*
       TASK 3:
      1-Go back mainPage
      2-Click Category3
      3-Validate the header "Category Archives: SoftwareTesting"

 */
        System.out.println();
        System.out.println();

        BrowserUtils.switchByTitle(driver,"iframes");//this is where my driver pointing
        driver.switchTo().frame("Frame1");
        WebElement printText = driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getText(printText));


        driver.switchTo().parentFrame();//hey you need to go back to parent
        driver.switchTo().frame("Frame2");//hey you need to switch to frame by use name/id of frame or webElement
        WebElement category3 =driver.findElement(By.linkText("Category3"));
        category3.click();

        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives ");
        WebElement validateHeader = driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(validateHeader));
        Thread.sleep(2000);





    }
}
