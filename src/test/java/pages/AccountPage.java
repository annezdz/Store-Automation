package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AccountPage   {

    protected WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By editAccountLabel = By.xpath("//a[normalize-space()='Edit your account information']");

    public WebElement getMyAccountLabel() {
        return driver.findElement(editAccountLabel);
    }





}
