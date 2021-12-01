package com.xcart.pages;

import com.xcart.ulities.Utility;
import org.openqa.selenium.By;

public class CheckOutSuccess extends Utility {
String errorMessage;
By pageText=By.xpath("//h1[@class='title']");
public void verifyCheckOutSuccessPage(String expectedMessage){
    errorMessage="You are not on a right page";
    verifyElementTextMatching(expectedMessage,pageText,errorMessage);


}

}
