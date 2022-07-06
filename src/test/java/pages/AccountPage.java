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

    private final By editAccountLabel = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)");

   public boolean getConfirmLogin() {
       return driver.findElement(editAccountLabel).isDisplayed();
   }





}
