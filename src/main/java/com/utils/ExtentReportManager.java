package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	
	//ExtentReports extent;
	ExtentTest logTest;
	
	ExtentHtmlReporter reporter = new ExtentHtmlReporter("./ExtentReport/AutomationExecutionReport.html");
	ExtentReports extent = new ExtentReports();
	
	
	/*extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name", "SoftwareTestingMaterial");
	extent.addSystemInfo("Environment", "Automation Testing");
	extent.addSystemInfo("User Name", "Rajkumar SM");*/

}
