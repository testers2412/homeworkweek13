package com.xcart.testsuite;

import com.xcart.pages.BestSeller;
import com.xcart.pages.HomePage;
import com.xcart.pages.Sale;
import com.xcart.testbase.TestBase;
import org.testng.annotations.Test;

public class HotDealsTest extends TestBase {
    HomePage homePage=new HomePage();
    Sale sale= new Sale();
    BestSeller bestSeller= new BestSeller();
    @Test
     public void verifySaleProductsArrangeAlphabetically() throws InterruptedException{
      homePage.clickOnSale();
      sale.verifySalePage("Sale");
      sale.clickOnAToZAndVerifySorting();
    }
    @Test
     public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException{
        homePage.clickOnSale();
        sale.verifySalePage("Sale");
        sale.clickOnLowToHighAndVerifySorting();
    }
    @Test
    public void verifySaleProductsPriceArrangeByRates() throws InterruptedException{
        homePage.clickOnSale();
        sale.verifySalePage("Sale");
        sale.clickOnRatesAndVerifySorting();
    }
    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        homePage.clickOnBestSeller();
        bestSeller.verifyBestSellerPage("Bestsellers");
        bestSeller.clickOnZToAAndVerifySorting();
    }
   @Test
   public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException{
       homePage.clickOnBestSeller();
       bestSeller.verifyBestSellerPage("Bestsellers");
      bestSeller.clickOnHighLowAndVerifySorting();
   }
   @Test
   public void verifyBestSellersProductsArrangeByRates() throws InterruptedException{
       homePage.clickOnBestSeller();
       bestSeller.verifyBestSellerPage("Bestsellers");
       bestSeller.clickOnRatesAndVerifySorting();


   }


}
