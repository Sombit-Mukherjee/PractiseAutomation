package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.RegistrationPage;
import utils.ConfigReader;

import java.util.List;
import java.util.Map;

public class UserRegistration {

    private RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());
    ConfigReader cr = new ConfigReader();

    @Given("when user in register page")
    public void when_user_in_register_page(){
        DriverFactory.getDriver().get(cr.getProperties("url"));
    }

    @When("user adds valid name and email")
    public void user_adds_valid_name_and_email(){
        String RegisterName = cr.getProperties("signName");
        String RegisterEmail = cr.getProperties("signEmail");
        registrationPage.Name(RegisterName);
        registrationPage.Email(RegisterEmail);

    }

    @And("user clicks on sign up button")
    public void user_clicks_on_sign_up_button(){
        registrationPage.setSignUpButton();
    }

    @Then("user should see the Additional Info section")
    public void user_should_see_the_Additional_Info_section(){
        boolean isDisplayed = registrationPage.isAccountInfoPageDisplayed();
        Assert.assertTrue("Enter Account Information", isDisplayed);
    }

    @When("user adds following account information details:")
    public void user_adds_following_account_information_details(DataTable dataTable){
        List<Map<String , String>> data = dataTable.asMaps(String.class, String.class);
        registrationPage.selectTitle(data.get(0).get("Title"));
        registrationPage.addPassword(data.get(0).get("Password"));
        registrationPage.selectDay(data.get(0).get("Day"));
        registrationPage.selectMonth(data.get(0).get("Month"));
        registrationPage.selectYear(data.get(0).get("Year"));

    }

    @And("user select the newsletters and offers checkboxes")
    public void use_select_the_newsletters_and_offers_checkboxes(){
        registrationPage.selectNewsLetter();
        registrationPage.selectOffers();
    }

    @And("user fill in the address information:")
    public void user_fill_in_the_address_information(DataTable dataTable){
        List<Map<String, String>> info = dataTable.asMaps(String.class, String.class);
        registrationPage.regFirstName(info.get(0).get("FirstName"));
        registrationPage.regLastName(info.get(0).get("LastName"));
        registrationPage.regCompany(info.get(0).get("Company"));
        registrationPage.regAddress(info.get(0).get("Address"));
        registrationPage.selectCountry(info.get(0).get("Country"));
        registrationPage.selectState(info.get(0).get("State"));
        registrationPage.selectCity(info.get(0).get("City"));
        registrationPage.selectZipcode(info.get(0).get("Zipcode"));
        registrationPage.selectMob(info.get(0).get("Mobile"));
    }

    @And("user click the Create Account button")
    public void user_click_the_Create_Account_button(){
        registrationPage.setCreateAccountButton();

    }

    @Then("user should see Account Created message")
    public void user_should_see_Account_Created_message(){
        boolean isAccountCreated = registrationPage.isAccountCreatedSuccessfully();
        Assert.assertTrue("Account Created!",isAccountCreated);

    }


}
