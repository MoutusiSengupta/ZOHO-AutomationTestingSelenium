

package com.zoho.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.readxlsdata;

import java.time.Duration;

import static base.BaseTest.*;

public class login {

    @Test(dataProviderClass = readxlsdata.class,dataProvider = "testdata")
    public static void logintest(String username,String password) throws InterruptedException {
        driver.findElement(By.xpath(loc.getProperty("sign_in_button"))).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(driver.findElement(By.id(loc.getProperty("email_field"))))).sendKeys(username);
        wait.until(
                ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(loc.getProperty("next_button"))))).click();
        wait.until(
                ExpectedConditions.elementToBeClickable(driver.findElement(By.id(loc.getProperty("password_field"))))).sendKeys(password);
        wait.until(
                ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(loc.getProperty("login_button"))))).click();
    }

    public static void logout(){
        wait.until(
                ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(loc.getProperty("profile_icon"))))).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(loc.getProperty("sign_out_button"))))).click();
    }

}
