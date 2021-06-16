package com.vtiger.elementrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "More")
	private WebElement moreDD;
	
	@FindBy(name = "Campaigns")
	private WebElement campaginsLink;
	
	@FindBy(xpath = "//span[@class='userName']/../following-sibling::td[1]/img")
	private WebElement signOutDD;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMoreDD() {
		return moreDD;
	}
	
	public WebElement getCampaginsLink() {
		return campaginsLink;
	}
	
	public WebElement getSignOutDD() {
		return signOutDD;
	}
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public WebElement getLeadsLink() {
		return leadsLink;
	}
}





















