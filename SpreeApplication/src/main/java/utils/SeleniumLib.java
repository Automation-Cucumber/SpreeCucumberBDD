package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author Sonal
 * This class holds all the Common Selenium Methods which are needed to perform testing on Spree
 * application.
 */
public class SeleniumLib {
	
	WebDriver driver;

	public SeleniumLib(WebDriver driver) {
		
		this.driver = driver;
	   PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//li//a[@class='nav-link text-white']")
	WebElement loginLink;
	
	@FindBy(xpath = "//li[@id='home-link']/a")
	WebElement home;
	
	@FindBy(xpath ="//div[@class= 'row']//figure") 
	WebElement spreeHeader;
	
	@FindBy(xpath ="//h3")
	WebElement headermsg;
	
	/** User Navigates to URL
	 * @param https://spree-vapasi.herokuapp.com/
	 */
	public void navigateToUrl(String url) {
	driver.navigate().to(url);
	}
	
	
	/**
	 * User Click Login Link on the HomePage
	 */
	public void clickLoginLink() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Login")));
		loginLink.click();
	}

	
	/**
	 *  User Clicks on Home Link in the Homepage
	 */
	public void clickHomeOnHomepage() {
		home.click();
	}
	
	/**
	 * Spree header (spree) is retrieved in header variable
	 */
	public String getHeader()
	{
	   String header = spreeHeader.getText();
	   return header;
	}
}
