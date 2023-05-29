package MyPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Practice1 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");

        WebElement searchSong = driver.findElement(By.xpath("//input[@id='search']"));
        searchSong.sendKeys("body gold");
        WebElement enter = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        enter.click();

        List<WebElement> song = driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement chooseSong :song){
            if(chooseSong.getAttribute("title").contains("Oh Wonder - Body Gold (Official Audio)")){

                Thread.sleep(2000);
                chooseSong.sendKeys(Keys.ARROW_DOWN);
                chooseSong.click();
            }

        }



    }
}
