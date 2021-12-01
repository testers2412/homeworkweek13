package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class Electronics extends Utility {
    By pageMessage= By.xpath("//h1[normalize-space()='Electronics']");
    public String getTextFromPage(){
        return getTextFromElement(pageMessage);
    }


}
