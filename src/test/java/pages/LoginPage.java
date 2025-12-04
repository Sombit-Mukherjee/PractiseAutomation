package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By emailfield = By.xpath("//input[@data-qa = 'login-email']");
    By passwd = By.xpath("//input[@data-qa = 'login-password']");
    By button = By.xpath("//button[@data-qa = 'login-button']");
    By loggedin = By.xpath("//a[contains(.,'Logged in as')]");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(emailfield).sendKeys(email);

    }

    public void enterPassword(String password){
        driver.findElement(passwd).sendKeys(password);

    }
    public void clickButton(){
        driver.findElement(button).click();
    }

    public boolean isuserloggedin(){
        return driver.findElement(loggedin).isDisplayed();
    }

}
