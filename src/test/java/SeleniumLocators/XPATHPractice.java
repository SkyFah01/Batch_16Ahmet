package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) {

        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");


        //testing Register Account functionality
        //all is XPATH

        WebElement firstName =driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Supattra");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Boonchalee");

        WebElement email= driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("supattrabonchjgale@gmail.com");

        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        telephone.sendKeys("356563224");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("fah123");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirmPassword.sendKeys("fah123");

        WebElement subscribe = driver.findElement(By.xpath("//input[@value='0']"));
        subscribe.click();

        WebElement privacyBox = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyBox.click();


        WebElement clickContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
        clickContinue.click();

        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Been Created!')]"));
       String actualHeader = header.getText().trim();
       String expectedHeader = "Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader)?"PASSED":"NOT PASSED");

        WebElement continue2 = driver.findElement(By.xpath("//a[.='Continue']"));
        continue2.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualUrl.equals(expectedUrl)?"URL PASSED":"URL FAILED" );





    }
}
