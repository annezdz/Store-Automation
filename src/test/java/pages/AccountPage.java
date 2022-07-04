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

    private final By myAccount = By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']");
    private final By register = By.xpath("//a[normalize-space()='Register']");

    public WebElement getMyAccount() {
        return driver.findElement(myAccount);
    }

    public RegisterPage getRegister() {
        driver.findElement(register).click();
        return new RegisterPage(driver);
    }
}
