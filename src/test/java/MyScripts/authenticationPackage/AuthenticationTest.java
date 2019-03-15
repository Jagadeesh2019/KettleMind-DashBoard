package MyScripts.authenticationPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonMethods.StandardMethods;
import keywords.Keywords;
import pageObjectRepository.authObjects.AuthenticationPageObjects;

public class AuthenticationTest {
	
	public static ArrayList<Object> excelData;
	public static Keywords key;
	public static FileInputStream file;
	public WebDriver mDriver;
	public static String userType;
	public static String userName = "Ashok Reddy";
	
	@SuppressWarnings("unused")
	
	@Test
	public void loginWithEmailTest() throws IOException, InterruptedException {
		//a = new ArrayList<Object>();
		key = new Keywords();
		excelData = new StandardMethods().excelReader("F:\\KettleMindWebExcels\\AuthenticationSuite.xlsx","LoginWithEmail");
		
		//Step1 : open browser
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("openBrowser")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					mDriver = key.openBrowser(data);
				}
			}	
		}
		
		//Step2 : maximize the browser
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("maximizeBrowser")) {
				String keyword = (String)excelData.get(i);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
						key.maximizeBrowser();
					}
				}
		}	
		
		//Step3 : navigate To the url
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("navigateTo")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					key.natigateTo(data);
				}
			}
		}
		
		//Step4 : verifyCardTitle
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("verifyText")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes") && objectName.equals("cardTitle")) {
					key.verifyText(data, objectName);
				}
			}
		}
		
		//Step5 : enter email and store UserType
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("input") && excelData.get(i+2).equals("email")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				userType = (String)excelData.get(i+4);
				if(runMode.equalsIgnoreCase("yes")) {
					key.input(data, objectName);
				}
			}
		}
		
		//Step6 : enter password
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("input")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes") && objectName.equals("passwordForEmail")) {
					key.input(data, objectName);
				}
			}
		}
		
		
		//Step7 : click on Login button	
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("click")) {
				String keyword = (String)excelData.get(i);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					key.click(objectName);
				}
			}
		}
		
		//Step8 : verify and accept alert	
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("acceptAlert")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					key.acceptAlert(data);
				}
			}
		}
		
		//Step9 : verify URL
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("verifyURL")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					key.verifyURL(data);
				}
			}
		}
		
		
		//Step10: verify UserName text
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("verifyText")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes") && objectName.equals("toolBarUserName")) {
					key.verifyText(userName, objectName);
					System.out.println("User Name Verified");
				}
			}
		}
		
		//Step11: verify UserType text
				for(int i=0;i<excelData.size();i++) {
					if(excelData.get(i).equals("verifyText")) {
						String keyword = (String)excelData.get(i);
						String data = (String)excelData.get(i+1);
						String objectName = (String)excelData.get(i+2);
						String runMode = (String)excelData.get(i+3);
						if(runMode.equalsIgnoreCase("yes") && objectName.equals("toolBarUserType")) {
							key.verifyText(userType, objectName);
							System.out.println("User Type Verified");
						}
					}
				}
				
				//Step12: verify Page Label text
				for(int i=0;i<excelData.size();i++) {
					if(excelData.get(i).equals("verifyText")) {
						String keyword = (String)excelData.get(i);
						String data = (String)excelData.get(i+1);
						String objectName = (String)excelData.get(i+2);
						String runMode = (String)excelData.get(i+3);
						if(runMode.equalsIgnoreCase("yes") && objectName.equals("toolBarLabel")) {
							key.verifyText(data, objectName);
							System.out.println("Page Title Verified");
						}
					}
				}		
		
		//Step13: Logout
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("logout")){
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					//Log out Logic will come here
				}
			}
		}
	}//End of loginWithEmailtest
	
	
	@Test(enabled=false)
	public void loginWithMobileTest() {
		key = new Keywords();
		
		try {
			excelData = new StandardMethods().excelReader("F:\\KettleMindWebExcels\\AuthenticationSuite.xlsx", "LoginWithMobile");
		} catch (IOException e) {
			System.out.println(e);
		}
		
		//read the keywords and perform step by step automation
		
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("openBrowser")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					mDriver = key.openBrowser(data);
				}
			}	
		}
		
		//maximize the window
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("maximizeBrowser")) {
				String keyword = (String)excelData.get(i);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					 key.maximizeBrowser();
				}
			}
		}
		
		//navigate to the url
		for(int i=0;i<excelData.size();i++) {
			if(excelData.get(i).equals("navigateTo")) {
				String keyword = (String)excelData.get(i);
				String data = (String)excelData.get(i+1);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					key.natigateTo(data);
				}
			}
		}
		
		//Click on Login with Mobile button
		for(int i=0;i<excelData.size()-1;i++) {
			if(excelData.get(i).equals("click")) {
				String keyword = (String)excelData.get(i);
				String objectName = (String)excelData.get(i+2);
				String runMode = (String)excelData.get(i+3);
				if(runMode.equalsIgnoreCase("yes")) {
					key.click(objectName);
				}
			}
		}
		
		//Step5&6 : enter mobile and password
				for(int i=0;i<excelData.size();i++) {
					if(excelData.get(i).equals("input")) {
						String keyword = (String)excelData.get(i);
						String data = (String)excelData.get(i+1);
						String objectName = (String)excelData.get(i+2);
						String runMode = (String)excelData.get(i+3);		
						if(runMode.equalsIgnoreCase("yes")) {
							key.input(data, objectName);
						}
					}
				}
				
				//Click on Login button
				for(int i=0;i<excelData.size()-1;i++) {
					if(excelData.get(i).equals("click")) {
						String keyword = (String)excelData.get(i);
						String objectName = (String)excelData.get(i+2);
						String runMode = (String)excelData.get(i+3);
						if(runMode.equalsIgnoreCase("yes")) {
							key.click(objectName);
						}
					}
				}
	}
	
}//End of class
