package com.xcart.pages;

import com.xcart.ulities.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ShoppingCart extends Utility {
    String errorMessage;
    By shoppingCartText=By.xpath("//h1[@id='page-title']");
    By qtyTab=By.xpath("//input[@id='amount16']");
By priceTab= By.xpath("//ul[contains(@class,'sums')]//span[contains(@class,'surcharge-cell')]");
By totalPriceTab= By.xpath("//li[@class='total']//span[@class='surcharge-cell']");
By checkOutButton= By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]");
By clearBagButton=By.xpath("//a[@class='clear-bag']");


    public void verifyQty(String expectedMessage){
        errorMessage="The qty is not matching";
        verifyElementTextMatching(expectedMessage,shoppingCartText,errorMessage);
    }
    public void updateTheQty(String newQty){
      clearText(qtyTab);
      sendTextToElement(qtyTab,newQty);
    }
    public void verifyPrice(String expectedMessage){
        errorMessage="The Price is not matching";
        verifyElementTextMatching(expectedMessage,priceTab,errorMessage);
    }
    public void verifyTotalPrice(String expectedMessage){
        errorMessage="The Price is not matching";
        verifyElementTextMatching(expectedMessage,totalPriceTab,errorMessage);
    }
    public void clickOnCheckOut(){
        clickOnElement(checkOutButton);

    }
    public void clickOnClearBag(){
        clickOnElement(clearBagButton);

    }
    public void verifyAlertMessageAndAccept() throws InterruptedException {
        String alert = alertGetText();
        Thread.sleep(2000);
        String expectedAlertMessage= "Are you sure you want to clear your cart?";
        Assert.assertEquals("The alert message is not matching",expectedAlertMessage,alert);
        Thread.sleep(2000);
        alertAccept();


    }
    public void verifyItemDeleteFromCart(String expectedMessage){
        errorMessage="The cart is not empty";
        verifyElementTextMatching(expectedMessage,shoppingCartText,errorMessage);


    }
}
