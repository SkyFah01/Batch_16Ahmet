package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickButton = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickButton.click();
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));//Before Switch


        System.out.println(driver.getWindowHandle());//return one ID of the mainPage >> 93B1607866E79B4002E3D350459DBD3F
        String mainPageId= driver.getWindowHandle();
        Set<String> allPageID=driver.getWindowHandles();//return Set of mainPageID
        for(String id :allPageID){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
       // System.out.println(allPageID);//[92D1D55EF7CD38E36D69192ED4ED5909, 0717D04BE12CE34F837006B913401BDB] 2 main page ID
        header = driver.findElement(By.tagName("h3"));//reassign
        System.out.println(BrowserUtils.getText(header));//After switch

    }
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");


        WebElement openNewTapButton = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        BrowserUtils.scrollWithJS(driver,openNewTapButton);
        openNewTapButton.click();

        String mainPageId= driver.getWindowHandle();//this is my current driver page id
        Set<String> allPageId= driver.getWindowHandles();//all page id(include second page)
        for(String id : allPageId){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;

            }
        }



        //Me
        WebElement alertsDemoMessage = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        Assert.assertEquals(BrowserUtils.getText(alertsDemoMessage),"AlertsDemo");
        Assert.assertEquals(driver.getTitle(),"AlertsDemo - H Y R Tutorials");
        WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='promptBox']"));
        clickMeButton.click();
        Thread.sleep(2000);




    }
}
