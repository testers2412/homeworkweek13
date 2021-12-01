package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import com.nopcommerce.ulitiy.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    By welcomeText = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
    By emailField = By.id("Email");
    By passwordField = By.name("Password");
    By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    By error = By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-1 div.page.login-page div.page-body div.customer-blocks div.returning-wrapper.fieldset form:nth-child(1) > div.message-error.validation-summary-errors:nth-child(1)");
    String expectedMessage;
    String actualMessage;
    String errorMessage;
    By checkOutAsGuest = By.xpath("//button[text()='Checkout as Guest']");
    By registerButton=By.xpath("//button[normalize-space()='Register']");


    public void verifySignInPage(){
        actualMessage= getTextFromElement(welcomeText);
        expectedMessage="Welcome, Please Sign In!";
        errorMessage= "You are not on Sign In page";
        Assert.assertEquals(errorMessage,expectedMessage,actualMessage);
    }
    public void clickOnCheckOutAsGuest(){
        clickOnElement(checkOutAsGuest);
    }

    public void enterPassword(String password){
        sendTextToElement(passwordField,password);

    }public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
    public String getErrorMessage(){
        return  getTextFromElement(error);

    }
    public void clickOnRegister(){
        clickOnElement(registerButton);
    }


}
