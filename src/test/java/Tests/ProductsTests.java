package Tests;

import Base.BaseTest;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductsTests extends BaseTest {

    String expectedAddedItemText, expectedCartTitleText, product1TitleText, emptyCartText, review, submittedReviewText;

    @BeforeMethod

    public void pageSetUp() {


        // driver = new ChromeDriver();
        // driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");


        expectedAddedItemText = "Your product has been added to cart.";
        expectedCartTitleText = "Shopping Cart";
        product1TitleText = "Blue Top";
        emptyCartText = "Cart is empty! Click here to buy products.";
        review = "This is not the END!";
        submittedReviewText = "Thank you for your review.";

       /* addedProduct = new AddedProduct(driver);
        loginSignupPage = new LoginSignupPage(driver);
        signupPage = new SignupPage(driver);
        homePage = new HomePage(driver);
        loggedInPage = new LoggedInPage(driver);
        */

        homePage.clickOnLoginSignupButton();
        loginSignupPage.inputLoginEmail(email);
        loginSignupPage.inputLoginPassword(password);
        loginSignupPage.clickOnLoginButton();


    }


    @Test(priority = 10)


    public void addingRandomProductToCart() throws InterruptedException {


        loggedInPage.clickAddRandomProduct();
        loggedInPage.clickAddRandomProduct();
        wait.until(ExpectedConditions.visibilityOf(addedProduct.getAddedItemTextLocation()));
        Assert.assertEquals(addedProduct.getAddedItemTextLocation().getText(), expectedAddedItemText);
        Assert.assertTrue(addedProduct.getViewCartLinkLocation().isDisplayed());
        addedProduct.clickOnContinueShoppingButton();
        loggedInPage.clickOnLogoutButton();
        loggedInPage.clickOnHomeButton();

    }


    @Test(priority = 20)
    public void verifyUserRedirectedToCartAfterClickingCartLinkAtAddedToCartText() {

        loggedInPage.clickAddRandomProduct();
        addedProduct.clickOnViewCartLink();
        Assert.assertEquals(shoppingCartPage.getShoppingCartTextLocation().getText(), expectedCartTitleText);
        Assert.assertEquals(driver.getCurrentUrl(), shoppingCartPage.getCartUrl());
        Assert.assertTrue(shoppingCartPage.getProceedToCheckoutButton().isDisplayed());
        loggedInPage.clickOnLogoutButton();
        loggedInPage.clickOnHomeButton();
    }


    @Test(priority = 30)
    public void addSpecificItemToCart() {

        loggedInPage.clickOnProduct1();
        addedProduct.clickOnViewCartLink();
        Assert.assertEquals(shoppingCartPage.getAddedProduct1TitleLocation().getText(), product1TitleText);
        loggedInPage.clickOnLogoutButton();
        loggedInPage.clickOnHomeButton();
    }

    @Test(priority = 35)
    public void addAllItemsToCart() throws InterruptedException {

        loggedInPage.addAllProducts();
        loggedInPage.clickOnLogoutButton();
        loggedInPage.clickOnHomeButton();
    }

    @Test(priority = 40)
    public void deleteAllItemsFromCart() throws InterruptedException {

        loggedInPage.clickOnCartButton();
        shoppingCartPage.deleteAllItemsFromTheCart();
        wait.until(ExpectedConditions.visibilityOf(shoppingCartPage.getEmptyCartTextLocation()));
        Assert.assertEquals(shoppingCartPage.getEmptyCartTextLocation().getText(), emptyCartText);
        loggedInPage.clickOnLogoutButton();
        wait.until(ExpectedConditions.elementToBeClickable(loggedInPage.getHomeButton()));
        loggedInPage.clickOnHomeButton();
    }


    @Test(priority = 50)
    public void deleteAddedItemFromCart() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(loggedInPage.getCartButton()));
        loggedInPage.clickOnCartButton();
        Assert.assertEquals(shoppingCartPage.getEmptyCartTextLocation().getText(), emptyCartText);
        wait.until(ExpectedConditions.elementToBeClickable(loggedInPage.getHomeButton()));
        loggedInPage.clickOnHomeButton();
        closeVignette();
        loggedInPage.clickOnHomeButton();
        loggedInPage.clickOnProduct1();
        addedProduct.clickOnViewCartLink();
        Assert.assertEquals(shoppingCartPage.getAddedProduct1TitleLocation().getText(), product1TitleText);
        shoppingCartPage.clickOnXbutton();
        wait.until(ExpectedConditions.visibilityOf(shoppingCartPage.getEmptyCartTextLocation()));
        Assert.assertEquals(shoppingCartPage.getEmptyCartTextLocation().getText(), emptyCartText);
        loggedInPage.clickOnLogoutButton();
        wait.until(ExpectedConditions.elementToBeClickable(loggedInPage.getHomeButton()));
        loggedInPage.clickOnHomeButton();
    }

    @Test(priority = 60)
    public void userCanSubmitReviewForTheProduct() {

        wait.until(ExpectedConditions.elementToBeClickable(loggedInPage.getProduct1details()));
        loggedInPage.clickOnProduct1details();
        closeVignette();
        product1Page.inputName(firstName);
        product1Page.inputEmail(email);
        product1Page.inputReview(review);
        product1Page.clickOnSubmitButton();
        Assert.assertEquals(product1Page.getSubmittedTextLocation().getText(), submittedReviewText);
    }
}
