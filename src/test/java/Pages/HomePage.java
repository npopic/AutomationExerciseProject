package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {


    WebElement loginSignupButton;
    WebDriver driver;


    String homePageUrl;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getLoginSignupButton() {
        return driver.findElement(By.cssSelector("div.shop-menu.pull-right a[href='/login']"));

    }

    public String getHomePageUrl() {
        return "https://automationexercise.com/";
    }


//------------------------------------------

    public void clickOnLoginSignupButton() {

        getLoginSignupButton().click();
    }


}
