package com.planittesting.model.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage<ContactPage> {
  public ContactPage(WebDriver driver) {
    super(driver);
  }

  // public ContactPage setEmail(String email) {
  // driver.findElement(By.id("email")).sendKeys(email);
  // return this;
  // }

//   public ContactPage setInput(String input, String id) {
//     driver.findElement(By.id(id)).sendKeys(input);
//     return this;
//   }

  public String getErrorText(String id) {
    var elements = driver.findElements(By.id(id));
    if (elements.isEmpty())
      return "No element found";
    return elements.get(0).getText();
  }

  // public String getErrorText(String id) {
  // var element = driver.findElement(By.id(id));

  // return element.isDisplayed() ? element.getText() : "No element found";
  // }

  public ContactPage clickSubmitButton() {
    driver.findElement(By.className("btn-contact")).click();
    return this;
  }

  public ContactPage setContactData(){

    this.setInput("Alex", "forename")
    .setInput("apike@planittesting.com", "email")
    .setInput("Test message", "message");
    return this;
  }
  public String getSuccessMessage(){
     return new WebDriverWait(driver, Duration.ofSeconds(60)).until(
        driver -> driver.findElement(By.className("alert-success")).getText());
    
  }
}