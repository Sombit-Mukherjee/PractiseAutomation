package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;


public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser){
        System.out.println("The browser is : " + browser);

        if (browser.equals("chrome")){
            tlDriver.set(new ChromeDriver());
        } else if (browser.equals("edge")) {
            tlDriver.set(new EdgeDriver());
        }
        else {
            System.out.println("Please pass the correct browser " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getDriver();
    }
    public static void unloadDriver(){
        tlDriver.remove();
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
