package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class NokiaLumia1020 extends Utility {
    By nokiaLumia1020PageText = By.xpath("//h1[text()='Nokia Lumia 1020']");
    String errorMessage;
    By price= By.xpath("//span[text()=' $349.00 ']");
    By qty= By.xpath("//input[@value='1']");
    By addToCartButton=By.xpath("//div[7]//div[1]//button[1]");
    By productAddedMessage= By.xpath("//p[text()='The product has been added to your ']");
    By closeProductAddedMessage= By.xpath("//span[@title='Close']");
    By shoppingCartButton= By.xpath("//span[text()='Shopping cart']");
    By goToCartButton=By.xpath("//button[text()='Go to cart']");
    public void verifyNokiaLumia1020Page(String expectedMessage){
        errorMessage= "You are on a wrong page";
        verifyElementTextMatching(expectedMessage,nokiaLumia1020PageText,errorMessage);
    }
    public void verifyPrice(String expectedMessage){
        errorMessage="The price is not matching";
        verifyElementTextMatching(expectedMessage,price,errorMessage);
    }
    public void changeQty(String newQty){
        clearText(qty);
        sendTextToElement(qty,newQty);
    }
    public void clickOnAddToCart(){
        clickOnElement(addToCartButton);
    }
    public void verifyProductIsAddedToCart(String expectedMessage){
        errorMessage="Product has not been added";
        verifyElementTextMatching(expectedMessage,productAddedMessage,errorMessage);
    }
    public void closeProductAddedMessagebox(){
        clickOnElement(closeProductAddedMessage);
    }
    public void clickOnGoToCart(){
        actionMouseHoverAndClickOnListElement(shoppingCartButton,goToCartButton);

    }


}
