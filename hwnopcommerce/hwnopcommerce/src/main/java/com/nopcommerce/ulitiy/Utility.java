package com.nopcommerce.ulitiy;

import com.nopcommerce.drivermanager.DriverManager;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static com.nopcommerce.drivermanager.DriverManager.driver;

public class Utility extends DriverManager {

    /**
     * This method will click element
     *
     * @param by
     */

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
        // driver.findElement(by).click();

    }

    /**
     * This Method get text from element
     *
     * @param by
     * @return
     */

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    /**
     * This method will send text on element
     *
     * @param by
     * @param text
     */

    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    /**
     * The method will clear the text from the element
     *
     * @param by
     */
    public void clearText(By by) {
        driver.findElement(by).clear();
    }

    /**
     * Method will select the text from Dropdown menu by visible text
     *
     * @param by
     * @param text
     */

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);

        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
        //new Select(driver.findElement(by)).selectByVisibleText(text);
    }

    /**
     * Method will select the element from the dropdown by value
     *
     * @param by
     * @param value
     */

    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown1 = driver.findElement(by);
        Select select = new Select(dropDown1);
        select.selectByValue(value);
        //new Select(driver.findElement(by)).selectByValue(value);

    }

    /**
     * Method will select the element by index number
     *
     * @param by
     * @param index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        // WebElement dropdown2 = driver.findElement(by);
        //Select select = new Select(dropdown2);
        // select.selectByIndex(index);
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    /**
     * Method will accept the alert
     */
    public void alertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //driver.switchTo().alert().accept();

    }

    /**
     * Method will dismiss the alert
     */
    public void alertDismiss() {
        //Alert alert = driver.switchTo().alert();
        //alert.dismiss();
        driver.switchTo().alert().dismiss();
    }

    /**
     * Mehod will get the text from alert
     */
    public String alertGetText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
        // return driver.switchTo().alert().getText();
    }

    /**
     * Method will send the text to alert if needed
     *
     * @param alertText
     */
    public void alertSendKeys(String alertText) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(alertText);
        //driver.switchTo().alert().sendKeys(alertText);
    }

    /**
     * Method will perform drag and drop action
     *
     * @param drag
     * @param drop
     */
    public void actionDragAndDrop(By drag, By drop) {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(drag);
        WebElement droppable = driver.findElement(drop);
        actions.dragAndDrop(draggable, droppable).build().perform();
        // new Actions(driver).dragAndDrop(driver.findElement(drag),driver.findElement(drag)).build().perform();
    }

    /**
     * Method will perform Right click action on the mouse
     *
     * @param by
     */
    public void actionRightClick(By by) {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(by);
        actions.contextClick(button).build().perform();
        // new Actions(driver).contextClick(driver.findElement(by)).build().perform();
    }

    /**
     * Method will move slider to given parameter place
     *
     * @param by
     * @param x
     * @param y
     */
    public void actionSlider(By by, int x, int y) {
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(by);
        actions.dragAndDropBy(slider, x, y).build().perform();
        // new Actions(driver).dragAndDropBy(driver.findElement(by),x,y).build().perform();
    }

    public void actionMouseHoverAndClickOnListElement(By main, By list) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(main);
        WebElement hover1 = driver.findElement(list);
        actions.moveToElement(hover).moveToElement(hover1).click().build().perform();
        //new Actions(driver).moveToElement(driver.findElement(main)).moveToElement(driver.findElement(list)).click().build().perform();

    }

    public void actionMouseHoverAndClick(By main) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(main);
        actions.moveToElement(hover).click().build().perform();
        //new Actions(driver).moveToElement(driver.findElement(main)).click().build().perform();

    }

    public void actionMouseHoverOnly(By main) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(main);
        actions.moveToElement(hover).build().perform();
        // new Actions(driver).moveToElement(driver.findElement(main)).build().perform();
    }

    //public void verifyMatchingElements(String expectedMessage, By by, String errorMessage) {
    //  String actualMessage = getTextFromElement(by);

    // Assert.assertEquals(errorMessage, expectedMessage, actualMessage);
    //Assert.assertEquals(errorMessage,expectedMessage,driver.findElement(by).getText());
    //}

    /*public void sortDataFromElementsAndVerifySorting(By by) {
        List<WebElement> originalList = driver.findElements(by);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());

        }
        List<WebElement> name = driver.findElements(by);//Storing webelements in a list of webelement
        String[] beforeSort = new String[name.size()];//array declaration with size equal to list size
        for (int i = 0; i < name.size(); i++) {
            beforeSort[i] = name.get(i).getText().trim();//will capture all the index positions, get text and trim spaces
        }
        Arrays.sort(beforeSort);//sorting the array
        WebElement sort = driver.findElement(by);
        sort.click();
        name = driver.findElements(by);
        String[] aftersort = new String[name.size()];

        for (int i = 0; i < name.size(); i++) {
            aftersort[i] = name.get(i).getText().trim();
            Assert.assertArrayEquals("Elements are not sorted", beforeSort, aftersort);
        }

    }*/

    public void sortAndVerifySortingAtoZ(By list, By position,  String value) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(list);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }
        Collections.sort(originalProductNameList);
        selectByValueFromDropDown(position,value);
        Thread.sleep(2000);
        List<WebElement> afterSortList = driver.findElements(list);
        List<String> afterSortProductName = new ArrayList<>();
        for (WebElement product : afterSortList) {
            afterSortProductName.add(product.getText());
        }
        Assert.assertEquals("The products are not sorted", originalProductNameList, afterSortProductName);

    }
    public void sortAndVerifySortingZtoA(By list, By position, String value) throws InterruptedException {
        List<WebElement> originalList = driver.findElements(list);
        List<String> originalProductNameList = new ArrayList<>();
        for (WebElement product : originalList) {
            originalProductNameList.add(product.getText());
        }
        Collections.sort(originalProductNameList,Collections.reverseOrder());
        selectByValueFromDropDown(position,value);
        //waitUntilVisibilityOfElementLocated(By.xpath("//h2[@class='product-title']"),20);
        Thread.sleep(2000);
        List<WebElement> afterSortList = driver.findElements(list);
        List<String> afterSortProductName = new ArrayList<>();
        for (WebElement product : afterSortList) {
            afterSortProductName.add(product.getText());
        }
        Assert.assertEquals("The products are not sorted", originalProductNameList, afterSortProductName);

    }

    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }
    public void selectMenu(String menu, By menuBars) throws InterruptedException {
        List<WebElement> menuBar= driver.findElements(menuBars);
        for(WebElement product:menuBar){
            if(product.getText().equalsIgnoreCase(menu)){
                Thread.sleep(2000);
                product.click();
                break;
            }}}
    public void verifyElementTextMatching(String expectedMessage,By by,String errorMessage){
      String actualMessage= getTextFromElement(by);
      Assert.assertEquals(errorMessage,expectedMessage,actualMessage);
    }
    public String randomString(){
        String randString;
        RandomString rnd = new RandomString(10);
       return randString= rnd.nextString();
    }


}

