package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By inputEmail = By.cssSelector("#input-email");
    private final By inputPassword = By.cssSelector("#input-password");
    private final By loginButton = By.xpath("//input[@value='Login']");

    public void loginUser(String user, String password) throws InterruptedException {
         driver.findElement(inputEmail).sendKeys(user);
         driver.findElement(inputPassword).sendKeys(password);
         driver.findElement(loginButton).click();
        Thread.sleep(3000);

    }

//    public WebElement getInputPassword() {
//        return driver.findElement(inputPassword);
//    }

//    public WebElement getLoginButtom() {
//        return driver.findElement(loginButton);
//    }
}