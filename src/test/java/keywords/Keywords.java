package keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CommonMethods.StandardMethods;
import pageObjectRepository.authObjects.AuthenticationPageObjects;

public class Keywords {
	public static WebDriver driver;
	public static JavascriptExecutor js;

	public WebDriver openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	public void implicityWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void natigateTo(String url) {
		driver.navigate().to(url);
		new AuthenticationPageObjects(driver);
		
	}
	
	
	public void verifyText(String data,String stringObjectName) {
		String ExpectedResult = data;
		WebElement element = new StandardMethods().mapObject(stringObjectName);
		implicityWait();
		makeElementVisible(element);
		String ActualResult = element.getText().toString();
		Assert.assertEquals(ActualResult, ExpectedResult);
	}
	
	public void verifyURL(String data) throws InterruptedException {
		Thread.sleep(4000);
		String ExpectedResult = data;
		String ActualResult = driver.getCurrentUrl();
		Assert.assertEquals(ActualResult, ExpectedResult);
	}
	
	
	public void input(String data,String stringObjectName) {
		WebElement element = new StandardMethods().mapObject(stringObjectName);
		implicityWait();
		makeElementVisible(element);
		element.sendKeys(data);
	}
	
	
	public void click(String stringObjectName) {
	WebElement element = new StandardMethods().mapObject(stringObjectName);
	implicityWait();
	makeElementVisible(element);
	sleep();
	element.click();
	}
	
	public void invisibilityScroll(String stringObjectName) {
		WebElement element = new StandardMethods().mapObject(stringObjectName);
		new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(element));
		
		if(!Keywords.driver.findElement(By.xpath("//b[contains(text(),'Load More')]/parent::span/parent::button")).isDisplayed()) {
			 js = (JavascriptExecutor) Keywords.driver;
			js.executeScript("arguments[0].scrollIntoView();", Keywords.driver.findElement(By.xpath("//b[contains(text(),'Load More')]/parent::span/parent::button")));
		}else {
			
			Keywords.driver.findElement(By.xpath("//b[contains(text(),'Load More')]/parent::span/parent::button")).click();
		}
	}
	
	
	public void select(String data,String stringObjectName) {
		WebElement element = new StandardMethods().mapObject(stringObjectName);
		implicityWait();
		click(stringObjectName);
		
		WebElement selectEle = driver.findElement(By.xpath("//span[contains(text(),'"+data+"')]/parent::mat-option[@ng-reflect-value='"+data+"']"));
		if(selectEle.isDisplayed()) {
			selectEle.click();
		}else {
			makeElementVisible(driver.findElement(By.xpath("//span[contains(text(),'"+data+"')]/parent::mat-option[@ng-reflect-value='"+data+"']/parent::div/parent::div")));
			selectEle.click();
		}
		
	}
	
	
	public void uploadImage(String data,String stringObjectName) throws AWTException, InterruptedException {
		WebElement element = new StandardMethods().mapObject(stringObjectName);
		implicityWait();
		element.click();
		//Control+c
		StringSelection selection = new StringSelection(data);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		//Control+v
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		//Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public void validateStatusByColor(String data,String orgName) {
		
		try {
		driver.findElement(By.xpath("//tbody//td[contains(text(),'"+orgName+"')]/parent::tr/td[2]")).isDisplayed();
		driver.findElement(By.xpath("//tbody//td[contains(text(),'"+orgName+"')]/parent::tr/td[1]")).click();
		String expected = data;
		String	actual = driver.findElement(By.xpath("//tbody//td[contains(text(),'"+orgName+"')]/parent::tr/td/[6]")).getAttribute("src");//status by color
		Assert.assertEquals(actual, expected);
		new Keywords().click("activateButton");
		new Keywords().acceptAlert("Status Updated successfully");
		}catch(Exception e) {
			System.out.println("Element not displayed");
			makeElementVisible(new StandardMethods().mapObject("loadMoreButton"));
			new StandardMethods().mapObject("loadMoreButton").click();

		}
		
	}
	
	
	
	public void makeElementVisible(WebElement element) {
		if(!element.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			return;
		}else {
			
			return;
		}
	}
	
	
	
	public void verifyAndCheckTableRow(String orgName, String stringLoadMore) {
		WebElement elementLoadMore = new StandardMethods().mapObject(stringLoadMore);
		//Here verification is done by organization name
	//WebElement orgNameSlot = //organization name
		for(int i=0;i<20;i++) {
			
			try {
				driver.findElement(By.xpath("//tbody//td[contains(text(),'"+orgName+"')]/parent::tr/td[2]")).isDisplayed();
				WebElement checkBox = driver.findElement(By.xpath("//tbody//td[contains(text(),'"+orgName+"')]/parent::tr/td/mat-checkbox/label/div"));
				new Keywords().checkTheBox(checkBox);
				Thread.sleep(3000);
				new Keywords().uncheckTheBox(checkBox);
				break;
			}catch(Exception e) {
				System.out.println("Element not displayed");
				makeElementVisible(elementLoadMore);
				elementLoadMore.click();
			}
		}
	}
	
	public void readTableByOrgName(String orgName,String stringLoadMore) throws InterruptedException {
		boolean ElementFound = false;
		WebElement elementLoadMore = new StandardMethods().mapObject(stringLoadMore);
		List<WebElement> tableBodyEntries = driver.findElements(By.xpath("//div/table/tbody/tr"));
		int tableSize = tableBodyEntries.size();
		//System.out.println(tableBodyEntries.size());
			while(ElementFound=false) {
			try {
				for(int i=0;i<tableSize;i++) {
			driver.findElement(By.xpath("//div/table/tbody/tr["+i+"]/td[2]")).getText().equalsIgnoreCase(orgName);
			ElementFound=true;	
			//If this is available, check the checkbox
				WebElement checkBox = driver.findElement(By.xpath("//div/table/tbody/tr["+i+"]/td[2][contains(text(),'"+orgName+"')]/parent::tr/td/mat-checkbox/label/div"));
				new Keywords().checkTheBox(checkBox);
				Thread.sleep(3000);
				new Keywords().uncheckTheBox(checkBox);
				break;
			}
			}catch(Exception e){
				makeElementVisible(elementLoadMore);
				elementLoadMore.click();
				
		}
	}
}
	
	public void scrollByPixel() {
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		System.out.println("Scrolled successfully");
	}
	
	public void scrollIntoElement() {
		
	}
	
	public void scrollToEnd() {
		
	}
	
	public void checkTheBox(WebElement element) {
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckTheBox(WebElement element) {
		if(element.isEnabled()) {
			element.click();
		}
	}
			

	
	public void logout(String data, String Objectname) {
		
	}
	
	public void acceptAlert(String alertText) throws NoAlertPresentException{
		String ExpectedResult = alertText;
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		if(ExpectedConditions.alertIsPresent()!=null) {
			String ActualResult = driver.switchTo().alert().getText().toString().trim();
			Assert.assertEquals(ActualResult, ExpectedResult);
			driver.switchTo().alert().accept();
			
		}else {
			System.out.println("No alert found on the given wait parameters");
			
		}
	}
	
	public void quit() {
		driver.quit();
	}
	
}
