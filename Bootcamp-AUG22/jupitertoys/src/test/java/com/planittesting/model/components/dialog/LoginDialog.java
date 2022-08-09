package com.planittesting.model.components.dialog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;

public class LoginDialog<T>{
    protected WebElement rooElement;
    protected T parent;
    public LoginDialog(WebElement rootElement, T parent){
        this.parent=parent;
        this.rooElement=rootElement;
    }
    public LoginDialog setUserName (String username){
        rooElement.findElement(By.id("loginUserName")).sendKeys(username);
        return this;
    }
    public LoginDialog setPassword (String password){
        rooElement.findElement(By.id("loginPassword")).sendKeys(password);
        return this;
    }
    public T clickLoginButton(){
        rooElement.findElement(By.className("btn-primary")).click();
        return parent;
    }
}
