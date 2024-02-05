package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage {


    WebDriver driver;


    WebElement proceedToCheckoutButton;

    WebElement xButton;
    String cartUrl;

    WebElement shoppingCartTextLocation;


    WebElement emptyCartTextLocation;

    WebElement addedProduct1TitleLocation;

    List<WebElement> xButtons;


    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getxButtons() {
        return driver.findElements(By.cssSelector("a.cart_quantity_delete > .fa.fa-times"));
    }
    public WebElement getProceedToCheckoutButton() {
        return driver.findElement(By.cssSelector(".btn.btn-default.check_out"));
    }

    public WebElement getxButton() {
        return driver.findElement(By.cssSelector("a.cart_quantity_delete > .fa.fa-times"));
    }

    public String getCartUrl() {
        return "https://automationexercise.com/view_cart";
    }

    public WebElement getShoppingCartTextLocation() {
        return driver.findElement(By.cssSelector("div.breadcrumbs li.active"));

    }

    public WebElement getAddedProduct1TitleLocation() {
        return driver.findElement(By.cssSelector("td.cart_description h4 > a[href='/product_details/1']"));

    }

    public WebElement getEmptyCartTextLocation() {
        return driver.findElement(By.id("empty_cart"));
    }

    //--------------------------------

    public void clickOnProceedToCheckoutButton() {

        getProceedToCheckoutButton().click();

    }

    public void clickOnXbutton() {

        getxButton().click();
    }

    public void deleteAllItemsFromTheCart() {
        for (WebElement pivot : getxButtons()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", pivot);
            js.executeScript("arguments[0].click();", pivot);
        }

    }

}
