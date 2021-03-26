package stepdef;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import pages.HomePage;
import pages.LoginPage;
import utils.SeleniumLib;
import utils.DriverFactory;

public class SpreeHomePgStepDef {
    
	WebDriver driver = null;
	HomePage homePage;
	LoginPage loginPage;
	DriverFactory factory;
	SeleniumLib commonSel;
	String spreeUrl,useremailid,password;
	ConfigFileReader configFileReader;
	
	public SpreeHomePgStepDef() throws Exception {
	 factory= new DriverFactory();
     driver = factory.createDriver();
	 homePage = new HomePage(driver);	
	 loginPage = new LoginPage(driver);
	 commonSel = new SeleniumLib(driver);
	} 
	
	@Given("^User navigates to Spree Url in the browser\\.$")
	public void user_navigates_to_Spree_Url_in_the_browser() throws Throwable {
		configFileReader = new ConfigFileReader();
		String spreeUrlValue = configFileReader.getProperty("spreeUrl");
		System.out.println("\n Print value of SpreeUrl  value" + spreeUrlValue);
		commonSel.navigateToUrl(spreeUrlValue);
		//String header = commonSel.getHeader();
	//	Assert.assertEquals(header, "spree", "\n Test Case is Passed");
	
	}

	@When("^User clicks Login in the HomePage\\.$")
	public void user_clicks_Login_in_the_HomePage() throws Throwable {
		commonSel.clickLoginLink();
		String header = loginPage.existingCustomerMsg();
		Assert.assertEquals(header, "Login as Existing Customer","\n Test Case is Passed");
				
	}

	@Then("^Login Page is opened\\.$")
	public void login_Page_is_opened() throws Throwable {
		String header = loginPage.existingCustomerMsg();
		Assert.assertEquals(header, "Login as Existing Customer","\n Test Case is Passed");

	}

	@Then("^User enter emailid/password details and press submit\\.$")
	public void user_enter_emailid_password_details_and_press_submit() throws Throwable {
	   configFileReader = new ConfigFileReader();
	   loginPage.loginToApplication(configFileReader.getProperty("useremailid"),configFileReader.getProperty("userpassword"));
		}

	@Then("^User able to login$")
	public void user_able_to_login() throws Throwable {
		String successMsg = homePage.loginSuccessfully();
		Assert.assertEquals(successMsg, "Logged in successfully","\n Test Case is Passed");
	
	}
	
	/**
	 * Verify that shopping items are present in Shop by Categories
	 */
  @When("^User clicks Home$")
	public void user_clicks_Home() throws Throwable {
	  System.out.println("\n Clicking Home on Homepage");
	  commonSel.clickHomeOnHomepage();
	}

	@Then("^Shop by Categories gets displayed$")
	public void shop_by_Categories_gets_displayed(DataTable key) throws Throwable {
	   	List<List<String>> data = key.raw();
		System.out.println("\n ### Display Shop By Categories ###"); 
		String shopByCategory = homePage.getShopByCategories();
		Assert.assertEquals(shopByCategory, "Shop by Categories");
		for(int i=0;i<3;i++)
		{
			boolean value = homePage.listShopByCategories(data.get(i).get(0));
			Assert.assertTrue(value, "\n TestCase is Passed");
		}
		
	} 
	
	@When("^User clicks items in Shop By Brands$")
	public void user_clicks_items_in_Shop_By_Brands(DataTable key) throws Throwable {
		List<List<String>> data = key.raw();
		System.out.println("\n ### Display Shop By Brands ###"); 
		String shopByBrand = homePage.getShopByCategories();
		Assert.assertEquals(shopByBrand, "Shop by Brands");
		for(int i=1;i<4;i++)
		{
			boolean value = homePage.listShopByCategories(data.get(i).get(0));
			Assert.assertTrue(value, "\n TestCase is Passed");
		}
		
	}

	@Then("^List of items which user clicked get displayed under the header which has the same item name\\.$")
	public void list_of_items_which_user_clicked_get_displayed_under_the_header_which_has_the_same_item_name(DataTable arg1) throws Throwable {
	
	}

	@Then("^Each item has the name that user clicked\\.$")
	public void each_item_has_the_name_that_user_clicked() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
	}

	@Then("^List of items which have the name same as user selected gets displayed\\.$")
	public void list_of_items_which_have_the_name_same_as_user_selected_gets_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}}
	

