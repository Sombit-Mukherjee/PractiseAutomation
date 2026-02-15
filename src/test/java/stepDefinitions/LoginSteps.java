package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps {

    ConfigReader cr = new ConfigReader();

    private LoginPage lp = new LoginPage(DriverFactory.getDriver());

   @Given("user is in the login page")
   public void user_is_in_the_login_page(){
        DriverFactory.getDriver().get(new ConfigReader().init_prop().getProperty("url"));

   }

    @When("user adds valid credentials")
    public void user_adds_valid_credentials(){
       String validEmail = cr.getProperties("validEm1");
       String validPassword = cr.getProperties("validPass1");
        lp.enterEmail(validEmail);
        lp.enterPassword(validPassword);
    }

    @When("user adds invalid {string} and {string} credentials")
    public void user_adds_invalid_credentials(String username, String password){
       //String invalidEmail = cr.getProperties("email2");
       //String invalidPassword = cr.getProperties("password2");
       lp.enterEmail(username);
       lp.enterPassword(password);

    }
    @And("clicks login button")
    public void clicks_login_button(){
        lp.clickButton();
    }

    @Then("user is redirected to home page")
    public void user_is_redirected_to_home_page(){
        boolean verify = lp.isuserloggedin();
        Assert.assertTrue("User login failed",verify);
    }

    @Then("user can see {string} message")
    public void user_can_see_error_message(String expectedError){
       //String expectederror = "Your email or password is incorrect!";

       Assert.assertTrue("The message is not displayed",lp.isErrorMessageDisplayed());
       String actualError = lp.getErrorMessageText();
       Assert.assertEquals("The displayed error message is different.",expectedError,actualError);


    }



}
