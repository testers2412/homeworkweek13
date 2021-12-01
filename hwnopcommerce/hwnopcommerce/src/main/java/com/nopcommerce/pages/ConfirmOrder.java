package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;


public class ConfirmOrder extends Utility {
    By paymentMethod= By.xpath("//span[normalize-space()='Credit Card']");
    String errorMessage;
    By shippingMethod= By.xpath("//li[@class='shipping-method']//span[@class='value']");
    By totalAmount= By.xpath("//span[@class='value-summary']//strong");
    By confirmButton= By.xpath("//button[normalize-space()='Confirm']");
    public void verifyPaymentType(String expectedMessage ){
        errorMessage= "The payment type is not right";
        verifyElementTextMatching(expectedMessage,paymentMethod,errorMessage);
    }
    public void verifyShippingMethod(String expectedMessage ){
        errorMessage= "The Shipping Method is not right";
        verifyElementTextMatching(expectedMessage,shippingMethod,errorMessage);
    }
    public void verifyTotalAmount(String expectedMessage ){
        errorMessage= "The Total Amount is not right";
        verifyElementTextMatching(expectedMessage,totalAmount,errorMessage);
    }
    public void clickOnConfirmButton(){
        clickOnElement(confirmButton);
    }
}
