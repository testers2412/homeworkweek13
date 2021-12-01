package com.xcart.testsuite;

import com.xcart.pages.*;
import com.xcart.testbase.TestBase;
import org.testng.annotations.Test;

public class ShoppingTest extends TestBase {
    HomePage homePage=new HomePage();
    Sale sale= new Sale();
    ShoppingCart shoppingCart= new ShoppingCart();
    Login login= new Login();
    CheckOut checkOut= new CheckOut();
    CheckOutSuccess checkOutSuccess= new CheckOutSuccess();
    BestSeller bestSeller= new BestSeller();
    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfully() throws InterruptedException {
        homePage.clickOnSale();
        Thread.sleep(2000);
        sale.verifySalePage("Sale");
        Thread.sleep(2000);
        sale.clickOnNameAToZ();
        Thread.sleep(2000);
        sale.clickOnAddToCartToAddAvengerToCart();
        Thread.sleep(2000);
        sale.verifyProductAddedToCartTextAndClose("Product has been added to your cart");
        sale.clickOnYourCartAndGoToViewCart();
        Thread.sleep(2000);
        shoppingCart.verifyQty("Your shopping cart - 1 item");
        shoppingCart.updateTheQty("2");
        Thread.sleep(4000);
        shoppingCart.verifyQty("Your shopping cart - 2 items");
        Thread.sleep(2000);
        shoppingCart.verifyPrice("$29.98");
        Thread.sleep(2000);
        shoppingCart.verifyTotalPrice("$36.00");
        shoppingCart.clickOnCheckOut();
        Thread.sleep(2000);
        login.verifyLoginPage("Log in to your account");
        login.enterEmail(randomString()+"@gmail.com");
        login.clickOnContinue();
        Thread.sleep(2000);
        checkOut.enterFirstName("Ram");
        checkOut.enterLastName("Kumar");
        checkOut.enterAddress1("9 Ayodhya Street");
        checkOut.enterCity("London");
        checkOut.enterCountryCode("GB");
        checkOut.enterState("Middex");
        checkOut.enterZipCode("90002");
        checkOut.clickOnCreateProfileButton();
        Thread.sleep(2000);
        checkOut.enterPassword("Abc123");
        checkOut.clickOnLocalShipping();
        checkOut.clickOnCOD();
        checkOut.verifyTotalPrice("$37.03");
        checkOut.clickOnPlaceOrder();
        Thread.sleep(4000);
        checkOutSuccess.verifyCheckOutSuccessPage("Thank you for your order");
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        homePage.clickOnBestSeller();
        Thread.sleep(2000);
        bestSeller.verifyBestSellerPage("Bestsellers");
        Thread.sleep(2000);
        bestSeller.clickOnNameAToZ();
        Thread.sleep(2000);
        bestSeller.clickOnAddToCartToAddGhostBusters();
        Thread.sleep(2000);
        bestSeller.verifyProductAddedToCartTextAndClose("Product has been added to your cart");
        bestSeller.clickOnYourCartAndGoToViewCart();
        Thread.sleep(2000);
        shoppingCart.verifyQty("Your shopping cart - 1 item");
        shoppingCart.clickOnClearBag();
        Thread.sleep(2000);
        shoppingCart.verifyAlertMessageAndAccept();
        Thread.sleep(2000);
        shoppingCart.verifyItemDeleteFromCart("Your cart is empty");


    }
}
