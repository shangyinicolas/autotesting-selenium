package com.planittesting.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.model.pages.HomePage;

public class ContactTests extends BaseTest{

    @Test
    public void verifyEmailError(){
        var contactPage = new HomePage(driver)
        .clickContactMenu()
        .setEmail("notanemail")
        .getEmailError();
        assertEquals("Please enter a valid email", contactPage);
    }
    @Test
    public void verifySubmitError(){
        var clickSubmit = new HomePage(driver)
        .clickContactMenu()
        .clickSubmitBtn();
        var contactForename=clickSubmit.getFronameError();
        var contactMessage=clickSubmit.getMessageError();
        var contactEmail=clickSubmit.getEmailError();
        assertEquals("Forename is required", contactForename);
        assertEquals("Message is required", contactMessage);
        assertEquals("Email is required", contactEmail);
    }
}