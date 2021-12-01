package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class OrderCompleted extends Utility {
    By thankYouText= By.xpath("//h1[normalize-space()='Thank you']");
    By orderSuccessfulMessage= By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
    By continueButton= By.xpath("//button[normalize-space()='Continue']");
    String errorMessage;
    public void verifyThankYouText(String expectedMessage){
        errorMessage="The text is not matching";
        verifyElementTextMatching(expectedMessage,thankYouText,errorMessage);
    }
    public void verifyOrderSuccessfulText(String expectedMessage){
        errorMessage="The text is not matching";
        verifyElementTextMatching(expectedMessage,orderSuccessfulMessage,errorMessage);
    }
    public void clickOnContinue(){
        clickOnElement(continueButton);
    }


}
