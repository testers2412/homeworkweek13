package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class Books extends Utility {
    By pageMessage= By.xpath("//h1[normalize-space()='Books']");
    public String getTextFromPage(){
        return getTextFromElement(pageMessage);
    }

}
