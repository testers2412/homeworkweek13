package com.xcart.pages;

import com.xcart.ulities.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestSeller extends Utility {
    String errorMessage;
    By bestSellerPageText= By.xpath("//h1[@id='page-title']");
    By nameList= By.xpath("//h5[@class='product-name']");
    By sortByValueTab= By.xpath("//span[@class='sort-by-value']");
    By nameZToATab= By.xpath("//a[normalize-space()='Name Z - A']");
    By priceList= By.xpath("//ul[@class='product-price']//li//span");
    By highToLowTab=By.xpath("//a[normalize-space()='Price High - Low']");
   By ratesList=By.xpath("//div[@class='rating']//div//div//div[@style]");
   By ratesTab=By.xpath("//a[normalize-space()='Rates']");
   By nameAToZTab=By.xpath("//a[normalize-space()='Name A - Z']");
   By ghostBusters=By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']");
   By addToCartButton=By.xpath("//li[10]//div[1]//div[2]//div[4]//div[1]//button[1]//span[1]");
    By addedToCartMessageBox= By.xpath("//li[@class='info']");
    By closeButton=By.xpath("//a[@title='Close']");
    By yourCartButton= By.xpath("//div[@title='Your cart']");
    By viewCartButton= By.xpath("//span[normalize-space()='View cart']");
    public void verifyBestSellerPage(String expectedMessage){
        errorMessage= "You are not on a right page";
        verifyElementTextMatching(expectedMessage,bestSellerPageText,errorMessage);
    }
    public void clickOnZToAAndVerifySorting() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(nameList);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }
        originalProductNameList.sort(String.CASE_INSENSITIVE_ORDER.reversed());
        actionMouseHoverAndClickOnListElement(sortByValueTab,nameZToATab);
        Thread.sleep(4000);
        List<WebElement> afterSortList = driver.findElements(nameList);
        List<String> afterSortProductName = new ArrayList<>();
        for (WebElement product : afterSortList) {
            afterSortProductName.add(product.getText());
        }
        Assert.assertEquals("The products are not sorted", originalProductNameList, afterSortProductName);
    }
    public void clickOnHighLowAndVerifySorting() throws InterruptedException {
        List<WebElement> originalList = driver.findElements(priceList);
        List<Double> originalPriceList = new ArrayList<>();
        for (WebElement price : originalList) {
            originalPriceList.add(Double.valueOf(price.getText().replace("$","")));
        }
        Collections.sort(originalPriceList,Collections.reverseOrder());
        actionMouseHoverAndClickOnListElement(sortByValueTab,highToLowTab);
        Thread.sleep(4000);
        List<WebElement> afterSortList = driver.findElements(priceList);
        List<Double> afterSortPriceList = new ArrayList<>();
        for (WebElement price1 : afterSortList) {
            afterSortPriceList.add(Double.valueOf(price1.getText().replace("$","")));
        }
        Assert.assertEquals("The products are not sorted", originalPriceList, afterSortPriceList);
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
    public void clickOnNameAToZ() throws InterruptedException {
        actionMouseHoverAndClickOnListElement(sortByValueTab,nameAToZTab);

    }
    public void clickOnAddToCartToAddGhostBusters() throws InterruptedException {
       // actionMouseHoverAndClickOnListElement(ghostBusters,addToCartButton);
        actionMouseHoverOnly(ghostBusters);
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
