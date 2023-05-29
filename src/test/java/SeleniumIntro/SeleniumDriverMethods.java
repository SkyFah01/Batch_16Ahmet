package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriverMethods {
    //driver.get()
    //driver.manage.windows.maximize()
    //driver.getTitle()
    //driver.getCurrentUrl()
    //driver.navigate.to()
    //driver.navigate.refresh()
    //driver.navigate.bank()
    //driver.navigate.forward()
    //driver.getPageSource()
    //driver.close()
    //driver.quit()

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//fixing the bug
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//it maximizes the screen
        //now my setup is done

        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);//pause the system for certain time (3 sec ) you will use a lot
        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);
        driver.navigate().back();//it will go to google again
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().forward();//it will go to your youtube again
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        driver.navigate().refresh();//it refreshes the page
        Thread.sleep(3000);

        //it gets the html structure of page on console //driver.getPageSource()
        System.out.println(driver.getPageSource());

        driver.quit();//it closes the all pages opened from one automation





    }
}
