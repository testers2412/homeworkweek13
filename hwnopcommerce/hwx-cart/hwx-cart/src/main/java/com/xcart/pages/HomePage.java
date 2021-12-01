package com.xcart.pages;

import com.xcart.ulities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By menuBar = By.xpath("//ul[@class='nav navbar-nav top-main-menu']/child::*");
    String errorMessage;
    By pageTitleText= By.xpath("//h1[@id='page-title']");
    By hotDealsButton=By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']");
    By saleButton= By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]");
    By bestSellerButton=By.xpath("//li[@class='leaf has-sub']//li[2]//a[1]");


    public void selectMenuFromMenuBar(String menu) throws InterruptedException {

        selectMenu(menu,menuBar);
    }
    public void verifyLendingPage(String expectedMessage){
        errorMessage="You are not on a right page";
        verifyElementTextMatching(expectedMessage,pageTitleText,errorMessage);
    }

    public void clickOnSale() throws InterruptedException {
        actionMouseHoverAndClickOnListElement(hotDealsButton,saleButton);
    }
    public void clickOnBestSeller() throws InterruptedException {
       // actionMouseHoverAndClickOnListElement(hotDealsButton,bestSellerButton);
        actionMouseHoverOnly(hotDealsButton);
        clickOnElement(bestSellerButton);
    }


}
