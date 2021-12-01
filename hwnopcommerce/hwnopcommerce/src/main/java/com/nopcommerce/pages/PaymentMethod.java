package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class PaymentMethod extends Utility {
    By creditCardField= By.xpath("//input[@value='Payments.Manual']");
    By continueButton= By.xpath("//button[@onclick='PaymentMethod.save()']");

    public void clickOnCreditCard(){
        clickOnElement(creditCardField);
    }
    public void clickOnContinue(){
        clickOnElement(continueButton);
    }
}
