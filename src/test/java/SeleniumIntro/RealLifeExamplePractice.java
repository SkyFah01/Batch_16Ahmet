package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class RealLifeExamplePractice {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//3. Get Title of page and validate it.(if conditions) expected title from website
//3. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)

    public static void main(String[] args) {

        WebDriverManager.chromiumdriver().setup();//set up system
        ChromeOptions chromeOptions = new ChromeOptions();// set up chrome

        chromeOptions.addArguments("--remote-allow-origins=*");//so importance , don't miss any word

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.godaddy.com/en-ca");

        System.out.println(driver.getTitle());//actual

        String actualTitle = driver.getTitle();

        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy CA";//control f write //title and delete e to able copy link
        System.out.println(actualTitle.equals(expectedTitle)? "TITLE PASSED" :"TOTLE FAILED");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/en-ca";
        System.out.println(actualUrl.equals(expectedUrl)?"URL PASSED":"URL FAILED");

        driver.close();


    }
}
