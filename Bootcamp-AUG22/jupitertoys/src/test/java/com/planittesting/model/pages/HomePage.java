package com.planittesting.model.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public ContactPage clickContactMenu(){
        driver.findElement(By.cssSelector("#nav-contact a")).click();
        return new ContactPage(driver);
    }
}
