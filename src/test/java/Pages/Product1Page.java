package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product1Page {


    WebDriver driver;


    WebElement nameField;
    WebElement emailField;
    WebElement reviewField;

    WebElement submitButton;

    WebElement product1NameLocation;


    WebElement submittedTextLocation;


    WebElement addToCartButton;

    public WebElement getAddToCartButton() {
        return driver.findElement(By.cssSelector(".btn.btn-default.cart"));
    }

    public WebElement getSubmittedTextLocation() {
        return driver.findElement(By.cssSelector("div#review-section div.alert-success.alert"));
    }

    public Product1Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProduct1NameLocation() {
        return driver.findElement(By.cssSelector("div.product-information > h2"));
    }

    public WebElement getNameField() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getReviewField() {
        return driver.findElement(By.id("review"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("button-review"));
    }

    //---------------------------------------------

    public void clickOnAddToCartButton() {
        getAddToCartButton().click();
    }

    public void inputName(String name) {
        getNameField().clear();
        getNameField().sendKeys(name);
    }

    public void inputEmail(String email) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    public void inputReview(String review) {
        getReviewField().clear();
        getReviewField().sendKeys(review);
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }

}
