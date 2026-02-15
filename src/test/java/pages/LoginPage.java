package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class LoginPage extends BaseClass {
    //WebDriver driver;

    By emailfield = By.xpath("//input[@data-qa = 'login-email']");
    By passwd = By.xpath("//input[@data-qa = 'login-password']");
    By button = By.xpath("//button[@data-qa = 'login-button']");
    By loggedin = By.xpath("//a[contains(.,'Logged in as')]");
    By error = By.xpath("//p[contains(.,'Your email or password is incorrect!')]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        typeText(emailfield, email);

    }

    public void enterPassword(String password) {
        typeText(passwd, password);

    }

    public void clickButton() {
        clickElement(button);
    }

    public boolean isuserloggedin() {
        return getElement(loggedin).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        try {
           return getElement(error).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessageText(){
            return getElement(error).getText().trim();
    }


}
