package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class GiftCard extends Utility {
    By pageMessage= By.xpath("//h1[normalize-space()='Gift Cards']");
    public String getTextFromPage(){
        return getTextFromElement(pageMessage);
    }

}
