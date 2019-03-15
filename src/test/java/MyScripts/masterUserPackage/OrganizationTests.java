package MyScripts.masterUserPackage;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import CommonMethods.StandardMethods;
import keywords.Keywords;

public class OrganizationTests {

	public Keywords key;
	public static ArrayList<Object> excelData;
	public String filePath = "F:\\KettleMindWebExcels\\MasterUserOrgTestSuite.xlsx";
	public String sheetName = "AddOrganization";
	public static WebDriver driver;
	public static String orgName;
	
	@Test
	public void addOrganizationTest() throws IOException, InterruptedException {
		key = new Keywords();
		excelData = new StandardMethods().excelReader(filePath, sheetName);
		
		//Test-case execution starts
		
		//OPEN BROWSER
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("openBrowser")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					key.openBrowser(data);
					System.out.println("Browser opened successfully");
				}
			}
		}
		
		//MAXIMIZE THE BROWSER
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("maximizeBrowser")) {
				String keyword = (String)excelData.get(i);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
						key.maximizeBrowser();
						System.out.println("Browser Maximized successfully");
				}
			}
		}
		
		//NAVIGATE TO URL
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("navigateTo")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					key.natigateTo(data);
					System.out.println("Navigated toURL successfully");
				}
			}
		}
		
		//CLICK ON ADD ORGANIZATION BUTTON
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("click")) {
				String keyword = (String)excelData.get(i);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes") && objectName.equalsIgnoreCase("addOrganizationButton")) {
					key.click(objectName);
					System.out.println("Clicked on ADD ORG BUTTON successfully");
				}
			}
		}
		
		//ENTER THE ORGANIZATION NAME
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("input")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes") && objectName.equalsIgnoreCase("orgNameEditText")) {
					key.input(data, objectName);
					System.out.println("OrgName entered successfully");
				}
			}
		}
		
		//SELECT COUNTRY,STATE,CITY (As they all are in sequence)
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("select")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					key.select(data, objectName);
					System.out.println("County,State,City selected successfully");
				}
			}
		}
		
		//ENTER PINCODE
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("input")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes") && objectName.equalsIgnoreCase("pincodeEditText")) {
					key.input(data, objectName);
					System.out.println("Pincode entered successfully");
				}
			}
		}
		
		//ENTER ABOUT ORGANIZATION
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("input")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes") && objectName.equalsIgnoreCase("aboutOrgEditText")) {
					key.input(data, objectName);
					System.out.println("AboutOrg entered successfully");
				}
			}
		}
		//UPLOAD COVER PHOTO
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("uploadImage")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					key.input(data, objectName);
					System.out.println("Cover Photo, OrgIcon Uploaded successfully");
				}
			}
		}
		
		
		//ENTER ADDRESS
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("input")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes") && objectName.equalsIgnoreCase("addressEditText")) {
					key.input(data, objectName);
					System.out.println("Address entered successfully");
				}
			}
		}
		
		//CLICK ON ADD ORGANIZATION BUTTON (to add the organization to dashboard)
				for(int i=0;i<excelData.size();i++) {
					if(excelData.get(i).equals("click")) {
						String keyword = (String)excelData.get(i);
						String objectName = (String)excelData.get(i+2);
						String runMode = (String)excelData.get(i+3);
						if(runMode.equalsIgnoreCase("yes") && objectName.equalsIgnoreCase("orgAddButton")) {
							key.click(objectName);
							System.out.println("clicked on add org button successfully");
						}
					}
				}
		//CLICK ON CANCEL button
				for(int i=0;i<excelData.size();i++) {
					if(excelData.get(i).equals("click")) {
						String keyword = (String)excelData.get(i);
						String objectName = (String)excelData.get(i+2);
						String runMode = (String)excelData.get(i+3);
						if(runMode.equalsIgnoreCase("yes") && objectName.equalsIgnoreCase("orgCancelButton")) {
							key.click(objectName);
							System.out.println("Clicked on cancel button successfully");
						}
					}
				}
		
		//ACCEPT ALERT
				for(int i=0;i<excelData.size();i++) {
					if(excelData.get(i).equals("acceptAlert")) {
						String keyword = (String)excelData.get(i);
						String data = (String)excelData.get(i+1);
						String runMode = (String)excelData.get(i+3);
						if(runMode.equalsIgnoreCase("yes")) {
							try {
							key.acceptAlert(data);
							System.out.println("Alert Accepted successfully");
							}catch(Exception e) {
								System.out.println(e);
							}
						}
					}
				}
		
		//Verification of that added organization starts here
				
				//VERIFY URL
				for(int i=0;i<excelData.size();i++) {
					if(excelData.get(i).equals("verifyURL")) {
						String keyword = (String)excelData.get(i);
						String data = (String)excelData.get(i+1);
						String runMode = (String)excelData.get(i+3);
						if(runMode.equalsIgnoreCase("yes")) {
							key.verifyURL(data);
							System.out.println("URL Verified successfully");
						}
					}
				}
				//FIND OUT THE ORGANIZATION NAME FROM TABLE ROWS-->TABLE DATA
				for(int i=0;i<excelData.size();i++) {
					if(excelData.get(i).equals("verifyAndCheckTableRow")) {
						String keyword = (String)excelData.get(i);
						String data = (String)excelData.get(i+1);
						String loadMoreButtonObject = (String)excelData.get(i+2);
						String runMode = (String)excelData.get(i+3);
						if(runMode.equalsIgnoreCase("yes")) {
						key.verifyAndCheckTableRow(data, loadMoreButtonObject);
						System.out.println("Entered "+data+" found successfully");
						}
					}
				}
				
				
		
	}//End of addOrganizationTest
	
	@Test(enabled=false)
	public void searchOrganization() {
		
	}
	
	@Test(enabled=false)
	public void filterOrganization() {
		
	}
	
	
	
	
}
