package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class DigitalDownloads extends Utility {
    By pageMessage= By.xpath("//h1[normalize-space()='Digital downloads']");
    public String getTextFromPage(){
        return getTextFromElement(pageMessage);
    }

}
