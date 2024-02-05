package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddedProduct {


    WebDriver driver;


    WebElement continueShoppingButton;
    WebElement viewCartLinkLocation;
    WebElement addedItemTextLocation;


    public AddedProduct(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getContinueShoppingButton() {
        return driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block"));
    }

    public WebElement getViewCartLinkLocation() {
        return driver.findElement(By.cssSelector("a[href='/view_cart']"));
    }

    public WebElement getAddedItemTextLocation() {
        // WebElement parent = driver.findElement(By.className("modal-body"));
        //return parent.findElement(By.cssSelector("text-center"))
        return driver.findElement(By.xpath("//div[@class='modal-body']//p[text()='Your product has been added to cart.']"));
    }


//----------------------------------------------------


    public void clickOnContinueShoppingButton() {

        getContinueShoppingButton().click();
    }

    public void clickOnViewCartLink() {

        getViewCartLinkLocation().click();
    }
}
