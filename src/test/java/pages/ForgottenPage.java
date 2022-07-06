package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgottenPage {

    protected WebDriver driver;

    public ForgottenPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailField = By.cssSelector("#input-email");
    private final By continueButton = By.cssSelector("input[value='Continue']");
    private final By emailLingMessage = By.cssSelector(".alert.alert-success.alert-dismissible");


    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public boolean getEmailMessage() {
        return driver.findElement(emailLingMessage).isDisplayed();
    }


}
