package com.nopcommerce.testsuite;

import com.nopcommerce.pages.*;
import com.nopcommerce.testbase.TestBase;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {
   HomePage homepage = new HomePage();
   Computers computers= new Computers();
   Electronics electronics = new Electronics();
   Apparel apparel = new Apparel();
   Books books = new Books();
   DigitalDownloads digitalDownloads = new DigitalDownloads();
   GiftCard giftCard = new GiftCard();
   Jewelry jewelry = new Jewelry();



    @Test
    public void verifyPageNavigateToComputers() throws InterruptedException {
        homepage.goToComputersPage();
       String actualMessage= computers.getTextFromPage();
       String expectedMessage = "Computers";
        Assert.assertEquals(expectedMessage,actualMessage,"You are not a right page");
    }
    @Test
    public void verifyPageNavigateToElectronics() throws InterruptedException {
        homepage.goToElectronicsPage();
        String actualMessage= electronics.getTextFromPage();
        String expectedMessage = "Electronics";
        Assert.assertEquals(expectedMessage,actualMessage,"You are not a right page");
    }
    @Test
    public void verifyPageNavigateToApparel() throws InterruptedException {
        homepage.goToApparelPage();
        String actualMessage= apparel.getTextFromPage();
        String expectedMessage = "Apparel";
        Assert.assertEquals(expectedMessage,actualMessage,"You are not a right page");
    }
    @Test
    public void verifyPageNavigateToDigitalDownloads() throws InterruptedException {
        homepage.goToDigitalDownloadsPage();
        String actualMessage= digitalDownloads.getTextFromPage();
        String expectedMessage = "Digital downloads";
        Assert.assertEquals(expectedMessage,actualMessage,"You are not a right page");
    }
    @Test
    public void verifyPageNavigateToBooks() throws InterruptedException {
        homepage.goToBooksPage();
        String actualMessage= books.getTextFromPage();
        String expectedMessage = "Books";
        Assert.assertEquals(expectedMessage,actualMessage,"You are not a right page");
    }
    @Test
    public void verifyPageNavigateToJewelry() throws InterruptedException {
        homepage.goToJewelryPage();
        String actualMessage= jewelry.getTextFromPage();
        String expectedMessage = "Jewelry";
        Assert.assertEquals(expectedMessage,actualMessage,"You are not a right page");
    }
    @Test
    public void verifyPageNavigateToGiftCard() throws InterruptedException {
        homepage.goToGiftCardsPage();
        String actualMessage= giftCard.getTextFromPage();
        String expectedMessage = "Gift Cards";
        Assert.assertEquals(expectedMessage,actualMessage,"You are not a right page");
    }




}
