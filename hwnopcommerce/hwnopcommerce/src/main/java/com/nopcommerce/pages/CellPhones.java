package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class CellPhones extends Utility {
    By cellPhonesPageText = By.xpath("//h1[normalize-space()='Cell phones']");
    String errorMessage;
    By listView= By.xpath("//a[@title='List']");
    By nokiaLumia1020 = By.xpath("//a[text()='Nokia Lumia 1020']");

    public void verifyCellPhonePage(String expectedMessage) {
        errorMessage = "You are not on a right page";
        verifyElementTextMatching(expectedMessage, cellPhonesPageText, errorMessage);
    }
    public void clickOnListView(){
        clickOnElement(listView);
    }
    public void clickOnNokiaLumia1020(){
        clickOnElement(nokiaLumia1020);
    }


}
