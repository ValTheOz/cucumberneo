package com.neotech.cucumber.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonUtils;
import utils.ExcelReader;


public class AddEmployeeTest extends CommonUtils {

    @Test(groups = "regression")
    public void AddEmployee(){
        String firstName = "Sema";
        String lastname = "Demir";
        String username = "SemaDemir";
        String password = "Sema@123";

        LoginPageElemnts loginPageElemnts = new LoginPageElemnts();
        DashboardPageElements dash = new DashboardPageElements();
        AddEmployeePageElements addEmployeePageElements = new AddEmployeePageElements();
        PersonalPageDetailsElements per = new PersonalPageDetailsElements();

        loginPageElemnts.signIn();

        wait(3);

        dash.PIM.click();
        dash.addEmployeeLink.click();
        wait(3);

        sendText(addEmployeePageElements.firstname, firstName);
        sendText(addEmployeePageElements.lastName, lastname);
        String expectedEmpID = addEmployeePageElements.employeeId.getAttribute("value");
        selectDropdown(addEmployeePageElements.location, "London Office");
        wait(1);
        jsClick(addEmployeePageElements.checkBoxLoginDetails);
        wait(1);
        sendText(addEmployeePageElements.username, username);
        sendText(addEmployeePageElements.password, password);
        sendText(addEmployeePageElements.confirmPassword, password);
        wait(1);

        click(addEmployeePageElements.saveButoon);
        wait(1);
        waitForVisibility(per.personalDetailsForm);
        test.info("Validating Employee...");
        String actualEmployeeID = per.employeeId.getAttribute("value");
        Assert.assertEquals(actualEmployeeID, expectedEmpID, "IDS do not match");
    }

    @DataProvider(name="excelData")
    public Object[][] createData(){
        return ExcelReader.excelIntoArray( "src/main/resources/testdatas/neosheets.xlsx","Employee");
    }
}
