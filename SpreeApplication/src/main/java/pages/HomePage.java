package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/**
 * @author Sonal
 *  This class holds all the details which are needed for testing the WebElements in the Homepage.
 */
public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver objDriver) {
		this.driver = objDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "keywords")
	WebElement searchKeyword;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement searchButton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Ruby')]")
	public List<WebElement> searchNameRuby;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Apache')]")
	public List<WebElement> searchNameApache;

	@FindBy(linkText = "Bags")
	WebElement bagLink;

	@FindBy(xpath = "//input[@id='Price_Range_$15.00_-_$18.00']")
	WebElement priceRange;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement searchFilter;

	@FindBy(how = How.XPATH, using = "//span[@itemprop='price']")
	public List<WebElement> priceValue;

	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement loginSuccess;
		
	@FindBy(xpath = "//h4[text()='Shop by Categories']")
	WebElement shopByCategory;
	 
	@FindBy(xpath = "//a[@class='list-group-item active']")
	WebElement shopByBrandRuby;
	
	@FindBy(xpath="//h1[@class='taxon-title']")
	WebElement headerRuby;
	
	@FindBy(xpath="//span[text()='Ruby Baseball Jersey']") 
	WebElement brandRubyBaseball;
	
	@FindBy(xpath="//h4[text()='Shop by Brands']")
	WebElement shopByBrands;
	
	
	/** Extracting the Shop by Categories header
	 * @return Shop by Categories header
	 */
	public String getShopByCategories()
	{
		String shopByCateg = shopByCategory.getText();
		return shopByCateg;
	}
	
	/** Display the Shop by Categories
	 * @param key = Bags/Mugs/Clothing
	 * @return True/False
	 */
	public boolean listShopByCategories(String key)
	{
		WebElement categoryItem = driver.findElement(By.xpath("//a[@class='list-group-item' and text()='"+key+"']"));
		boolean value = categoryItem.isDisplayed();
		return value;
	}
	
	public String getShopByBrands()
	{
		String shopByBrand = shopByBrands.getText();
		return shopByBrand;
	}
	
	/** This method will check if any brand is selected in shop by brand same item is generated in the list
	 * @return True/False
	 */
	
	public boolean listShopByBrandRuby(String key)
	{
		shopByBrandRuby.isDisplayed();
		driver.findElement(By.xpath("//a[text()='"+key+"']")).isDisplayed();
		return true;
	}
	
	
	public boolean listShopByBrandRuby1()
	{
		
		shopByBrandRuby.click();
		String brandRubyOption = shopByBrandRuby.getText();
		String brandRuby=headerRuby.getText();
		String brandRubyBaseballSelect = brandRubyBaseball.getText().substring(0, 4);
		if(brandRubyOption.equals(brandRuby) && brandRuby.equals(brandRubyBaseballSelect) &&brandRubyOption.equals(brandRubyBaseballSelect))
		return true;
		else
		return false;
			
	}
	
	
	
	public String loginSuccessfully()
	{
		String successmsg = loginSuccess.getText();
		return successmsg;
	}
	

	public void searchKeyword(String name) {
		searchKeyword.sendKeys(name);
		searchButton.click();
		searchKeyword.clear();

	}

	public boolean verifyallSearchedHaveRuby() {
		int size = searchNameRuby.size();
		String title = "";
		for (int i = 0; i < size; i++)
			title = searchNameRuby.get(i).getText();
		boolean check = title.contains("Ruby");
		return check;
	}

	public boolean verifyallSearchedHaveApache() {
		int size = searchNameApache.size();
		String title = "";
		for (int i = 0; i < size; i++)
			title = searchNameApache.get(i).getText();
		boolean check = title.contains("Apache");
		return check;

	}

	public void searchByFilters() {

		bagLink.click();
		priceRange.click();
		searchFilter.click();

	}

	public boolean verifySearchByFilters() {
		Boolean checkbox = priceRange.isSelected();
		Boolean checkPrice = null;
		Assert.assertTrue(checkbox);
		for (int i = 0; i < priceValue.size(); i++) {
			String price = priceValue.get(i).getText();
			String value = price.substring(1);
			double priceText = Double.parseDouble(value);
			if ((priceText > 15.00) && (priceText < 18.00))
				
			checkPrice = true;
		}
		return checkPrice;
	}

}
