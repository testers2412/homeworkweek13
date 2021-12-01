package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class ShippingMethod extends Utility {
    By nextDayAirButton= By.xpath("//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']");
    By continueButton= By.xpath("//button[@onclick='ShippingMethod.save()']");
    By secondDayAir= By.xpath("//input[@value='2nd Day Air___Shipping.FixedByWeightByTotal']");
    public void clickOnNextDayAir(){
        clickOnElement(nextDayAirButton);
    }
    public void clickOnContinue(){
        clickOnElement(continueButton);
    }
public void clickOn2ndDayAir(){
        clickOnElement(secondDayAir);
}
}
