package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    protected WebDriver driver;
    public static String usernameRegistered = "";
    public static String passwordRegistered = "";


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By registerAccount = By.cssSelector("div[id='content'] h1");
    private final By firstName = By.cssSelector("#input-firstname");
    private final By lastName = By.cssSelector("#input-lastname");
    private final By email = By.cssSelector("#input-email");
    private final By telephone = By.cssSelector("#input-telephone");

    private final By password = By.cssSelector("#input-password");
    private final By passwordConfirm = By.cssSelector("#input-confirm");
    private final By newsletter = By.cssSelector("input[value='0']");
    private final By privacy = By.cssSelector("input[value='1'][name='agree']");
    private final By continueButtom = By.cssSelector("input[value='Continue']");
    private final By messageCreatedAccount = By.cssSelector("div[id='content'] h1");
    private final By messageAlreadyRegisteredMessage = By.cssSelector(".alert.alert-danger.alert-dismissible");



    public WebElement getRegisterAccountTitle() {
        return driver.findElement(registerAccount);
    }

    public void createUser(String eMail) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(eMail);
    }

    public void createUser(String name, String lastname, String eMail, String phone,
                                 String passWord,String confirmPassword) {
         driver.findElement(firstName).sendKeys(name);
         driver.findElement(lastName).sendKeys(lastname);
         driver.findElement(email).sendKeys(eMail);
         driver.findElement(telephone).sendKeys(phone);
//         driver.findElement(email).sendKeys(eMail);
         driver.findElement(password).sendKeys(passWord);
         driver.findElement(passwordConfirm).sendKeys(confirmPassword);
         driver.findElement(newsletter).click();
         driver.findElement(privacy).click();
//         driver.findElement(continueButtom).click();
        usernameRegistered = eMail;
        passwordRegistered = passWord;
    }

    public String message() {
        System.out.println("*** " + passwordRegistered);
        System.out.println("*** " + usernameRegistered);
        return driver.findElement(messageCreatedAccount).getText();
    }

    public String getAlreadyRegisteredMessage() {
        return driver.findElement(messageAlreadyRegisteredMessage).getText();
    }

    public WebElement getContinueButtom() {
        return driver.findElement(continueButtom);
    }
}
