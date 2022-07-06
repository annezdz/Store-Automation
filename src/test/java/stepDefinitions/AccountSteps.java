package stepDefinitions;

import com.beust.ah.A;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.IOException;

//import static pages.Base.openurl;

@RunWith(Cucumber.class)
public class AccountSteps extends Base {

//   protected WebDriver driver;

    protected HomePage homePage = new HomePage(driver);
    protected RegisterPage registerPage = new RegisterPage(driver);
    protected LoginPage loginPage = new LoginPage(driver);

    public AccountSteps() throws IOException {
    }

//    public AccountSteps() throws IOException {
//        super();
//    }


//
//    public AccountSteps(Base base) throws IOException {
//        super(base);
//    }


    @Given("^I initialize the browser with Chrome$")
    public void i_initialize_the_browser_with_chrome() throws Throwable {
//        initialize();
        System.out.println("DRIVER INICIALIZADO");
    }

    @Then("^I go to \"([^\"]*)\" webpage$")
    public void i_go_to_something_page(String webpage) {
        if (webpage.equals("Register Account")) {
            Assert.assertTrue(registerPage.getRegisterAccountTitle().isDisplayed());
        }
    }

    @And("^navigate to \"([^\"]*)\"$")
    public void navigate_to_something(String strArg1) {
        openurl(properties.getProperty("url"));
        System.out.println("*** " + driver.getTitle());
//        driver.findElement(By.cssSelector("a[title='My Account'] span[class='hidden-xs hidden-sm hidden-md']")).click();
        //log.info("Open " + properties.getProperty("url"));
    }

    @And("^click on \"([^\"]*)\"$")
    public void click_on_something(String buttom) throws InterruptedException {
        switch (buttom) {
            case "My Account" -> {
                homePage.getMyAccount().click();
                System.out.println("CHEGAMOS AQUI");
                Thread.sleep(2000);
                break;
            }
            case "Register" -> {
                homePage.getRegister();
                System.out.println("CHEGAMOS NO REGISTER");
                break;
            }
            case "Login" -> {
                homePage.getLogin();
                System.out.println("CHEGAMOS NO LOGIN");
                break;
            }
//            case "LoginButtom" -> {
//                Thread.sleep(3000);
//                loginPage.getLoginButtom().click();
//                break;
//            }
        }
    }
}


