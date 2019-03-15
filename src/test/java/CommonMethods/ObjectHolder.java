package CommonMethods;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;


public class ObjectHolder {
	
	public Map<String,WebElement> objMap;
	public WebElement mapObject(String stringObjName) {
		objMap = new HashMap<String,WebElement>();
		
		//return the object name
		return objMap.get(stringObjName);

	}
}
