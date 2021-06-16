package com.vtiger.genericlibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExecutionMoniter extends BaseClass implements ITestListener{

	public void onTestFailure(ITestResult result) {
		
		System.out.println("screenshot captured...");
		
		String testName = result.getName();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		String timeStamp = sdf.format(new Date()).replace("/", "_").replace(" ", "_").replace(":", "_");
		
		EventFiringWebDriver efwd = new EventFiringWebDriver(extraDriver);
		File source = efwd.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./screenshot/"+testName+timeStamp+".png"));
		} catch (IOException e) {

		}
	}
}
