package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	public static WebDriver driver;

	public WebDriver createDriver() throws Exception {
		
		try {

			switch ("chrome") {

			// firefox setup
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver();
				break;

			// chrome setup
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium Study Mster\\ChromeDriver89\\chromedriver.exe");
				// CHROME OPTIONS
				ChromeOptions options = new ChromeOptions();
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				break;

			}
		} catch (Exception e) {
			System.out.println("Unable to load browser! - Exception: " + e.getMessage());
		} 
		finally {
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		}
		return driver;
	}

}
