package com.vtiger.elementrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {

	@FindBy(name = "lastname")
	private WebElement leadNameTb;
	
	@FindBy(name = "company")
	private WebElement companyNameTb;
	
	@FindBy(css = "input.save")
	private WebElement leadSaveBtn;
	
	public CreateNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLeadNameTb() {
		return leadNameTb;
	}
	
	public WebElement getCompanyNameTb() {
		return companyNameTb;
	}
	
	public WebElement getLeadSaveBtn() {
		return leadSaveBtn;
	}
}







