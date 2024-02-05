package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountCreatedPage {


    WebDriver driver;


    String ExpectedAccountCreatedPageUrl;
    WebElement AccountCreatedText;

    public WebElement locate;

    WebElement continueButton;


    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountCreatedPageUrl() {
        return "https://automationexercise.com/account_created";
    }

    public WebElement getAccountCreatedText() {
        return driver.findElement(By.cssSelector(".title.text-center"));

    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector("a[data-qa='continue-button'].btn.btn-primary"));
    }

//----------------------------------------

    public void clickOnContinueButton() {

        getContinueButton().click();
    }

}