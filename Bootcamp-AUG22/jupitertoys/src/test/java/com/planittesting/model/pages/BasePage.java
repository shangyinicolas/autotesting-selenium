package com.planittesting.model.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.planittesting.model.components.dialog.LoginDialog;
import com.planittesting.model.components.dialog.LogoutDialog;

public class BasePage<T> {
   
    public By logoutMenu = By.id("nav-logout");
    protected WebDriver driver;
    public BasePage (WebDriver driver){
        this.driver=driver;
    }
    public ContactPage clickContactMenu(){
        
        driver.findElement(By.cssSelector("#nav-contact a")).click();
        return new ContactPage(driver);
    }


    public BasePage setInput(String input, String id) {
        driver.findElement(By.id(id)).sendKeys(input);
        return this;
      }


    public boolean getLoginMessage(){
        // return new WebDriverWait(driver, Duration.ofSeconds(60)).until(
        //     driver -> driver.findElement(By.id("nav-logout")).isDisplayed());

        return driver.findElement(By.id("nav-logout")).isDisplayed();
      }
    




    @SuppressWarnings("unchecked")
    public LoginDialog<T> clickLoginMenu() {
        driver.findElement(By.cssSelector("#nav-login")).click();
        return new LoginDialog<T>(driver.findElement(By.className("modal")), (T)this);
    }
 
    
    // public LogoutDialog<T> clickLogoutMenu(){
    //     driver.findElement(By.cssSelector("#nav-logout a")).click();
    //     return new LogoutDialog<T>(driver.findElement(By.className("modal")), (T)this);
    // }

  @SuppressWarnings("unchecked")
  public LogoutDialog<T> clickLogoutMenu() {
    driver.findElement(logoutMenu).click();
    return new LogoutDialog<T>(driver, (T) this);
  }

    // this is the function will click the logout button and navi to the pop out windows
    //and will return to dialog and its parents as current window 
        //modal is the pop out alert windows
    

// public void clicksubmitButton( id?){

// }

}
