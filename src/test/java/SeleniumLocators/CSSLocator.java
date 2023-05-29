package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CSSLocator {
    public static void main(String[] args) {

        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");


        WebElement searchItem = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchItem.sendKeys("watch");

        WebElement searchButton= driver.findElement(By.cssSelector(".global-enhancements-search-input-btn-group__btn"));
        searchButton.click();
        String actualURL = driver.getCurrentUrl();
        String expectedUrl = "https://www.etsy.com/";
        System.out.println(actualURL.equals(expectedUrl)? "PASSED":"NOT PASSED");








    }
}
