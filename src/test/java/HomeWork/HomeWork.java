package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeWork {
    /*

1-Create a homework package and class
2-Under 1 main method--> go to 3 different websites and validate the title,
and URL of the page with Ternary Operator. (It can be any website you decide)
SIDE NOTE: You do not need to create 3 different web drivers. One will be enough.
     */
    public static void main(String[] args) {

        //First
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://www.vogue.com/");
        System.out.println(webDriver.getTitle());


        String actualTitle= webDriver.getTitle();
        String  expectedTitle = "Vogue: Fashion, Beauty, Celebrity, Fashion Shows | Vogue";
        System.out.println(actualTitle.equals(expectedTitle)? "Title Passed":"Title Failed");

        String actualUrl = webDriver.getCurrentUrl();
        String expectedUrl ="https://www.vogue.com/";
        System.out.println(actualUrl.equals(expectedUrl)? "URL IS PASSED" : "URL IS FAILED");

        webDriver.close();

        //Second
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://www.zara.com/ca/");
        System.out.println(webDriver.getTitle());

        String actualTitle2= webDriver.getTitle();
        String  expectedTitle2 = "Dresses for Women | ZARA Canada";
        System.out.println(actualTitle2.equals(expectedTitle2)? "Title Passed":"Title Failed");

        String actualUrl2 = webDriver.getCurrentUrl();
        String expectedUrl2 ="https://www.vogue.com/";
        System.out.println(actualUrl2.equals(expectedUrl2)? "URL IS PASSED" : "URL IS FAILED");

        webDriver.close();

        //Third
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://food-guide.canada.ca/en/");
        System.out.println(webDriver.getTitle());

        String actualTitle3= webDriver.getTitle();
        String  expectedTitle3 = "Canada's Food Guide";
        System.out.println(actualTitle3.equals(expectedTitle3)? "Title Passed":"Title Failed");

        String actualUrl3 = webDriver.getCurrentUrl();
        String expectedUrl3 ="https://food-guide.canada.ca/en/";
        System.out.println(actualUrl3.equals(expectedUrl3)? "URL IS PASSED" : "URL IS FAILED");

        webDriver.close();
    }
}
