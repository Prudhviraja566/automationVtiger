package com.vtiger.testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.elementrepositary.CreateNewLeadPage;
import com.vtiger.elementrepositary.HomePage;
import com.vtiger.elementrepositary.LeadInfoPage;
import com.vtiger.elementrepositary.LeadsPage;
import com.vtiger.genericlibrary.BaseClass;

@Listeners(com.vtiger.genericlibrary.ExecutionMoniter.class)
public class CreateNewLeadTest extends BaseClass{

	@Test
	public void createNewLead() throws IOException, InterruptedException {
		
		HomePage hp = new HomePage(driver);
		LeadsPage lp = new LeadsPage(driver);
		CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
		LeadInfoPage lip = new LeadInfoPage(driver);
		
		hp.getLeadsLink().click();
		lp.getCreateLeadImage().click();
		
		cnlp.getLeadNameTb().sendKeys(du.getDataFromExcel("Leads", 1, 2));
		cnlp.getCompanyNameTb().sendKeys(du.getDataFromExcel("Leads", 1, 3));
		cnlp.getLeadSaveBtn().click();
		
		String actualSuccessMsg = lip.getLeadSuccessMsg().getText();
		
		Assert.assertTrue(actualSuccessMsg.contains(du.getDataFromExcel("Leads", 1, 4)) , "Lead creation fails");
		Reporter.log("Lead created successfully",true);
		
	}

}
