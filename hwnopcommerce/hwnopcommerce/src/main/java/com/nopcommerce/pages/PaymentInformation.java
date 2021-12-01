package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class PaymentInformation extends Utility {
    By masterCard = By.xpath("//select[@id='CreditCardType']");
    String value;
    By cardHolderNameField = By.xpath("//input[@id='CardholderName']");
    By cardNumberField = By.xpath("//input[@id='CardNumber']");
    By expiryMonthField = By.xpath("//select[@id='ExpireMonth']");
    By expiryYearField = By.xpath("//select[@id='ExpireYear']");
   By securityCodeField=By.xpath("//input[@id='CardCode']");
   By continueButton=By.xpath("//button[@onclick='PaymentInfo.save()']");
    public void selectCreditCardType(String value) {

        selectByValueFromDropDown(masterCard, value);
    }

    public void enterCardHolderName(String cardHolderName) {
        sendTextToElement(cardHolderNameField, cardHolderName);
    }

    public void enterCardNumber(String cardNumber) {
        sendTextToElement(cardNumberField, cardNumber);
    }

    public void selectExpiryMonth(String value) {

        selectByValueFromDropDown(expiryMonthField, value);
    }
    public void selectExpiryYear(String value) {

        selectByValueFromDropDown(expiryYearField, value);
    }
    public void enterSecurityCode(String securityCode){
        sendTextToElement(securityCodeField, securityCode);
    }
    public void clickOnContinue(){
        clickOnElement(continueButton);

    }



}
