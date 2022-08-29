package pages;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;

public class TMSLogInPage extends BaseClass {

	WebDriver driver;

	public TMSLogInPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement inpEmail;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement inpPassword;

	@FindBy(xpath = "//span[@class='form-group-checkbox-input__checkbox-text']")
	WebElement chkRememberMe;

	@FindBy(xpath = "//button[@id='SignIn']")
	WebElement btnLogin;

	@FindBy(xpath = "//button[@id='Cancel']")
	WebElement btnCancel;

	@FindBy(xpath = "//a[.='Forgotten password?']")
	WebElement lnkForgottenPassword;

	@FindBy(xpath = "//a[.='Register now']")
	WebElement lnkRegisterNow;

	@FindBy(xpath = "//li[.='Invalid email or password']")
	WebElement msgInvalidEmailorPassword;

	@FindBy(xpath = "//a[.='Having trouble logging in?']")
	WebElement lnkHavingTroubleInLogin;

	@FindBy(xpath = "//a[@id='LoginLink']")
	WebElement btnLoginLink;
	
	@FindBy(xpath = "//input[@id='Email']/following::span[@class='field-validation-error'][1]")
	WebElement lblEmailValidationMessage;
	
	@FindBy(xpath = "//input[@id='Email']/following::span[@class='field-validation-error'][2]")
	WebElement lblPasswordValidationMessage;
	
	@FindBy(xpath = "//input[@value='Log out']")
	WebElement lblLogOut;
	
	@FindBy(xpath = "//select[@id='SearchType']")
	WebElement btnSearshType;
	
	@FindBy(xpath = "//option[.='Computers']")
	WebElement optComputers;
	
	@FindBy(xpath = "//input[@name='searchString']")
	WebElement txtSearchBox;
	
	@FindBy(xpath = "//button[@value='Search']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//input[@name='listing-title']")
	WebElement inpListingTitle;
	
	@FindBy(xpath = "//span[.='Browse all categories']")
	WebElement btnBrowseAllCat;
	
	@FindBy(xpath = "//option[@value='193']")
	WebElement optBooks;
	
	@FindBy(xpath = "//option[@value='462']")
	WebElement btnChildren;
	
	@FindBy(xpath = "//option[@value='1937']")
	WebElement btnFairy;
	
	@FindBy(xpath = "//input[@id='one-category-radio']")
	WebElement rdoOnecategory;
	
	@FindBy(xpath = "//input[@id='submit_button']")
	WebElement btnNext;
	
	@FindBy(xpath = "//textarea[@name='body']")
	WebElement txtItemDetails;
	
//	@FindBy(xpath = "//input[@id='submit1']")
//	WebElement btnNext1;
	
	@FindBy(xpath = "//input[@id='startPriceInput']")
	WebElement inpStartPrice;
	
//	@FindBy(xpath = "//input[@id='submit1']")
//	WebElement btnNext1;
	
	@FindBy(xpath = "//input[@id='gh_1']")
	WebElement rdoFreeShipping;
	
	@FindBy(xpath = "//input[@id='submit1']")
	WebElement btnNext1;
	
	@FindBy(xpath = "//input[@id='fileloc1']")
	WebElement fileUploadlocation;
	
	@FindBy(xpath = "//input[@id='ContinueUpload']")
	WebElement btnNext2;
	
	@FindBy(xpath = "//div[@id='basic-selector']")
	WebElement btnBasicSelector;
	
	@FindBy(xpath = "//button[@id='promo-submit']")
	WebElement btnPromoSubmit;
	
	@FindBy(xpath = "//td[contains(text(),'Listing title')]/following::td[1]")
	WebElement lblListingTitle;
	
	@FindBy(xpath = "//td[contains(text(),'Start price')]/following::td[1]")
	WebElement lblStartPrice;
	
	@FindBy(xpath = "//input[@id='submit_sell']")
	WebElement btnSubmitSell;
	
	@FindBy(xpath = "//h1[contains(text(),'Your auction has started.')]")
	WebElement lblConfirmation;
	
	@FindBy(id = "contained-button-file")
	WebElement btnContained;
	
	@FindBy(xpath = "//a[@id='SiteHeader_SiteTabs_sellLink']")
	WebElement lnkSell;
	
	@FindBy(xpath = "//a[.='General item']")
	WebElement lnkGeneralItem;
	

	/* validate the user lands correct page*/

	public void ValidateUserInLoginPage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		if(!driver.getTitle().equals("Buy online and sell with NZ's #1 auction & classifieds site | Trade Me")) {
			throw new IllegalStateException("This is not the TMS Login Page. Current page is " + driver.getCurrentUrl());
		}
		else {
			System.out.println("User is navigated to login page successfully");
		}
	}

	/* User clicks login link button*/

	public void clickLoginLinkButton() {		
		btnLoginLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		inpEmail.isEnabled();
	}

	/* The user login with a valid email and an invalid password */

	public boolean loginWithValidEmailAndInvalidPassword(String email, String password) throws Exception {
		try {		
			inpEmail.sendKeys(email);
			inpPassword.sendKeys(password);
			chkRememberMe.click();			
			btnLogin.click();			 
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	/* Validate the error message and the user is still in Login page*/

	public void validateErrorMessage() {		
		msgInvalidEmailorPassword.isDisplayed();
		this.ValidateUserInLoginPage();
	}
	
	/* When the field is blank and Login button is clicked */

	public boolean loginWithoutEmailAndPassword() throws Exception {
		try {		
			btnLogin.click();			 
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/* Validate the error message and the user is still in Login page*/

	public void checkFieldValidationMessages() {		
		lblEmailValidationMessage.isDisplayed();
		lblPasswordValidationMessage.isDisplayed();
		this.ValidateUserInLoginPage();
	}
	
	/* The user login with a valid email and a valid password */

	public boolean loginWithValidEmailAndValidPassword(String email, String password) throws Exception {
		try {		
			inpEmail.sendKeys(email);
			inpPassword.sendKeys(password);
			chkRememberMe.click();			
			btnLogin.click();			 
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/* Validate user is logged in successfully*/

	public void checkSuccessfulLogin() {
		lblLogOut.isDisplayed();	 
	}	
	
	/* Search Functionality, within the Computers Category */

	public boolean searchAnItemInComputerCategorry(String seachKey) {
		try {		
			btnSearshType.click();
			optComputers.click();
			txtSearchBox.sendKeys(seachKey);
			btnSearch.click();					 
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	/* Search Functionality, within the Computers Category */

	public boolean addItemToListing(String itemName, String startPrice, String fileName) {
		try {		
			lnkSell.click();
			lnkGeneralItem.click();
			inpListingTitle.sendKeys(itemName);
			btnBrowseAllCat.click();	
			optBooks.click();
			btnChildren.click();
			btnFairy.click();
			rdoOnecategory.click();
			btnNext.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			txtItemDetails.click();
			btnNext1.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			inpStartPrice.sendKeys(startPrice);
			btnNext1.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			rdoFreeShipping.click();
			btnNext1.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			fileUploadlocation.click();
			String home = System.getProperty("user.home");
			String downloadPathNew = home + "\\Downloads\\";
//			WebElement chooseFile = driver.findElement(FindBy.id("contained-button-file"));
			btnContained.sendKeys(downloadPathNew + fileName);
			btnNext2.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			btnBasicSelector.click();
			btnPromoSubmit.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			String title = lblListingTitle.getText();
			String price = lblStartPrice.getText();
			if ((title.contentEquals(itemName)) && (price.contains(startPrice))) {
				btnSubmitSell.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				btnSubmitSell.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				lblConfirmation.isDisplayed();
				return true;
			}	
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
