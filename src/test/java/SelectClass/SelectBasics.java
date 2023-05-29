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
import java.util.Arrays;
import java.util.List;

public class SelectBasics {


    @Test
    public void selectMethods() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//fixing the bug
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        dropDown.click();
        WebElement optionsBox = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select choice = new Select(optionsBox);//it means I will choose an option from THAT BOX
        //Default value is the things to need to check first
        String actualDefaultOption = choice.getFirstSelectedOption().getText().trim();
        String expectedDefaultOption="Please select an option";
        Assert.assertEquals(actualDefaultOption,expectedDefaultOption);

        choice.selectByVisibleText("Option 2");//whatever you have select, it will select it
        Thread.sleep(2000);
        choice.selectByValue("1");
        Thread.sleep(2000);
        //not suggest to use but just showing
        choice.selectByIndex(2);
        Thread.sleep(2000);

        //I want to get all options
        List<WebElement> actualOptions = choice.getOptions();//my actual options
        List<String> expectedOptions = Arrays.asList("Please select an option","Option 1","Option 2");//you can provide by yourself if it is small options

        for(int i=0 ; i<actualOptions.size(); i++){
            //compare option
            Assert.assertEquals(actualOptions.get(i).getText().trim(),expectedOptions.get(i).trim());

        }







    }

}
