package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    String invalidEmail, invalidPassword, invalidInputText;

    @BeforeMethod

    public void pageSetUp() {


        driver.get("https://automationexercise.com/");
        homePage.clickOnLoginSignupButton();
        Assert.assertNotEquals(homePage.getHomePageUrl(), driver.getCurrentUrl());


        invalidEmail = "email@it.qa";
        invalidPassword = "password";
        invalidInputText = "Your email or password is incorrect!";

    }


    @Test(priority = 10)
    public void UserCannotLoginWithInvalidEmail() {

        loginSignupPage.inputLoginEmail(invalidEmail);
        loginSignupPage.inputLoginPassword(password);
        loginSignupPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), loginSignupPage.getSignupPageUrl());
        Assert.assertTrue(loginSignupPage.getLoginButton().isDisplayed());
        Assert.assertEquals(loginSignupPage.getInvalidInputText().getText(), invalidInputText);
    }

    @Test(priority = 20)
    public void UserCannotLoginWithInvalidPassword() {

        loginSignupPage.inputLoginEmail(email);
        loginSignupPage.inputLoginPassword(invalidPassword);
        loginSignupPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), loginSignupPage.getSignupPageUrl());
        Assert.assertTrue(loginSignupPage.getLoginButton().isDisplayed());
        Assert.assertEquals(loginSignupPage.getInvalidInputText().getText(), invalidInputText);

    }

    @Test(priority = 30)
    public void UserCanLogout() {

        loginSignupPage.inputLoginEmail(email);
        loginSignupPage.inputLoginPassword(password);
        loginSignupPage.clickOnLoginButton();

        Assert.assertEquals(loggedInPage.getUserIsLoggedIn().getText(), "Logged in as " + firstName);
        Assert.assertTrue(loggedInPage.getLogoutButton().isDisplayed());

        loggedInPage.clickOnLogoutButton();

        Assert.assertEquals(driver.getCurrentUrl(), loginSignupPage.getSignupPageUrl());
        Assert.assertTrue(loginSignupPage.getLoginButton().isDisplayed());
    }

    @Test(priority = 40)


    public void userCanLoginWithValidCredentials() {

        loginSignupPage.inputLoginEmail(email);
        loginSignupPage.inputLoginPassword(password);
        loginSignupPage.clickOnLoginButton();

        Assert.assertEquals(loggedInPage.getUserIsLoggedIn().getText(), "Logged in as " + firstName);
        Assert.assertTrue(loggedInPage.getLogoutButton().isDisplayed());

    }
}
