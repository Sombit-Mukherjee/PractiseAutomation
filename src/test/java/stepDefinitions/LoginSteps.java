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

    private LoginPage lp = new LoginPage(DriverFactory.getDriver());

   @Given("user is in the login page")
   public void user_is_in_the_login_page(){
        DriverFactory.getDriver().get(new ConfigReader().init_prop().getProperty("url"));

   }

    @When("user adds valid credentials")
    public void user_adds_valid_credentials(){
        lp.enterEmail("Test@123.gmail.com");
        lp.enterPassword("Test@1234");
    }

    @When("user adds invalid credentials")
    public void user_adds_invalid_credentials(){
       ConfigReader cr = new ConfigReader();
       String invalidEmail = cr.getProperties("email2");
       String invalidPassword = cr.getProperties("password2");
       lp.enterEmail(invalidEmail);
       lp.enterPassword(invalidPassword);

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

    @Then("user can see error message")
    public void user_can_see_error_message(){
       String expectederror = "Your email or password is incorrect!";
       String actualError = lp.getErrorMessageText();
       Assert.assertEquals("The displayed error message is different.",expectederror,actualError);
       Assert.assertTrue("The message is not displayed", lp.isErrorMessageDisplayed());

    }



}
