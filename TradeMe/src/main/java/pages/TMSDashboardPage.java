package pages;
import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;

public class TMSDashboardPage extends BaseClass {

	WebDriver driver;
	public TMSDashboardPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//a[@id='LoginLink']")
	WebElement btnLoginLink;

	@FindBy(xpath = "//a[@id='SiteHeader_SiteTabs_browseDropDownLink']")
	WebElement lnkBrowse;

	@FindBy(xpath = "//a[.='Computers']")
	WebElement lnkComputers;

	@FindBy(xpath = "//a[@id='SiteHeader_SiteTabs_sellLink']")
	WebElement lnkSell;

	@FindBy(xpath = "//a[.='General item']")
	WebElement lnkGeneralItem;

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

	//		@FindBy(xpath = "//input[@id='submit1']")
	//		WebElement btnNext1;

	@FindBy(xpath = "//input[@id='startPriceInput']")
	WebElement inpStartPrice;

	//		@FindBy(xpath = "//input[@id='submit1']")
	//		WebElement btnNext1;

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
			//				WebElement chooseFile = driver.findElement(FindBy.id("contained-button-file"));
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
