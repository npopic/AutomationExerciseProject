package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeletedAccountPage {


    WebDriver driver;


    WebElement accountDeletedMessageLocation;

    public DeletedAccountPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getAccountDeletedMessageLocation() {
        return driver.findElement(By.cssSelector(".title.text-center"));
    }

}
