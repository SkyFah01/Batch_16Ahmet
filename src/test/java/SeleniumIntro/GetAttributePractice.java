package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class GetAttributePractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromiumdriver().setup();//setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait time
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");//url

        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();


        List<WebElement> allBox =driver.findElements(By.xpath("//div[@role='checkbox']"));
           for(WebElement list : allBox){
           if(list.getAttribute("aria-checked").equals("false")){
               list.click();
           }

       }




    }
}
