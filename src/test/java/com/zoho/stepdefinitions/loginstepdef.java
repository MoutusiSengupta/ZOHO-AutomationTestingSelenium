package com.zoho.stepdefinitions;

import base.BaseTest;
import com.zoho.pageObjects.login;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import utilities.readxlsdata;

import java.io.File;
import java.io.FileInputStream;


public class loginstepdef {
    public static String[] getLoginData() throws Exception {

        File f = new File(
                System.getProperty("user.dir")
                        +"\\src\\test\\resources\\testdata\\testdata.xlsx");

        FileInputStream fis = new FileInputStream(f);

        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet = wb.getSheet("login");

        DataFormatter df = new DataFormatter();

        String username =
                df.formatCellValue(sheet.getRow(1).getCell(0));

        String password =
                df.formatCellValue(sheet.getRow(1).getCell(1));

        wb.close();

        return new String[]{username,password};
    }
    @Given("Zoho web loads successfully")
    public void Zoho_web_loads_successfully() throws Throwable{
    BaseTest.driver.get(BaseTest.prop.getProperty("url"));
    Thread.sleep(2000);

    }

@Then("user enter valid email address and correct password login should be successful")
    public void user_enter_valid_email_address_and_correct_password_login_should_be_successful() throws Throwable{
    readxlsdata excel = new readxlsdata();

    String[] data = excel.getLoginData();

    String username = data[0];
    String password = data[1];

    login.logintest(username,password);
}

@Then("verify login is successful")
    public void verify_login_is_successful() throws Throwable{
    throw new PendingException();
}

    @When("click on {string} button on homepage")
    public void clickOnButtonOnHomepage(String arg0) {
        
    }

    @Then("enter valid email address")
    public void enterValidEmailAddress() {
        
    }

    @And("complete the registration form")
    public void completeTheRegistrationForm() {
        
    }

    @Then("click {string} button")
    public void clickButton(String arg0) {
        
    }

    @And("verify account creation success message")
    public void verifyAccountCreationSuccessMessage() {
    }

    @Then("user logout")
    public void userLogout() {
     login.logout();
    }
}

