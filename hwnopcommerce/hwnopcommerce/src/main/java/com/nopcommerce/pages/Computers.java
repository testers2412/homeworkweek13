package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;


public class Computers extends Utility {
    By pageMessage= By.xpath("//h1[normalize-space()='Computers']");
    By desktop = By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']");
    By list = By.xpath("//h2[@class='product-title']");
    By position= By.xpath("//select[@id='products-orderby']");
    String value = "6";
    String value1= "5";
    public String getTextFromPage(){
      return getTextFromElement(pageMessage);
    }
    public void clickOnDesktop(){
        clickOnElement(desktop);

    }
    public void verifyDesktopProductsSortedDescendingOrder() throws InterruptedException {
        sortAndVerifySortingZtoA(list,position,value);

    }
    public void selectPosition(){
        selectByValueFromDropDown(position,value1);
    }
    public void clickOnAddToCartBuildYOC(){
        clickOnElement(By.xpath("//div[@class='picture']//img[@title='Show details for Build your own computer']"));
    }






}
