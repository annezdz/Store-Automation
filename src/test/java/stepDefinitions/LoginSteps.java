package stepDefinitions;

import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AccountPage;
import pages.Base;
import pages.LoginPage;

import java.io.IOException;

public class LoginSteps extends Base {

    protected LoginPage loginPage = new LoginPage(driver);
    AccountPage accountPage = new AccountPage(driver);

    public LoginSteps() throws IOException {
    }

    @Then("^I login successfully$")
    public void i_login_successfully() throws InterruptedException {
//        loginPage.getLoginButtom().click();
        Assert.assertTrue(accountPage.getMyAccountLabel().isDisplayed());
        quit();
    }

    @And("^input a password$")
    public void input_a_password() throws InterruptedException {
        Thread.sleep(3000);
//        loginPage.getInputPassword().sendKeys("123456");
    }
}
