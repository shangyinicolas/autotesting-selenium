package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
    protected WebDriver driver;
    public ContactPage(WebDriver driver){
        this.driver=driver;
    }
    public ContactPage setEmail(String email){
        driver.findElement(By.id("email")).sendKeys(email);
        return this;
    }
    public String getEmailError(){
       return driver.findElement(By.id("email-err")).getText();
    }
    public ContactPage clickSubmitBtn(){
        driver.findElement(By.linkText("Submit")).click();
        return this;
    }
    public String getFronameError(){
        return driver.findElement(By.id("forename-err")).getText();
    }
    public String getMessageError(){
        return driver.findElement(By.id("message-err")).getText();
    }
}
