package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptUtil {

    private JavascriptExecutor js;

    public JavaScriptUtil(WebDriver driver){
        this.js = (JavascriptExecutor) driver;
    }

    public void clickElementByJS(By locator){
        js.executeScript("arguments[0].click();", locator);
    }
}
