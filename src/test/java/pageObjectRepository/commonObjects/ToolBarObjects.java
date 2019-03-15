package pageObjectRepository.commonObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolBarObjects {
	public static WebDriver driver;
	
	public ToolBarObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//span/i[contains(text(),'menu')]/ancestor::button")
	public WebElement menuButton;
	
	@FindBy(xpath="//mat-toolbar/button/following-sibling::label")
	public WebElement toolBarLabel;
	
	@FindBy(xpath="//mat-toolbar/mat-form-field//mat-select")
	public WebElement orgToolBarSelect;
	
	@FindBy(xpath="//div/div/mat-option/span[contains(text(),'Color')]")
	public WebElement orgToolBarSelectDropDown; // sample item path, customized in script
	
	@FindBy(xpath="//mat-toolbar/button/following-sibling::cdk-user-menu/div/span/label[contains(text(),'Master User')]")
	public WebElement toolBarUserType;
	
	@FindBy(xpath="//mat-toolbar/button/following-sibling::cdk-user-menu/div/button/span/span/span")
	public WebElement toolBarUserName;
	
	@FindBy(xpath="//mat-toolbar/button/following-sibling::cdk-user-menu/div//div/a[contains(text(),'Logout')]")
	public WebElement toolBarLogoutButton;
}
