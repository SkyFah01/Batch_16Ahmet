package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {

    //FIRST STEP IS setting up your automation

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();//set up your chrome
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");//bug, not importance

        //Then create your driver to start automation

        WebDriver driver = new ChromeDriver(options);//way to create your driver to connect with your website , manipulate data from website. it is importance

        driver.get("https://www.amazon.com/");//execute by this code
        System.out.println(driver.getTitle());

        String actualTitle = driver.getTitle();//from our library ,actual come from website

        String expectedTitle = "Amazon.com. Spend less. Smile more."; //link from amazon by control f and write //titl and copy link
        if(actualTitle.equals(expectedTitle)){ //if not match is a bug

            System.out.println("Passed");//Passed

        }else {
            System.out.println("Failed");
        }

        String actualUrl = driver.getCurrentUrl();

        String expectedUrl="https://www.amazon.com/"; // i need to provide --> COPY LINK AMAZON

        if(actualUrl.equals(expectedUrl)){
            System.out.println("URL IS PASSED");

        }else{

            System.out.println("URL IS FAILED");
        }

        driver.close();//close website





    }

}
