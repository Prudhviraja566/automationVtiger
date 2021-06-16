package com.vtiger.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseClass;

@Listeners(com.vtiger.genericlibrary.ExecutionMoniter.class)
public class CreateNewCampaginTest extends BaseClass{

	@Test
	public void createNewCampagin() throws IOException, InterruptedException {
		
		WebElement moreDD = driver.findElement(By.linkText("More"));
		common.moveMousePointer(moreDD);
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.cssSelector("img[title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(du.getDataFromExcel("Campagin", 1, 2));
		driver.findElement(By.cssSelector("input.save")).click();
		
		String actualSuccessMsg = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(actualSuccessMsg.contains(du.getDataFromExcel("Campagin", 1, 3))) {
			System.out.println("campagin created successfully...");
		}else {
			System.out.println("campagin creation failed...");
		}
	}
	
	
}
