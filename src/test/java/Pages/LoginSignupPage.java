package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSignupPage {

    WebDriver driver;


    WebElement nameForSignupField;
    WebElement emailForSignupField;


    WebElement emailForLoginField;

    WebElement passwordForLoginField;

    WebElement signupButton;


    WebElement invalidInputText;
    WebElement loginButton;
    String signupPageUrl;

    public LoginSignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSignupPageUrl() {
        return "https://automationexercise.com/login";
    }

    public WebElement getNameForSignupField() {
        return driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
    }

    public WebElement getEmailForSignupField() {
        return driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
    }

    public WebElement getSignupButton() {
        return driver.findElement(By.cssSelector("button[data-qa='signup-button']"));


    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("button[data-qa='login-button']"));
    }

    public WebElement getEmailForLoginField() {
        return driver.findElement(By.cssSelector("input[data-qa='login-email']"));
    }

    public WebElement getPasswordForLoginField() {
        return driver.findElement(By.cssSelector("input[data-qa='login-password']"));
    }

//----------------------------------------------

    public void inputSignupName(String name) {

        getNameForSignupField().clear();
        getNameForSignupField().sendKeys(name);
    }

    public void inputSignupEmail(String email) {

        getEmailForSignupField().clear();
        getEmailForSignupField().sendKeys(email);
    }

    public void clickOnSubmitButton() {
        getSignupButton().click();
    }


    public void clickOnLoginButton() {
        getLoginButton().click();
    }


    public void inputLoginEmail(String email) {

        getEmailForLoginField().clear();
        getEmailForLoginField().sendKeys(email);
    }

    public void inputLoginPassword(String password) {

        getPasswordForLoginField().clear();
        getPasswordForLoginField().sendKeys(password);
    }

    public WebElement getInvalidInputText() {
        return driver.findElement(By.cssSelector("p[style='color: red;']"));

    }


}


