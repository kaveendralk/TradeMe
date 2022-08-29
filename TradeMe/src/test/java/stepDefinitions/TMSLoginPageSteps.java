package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TMSDashboardPage;
import pages.TMSLogInPage;

public class TMSLoginPageSteps {

	WebDriver driver = null;
	TMSLogInPage tmsloginpage;
	TMSDashboardPage tmsdashboardpage;

	@Given("Open the browser")
	public void browserIsOpen() {
		 
		String projectPath = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}
	
	@And("Navigate to TMS Login page")
	public void navigateToTMSLoginPage() {
		tmsloginpage = new TMSLogInPage(driver);
		driver.navigate().to("https://www.tmsandbox.co.nz/");
		tmsloginpage.clickLoginLinkButton();
		tmsloginpage.ValidateUserInLoginPage();
	}

	@When("The user login with a valid (.*) and an invalid (.*)$")
	public boolean loginWithValidEmailAndInvalidPassword(String email, String password) throws Exception {
		return tmsloginpage.loginWithValidEmailAndInvalidPassword(email, password);
	}

	@Then("Validate the error message and the user is still in Login page")
	public void validateErrorMessage() throws Exception {
		tmsloginpage.validateErrorMessage();	
	}
	
	@When("The field is blank and Login button is clicked")
	public boolean loginWithoutEmailAndPassword() throws Exception {
		return tmsloginpage.loginWithoutEmailAndPassword();
	}
	
	@Then("Verify field validation messages and the user is still in Login page")
	public void checkFieldValidationMessages() throws Exception {
		tmsloginpage.checkFieldValidationMessages();
	}
	
	@When("The user login with a valid (.*) and a valid (.*)$")
	public boolean loginWithValidEmailAndValidPassword(String email, String password) throws Exception {
		return tmsloginpage.loginWithValidEmailAndValidPassword(email, password);
	}

	@Then("Verify the user is logged in to TMS successfully")
	public void checkSuccessfulLogin() throws Exception {
		tmsloginpage.checkSuccessfulLogin();
	}
	
	@When("Search by (.*) in computers category$")
	public void searchAnItemInComputerCategorry(String searchKey) {
//		tmsdashboardpage = new TMSDashboardPage(driver);
		tmsloginpage.searchAnItemInComputerCategorry(searchKey);
	}
	
	@When("Listing an (.*) with (.*) and uploading its image (.*)$")
	public void addItemToListing(String itemName, String startPrice, String fileName) {
//		tmsdashboardpage = new TMSDashboardPage(driver);
		tmsloginpage.addItemToListing(itemName, startPrice, fileName);
	}

 

	@Then("Close the browser")
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
