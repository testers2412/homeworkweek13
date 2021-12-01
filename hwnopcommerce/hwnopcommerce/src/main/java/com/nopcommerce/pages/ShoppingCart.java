package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ShoppingCart extends Utility {
    String expectedMessage="Shopping cart";
    By actualMessage = By.xpath("//h1[text()='Shopping cart']");
    String errorMessage= "You are not on a right page";
   By qty = By.xpath("//input[@class='qty-input']");
   By qtyUpdateButton = By.xpath("//button[normalize-space()='Update shopping cart']");
    String expectedMessage1="$2,950.00";
    By actualMessage1 = By.xpath("//tr[@class='order-subtotal']//span[@class='value-summary'][text()='$2,950.00']");
    String errorMessage1="The total is not matching";
    By tAndC= By.xpath("//input[@id='termsofservice']");
   By checkOut= By.xpath("//button[@id='checkout']");
   By qtyTab= By.xpath("//input[@value='2']");
   By subTotal= By.xpath("//span[@class='product-subtotal']");
    public void verifyShoppingCartPage(){
        verifyElementTextMatching(expectedMessage,actualMessage,errorMessage);
    }
    public  void  updateQty(){
        clearText(qty);
        sendTextToElement(qty,"2");
        clickOnElement(qtyUpdateButton);
    }
    public  void verifyTotalAmount(){
        verifyElementTextMatching(expectedMessage1,actualMessage1,errorMessage1);
    }
    public void acceptTAndC(){
        clickOnElement(tAndC);
    }
    public void clickOnCheckOutButton(){
        clickOnElement(checkOut);
    }
    public void verifyQty(String expectedMessage){
        errorMessage="The Qty is not matching";
        String actualMessage2=driver.findElement(qtyTab).getAttribute("value");
        Assert.assertEquals(errorMessage,expectedMessage,actualMessage2);
    }
    public void verifySubTotal(String expectedMessage){
        errorMessage= "The sub total is not matching";
        verifyElementTextMatching(expectedMessage,subTotal,errorMessage);


    }




}
