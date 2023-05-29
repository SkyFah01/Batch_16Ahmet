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
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {
    @Test
    public void validateOrderMessage() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//fixing the bug
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        /*
        1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
         */

        WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();
        Thread.sleep(2000);
        WebElement passengerOption = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengerChoice = new Select(passengerOption);//create object
        passengerChoice.selectByVisibleText("4");
        Thread.sleep(2000);

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingChoice = new Select(departingFrom);
        String actualDefaultDepart = departingChoice.getFirstSelectedOption().getText().trim();
        String expectedDepart = "Acapulco";
        Assert.assertEquals(actualDefaultDepart, expectedDepart);
        Thread.sleep(2000);
        departingChoice.selectByValue("Paris");

        WebElement monthOn = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select monthChoiceOn = new Select(monthOn);
        monthChoiceOn.selectByValue("8");
        Thread.sleep(2000);

        WebElement dateOn = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select dateChoice = new Select(dateOn);
        dateChoice.selectByValue("15");
        Thread.sleep(2000);

        WebElement arriving = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivingChoice = new Select(arriving);
        arrivingChoice.selectByVisibleText("San Francisco");

        WebElement returningMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returningMonthChoice = new Select(returningMonth);
        returningMonthChoice.selectByValue("12");
        Thread.sleep(2000);
        WebElement returningDate = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returningDateChoice = new Select(returningDate);
        returningDateChoice.selectByVisibleText("15");
        Thread.sleep(2000);

        WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();
        Thread.sleep(2000);

        WebElement allOptionAirline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineChoice = new Select(allOptionAirline);
        List<WebElement> actualAirlineOption = airlineChoice.getOptions();
        List<String> expectedAirlineOption = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < actualAirlineOption.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(actualAirlineOption.get(i)), expectedAirlineOption.get(i).trim());


        }
        airlineChoice.selectByVisibleText("Unified Airlines");
        Thread.sleep(2000);

        WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
        continueButton.click();
        Thread.sleep(2000);

        WebElement messageFightFinder = driver.findElement(By.xpath("//font[@size='4']"));
        //String actualMessage = messageFightFinder.getText().trim();
        String expectMessage = "After flight finder - No Seats Available";

        Assert.assertEquals(BrowserUtils.getText(messageFightFinder),expectMessage);

    }
        @Test
        public void validateOrderMessageShortcut() throws InterruptedException {
            WebDriverManager.chromiumdriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");//fixing the bug
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

            //make shortcut for use object from another class with select

            WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
            oneWay.click();
            Thread.sleep(2000);
            WebElement passengerOption = driver.findElement(By.xpath("//select[@name='passCount']"));
//            Select passengerChoice = new Select(passengerOption);//create object
//            passengerChoice.selectByVisibleText("4");
            BrowserUtils.selectBy(passengerOption,"4","value");//does exactly the same thing

            WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));
            Select departingChoice = new Select(departingFrom);
            String actualDefaultDepart = departingChoice.getFirstSelectedOption().getText().trim();
            String expectedDepart = "Acapulco";
            Assert.assertEquals(actualDefaultDepart, expectedDepart);
            Thread.sleep(2000);
            //departingChoice.selectByValue("Paris");
            BrowserUtils.selectBy(departingFrom,"Paris","value");

            WebElement monthOn = driver.findElement(By.xpath("//select[@name='fromMonth']"));
//            Select monthChoiceOn = new Select(monthOn);
//            monthChoiceOn.selectByValue("8");
            BrowserUtils.selectBy(monthOn,"8","value");
            Thread.sleep(2000);

            WebElement dateOn = driver.findElement(By.xpath("//select[@name='fromDay']"));
//            Select dateChoice = new Select(dateOn);
//            dateChoice.selectByValue("15");
            BrowserUtils.selectBy(dateOn,"15","value");
            Thread.sleep(2000);

            WebElement arriving = driver.findElement(By.xpath("//select[@name='toPort']"));
//            Select arrivingChoice = new Select(arriving);
//            arrivingChoice.selectByVisibleText("San Francisco");
            BrowserUtils.selectBy(arriving,"San Francisco","text");

            WebElement returningMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
//            Select returningMonthChoice = new Select(returningMonth);
//            returningMonthChoice.selectByValue("12");
            BrowserUtils.selectBy(returningMonth,"12","value");
            Thread.sleep(2000);
            WebElement returningDate = driver.findElement(By.xpath("//select[@name='toDay']"));
//            Select returningDateChoice = new Select(returningDate);
//            returningDateChoice.selectByVisibleText("15");
            BrowserUtils.selectBy(returningDate,"15","text");
            Thread.sleep(2000);

            WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
            firstClass.click();
            Thread.sleep(2000);

            WebElement allOptionAirline = driver.findElement(By.xpath("//select[@name='airline']"));
            Select airlineChoice = new Select(allOptionAirline);
            List<WebElement> actualAirlineOption = airlineChoice.getOptions();
            List<String> expectedAirlineOption = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

            for (int i = 0; i < actualAirlineOption.size(); i++) {
                Assert.assertEquals(BrowserUtils.getText(actualAirlineOption.get(i)), expectedAirlineOption.get(i).trim());


            }
            airlineChoice.selectByVisibleText("Unified Airlines");
            Thread.sleep(2000);

            WebElement continueButton = driver.findElement(By.xpath("//input[@type='image']"));
            continueButton.click();
            Thread.sleep(2000);

            WebElement messageFightFinder = driver.findElement(By.xpath("//font[@size='4']"));
            //String actualMessage = messageFightFinder.getText().trim();
            String expectMessage = "After flight finder - No Seats Available";

            Assert.assertEquals(BrowserUtils.getText(messageFightFinder),expectMessage);//use BrowserUtils to not repeat
        }

    }

