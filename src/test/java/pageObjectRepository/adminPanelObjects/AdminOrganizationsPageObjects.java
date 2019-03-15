package pageObjectRepository.adminPanelObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminOrganizationsPageObjects{

	private WebDriver driver;
	//private String url;
	
	public AdminOrganizationsPageObjects(WebDriver driver) {
		this.driver=driver;
		//this.url=Url;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Organizations')]/ancestor::mat-list-item")
	public WebElement sideNavOrganization;
	
	@FindBy(xpath="//h3[contains(text(),'Users')]/ancestor::mat-list-item")
	public WebElement sideNavUsers;
	
	@FindBy(xpath="//h3[contains(text(),'Groups')]/ancestor::mat-list-item")
	public WebElement sideNavGroups;
	
	@FindBy(xpath="//h3[contains(text(),'Members')]/ancestor::mat-list-item")
	public WebElement sideNavMemebers;
	
	@FindBy(xpath="//i[contains(text(),'menu')]/ancestor::button")
	public WebElement toolBarMenuIcon;
	
	@FindBy(xpath="//label[contains(text(),'Master User')]/parent::span/preceding-sibling::button")
	public WebElement settingButton;
	
	@FindBy(xpath="//span[contains(text(),'ADD ORGANIZATION')]/parent::button")
	public WebElement addOrganizationButton;
	
	@FindBy(xpath="//label[contains(text(),'ADD FILTER')]/ancestor::div[1]")
	public WebElement addFilterButton;
	
	@FindBy(xpath="//mat-label[contains(text(),'Search')]/ancestor::span/preceding-sibling::input[@id='mat-input-0']")
	public WebElement searchOrganizationEditText;
	
	@FindBy(xpath="//mat-label[contains(text(),'By Organization')]/ancestor::div[1]/mat-select[@id='Select']")
	public WebElement searchByOrganizationSelect;
	
	@FindBy(xpath="//span[contains(text(),'SEARCH ORGANIZATIONS')]/parent::button")
	public WebElement searchOrganizationsButton;
	
	@FindBy(xpath="//input[@id='mat-checkbox-1-input']/ancestor::mat-checkbox[1]")
	public WebElement selectAllCheckBox;
	
	@FindBy(xpath="//tbody//td[contains(text(),'Color')]/parent::tr/td/mat-checkbox/label/div")
	public WebElement distinctCheckBoxTableData; //here the check box is selected based on the Organization name 
	
	@FindBy(xpath="//tbody//td[contains(text(),'Color')]/parent::tr/td[2]")
	public WebElement organizationNameTableData;
	
	@FindBy(xpath="//tbody//td[contains(text(),'Color')]/parent::tr/td[3]")
	public WebElement userCountTableData;
	
	@FindBy(xpath="//tbody//td[contains(text(),'Color')]/parent::tr/td[4]")
	public WebElement groupCountTableData;
	
	@FindBy(xpath="//tbody//td[contains(text(),'Color')]/parent::tr/td[5]")
	public WebElement memberCountTableData;
	
	@FindBy(xpath="//tbody//td[contains(text(),'Color')]/parent::tr/td[6]")
	public WebElement statusTableData;
	
	@FindBy(xpath="//span[contains(text(),'ACTIVATE')]/parent::button")
	public WebElement activateButton;
	
	@FindBy(xpath="//span[contains(text(),'DEACTIVATE')]/parent::button")
	public WebElement deactivateButton;
	
	@FindBy(xpath="//b[contains(text(),'Load More')]/parent::span/parent::button")
	public WebElement loadMoreButton;

	
	
	
}
