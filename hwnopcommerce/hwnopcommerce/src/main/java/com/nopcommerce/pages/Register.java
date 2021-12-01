package com.nopcommerce.pages;

import com.nopcommerce.ulitiy.Utility;
import org.openqa.selenium.By;

public class Register extends Utility {
    By registerPageText=By.xpath("//h1[normalize-space()='Register']");
    String errorMessage;
    By genderButton=By.xpath("//input[@id='gender-male']");
    By firstNameTab= By.id("FirstName");
    By lastNameTab= By.id("LastName");
    By dayTab=By.xpath("//select[@name='DateOfBirthDay']");
    By monthTab= By.xpath("//select[@name='DateOfBirthMonth']");
    By yearTab= By.xpath("//select[@name='DateOfBirthYear']");
    By emailTab= By.id("Email");
    By passwordTab= By.id("Password");
    By confirmPasswordTab= By.id("ConfirmPassword");
    By registerButton= By.id("register-button");
    By registrationCompletionText=By.xpath("//div[@class='result']");
    By continueTab= By.xpath("//a[normalize-space()='Continue']");

    public void verifyRegisterPage(String expectedMessage){
        errorMessage="You are not on register page";
        verifyElementTextMatching(expectedMessage,registerPageText,errorMessage);
    }
    public void clickOnGenderMale(){
        clickOnElement(genderButton);
    }
    public void enterFirstName(String firstName){
        sendTextToElement(firstNameTab,firstName);
    }
    public void enterLastName(String lastName){
        sendTextToElement(lastNameTab,lastName);
    }
    public void selectDOB(String day,String month,String year){
        sendTextToElement(dayTab,day);
        sendTextToElement(monthTab,month);
        sendTextToElement(yearTab,year);
    }
    public void enterEmail(String email){
        sendTextToElement(emailTab,email);

    }
    public void enterPassword(String password){
        sendTextToElement(passwordTab,password);

    }
    public void enterConfirmPassword(String confirmPassword){
        sendTextToElement(confirmPasswordTab,confirmPassword);

    }
    public void clickOnRegister(){
        clickOnElement(registerButton);
    }
    public void verifyRegistrationCompleted(String expectedMessage){
        errorMessage="The registration is not completed";
        verifyElementTextMatching(expectedMessage,registrationCompletionText,errorMessage);
    }
    public void clickOnContinue(){
        clickOnElement(continueTab);
    }



}
