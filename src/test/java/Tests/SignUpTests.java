package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTests extends BaseTest {

    String lastName, address, state, city, zipcode, mobileNumber, AccountCreatedText, DeletedAccountText, blank;



    @BeforeMethod

    public void pageSetUp() {


        driver.get("https://automationexercise.com/");


        lastName = "Peric";
        address = "Akacija 29";
        state = "CA";
        city = "San Francisco";
        zipcode = "94103";
        mobileNumber = "628328002";
        AccountCreatedText = "ACCOUNT CREATED!";
        DeletedAccountText = "ACCOUNT DELETED!";
        blank = "";

        homePage.clickOnLoginSignupButton();
        Assert.assertNotEquals(homePage.getHomePageUrl(), driver.getCurrentUrl());
        loginSignupPage.inputSignupName(firstName);
        loginSignupPage.inputSignupEmail(email);
        loginSignupPage.clickOnSubmitButton();

        signupPage.inputPassword(password);
        signupPage.inputFirstName(firstName);
        signupPage.inputLastName(lastName);
        signupPage.inputAddress(address);
        signupPage.inputState(state);
        signupPage.inputCity(city);
        signupPage.inputZipcode(zipcode);
        signupPage.inputMobileNumber(mobileNumber);

    }

    @Test(priority = 10)

    public void userCannotSignupWithBlankMandatoryFirstNameField() {

        signupPage.inputFirstName(blank);

        signupPage.clickOnCreateAccountButton();

        Assert.assertEquals(driver.getCurrentUrl(), signupPage.getSignupPageUrl());
        Assert.assertTrue(signupPage.getCreateAccountButton().isDisplayed());

    }


    @Test(priority = 20)

    public void userCanDeleteAccount() {


        signupPage.clickOnCreateAccountButton();
        accountCreatedPage.clickOnContinueButton();

        Assert.assertEquals(loggedInPage.getUserIsLoggedIn().getText(), "Logged in as " + firstName);
        Assert.assertTrue(loggedInPage.getDeleteAccountButton().isDisplayed());

        loggedInPage.clickOnDeleteAccount();

        Assert.assertEquals(deletedAccountPage.getAccountDeletedMessageLocation().getText(), DeletedAccountText);


    }


    @Test(priority = 30)

    public void userCanSignupWithFillingMandatoryFields() {

        signupPage.clickOnCreateAccountButton();

        Assert.assertEquals(accountCreatedPage.getAccountCreatedText().getText(), AccountCreatedText);
        Assert.assertEquals(driver.getCurrentUrl(), accountCreatedPage.getAccountCreatedPageUrl());

        accountCreatedPage.clickOnContinueButton();

        Assert.assertEquals(loggedInPage.getUserIsLoggedIn().getText(), "Logged in as " + firstName);
        Assert.assertTrue(loggedInPage.getDeleteAccountButton().isDisplayed());



    }



}
