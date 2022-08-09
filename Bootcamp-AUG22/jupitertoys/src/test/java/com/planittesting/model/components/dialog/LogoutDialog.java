package com.planittesting.model.components.dialog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.planittesting.model.pages.HomePage;


public class LogoutDialog<T> {
    protected WebElement rootElement;
    protected WebDriver driver;
    protected T parent;
  
    By logoutButton = By.className("btn-success");
  
    public LogoutDialog(WebDriver driver, T parent) {
      this.rootElement = driver.findElement(By.className("modal"));
      this.parent = parent;
      this.driver = driver;
    }
  
    public HomePage clickLogoutButton() {
      rootElement.findElement(logoutButton).click();
      return new HomePage(driver);
    }
  }