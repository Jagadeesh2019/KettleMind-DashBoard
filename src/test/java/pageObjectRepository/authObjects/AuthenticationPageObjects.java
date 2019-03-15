package pageObjectRepository.authObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.StandardMethods;
import keywords.Keywords;

public class AuthenticationPageObjects{
	public WebDriver driver;
	public ArrayList<String> objects ;
	
	public AuthenticationPageObjects() {
		
	}
	
	public AuthenticationPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	
	@FindBy(xpath="//mat-card-title[contains(text(),'User login')]")
	public  WebElement cardTitle;
	
	@FindBy(xpath="//*[@id='email']")
	public  WebElement email;
	
	@FindBy(xpath="//*[@id='password']")
	public  WebElement passwordForEmail;
	
	@FindBy(xpath="//span[contains(text(),'LogIn')]//parent::button")
	public  WebElement loginButton;
	
	@FindBy(xpath="//span[contains(text(),'Login with Mobile')]//parent::button")
	public  WebElement loginWithMobileButton;
	
	@FindBy(xpath="//input[@id='phone']")
	public  WebElement mobileNumber;
	
	@FindBy(xpath="//input[@id='password1']")
	public  WebElement passwordForMobile;
	
 
}

