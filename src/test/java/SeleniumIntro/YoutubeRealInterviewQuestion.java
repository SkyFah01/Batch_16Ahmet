package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromiumdriver().setup();//setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait time
        driver.get("https://www.youtube.com/");

        // Thread.sleep(2000)
        //song.sendKeys(Key.ARROW_DOWN) -->put this inside of loop
        WebElement searchBar =driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("billie eilish");
        searchBar.sendKeys(Keys.ENTER);


        //WebElement search = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
       // search.click();
        Thread.sleep(2000);//give enough time to website for load all element
        List<WebElement> allSongs =driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement song :allSongs){
            if(song.getAttribute("title").contains("Billie Eilish, Khalid - lovely")){

                Thread.sleep(2000);
                song.sendKeys((Keys.ARROW_DOWN));//scroll down
                song.click();
                break;
            }

        }



    }
}
