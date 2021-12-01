package com.xcart.pages;

import com.xcart.ulities.Utility;
import org.openqa.selenium.By;

public class CheckOut extends Utility {
    By firstNameTab=By.id("shippingaddress-firstname");
    By lastNameTab=By.id("shippingaddress-lastname");
    By streetTab=By.id("shippingaddress-street");
    By cityTab=By.id("shippingaddress-city");
    By countryCodeTab=By.id("shippingaddress-country-code");
    By stateTab=By.id("shippingaddress-custom-state");
    By zipCodeTab=By.id("shippingaddress-zipcode");
    By createProfileTab=By.xpath("//input[@name='create_profile']");
    By passwordTab= By.id("password");
    By localShippingButton=By.xpath("//input[@value='128']");
    By cODButton=By.xpath("//input[@value='6']");
    String errorMessage;
    By totalPrice=By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']");
By placeOrderButton=By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']");
    public void enterFirstName(String firstName){
        sendTextToElement(firstNameTab,firstName);
    }
    public void enterLastName(String lastName){
        sendTextToElement(lastNameTab,lastName);
    }
    public void enterAddress1(String streetName){
        sendTextToElement(streetTab,streetName);
    }
    public void enterCity(String city){
        clearText(cityTab);
        sendTextToElement(cityTab,city);
    }
    public void enterCountryCode(String countryCode){
        sendTextToElement(countryCodeTab,countryCode);
    }
    public void enterState(String state){
        sendTextToElement(stateTab,state);
    }
    public void enterZipCode(String zipCode) throws InterruptedException {
        clearText(zipCodeTab);
        Thread.sleep(2000);
        sendTextToElement(zipCodeTab,zipCode);
    }
    public void clickOnCreateProfileButton(){
        clickOnElement(createProfileTab);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordTab,password);
    }
    public void clickOnLocalShipping(){
        clickOnElement(localShippingButton);
    }
    public void clickOnCOD(){
        clickOnElement(cODButton);
    }
    public void verifyTotalPrice(String expectedMessage){
        errorMessage="The Price is not matching";
        verifyElementTextMatching(expectedMessage,totalPrice,errorMessage);
    }
    public void clickOnPlaceOrder(){
        clickOnElement(placeOrderButton);

    }

}

