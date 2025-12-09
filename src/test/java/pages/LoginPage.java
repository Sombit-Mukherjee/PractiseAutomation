package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    By emailfield = By.xpath("//input[@data-qa = 'login-email']");
    By passwd = By.xpath("//input[@data-qa = 'login-password']");
    By button = By.xpath("//button[@data-qa = 'login-button']");
    By loggedin = By.xpath("//a[contains(.,'Logged in as')]");
    By error = By.xpath("//p[contains(.,'Your email or password is incorrect!')]");


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

    public boolean isErrorMessageDisplayed(){
       try {
           return driver.findElement(error).isDisplayed();
       } catch (NoSuchElementException e) {
           return false;
       }

    }

    public String getErrorMessageText(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(error));
        return driver.findElement(error).getText().trim();

    }



}
