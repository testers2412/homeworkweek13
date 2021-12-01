package com.xcart.testsuite;

import com.xcart.pages.HomePage;
import com.xcart.testbase.TestBase;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {
    HomePage homePage= new HomePage();
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {
        homePage.selectMenuFromMenuBar("Shipping");
        homePage.verifyLendingPage("Shipping");
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {
        homePage.selectMenuFromMenuBar("New!");
        homePage.verifyLendingPage("New arrivals");
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() throws InterruptedException{
        homePage.selectMenuFromMenuBar("Coming soon");
        homePage.verifyLendingPage("Coming soon");
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException{
        homePage.selectMenuFromMenuBar("Contact us");
        homePage.verifyLendingPage("Contact us");
    }

}
