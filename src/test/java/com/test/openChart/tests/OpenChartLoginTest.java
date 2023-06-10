package com.test.openChart.tests;

import com.test.openChart.pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase {

    @Test
    public void happyPathLogin() throws InterruptedException {

        OpenChartLoginPage openChartPage = new OpenChartLoginPage(driver);

        openChartPage.loginFunctionality("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");//validate title


    }
    @Test
    public void validateNegativeLogin() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.loginFunctionality("wrongUsername","wrongPassword");
        Assert.assertEquals(openChartLoginPage.errorMessage(),"No match for Username and/or Password.");
    }

}
