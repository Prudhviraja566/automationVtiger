package com.vtiger.genericlibrary;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverCommonUtils {

	String mainId;
	
	// Alert Handling
	public void alertAccept() {
		BaseClass.extraDriver.switchTo().alert().accept();
	}
	
	public void alertReject() {
		BaseClass.extraDriver.switchTo().alert().dismiss();
	}
	
	public String getAlertMessage() {
		return BaseClass.extraDriver.switchTo().alert().getText();
	}
	
	// ListBox Handling
	public void chooseOptionByText(WebElement list , String itemName) {
		
		Select s = new Select(list);
		s.selectByVisibleText(itemName);
	}
	
	public void chooseOptionByValue(WebElement list , String value) {
		Select s = new Select(list);
		s.selectByValue(value);
	}
	
	public List<WebElement> getAllOptionInList(WebElement list){
		
		Select s = new Select(list);
		return s.getOptions();
	}
	
	// window handling
	public void chooseFirstWindow() {
		
		mainId = BaseClass.extraDriver.getWindowHandle();
		Set<String> allId = BaseClass.extraDriver.getWindowHandles();
		
		for(String id : allId) {
			if(!mainId.equals(id)) {
				BaseClass.extraDriver.switchTo().window(id);
				break;
			}
		}
	}
	
	public void chooseParentWindow() {
		if(mainId == null) {
			System.out.println("Focus is already on parent window");
		}else {
			BaseClass.extraDriver.switchTo().window(mainId);	
		}
	}
	
	public void chooseWindowByTitle(String expTitle) {
		mainId = BaseClass.extraDriver.getWindowHandle();
		Set<String> allId = BaseClass.extraDriver.getWindowHandles();
		
		for(String id : allId) {
			BaseClass.extraDriver.switchTo().window(id);
			
			if(BaseClass.extraDriver.getTitle().equals(expTitle)) {
				break;
			}
		}
	}
	
	// mouse handling
	public void moveMousePointer(WebElement element) {
		Actions act = new Actions(BaseClass.extraDriver);
		act.moveToElement(element).perform();
	}
}



















