package com.test.openChart.tests;

import Utils.BrowserUtils;
import com.test.openChart.pages.CustomerPage;
import com.test.openChart.pages.LoginPage;
import com.test.openChart.pages.HomePage;
import org.testng.annotations.Test;

public class CustomerTest extends OpenChartTestBase {

    @Test

    public void customerFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CustomerPage customerPage = new CustomerPage(driver);

        loginPage.LoinFunctionality("demo","demo");
        homePage.customerHomePage();
        customerPage.customerDetail("Supattra","Boonchalee","fah@hotmail.com","5678999995");
        customerPage.customerPassword("f001","f001");
        customerPage.selectButton(driver);
        customerPage.validateErrorMessage("Warning: You do not have permission to modify customers!");








    }

}
