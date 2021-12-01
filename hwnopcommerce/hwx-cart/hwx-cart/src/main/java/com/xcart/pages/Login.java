package com.xcart.pages;

import com.xcart.ulities.Utility;
import org.openqa.selenium.By;

public class Login extends Utility {
    String errorMessage;
    By loginPageText=By.xpath("//h3[normalize-space()='Log in to your account']");
    By emailField=By.xpath("//input[@name='email']");
    By continueTab= By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]");

    public void verifyLoginPage(String expectedMessage){
        errorMessage="You are not on Login page";
        verifyElementTextMatching(expectedMessage,loginPageText,errorMessage);
    }
    public void enterEmail(String email){
        sendTextToElement(emailField,email);
    }
    public void clickOnContinue(){
        clickOnElement(continueTab);
    }

}
