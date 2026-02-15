package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseClass;

public class RegistrationPage extends BaseClass {

    By name = By.xpath("//input[@placeholder = 'Name']");
    By email_id = By.xpath("//input[@data-qa = 'signup-email']");
    By signUpButton = By.xpath("//button[@data-qa = 'signup-button']");
    By pageTitle = By.xpath("//b[text() = 'Enter Account Information']");
    By titleMr = By.xpath("//input[@name = 'title' and @value = 'Mr']");
    By titleMrs = By.xpath("//input[@name = 'title' and @value = 'Mrs']");

    By passwordField = By.xpath("//input[@type = 'password']");
    By daysDropdown = By.xpath("//select[@id = 'days']");
    By monthsDropdown = By.xpath("//select[@id = 'months']");
    By yearsDropdown = By.xpath("//select[@id = 'years']");
    By newsLetterCheckbox = By.xpath("//input[@id = 'newsletter']");
    By offerCheckbox = By.xpath("//input[@id = 'optin']");
    By firstname = By.xpath("//input[@id = 'first_name']");
    By lastname = By.xpath("//input[@id = 'last_name']");
    By company = By.xpath("//input[@id = 'company']");
    By address = By.xpath("//input[@id = 'address1']");
    By country = By.xpath("//select[@id = 'country']");
    By city = By.xpath("//input[@id = 'city']");
    By state = By.xpath("//input[@id = 'state']");
    By zipcode = By.xpath("//input[@id = 'zipcode']");
    By mob = By.xpath("//input[@id = 'mobile_number']");
    By createAccountButton = By.xpath("//button[@type = 'submit']");
    By accountCreatedTitle = By.xpath("//b[text() = 'Account Created!']");

    public RegistrationPage (WebDriver driver){
        super(driver);
    }

    public  void selectTitle(String titleValue){
        if (titleValue.equalsIgnoreCase("Mr")){
            clickElement(titleMr);
        } else if (titleValue.equalsIgnoreCase("Mrs")) {
            clickElement(titleMrs);
        }

    }

    public void Name(String SignupName){
        typeText(name,SignupName);
    }

    public void Email(String SignupEmail){
        typeText(email_id,SignupEmail);
    }

    public void setSignUpButton(){
        clickElement(signUpButton);
    }

    public boolean isAccountInfoPageDisplayed(){
        return getElement(pageTitle).isDisplayed();
    }

    public void addPassword(String password){
        typeText(passwordField,password);

    }
    public void selectDay(String dayValue){
        selectFromDropdown(daysDropdown,dayValue);
    }

    public void selectMonth(String monthValue){
        selectFromDropdown(monthsDropdown, monthValue);

    }

    public void selectYear(String yearValue){
        selectFromDropdown(yearsDropdown,yearValue);
    }

    public void selectCountry(String countryValue){
        selectFromDropdown(country,countryValue);

    }

    public void selectNewsLetter(){
        if(!getElement(newsLetterCheckbox).isSelected()){
            clickElement(newsLetterCheckbox);
        }
    }

    public void selectOffers(){
        if(!getElement(offerCheckbox).isSelected()){
        clickElement(offerCheckbox);
        }
    }

    public void regFirstName(String rFirstname){
        typeText(firstname,rFirstname);
    }

    public void regLastName(String rLastname){
        typeText(lastname,rLastname);
    }

    public void regCompany(String rCompany){
        typeText(company,rCompany);
    }

    public void regAddress(String rAddress){
        typeText(address,rAddress);
    }

    public void selectState(String rState){
        typeText(state,rState);

    }
    public void selectCity(String rCity){
        typeText(city,rCity);

    }

    public void selectZipcode(String rZipcode){
        typeText(zipcode,rZipcode);

    }

    public void selectMob(String rMob){
        typeText(mob,rMob);

    }

    public void setCreateAccountButton(){
        clickElement(createAccountButton);
    }

    public boolean isAccountCreatedSuccessfully(){
        return getElement(accountCreatedTitle).isDisplayed();
    }

}
