package TestNG;

import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class OpenChartTestNGPractice {

    @Test
    public void successfulLogin() throws InterruptedException {

        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");

        WebElement login = driver.findElement(By.tagName("button"));
        login.click();

        Thread.sleep(2000);
        WebElement click =driver.findElement(By.cssSelector(".btn-close"));
        click.click();

        String actualTitle =driver.getTitle(); //Dashboard
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle,expectedTitle);


    }
    @Test
    public void negativeLoginTest() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("DEMO");

        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        Thread.sleep(2000);

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='alert']"));
        String actualMessage =  errorMessage.getText().trim();
        String expectedMessage ="No match for Username and/or Password.";
        Assert.assertEquals(actualMessage,expectedMessage);



    }
    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        Thread.sleep(2000);

        WebElement xButton =driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();

        Thread.sleep(2000);

        WebElement catalogButton =driver.findElement(By.xpath("//a[@class='parent collapsed']"));
        catalogButton.click();
         Thread.sleep(2000);

        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(productsButton.isDisplayed());
        Assert.assertTrue(productsButton.isEnabled());
    }

    
    @Test
    public void  validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();
        Thread.sleep(2000);

        WebElement xButton =driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();
        Thread.sleep(2000);

        WebElement catalogButton =driver.findElement(By.xpath("//a[@class='parent collapsed']"));
        catalogButton.click();
        Thread.sleep(2000);
        WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
        productsButton.click();
        Thread.sleep(2000);


        /*
        1-Find the all boxes location
        2-Use regular for loop and start from 1 (int i=1)
        3-Inside of loop you should have:

          1-Thread,sleep
          2-IsDisplayed(true)
          3-IsEnabled(true)
          4-IsSelected(false)-->AssertFalse
          5-Click
          6-IsSelected(true)-->AssertTrue
          7-box.sendKeys(Keys.Arrow.Down)

         */

        List<WebElement> allBoxes =driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=1 ; i<allBoxes.size(); i++){
           Thread.sleep(1000);
           Assert.assertTrue(allBoxes.get(i).isDisplayed());
           Assert.assertTrue(allBoxes.get(i).isEnabled());

           Assert.assertFalse(allBoxes.get(i).isSelected());//as default, it should not be selected
           allBoxes.get(i).click();

           Assert.assertTrue(allBoxes.get(i).isSelected());//this one should be selected
           allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
           allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
           Thread.sleep(2000);



        }


    }
      @Test
      public void validateProductNameFunctionaillity() throws InterruptedException {
          WebDriverManager.chromiumdriver().setup();
          ChromeOptions options= new ChromeOptions();
          options.addArguments("--remote-allow-origins=*");
          WebDriver driver = new ChromeDriver(options);
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.navigate().to("https://demo.opencart.com/admin/");

          WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
          username.sendKeys("demo");

          WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
          password.sendKeys("demo");

          WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
          button.click();
          Thread.sleep(2000);

          WebElement xButton =driver.findElement(By.cssSelector(".btn-close"));
          xButton.click();
          Thread.sleep(2000);

          WebElement catalogButton =driver.findElement(By.xpath("//a[@class='parent collapsed']"));
          catalogButton.click();
          Thread.sleep(2000);
          WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
          productsButton.click();
          Thread.sleep(2000);

          /*
          TEST CASE:

          1-You will click the productName button
          2-You should create 2 arraylist
            *-One of them will be actualData
            *-Another will be expectedData
          3-For(int i=1)
            *store all the names for both of the list. Please use at the end .ToUppercase or ToLowerCase
          4-For expected List --> You will use Collection.sort(expectedList)
                              -->Collections.reverse(expected)
                              Assert.equals(actualList,expectedList)

           */
          WebElement productNameButton = driver.findElement(By.xpath("//a[contains(text(),'Product Name')]"));
          productNameButton.click();
          List<WebElement> allProductsName=driver.findElements(By.xpath("//td[@class='text-start']"));
          ArrayList<String> actualData = new ArrayList<>();
          ArrayList<String> expectData = new ArrayList<>();

          for(int i=1 ; i<allProductsName.size(); i++){
             actualData.add(allProductsName.get(i).getText().toLowerCase().trim());//same order same item
             expectData.add(allProductsName.get(i).getText().toLowerCase().trim());//same order same item

          }

          Collections.sort(expectData);
          System.out.println(actualData);
          System.out.println(expectData);
          Assert.assertEquals(actualData,expectData);


      }
      @Test
      public void validateDescendingOrder() throws InterruptedException {
          WebDriverManager.chromiumdriver().setup();
          ChromeOptions options= new ChromeOptions();
          options.addArguments("--remote-allow-origins=*");
          WebDriver driver = new ChromeDriver(options);
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.navigate().to("https://demo.opencart.com/admin/");

          WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
          username.sendKeys("demo");

          WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
          password.sendKeys("demo");

          WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
          button.click();
          Thread.sleep(2000);

          WebElement xButton =driver.findElement(By.cssSelector(".btn-close"));
          xButton.click();
          Thread.sleep(2000);

          WebElement catalogButton =driver.findElement(By.xpath("//a[@class='parent collapsed']"));
          catalogButton.click();
          Thread.sleep(2000);
          WebElement productsButton = driver.findElement(By.xpath("//a[.='Products']"));
          productsButton.click();
          Thread.sleep(2000);

          WebElement productNameButton = driver.findElement(By.xpath("//a[.='Product Name']"));
          productNameButton.click();
          Thread.sleep(3000);
          List<WebElement> allProductsName=driver.findElements(By.xpath("//td[@class='text-start']"));
          ArrayList<String> actualDAta = new ArrayList<>();
          ArrayList<String> expectData = new ArrayList<>();

          for(int i=1 ; i<allProductsName.size(); i++){
              actualDAta.add(allProductsName.get(i).getText().toLowerCase().trim());//same order same item
              expectData.add(allProductsName.get(i).getText().toLowerCase().trim());//same order same item

          }

          Collections.sort(expectData);//Ascending order
          Collections.reverse(expectData);
          System.out.println(actualDAta);
          System.out.println(expectData);
          Assert.assertEquals(actualDAta,expectData);


      }

      @Test
    public void exp(){
        List<String> names2= Arrays.asList("Ahmet","Mehmet","Ayse","Mahmut");
          List<String> names3= Arrays.asList("Ahmet","Ayse","Mehmet","Mahmut");
          System.out.println(names3);//[Ahmet, Ayse, Mehmet, Mahmut]
          Collections.sort(names3);
          Collections.sort(names2);
          System.out.println(names2);
          System.out.println(names3);//[Ahmet, Ayse, Mahmut, Mehmet]

      }


      }




