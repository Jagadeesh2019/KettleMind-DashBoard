package pageObjectRepository.adminPanelObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.StandardMethods;
import keywords.Keywords;

public class AdminAddOrganizationPageObjects {

	public WebDriver driver;
	
	
	public AdminAddOrganizationPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public AdminAddOrganizationPageObjects() {
		
	}

	@FindBy(xpath="//mat-label[contains(text(),'Organization name')]/ancestor::span/preceding-sibling::input")
	public static WebElement orgNameEditText;
	
	@FindBy(xpath="//mat-label[contains(text(),'Select Org Type')]/ancestor::span/parent::div/*")
	public static WebElement orgTypeSelect;
	
	@FindBy(xpath="//mat-label[contains(text(),'Select Country')]/ancestor::span/preceding-sibling::mat-select")
	public WebElement countrySelect;
	
	@FindBy(xpath="//mat-label[contains(text(),'Select State')]/ancestor::span/preceding-sibling::mat-select")
	public WebElement stateSelect;
	
	@FindBy(xpath="//mat-label[contains(text(),'Select City')]/ancestor::span/preceding-sibling::mat-select")
	public WebElement citySelect;
	
	@FindBy(xpath="//mat-label[contains(text(),'Pin code')]/ancestor::span/preceding-sibling::input")
	public WebElement pincodeEditText;
	
	@FindBy(xpath="//mat-label[contains(text(),'About Organisation')]/ancestor::span/preceding-sibling::textarea")
	public WebElement aboutOrgEditText;
	
	@FindBy(xpath="//label[contains(text(),'Browse Icon')]/following-sibling::input")
	public WebElement uploadIconButton;
	
	@FindBy(xpath="//label[contains(text(),'Browse Cover Pic')]/following-sibling::input")
	public WebElement uploadCoverPhotoButton;
	
	@FindBy(xpath="//mat-label[contains(text(),'Address')]/ancestor::span/preceding-sibling::textarea")
	public WebElement addressEditText;
	
	@FindBy(xpath="//span[contains(text(),'ADD ORGANIZATION')]/parent::button[@class='button1 mat-raised-button']")
	public WebElement orgAddButton;
	
	@FindBy(xpath="//span[contains(text(),'CANCEL')]/parent::button[@class='button1 mat-raised-button']")
	public WebElement orgCancelButton;
	
}
