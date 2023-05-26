package com.neotech.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class DashboardPageElements extends CommonUtils {

    @FindBy(xpath = "//span[@id='account-name']")
    public WebElement accountName;

    public DashboardPageElements(){
        PageFactory.initElements(driver, this);
    }
}
