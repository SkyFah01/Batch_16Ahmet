package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathRealHealthProject {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

         */
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointment.click();


        WebElement account = driver.findElement(By.xpath("//input[@value='John Doe']"));
        account.sendKeys("John Doe");

        WebElement accountPass = driver.findElement(By.xpath("//input[@value='ThisIsNotAPassword']"));
        accountPass.sendKeys("ThisIsNotAPassword");

        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");

        WebElement passWord = driver.findElement(By.xpath("//input[@id='txt-password']"));
        passWord.sendKeys("ThisIsNotAPassword");
        Thread.sleep(2000);

        //WebElement loginButton = driver.findElement(By.xpath("//button[.='Login']"));
        //CSS WITH CLASS
        WebElement loginButton = driver.findElement(By.cssSelector(".btn-default"));
        loginButton.click();

        Thread.sleep(2000);

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
       facility.sendKeys("HongKong CURA Healthcare Center ");

      WebElement  hospitalReadmission = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
      if(hospitalReadmission.isDisplayed()&& !hospitalReadmission.isSelected()){
          hospitalReadmission.click();
      }
      WebElement healthCareProgram = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
      healthCareProgram.click();

      WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
      date.sendKeys("14/05/2023");

      WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
      comment.sendKeys("I would like to make an appointment for x-ray");

      Thread.sleep(1000);

      WebElement bookAppointment = driver.findElement(By.xpath("//button[.='Book Appointment']"));
      bookAppointment.click();
     Thread.sleep(2000);

      WebElement header= driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
      String actualHeader = header.getText().trim();
      String expectedHeader="Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader)? "PASSED TESTNG":"FALSE TESTNG");

        WebElement printFacility = driver.findElement(By.xpath("//p[contains(text(),'Hongkong CURA Healthcare Center')]"));
        System.out.println(printFacility.getText());

        WebElement printYes = driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println(printYes.getText());

        WebElement printMedicaid = driver.findElement(By.xpath("//p[.='Medicaid']"));
        System.out.println(printMedicaid.getText());

        WebElement printDate = driver.findElement(By.xpath("//p[.='14/05/2023']"));
        System.out.println(printDate.getText());

        WebElement printComment = driver.findElement(By.xpath("//p[contains(text(),'I would like to make an appointment for x-ray')]"));
        System.out.println(printComment.getText());

        Thread.sleep(2000);
        WebElement homePage = driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]"));
        homePage.click();

        System.out.println(driver.getCurrentUrl());

        driver.close();














    }
}
