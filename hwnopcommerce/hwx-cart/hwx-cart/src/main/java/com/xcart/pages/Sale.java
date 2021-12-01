package com.xcart.pages;

import com.xcart.ulities.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sale extends Utility {
    String errorMessage;
    By salePageText= By.xpath("//h1[@id='page-title']");
    By sortByValueTab= By.xpath("//span[@class='sort-by-value']");
    By nameAToZTab= By.xpath("//a[normalize-space()='Name A - Z']");
    By nameList= By.xpath("//h5[@class='product-name']");
    By ratesList=By.xpath("//div[@class='rating']//div//div//div[@style]");
    By ratesTab= By.xpath("//a[normalize-space()='Rates']");
    By lowToHighTab= By.xpath("//a[normalize-space()='Price Low - High']");
    By priceList= By.xpath("(//ul[@class='product-price'])//li//span");
    By avengerProductTab= By.xpath("//div[contains(@class,'product productid-16')]//h5[@class='product-name']");
    By addToCartButton=By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]");
    By addedToCartMessageBox= By.xpath("//li[@class='info']");
    By closeButton=By.xpath("//a[@title='Close']");
    By yourCartButton= By.xpath("//div[@title='Your cart']");
    By viewCartButton= By.xpath("//span[normalize-space()='View cart']");

public void verifySalePage(String expectedMessage){
    errorMessage="You are not on a right Page";
    verifyElementTextMatching(expectedMessage,salePageText,errorMessage);
}
public void clickOnAToZAndVerifySorting() throws InterruptedException {
    List<WebElement> originalList = driver.findElements(nameList);
    List<String> originalProductNameList = new ArrayList<>();
    for (WebElement product : originalList) {
        originalProductNameList.add(product.getText());
    }
    Collections.sort(originalProductNameList);
    actionMouseHoverAndClickOnListElement(sortByValueTab,nameAToZTab);
    Thread.sleep(4000);
    List<WebElement> afterSortList = driver.findElements(nameList);
    List<String> afterSortProductName = new ArrayList<>();
    for (WebElement product : afterSortList) {
        afterSortProductName.add(product.getText());
    }
    Assert.assertEquals("The products are not sorted", originalProductNameList, afterSortProductName);

}
public void clickOnRatesAndVerifySorting() throws InterruptedException {
    List<WebElement> originalList = driver.findElements(ratesList);
    List<Integer> originalProductNameList = new ArrayList<>();
    for (WebElement product : originalList) {
        originalProductNameList.add(product.getAttribute("style").indexOf(2,6));
    }
    Collections.sort(originalProductNameList,Collections.reverseOrder());
    actionMouseHoverAndClickOnListElement(sortByValueTab,ratesTab);
    Thread.sleep(4000);
    List<WebElement> afterSortList = driver.findElements(ratesList);
    List<Integer> afterSortProductName = new ArrayList<>();
    for (WebElement product : afterSortList) {
        afterSortProductName.add(product.getAttribute("style").indexOf(3,6));
    }
    Assert.assertEquals("The products are not sorted", originalProductNameList, afterSortProductName);

}
public void clickOnLowToHighAndVerifySorting() throws InterruptedException {
    List<WebElement> originalList = driver.findElements(priceList);
    List<Double> originalPriceList = new ArrayList<>();
    for (WebElement price : originalList) {
        originalPriceList.add(Double.valueOf(price.getText().replace("$","")));
    }
    Collections.sort(originalPriceList);
    actionMouseHoverAndClickOnListElement(sortByValueTab,lowToHighTab);
    Thread.sleep(4000);
    List<WebElement> afterSortList = driver.findElements(priceList);
    List<Double> afterSortPriceList = new ArrayList<>();
    for (WebElement price1 : afterSortList) {
        afterSortPriceList.add(Double.valueOf(price1.getText().replace("$","")));
    }
    Assert.assertEquals("The products are not sorted", originalPriceList, afterSortPriceList);

}
public void clickOnNameAToZ() throws InterruptedException {
    actionMouseHoverAndClickOnListElement(sortByValueTab,nameAToZTab);
}
public void clickOnAddToCartToAddAvengerToCart() throws InterruptedException {
  //actionMouseHoverAndClickOnListElement(avengerProductTab,addToCartButton);
    actionMouseHoverOnly(avengerProductTab);
    Thread.sleep(2000);
    clickOnElement(addToCartButton);

}

public void verifyProductAddedToCartTextAndClose(String expectedMessage){
    errorMessage="Product is not added to cart";
    verifyElementTextMatching(expectedMessage,addedToCartMessageBox,errorMessage);
    clickOnElement(closeButton);
}

public void clickOnYourCartAndGoToViewCart(){
    clickOnElement(yourCartButton);
    clickOnElement(viewCartButton);


}

}
