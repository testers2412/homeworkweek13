package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class CheckOut extends Utility {
    By firstNameField = By.xpath("//input[@id='BillingNewAddress_FirstName']");
    By lastNameField= By.xpath("//input[@id='BillingNewAddress_LastName']");
    By emailField= By.xpath("//input[@id='BillingNewAddress_Email']");
    By countryCode = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    String value;
    By cityField = By.xpath("//input[@id='BillingNewAddress_City']");
    By address1Field= By.xpath("//input[@data-val-required='Street address is required']");
    By zipCodeField= By.xpath("//input[@data-val-required='Zip / postal code is required']");
    By telephoneField= By.xpath("//input[@type='tel']");
    By continueButton= By.xpath("//button[@onclick='Billing.save()']");
    public void enterFirstName(String firstName){
        sendTextToElement(firstNameField,firstName);
    }
    public void enterLastName(String lastName){
        sendTextToElement(lastNameField, lastName);
}
    public void enterEmailID(String email) {
        sendTextToElement(emailField, email);
    }
    public void selectCountryCode(){
        value="133";
        selectByValueFromDropDown(countryCode,value);
    }
    public void enterCity(String city){
        sendTextToElement(cityField,city);
    }
    public void enterAddress1(String address1){
        sendTextToElement(address1Field,address1);
    }
    public void enterZipCode(String zipCode){
        sendTextToElement(zipCodeField,zipCode);
    }
    public void enterTelephone(String telephone){
        sendTextToElement(telephoneField,telephone);
    }
    public void clickOnContinue(){
        clickOnElement(continueButton);
    }



}