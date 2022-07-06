package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import pages.Base;
import pages.LoginPage;
import pages.RegisterPage;
import utils.Utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(Cucumber.class)
public class RegisterSteps extends Base {

    private static final String existentEmail = "annezdz@hotmail.com";

    private static String emailRandom;

    protected RegisterPage registerPage = new RegisterPage(driver);
    protected LoginPage loginPage = new LoginPage(driver);


    public RegisterSteps() throws IOException {
    }


    @When("^I set information to create a user$")
    public void i_set_informations_to_create_a_new_user() {
            emailRandom = "annezdz"  + Utils.randomNumbers() + "@hotmail.com";
            registerPage.createUser("Anne", "Marzano",
                    emailRandom,
                    "(47)99999-9999", "123456", "123456");
            System.out.println(emailRandom);
    }

    @Then("^a new user is created$")
    public void a_new_user_is_created() {
        registerPage.getContinueButtom().click();
        Assert.assertEquals("Your Account Has Been Created!", registerPage.message());
    }


    @And("^input a email already registered in \"([^\"]*)\" page$")
    public void input_a_email_already_registered(String page) throws InterruptedException {
        switch (page) {
            case "Register" : {
                registerPage.createUser(existentEmail);
                Thread.sleep(3000);
                System.out.println(existentEmail);
                registerPage.getContinueButtom().click();
                break;
            }
            case "Login" : {
                Thread.sleep(3000);

                loginPage.loginUser(existentEmail, "123456");
                break;
            }
        }
    }

    @Then("^the message (.+) is displayed$")
    public void the_message_is_displayed(String message) {
        Assert.assertEquals(message,registerPage.getAlreadyRegisteredMessage());
        driver.close();
    }

}
