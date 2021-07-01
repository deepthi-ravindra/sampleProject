package drivers;

import log.Log;
import net.thucydides.core.webdriver.DriverSource;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

public class LocalChromeDriver implements DriverSource {
    public WebDriver newDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
//        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--acceptSslCerts");
        options.addArguments("--acceptInsecureCerts");
//        options.setHeadless(true);

        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        options.setCapability(CapabilityType.PLATFORM_NAME, "MAC");
//        options.setCapability("acceptInsecureCerts", "true");

        Logger.getRootLogger().setLevel(Level.INFO);
        options.setCapability("acceptSslCerts", "true");
        System.setProperty("browser", "chrome");
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Log.info("Webdriver for browser: "+((ChromeDriver)driver).getCapabilities().getBrowserName()+" running");

        return driver;
    }

    public boolean takesScreenshots() {
        return true;
    }
}

