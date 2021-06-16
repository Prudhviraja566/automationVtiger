package com.vtiger.elementrepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "user_name")
	private WebElement usernameTB;
	
	@FindBy(name = "user_password")
	private WebElement passwordTB;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[contains(text(),'You must specify a valid username')]")
	private WebElement errorMsg;

	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUsernameTB() {
		return usernameTB;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}
}
