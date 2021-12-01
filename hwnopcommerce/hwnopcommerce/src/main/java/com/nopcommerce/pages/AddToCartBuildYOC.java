package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class AddToCartBuildYOC extends Utility {
    String expectedMessage="Build your own computer";
    By actualMessage = By.xpath("//h1[text()='Build your own computer']");
    String errorMessage= "You are not on a right Page";
    By processor = By.xpath("//select[@id='product_attribute_1']");
    String value1= "1";
    By ram= By.xpath("//select[@id='product_attribute_2']");
    String value2= "5";
    By hdd= By.xpath("//label[text()='400 GB [+$100.00]']");
    By os= By.xpath("//label[text()='Vista Premium [+$60.00]']");
    By software= By.xpath("//label[text()='Total Commander [+$5.00]']");
    String expectedMessage1="$1,475.00";
    By actualMessage1 = By.xpath("//span[@id='price-value-1']");
    String errorMessage1= "The Price is not matching";
    By addToCart =By.xpath("//button[@id='add-to-cart-button-1']");
    String expectedMessage2="The product has been added to your shopping cart";
    By actualMessage2 = By.xpath("//p[@class='content']");
    String errorMessage2= "The item is not added to cart";
    By closeMessage= By.xpath("//span[@title='Close']");
    By shoppingCart= By.xpath("//span[@class='cart-label']");
    By goToCartButton= By.xpath("//button[normalize-space()='Go to cart']");
    public void verifyBuildYOCPage(){
        verifyElementTextMatching(expectedMessage,actualMessage,errorMessage);
    }
    public void selectProcessor(){
        selectByValueFromDropDown(processor,value1);
    }
    public void selectRAM(){
        selectByValueFromDropDown(ram,value2);
    }
    public void selectHDD(){
        actionMouseHoverAndClick(hdd);
    }
    public  void selectOS(){
        actionMouseHoverAndClick(os);
    }
    public void selectSoftware(){
        actionMouseHoverAndClick(software);
    }
    public void verifyPriceTotal(){
        verifyElementTextMatching(expectedMessage1,actualMessage1,errorMessage1);
    }
    public void clickAddToCart(){
        clickOnElement(addToCart);
    }
    public void verifyAddToCartMessage(){
        verifyElementTextMatching(expectedMessage2,actualMessage2,errorMessage2);
    }
    public void clickOnCloseMessage(){
        clickOnElement(closeMessage);

    }
    public void clickOnShoppingCart(){
        actionMouseHoverOnly(shoppingCart);
        clickOnElement(goToCartButton);
    }




}
