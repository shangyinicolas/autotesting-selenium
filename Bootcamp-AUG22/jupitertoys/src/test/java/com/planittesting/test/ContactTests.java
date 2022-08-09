package com.planittesting.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.model.pages.HomePage;

public class ContactTests extends BaseTest {
  @Test
  public void verifyEmailError() {
    var contactPage = new HomePage(driver)
        .clickContactMenu()
        .setInput("notanemail", "email")
        .getErrorText("email-err");

    assertEquals("Please enter a valid email", contactPage);
  }

  @Test
  public void verifyRequiredFieldErrors() {
    var contactPage = new HomePage(driver)
        .clickContactMenu()
        .clickSubmitButton();

    assertEquals("Forename is required", contactPage.getErrorText("forename-err"));
    assertEquals("Email is required", contactPage.getErrorText("email-err"));
    assertEquals("Message is required", contactPage.getErrorText("message-err"));

    contactPage
        .setInput("Alex", "forename")
        .setInput("apike@planittesting.com", "email")
        .setInput("Test message", "message");

    assertEquals("No element found", contactPage.getErrorText("forename-err"));
    assertEquals("No element found", contactPage.getErrorText("email-err"));
    assertEquals("No element found", contactPage.getErrorText("message-err"));
  }
  @Test
  public void validateContactFormSubmit(){
    var message =new HomePage(driver)
     .clickContactMenu()
     .setContactData()
     .clickSubmitButton()
     .getSuccessMessage();
     assertEquals("Thanks Alex, we appreciate your feedback.", message);

  }

}