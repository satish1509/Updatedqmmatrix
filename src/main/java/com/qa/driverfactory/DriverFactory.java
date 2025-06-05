package com.qa.driverfactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public WebDriver init_driver(String driver) {
    	if (driver.equalsIgnoreCase("chrome")) {
    	    ChromeOptions options = new ChromeOptions();

    	    // Suppress "Chrome is being controlled..." message
    	    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
    	    options.setExperimentalOption("useAutomationExtension", false);

    	    // Disable popups
    	    Map<String, Object> prefs = new HashMap<>();
    	    prefs.put("credentials_enable_service", false); // Disable password manager
    	    prefs.put("profile.password_manager_enabled", false); // Disable save password prompt
    	    prefs.put("profile.default_content_setting_values.notifications", 2); // Block notifications
    	    prefs.put("profile.default_content_setting_values.geolocation", 2); // Block location popup

    	    options.setExperimentalOption("prefs", prefs);

    	    tdriver.set(new ChromeDriver(options));
    	
     
        } else if (driver.equalsIgnoreCase("firefox")) {
            tdriver.set(new FirefoxDriver());
        } else {
            System.out.println("Browser not supported: " + driver);
        }

        // Common setup
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }
}
