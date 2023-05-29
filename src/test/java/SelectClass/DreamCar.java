package SelectClass;

import Utils.BrowserUtils;
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
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
    public void HeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//fixing the bug
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
          /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */
        WebElement new_UsedOption= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        Thread.sleep(1000);
        BrowserUtils.selectBy(new_UsedOption,"new","value");

        WebElement makeOption = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makeOption,"Lexus","text");
        Thread.sleep(2000);

        WebElement model = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(model,"lexus-rx_350","value");
        Thread.sleep(2000);

        WebElement price = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceOption = new Select(price);
        String actualDefault=BrowserUtils.getText(priceOption.getFirstSelectedOption());
        String expectedPrice= "No max price";
        Assert.assertEquals(actualDefault,expectedPrice);
        Thread.sleep(2000);


        WebElement distance = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance,"40 miles","text");
        Thread.sleep(2000);

        WebElement zip = driver.findElement(By.cssSelector("#make-model-zip"));
        zip.clear();
        zip.sendKeys("60056");
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        search.click();
        Thread.sleep(2000);

        WebElement headMessage = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        String actualHeadMessage = BrowserUtils.getText(headMessage);
        String expected="New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeadMessage,expected);
        Thread.sleep(2000);

        WebElement sortPrice = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        Thread.sleep(2000);
        BrowserUtils.selectBy(sortPrice,"Lowest price","text");
        Thread.sleep(2000);
        List<WebElement>sortOrder = driver.findElements(By.xpath("//h2[@class='title']"));

        for(WebElement title : sortOrder){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));

            System.out.println(BrowserUtils.getText(title));
        }

        List<WebElement> sortingAllPrice = driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Integer> actualAllPrice = new ArrayList<>();
        List<Integer> expectedAllPrice= new ArrayList<>();

        for(int i=0; i<sortingAllPrice.size(); i++){

            //String prices=BrowserUtils.getText(sortingAllPrice.get(i)).replace("$","").replace(",","");

            actualAllPrice.add(Integer.parseInt(BrowserUtils.getText(sortingAllPrice.get(i)).replace("$","").replace(",","")));
            expectedAllPrice.add(Integer.parseInt(BrowserUtils.getText(sortingAllPrice.get(i)).replace("$","").replace(",","")));

        }
        Collections.sort(expectedAllPrice);
        Assert.assertEquals(actualAllPrice,expectedAllPrice);
        System.out.println(expectedAllPrice);
        System.out.println(actualAllPrice);






    }
}
