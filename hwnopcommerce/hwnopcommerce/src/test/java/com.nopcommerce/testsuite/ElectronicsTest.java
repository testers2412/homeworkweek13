package com.nopcommerce.testsuite;

import com.nopcommerce.pages.*;
import com.nopcommerce.testbase.TestBase;
import net.bytebuddy.utility.RandomString;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ElectronicsTest extends TestBase {
    HomePage homePage = new HomePage();
    CellPhones cellPhones = new CellPhones();
    NokiaLumia1020 nokiaLumia1020 = new NokiaLumia1020();
    ShoppingCart shoppingCart = new ShoppingCart();
    LoginPage loginPage = new LoginPage();
    Register register= new Register();
    CheckOut checkOut= new CheckOut();
    ShippingMethod shippingMethod= new ShippingMethod();
    PaymentMethod paymentMethod= new PaymentMethod();
    PaymentInformation paymentInformation= new PaymentInformation();
    ConfirmOrder confirmOrder= new ConfirmOrder();
    OrderCompleted orderCompleted= new OrderCompleted();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        homePage.mouseHoverOnElectronics();
        homePage.clickOnCellPhone();
        cellPhones.verifyCellPhonePage("Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        homePage.mouseHoverOnElectronics();
        homePage.clickOnCellPhone();
        cellPhones.verifyCellPhonePage("Cell phones");
        Thread.sleep(2000);
        cellPhones.clickOnListView();
        Thread.sleep(2000);
        cellPhones.clickOnNokiaLumia1020();
        Thread.sleep(2000);
        nokiaLumia1020.verifyNokiaLumia1020Page("Nokia Lumia 1020");
        nokiaLumia1020.verifyPrice("$349.00");
        nokiaLumia1020.changeQty("2");
        nokiaLumia1020.clickOnAddToCart();
        nokiaLumia1020.verifyProductIsAddedToCart("The product has been added to your shopping cart");
        nokiaLumia1020.closeProductAddedMessagebox();
        Thread.sleep(2000);
        nokiaLumia1020.clickOnGoToCart();
        shoppingCart.verifyShoppingCartPage();
        shoppingCart.verifyQty("2");
        shoppingCart.verifySubTotal("$698.00");
        shoppingCart.acceptTAndC();
        shoppingCart.clickOnCheckOutButton();
        Thread.sleep(2000);
        loginPage.verifySignInPage();
        loginPage.clickOnRegister();
        Thread.sleep(2000);
        register.verifyRegisterPage("Register");
        register.clickOnGenderMale();
        register.enterFirstName("Ram");
        register.enterLastName("Kumar");
        register.selectDOB("9","8","1980");
        Thread.sleep(2000);
        RandomString rnd = new RandomString(10);
        String randString= rnd.nextString();
        register.enterEmail(randString+"@gmail.com");
        register.enterPassword("Abc123");
        register.enterConfirmPassword("Abc123");
        register.clickOnRegister();
        register.verifyRegistrationCompleted("Your registration completed");
        register.clickOnContinue();
        Thread.sleep(2000);
        shoppingCart.verifyShoppingCartPage();
        shoppingCart.acceptTAndC();
        shoppingCart.clickOnCheckOutButton();
        checkOut.selectCountryCode();
        checkOut.enterCity("Vadodara");
        checkOut.enterAddress1("9 Ayodhyay Apartments");
        checkOut.enterZipCode("391440");
        checkOut.enterTelephone("0091982536419");
        checkOut.clickOnContinue();
        Thread.sleep(2000);
        shippingMethod.clickOn2ndDayAir();
        shippingMethod.clickOnContinue();
        paymentMethod.clickOnCreditCard();
        paymentMethod.clickOnContinue();
        Thread.sleep(2000);
        paymentInformation.selectCreditCardType("visa");
        paymentInformation.enterCardHolderName("Ram Kumar");
        paymentInformation.enterCardNumber("4111 1111 1111 1111");
        paymentInformation.selectExpiryMonth("3");
        paymentInformation.selectExpiryYear("2025");
        paymentInformation.enterSecurityCode("756");
        paymentInformation.clickOnContinue();
        Thread.sleep(2000);
        confirmOrder.verifyPaymentType("Credit Card");
        Thread.sleep(2000);
        confirmOrder.verifyShippingMethod("2nd Day Air");
        Thread.sleep(2000);
        confirmOrder.verifyTotalAmount("$698.00");
        Thread.sleep(2000);
        confirmOrder.clickOnConfirmButton();
        Thread.sleep(2000);
        orderCompleted.verifyThankYouText("Thank you");
        orderCompleted.verifyOrderSuccessfulText("Your order has been successfully processed!");
        orderCompleted.clickOnContinue();
        Thread.sleep(2000);
        homePage.verifyWelcomeText("Welcome to our store");
        homePage.clickOnLogOut();
        homePage.verifyHomePage("https://demo.nopcommerce.com/");

    }

}

