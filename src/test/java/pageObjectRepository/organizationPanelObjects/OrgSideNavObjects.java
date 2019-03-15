package pageObjectRepository.organizationPanelObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgSideNavObjects {
	public static WebDriver driver;
	
	public OrgSideNavObjects() {
		
	}
	
	public OrgSideNavObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//mat-sidenav/mat-toolbar/img")
	public WebElement orgIconButton;
	
	@FindBy(xpath="//mat-sidenav/mat-toolbar/h1")
	public WebElement orgNameTextButton;
	
	@FindBy(xpath="//mat-sidenav/mat-toolbar/following-sibling::cdk-sidemenu/perfect-scrollbar/div/div/div/cdk-sidemenu-item[1]")
	public WebElement orgSideNavDashboard;
	
	@FindBy(xpath="//mat-sidenav/mat-toolbar/following-sibling::cdk-sidemenu/perfect-scrollbar/div/div/div/cdk-sidemenu-item[2]")
	public WebElement orgSideNavUsers;
	
	@FindBy(xpath="//mat-sidenav/mat-toolbar/following-sibling::cdk-sidemenu/perfect-scrollbar/div/div/div/cdk-sidemenu-item[3]")
	public WebElement orgSideNavGroups;
	
	@FindBy(xpath="//mat-sidenav/mat-toolbar/following-sibling::cdk-sidemenu/perfect-scrollbar/div/div/div/cdk-sidemenu-item[4]")
	public WebElement orgSideNavPerformance;
	
	@FindBy(xpath="//mat-sidenav/mat-toolbar/following-sibling::cdk-sidemenu/perfect-scrollbar/div/div/div/cdk-sidemenu-item[5]")
	public WebElement orgSideNavMembers;
	
	@FindBy(xpath="//mat-sidenav/mat-toolbar/following-sibling::cdk-sidemenu/perfect-scrollbar/div/div/div/cdk-sidemenu-item[6]")
	public WebElement orgSideNavSettings;
	
	@FindBy(xpath="//span[contains(text(),'Admin Dashboard')]/parent::button")
	public WebElement orgSideNavAdminDashboardButton;
}
