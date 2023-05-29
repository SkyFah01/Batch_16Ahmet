import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro1 {

    //LOCATORS -->is a way to locate(find) element and manipulate on it
    public static void main(String[] args) throws InterruptedException {
        //web element >> it meant everything

        //ID LOCATION:
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");//fixing the bug
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///Users/fah/Desktop/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header = driver.findElement(By.id("techtorial1"));//finding element by id value
        String actualHeader = header.getText().trim();// it gets the text from element
        String expectedHeader ="Techtorial Academy";//next from id value location
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader)? "CORRECT":"WRONG");

        WebElement paragraph = driver.findElement(By.id("details2"));//for text

        System.out.println(paragraph.getText());

        //NAME LOCATOR
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Supattra");//now computer will type my name on it

        //choose copy from Id than name , if dont have it is ok
        //CONTROL C,F AND V --> check unique element
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Boonchalee");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("778-3457234");

        WebElement email = driver.findElement(By.name("userName"));
        email.sendKeys("supattraboonchalee@hotmail.com");

        WebElement address1= driver.findElement(By.name("address1"));
        address1.sendKeys("Mt Tolmie Ride ");

        WebElement city= driver.findElement(By.name("city"));
        city.sendKeys("Victoria BC ");


        WebElement state= driver.findElement(By.name("state"));
        state.sendKeys("Canada ");

        WebElement postalCode= driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("V8P");


        //CLASS LOCATOR
        WebElement allTools= driver.findElement(By.className("group_checkbox"));// from class locator
        System.out.println(allTools.getText());//you can locate element by class

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed() && !javaBox.isSelected()) {//CHECKING >>javaBox showing on the website && JavaBox not select
            javaBox.click();//if not select then click

        }
            System.out.println(javaBox.isSelected() ? "SELECTED" : "NOT SELECTED");// if is select >> true



        //TASK1
        WebElement seleniumBox = driver.findElement(By.id("cond2"));
        if(seleniumBox.isDisplayed() && !seleniumBox.isSelected()){
            seleniumBox.click();

        }
        System.out.println(seleniumBox.isSelected()? "SELECTED":"NOT SELECTED");

        //TASK2
        WebElement testNG = driver.findElement(By.id("cond3"));
        if(testNG.isDisplayed() && !testNG.isSelected()){
            testNG.click();

        }
        System.out.println(testNG.isSelected()?"CHECKED":"NOT CHECKED");


        //TAG NAME LOCATOR:>> // h1

        WebElement header2 = driver.findElement(By.tagName("h1"));//only the value NOT tag
        System.out.println(header2.getText());//Techtorial Academy

        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());

        Thread.sleep(2000);

        driver.quit();//close everything
    }
}


