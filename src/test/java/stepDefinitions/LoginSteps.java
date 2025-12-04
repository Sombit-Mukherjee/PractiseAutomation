package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    @And("clicks login button")
    public void clicks_login_button(){
        lp.clickButton();
    }

    @Then("user is redirected to home page")
    public void user_is_redirected_to_home_page(){
        boolean verify = lp.isuserloggedin();
        Assert.assertTrue(verify,"User login failed");
    }



}
