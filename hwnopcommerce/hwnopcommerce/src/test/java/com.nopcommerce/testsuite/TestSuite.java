package com.nopcommerce.testsuite;

import com.nopcommerce.pages.*;
import com.nopcommerce.testbase.TestBase;
import org.testng.annotations.Test;

public class TestSuite extends TestBase {
    HomePage homepage = new HomePage();
    Computers computers= new Computers();
    AddToCartBuildYOC addToCartBuildYOC= new AddToCartBuildYOC();
    ShoppingCart shoppingCart= new ShoppingCart();
    LoginPage loginPage= new LoginPage();
    String rndString= randomString();
    CheckOut checkOut = new CheckOut();
    ShippingMethod shippingMethod=new ShippingMethod();
    PaymentMethod paymentMethod= new PaymentMethod();
    PaymentInformation paymentInformation= new PaymentInformation();
    ConfirmOrder confirmOrder= new ConfirmOrder();
    OrderCompleted orderCompleted= new OrderCompleted();
    @Test
    public void verifyProductArrangedInAlphabeticalOrder() throws InterruptedException {
        homepage.goToComputersPage();
        computers.clickOnDesktop();
        computers.verifyDesktopProductsSortedDescendingOrder();
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homepage.goToComputersPage();
        computers.clickOnDesktop();
        computers.selectPosition();
        Thread.sleep(2000);
        computers.clickOnAddToCartBuildYOC();
        Thread.sleep(3000);
        addToCartBuildYOC.verifyBuildYOCPage();
        addToCartBuildYOC.selectProcessor();
        addToCartBuildYOC.selectRAM();
        addToCartBuildYOC.selectHDD();
        addToCartBuildYOC.selectOS();
        Thread.sleep(2000);
        addToCartBuildYOC.selectSoftware();
        Thread.sleep(3000);
        addToCartBuildYOC.verifyPriceTotal();
        Thread.sleep(2000);
        addToCartBuildYOC.clickAddToCart();
        addToCartBuildYOC.verifyAddToCartMessage();
        addToCartBuildYOC.clickOnCloseMessage();
        Thread.sleep(3000);
        addToCartBuildYOC.clickOnShoppingCart();
        shoppingCart.verifyShoppingCartPage();
        shoppingCart.updateQty();
        shoppingCart.verifyTotalAmount();
        shoppingCart.acceptTAndC();
        shoppingCart.clickOnCheckOutButton();
        Thread.sleep(3000);
        loginPage.verifySignInPage();
        Thread.sleep(2000);
        loginPage.clickOnCheckOutAsGuest();
        checkOut.enterFirstName("Ram");
        checkOut.enterLastName("Kumar");
        checkOut.enterEmailID(rndString+"@gmail.com");
        Thread.sleep(2000);
        checkOut.selectCountryCode();
        checkOut.enterCity("Vadodara");
        checkOut.enterAddress1("9 Ayodhya Apartments");
        checkOut.enterZipCode("391440");
        checkOut.enterTelephone("00919825336419");
        checkOut.clickOnContinue();
        Thread.sleep(2000);
        shippingMethod.clickOnNextDayAir();
        shippingMethod.clickOnContinue();
        Thread.sleep(2000);
        paymentMethod.clickOnCreditCard();
        paymentMethod.clickOnContinue();
        Thread.sleep(2000);
        paymentInformation.selectCreditCardType("MasterCard");
        paymentInformation.enterCardHolderName("Ram Kumar");
        paymentInformation.enterCardNumber("5553 0422 4198 4105");
        paymentInformation.selectExpiryMonth("9");
        paymentInformation.selectExpiryYear("2025");
        paymentInformation.enterSecurityCode("756");
        paymentInformation.clickOnContinue();
        Thread.sleep(2000);
        confirmOrder.verifyPaymentType("Credit Card");
        confirmOrder.verifyShippingMethod("Next Day Air");
        confirmOrder.verifyTotalAmount("$2,950.00");
        confirmOrder.clickOnConfirmButton();
        Thread.sleep(2000);
        orderCompleted.verifyThankYouText("Thank you");
        orderCompleted.verifyOrderSuccessfulText("Your order has been successfully processed!");
        orderCompleted.clickOnContinue();
        homepage.verifyWelcomeText("Welcome to our store");

    }



}
