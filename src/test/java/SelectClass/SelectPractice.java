package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelectPractice {
    @Test
    public  void practice() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//fixing the bug
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/fah/Desktop/Techtorial.html");

        WebElement countryOptions = driver.findElement(By.xpath("//select[@name='country']"));
        Select country = new Select(countryOptions);
        String actualDefault = country.getFirstSelectedOption().getText().trim();
        String expectedDefault = "UNITED STATES";
        Assert.assertEquals(actualDefault , expectedDefault);
        List<WebElement> allCountry = country.getOptions();

        int count =0;
        for(int i=0; i<allCountry.size() ; i++){
            System.out.println(allCountry.get(i).getText().trim());
            count++;


        }

        System.out.println("Total of country "+count);
        Thread.sleep(2000);


        //TASK: Choose your own country with VisibleText method
        //:Chooses Favorite country with value
        //:Choose Travel Country with index
        country.selectByVisibleText("THAILAND ");
        Thread.sleep(2000);
        country.selectByValue("198");
        Thread.sleep(2000);
        country.selectByIndex(15);
        Thread.sleep(2000);













    }

}
