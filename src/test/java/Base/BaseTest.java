package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;
    public LoginSignupPage loginSignupPage;
    public SignupPage signupPage;

    public AccountCreatedPage accountCreatedPage;

    public LoggedInPage loggedInPage;

    public ShoppingCartPage shoppingCartPage;

    public JavascriptExecutor js;

    public DeletedAccountPage deletedAccountPage;

    public AddedProduct addedProduct;

    public Product1Page product1Page;
    public String email, password, firstName;
    public WebDriverWait wait;

    @BeforeClass

    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginSignupPage = new LoginSignupPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        loggedInPage = new LoggedInPage(driver);
        deletedAccountPage = new DeletedAccountPage(driver);
        addedProduct = new AddedProduct(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        product1Page = new Product1Page(driver);

        js = (JavascriptExecutor) driver;
        email = "pera@p.qa";
        password = "P@ssw0rd1";
        firstName = "Pera";

    }


    @AfterClass

    public void tearDown() {

        driver.manage().deleteAllCookies();
        driver.quit();
        //  loggedInPage.clickOnLogoutButtonIfDisplayed(loggedInPage.getLogoutButton());

    }

    public void closeVignette() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName" +
                "('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }


    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(element)));
    }

  /*  public void klikniNaElementAkoJePrisutan(By locator) {
        try {
            if (driver.findElement(locator).isDisplayed()) {
                driver.findElement(locator).click();
                System.out.println("Kliknuto na element.");
            } else {
                System.out.println("Element nije prisutan na stranici.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element nije prisutan na stranici.");
        }
    }

   */
}
