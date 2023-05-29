package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementPractice {
    public static void main(String[] args) {

        WebDriverManager.chromiumdriver().setup();//setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//wait time
        driver.get("https://the-internet.herokuapp.com/");//url


        //TASK print all element and count
        List<WebElement> allElements =driver.findElements(By.xpath("//li"));
          int count =0;
        for(WebElement allList : allElements){
            System.out.println(allList.getText());
           count++;

        }
        System.out.println("element = " + count);

        //TASK2
        //Print it if length is equal and more than 12 and count how many

        List<WebElement> printLength =driver.findElements(By.xpath("//li"));

        int counter =0;
        for(WebElement list : printLength){
            if(list.getText().length() >= 12){
                System.out.println(list.getText().trim());
                counter++;
            }

        }
        System.out.println("Total list have length more than 12 =" +counter + "Element");










    }
}
