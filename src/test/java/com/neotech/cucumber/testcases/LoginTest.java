package com.neotech.cucumber.testcases;

import org.testng.annotations.Test;
import utils.CommonUtils;
import utils.ConfigsReader;

public class LoginTest extends CommonUtils {

    @Test(groups = {"smoke", "Smoke Test", "regression"})
    public void validLogin(){
        LoginPageElemnts login = new LoginPageElemnts();
        DashboardPageElements dashboardPageElements = new DashboardPageElements();
        wait(2);
        test.info("Entering valid login credentials.");
        wait(2);
        sendText(login.username, ConfigsReader.getProperties("username"));
        wait(1);
        sendText(login.password, ConfigsReader.getProperties("password"));
        wait(1);
        jsClick(login.logInButton);
        wait(2);
        test.info("Verifying that user is logged in.");

        String EXPECTED = "Jacqueline White";
    }

    @Test (groups = "regression")
    public void invalidPasswordLogin(){
        LoginPageElemnts login = new LoginPageElemnts();
        wait(2);
        sendText(login.username, ConfigsReader.getProperties("username"));
        wait(1);
        sendText(login.password, "blah");
        wait(1);
        click(login.logInButton);
        wait(1);
        String expected = "Invalid Credentials - Blah bla bla";

    }
}
