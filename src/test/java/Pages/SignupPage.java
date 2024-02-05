package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {


    WebDriver driver;

    WebElement passwordField;
    WebElement firstNameField;
    WebElement lastNameField;
    WebElement addressField;

    WebElement countryField;
    WebElement stateField;
    WebElement cityField;
    WebElement zipcodeField;
    WebElement mobileNumberField;

    WebElement createAccountButton;

    String signupPageUrl;

    JavascriptExecutor js;


    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getFirstNameField() {
        return driver.findElement(By.id("first_name"));
    }

    public WebElement getLastNameField() {
        return driver.findElement(By.id("last_name"));
    }

    public WebElement getAddressField() {
        return driver.findElement(By.id("address1"));
    }

    public WebElement getCountryField() {
        return countryField;
    }

    public WebElement getStateField() {
        return driver.findElement(By.id("state"));
    }

    public WebElement getCityField() {
        return driver.findElement(By.id("city"));
    }

    public WebElement getZipcodeField() {
        return driver.findElement(By.id("zipcode"));
    }

    public WebElement getMobileNumberField() {
        return driver.findElement(By.id("mobile_number"));
    }

    public WebElement getCreateAccountButton() {
        return driver.findElement(By.cssSelector("button[data-qa='create-account']"));
    }

    public String getSignupPageUrl() {
        return "https://automationexercise.com/signup";
    }


    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    //-------------


    public void inputPassword(String password) {


        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void inputFirstName(String firstName) {

        getFirstNameField().clear();
        getFirstNameField().sendKeys(firstName);
    }

    public void inputLastName(String lastName) {

        getLastNameField().clear();
        getLastNameField().sendKeys(lastName);
    }

    public void inputAddress(String address) {

        getAddressField().clear();
        getAddressField().sendKeys(address);
    }

    public void inputState(String state) {

        getStateField().clear();
        getStateField().sendKeys(state);
    }

    public void inputCity(String city) {

        getCityField().clear();
        getCityField().sendKeys(city);
    }

    public void inputZipcode(String zipcode) {

        getZipcodeField().clear();
        getZipcodeField().sendKeys(zipcode);
    }

    public void inputMobileNumber(String mobileNumber) {

        getMobileNumberField().clear();
        getMobileNumberField().sendKeys(mobileNumber);
    }

    public void clickOnCreateAccountButton() {

        js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", getCreateAccountButton());
        js.executeScript("arguments[0].click();", getCreateAccountButton());

    }

}
