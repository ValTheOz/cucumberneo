package com.neotech.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElemnts {
    @FindBy (id ="txtUsername" )
    public WebElement username;
    @FindBy (id ="txtPassword" )
    public WebElement password;
    @FindBy (id ="//button[@type='submit']" )
    public WebElement loginButton;

}
