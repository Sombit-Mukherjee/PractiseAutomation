package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    private WebDriver driver;
    private WebDriverWait wait;

    public static final Logger logger = LogManager.getLogger(BaseClass.class);

    public BaseClass(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getElement(By locator){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void typeText(By locator, String text){
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
        logger.info("Entered text: " + text+ " into element: "+ locator);
    }

    public void clickElement(By locator){
        getElement(locator).click();
        logger.info("Clicked on element: " + locator);
    }

    public void selectFromDropdown(By locator, String visibleText){
        WebElement element = getElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
        logger.info("Selected option: "+ visibleText+ " from dropdowwn: "+ locator);

    }



}
