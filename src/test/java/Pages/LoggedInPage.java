package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoggedInPage {


    WebDriver driver;


    public WebElement logoutButton;
    WebElement deleteAccount;
    WebElement userIsLoggedIn;

    WebElement continueShoppingButton;

    WebElement cartButton;

    List<WebElement> homepageProducts;
    WebElement product1;


    WebElement product1details;

    WebElement homeButton;

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeButton() {
        return driver.findElement(By.cssSelector("div.shop-menu.pull-right a[href='/']"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector("div.shop-menu.pull-right a[href='/logout']"));

    }

    public WebElement getDeleteAccountButton() {
        return driver.findElement(By.cssSelector("div.shop-menu.pull-right a[href='/delete_account']"));

    }

    public WebElement getCartButton() {
        return driver.findElement(By.cssSelector("div.shop-menu.pull-right a[href='/view_cart']"));
    }

    public WebElement getUserIsLoggedIn() {
        return driver.findElement(By.cssSelector("div.shop-menu.pull-right ul.nav.navbar-nav li:last-child a"));


    }

    public WebElement getContinueShoppingButton() {
        return driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block"));
    }

    public List<WebElement> getHomepageProducts() {

        return driver.findElements(By.cssSelector("a.add-to-cart[data-product-id]"));

    }

    public WebElement getProduct1() {

        return driver.findElement(By.cssSelector("a[data-product-id='1']"));
    }

    public WebElement getProduct1details() {
        return driver.findElement(By.cssSelector("ul.nav.nav-pills.nav-justified > li > a[href='/product_details/1']"));
    }

    public WebElement getAddRandomHomepageProductToCart() {

        int index = (int) (Math.random() * (getHomepageProducts().size() - 31));
        return getHomepageProducts().get(index);

    }

    //----------------------

    public void clickOnProduct1details() {

        getProduct1details().click();
    }

    public void clickOnProduct1() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", getProduct1());
        js.executeScript("arguments[0].click();", getProduct1());
    }


    public void clickAddRandomProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", getAddRandomHomepageProductToCart());
        js.executeScript("arguments[0].click();", getAddRandomHomepageProductToCart());


    }


    public void clickOnLogoutButton() {

        getLogoutButton().click();
    }

    public void clickOnCartButton() {

        getCartButton().click();
    }

    public void clickOnHomeButton() {

        getHomeButton().click();
    }

    public void clickOnDeleteAccount() {
        getDeleteAccountButton().click();
    }

    public void clickOnLogoutButtonIfDisplayed(WebElement logoutButton) {
        try {
            if (logoutButton.isDisplayed()) {
                logoutButton.click();
            } else {
                System.out.println("Element nije prisutan na stranici.");
            }
        } catch (Exception e) {
            System.out.println("Element nije prisutan na stranici.");
        }
    }


    public void addAllProducts() throws InterruptedException {
        for (int i = 0; i < getHomepageProducts().size() - 6; i = i + 2) {

            getHomepageProducts().get(i).click();

            getContinueShoppingButton().click();

        }
    }
}
