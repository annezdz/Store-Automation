package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By myAccount = By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']");
    private final By register = By.xpath("//a[normalize-space()='Register']");
    private final By login = By.cssSelector("li[class='dropdown open'] li:nth-child(2) a:nth-child(1)");

    public WebElement getMyAccount() {
        return driver.findElement(myAccount);
    }

    public RegisterPage getRegister() {
        driver.findElement(register).click();
        return new RegisterPage(driver);
    }

    public LoginPage getLogin() {
        driver.findElement(login).click();
        return new LoginPage(driver);
    }

}
