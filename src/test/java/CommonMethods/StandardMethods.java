package CommonMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import keywords.Keywords;
import pageObjectRepository.adminPanelObjects.AdminAddOrganizationPageObjects;
import pageObjectRepository.adminPanelObjects.AdminOrganizationsPageObjects;
import pageObjectRepository.authObjects.AuthenticationPageObjects;
import pageObjectRepository.commonObjects.ToolBarObjects;

public class StandardMethods {

	public WebDriver driver;
	public static WebDriverWait wait;
	public static FileInputStream file;
	public Map<String,WebElement> objMap;
	
	public  ArrayList<Object> excelReader(String filePath,String sheetName) throws IOException {
    	ArrayList<Object> excelData = new ArrayList<Object>();
    	try {
    		//Get the Excel file instance
    		file = new FileInputStream(filePath);
    		//Get the workbook of that file
    		XSSFWorkbook workBook = new XSSFWorkbook(file);
    		//Get the sheet from that workbook
    		XSSFSheet sheet = workBook.getSheet(sheetName);
    		//Create an iterator above all the rows and cells
    		Iterator itr = sheet.iterator();
    		//check whether there exists a row in the sheet, so that iterator can parse
    		while(itr.hasNext()) {
    			//Until the sheet has rows
    		Row rowitr = (Row)itr.next();//create a row iterator
    		Iterator cellitr = rowitr.cellIterator();//create a cell iterator
    		while(cellitr.hasNext()) {
    			Cell cellData = (Cell)cellitr.next();
    			//fetch the data from the cells
    			switch(cellData.getCellType()) {
    			case STRING :  excelData.add(cellData.getStringCellValue());
    						   break;
    			case NUMERIC : excelData.add(cellData.getNumericCellValue());
    						   break;
    			case BOOLEAN : excelData.add(cellData.getBooleanCellValue());  
    				           break;
    			default:
    				break;	           
    				}
    			}
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}finally {
    	    file.close();
    	}
    	
    	return excelData;
    }
	
	public WebElement mapObject(String stringObjName) {
		objMap = new HashMap<String,WebElement>();
		AuthenticationPageObjects authPageObj = new AuthenticationPageObjects(Keywords.driver);
		
		//Authentication page objects are pushed to HashMap
		
		objMap.put("cardTitle", authPageObj.cardTitle);
		objMap.put("email", authPageObj.email);
		objMap.put("loginButton", authPageObj.loginButton);
		objMap.put("loginWithMobileButton", authPageObj.loginWithMobileButton);
		objMap.put("mobileNumber", authPageObj.mobileNumber);
		objMap.put("passwordForEmail", authPageObj.passwordForEmail);
		objMap.put("passwordForMobile", authPageObj.passwordForMobile);
		
		//masterUserPackageOrganization page objects are pushed to HashMap
		
		AdminOrganizationsPageObjects masterAdminObj = new AdminOrganizationsPageObjects(Keywords.driver);
		objMap.put("sideNavOrganization", masterAdminObj.sideNavOrganization);
		objMap.put("sideNavUsers", masterAdminObj.sideNavUsers);
		objMap.put("sideNavMemebers", masterAdminObj.sideNavMemebers);
		objMap.put("sideNavGroups", masterAdminObj.sideNavGroups);
		objMap.put("toolBarMenuIcon", masterAdminObj.toolBarMenuIcon);
		objMap.put("settingButton", masterAdminObj.settingButton);
		objMap.put("addOrganizationButton", masterAdminObj.addOrganizationButton);
		objMap.put("addFilterButton", masterAdminObj.addFilterButton);
		objMap.put("searchOrganizationEditText", masterAdminObj.searchOrganizationEditText);
		objMap.put("searchByOrganizationSelect", masterAdminObj.searchByOrganizationSelect);
		objMap.put("searchOrganizationsButton", masterAdminObj.searchOrganizationsButton);
		objMap.put("selectAllCheckBox", masterAdminObj.selectAllCheckBox);
		objMap.put("distinctCheckBoxTableData", masterAdminObj.distinctCheckBoxTableData);
		objMap.put("organizationNameTableData", masterAdminObj.organizationNameTableData);
		objMap.put("userCountTableData", masterAdminObj.userCountTableData);
		objMap.put("groupCountTableData", masterAdminObj.groupCountTableData);
		objMap.put("memberCountTableData", masterAdminObj.memberCountTableData);
		objMap.put("statusTableData", masterAdminObj.statusTableData);
		objMap.put("activateButton", masterAdminObj.activateButton);
		objMap.put("deactivateButton", masterAdminObj.deactivateButton);
		objMap.put("loadMoreButton", masterAdminObj.loadMoreButton);
		
		//masterUserPackageOrganization-->AddOrganization page objects
		AdminAddOrganizationPageObjects addOrgObj = new AdminAddOrganizationPageObjects(Keywords.driver);
		objMap.put("orgNameEditText", addOrgObj.orgNameEditText);
		objMap.put("orgTypeSelect", addOrgObj.orgTypeSelect);
		objMap.put("countrySelect", addOrgObj.countrySelect);
		objMap.put("stateSelect", addOrgObj.stateSelect);
		objMap.put("citySelect", addOrgObj.citySelect);
		objMap.put("pincodeEditText", addOrgObj.pincodeEditText);
		objMap.put("aboutOrgEditText", addOrgObj.aboutOrgEditText);
		objMap.put("uploadIconButton", addOrgObj.uploadIconButton);
		objMap.put("uploadCoverPhotoButton", addOrgObj.uploadCoverPhotoButton);
		objMap.put("addressEditText", addOrgObj.addressEditText);
		objMap.put("orgAddButton", addOrgObj.orgAddButton);
		objMap.put("orgCancelButton", addOrgObj.orgCancelButton);
		
		//Common ToolBarObjects
		ToolBarObjects tBObj = new ToolBarObjects(Keywords.driver);
		objMap.put("menuButton", tBObj.menuButton);
		objMap.put("toolBarLabel", tBObj.toolBarLabel);
		objMap.put("orgToolBarSelect", tBObj.orgToolBarSelect);
		objMap.put("toolBarUserType", tBObj.toolBarUserType);
		objMap.put("toolBarUserName", tBObj.toolBarUserName);
		objMap.put("toolBarLogoutButton", tBObj.toolBarLogoutButton);
		
		//return the object name
		return objMap.get(stringObjName);

	}
	
	
}