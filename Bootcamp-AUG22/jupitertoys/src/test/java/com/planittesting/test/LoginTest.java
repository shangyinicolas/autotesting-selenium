package com.planittesting.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.page.Page;

import com.planittesting.model.components.dialog.LogoutDialog;
import com.planittesting.model.pages.BasePage;
import com.planittesting.model.pages.HomePage;

public class LoginTest extends BaseTest {
    @Test
    public void validateLoginSuccess()  {
      var login=new HomePage(driver)
       .clickLoginMenu()
       .setUserName("nic")
       .setPassword("letmein")
       .clickLoginButton();
       var page =driver.findElement(By.linkText("Logout"));
       assertTrue(page.isDisplayed());
    }

    @Test
    public void validateLogoutSuccess()  {
      var login=new HomePage(driver)
       .clickLoginMenu()
       .setUserName("nic")
       .setPassword("letmein")
       .clickLoginButton();
       var page =driver.findElement(By.linkText("Logout"));
       assertTrue(page.isDisplayed());
       ((BasePage<HomePage>) login).clickLogoutMenu().clickLogoutButton();
       assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());
      
    }
}
