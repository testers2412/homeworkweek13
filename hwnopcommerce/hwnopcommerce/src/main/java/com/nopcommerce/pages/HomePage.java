package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.List;

public class HomePage extends Utility {
    By loginLink= By.linkText("Log in");
    By registerLink= By.linkText("Register");
    By menuBars = By.xpath("//ul[@class='top-menu notmobile']/li");
    By computers = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
    By electronics = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']");
    By apparel = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']");
    By digitalDownloads = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']");
    By books = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Books']");
    By jewelry = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']");
    By giftCard = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']");
    By cellPhones= By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']");
    By welcomeText= By.xpath("//h2[normalize-space()='Welcome to our store']");

By logOutButton= By.xpath("//a[normalize-space()='Log out']");
    String errorMessage;
    public void goToComputersPage() throws InterruptedException {
        selectMenu("Computers",menuBars);
    }
    public void goToApparelPage() throws InterruptedException {
        selectMenu("Apparel",menuBars);
    }
    public void goToBooksPage() throws InterruptedException {
        selectMenu("Books",menuBars);
    }
    public void goToDigitalDownloadsPage() throws InterruptedException {
        selectMenu("Digital downloads",menuBars);
    }
    public void goToElectronicsPage() throws InterruptedException {
        selectMenu("Electronics",menuBars);
    }
    public void goToGiftCardsPage() throws InterruptedException {
        selectMenu("Gift Cards",menuBars);
    }
    public void goToJewelryPage() throws InterruptedException {
        selectMenu("Jewelry",menuBars);
    }


    public void clickOnLoginLink(){
        clickOnElement(loginLink);

    }
    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }

    public void mouseHoverOnElectronics(){
        actionMouseHoverOnly(electronics);
    }
    public void clickOnCellPhone(){
        clickOnElement(cellPhones);
    }
    public  void verifyWelcomeText(String expectedMessage){
        errorMessage= "You are not on a welcome page";
        verifyElementTextMatching(expectedMessage,welcomeText,errorMessage);
    }
    public void clickOnLogOut(){
        clickOnElement(logOutButton);

    }
    public void verifyHomePage(String expectedMessage){
        errorMessage= "you are not on a homepage";
        String actualMessage= driver.getCurrentUrl();
        Assert.assertEquals(errorMessage,expectedMessage,actualMessage);


    }


}
