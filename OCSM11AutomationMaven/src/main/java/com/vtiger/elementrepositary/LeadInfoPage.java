package com.vtiger.elementrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {

	@FindBy(className = "dvHeaderText")
	public WebElement leadSuccessMsg;
	
	public LeadInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLeadSuccessMsg() {
		return leadSuccessMsg;
	}
}
