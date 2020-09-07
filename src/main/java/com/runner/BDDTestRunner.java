package com.runner;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.cucumber.listener.Reporter;
import com.utils.Coreutils;

import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)				
@CucumberOptions(
					features="Features",
					plugin = {
							"pretty" , 
							"html:target/cucumber/cucumber-html-report" , 
							"com.cucumber.listerner.ExtentCucumberFormatter:target/cucumber-reports/report.html"
							
					},
					glue={"StepDefinition"},
					tags = {}
			    )	

public class BDDTestRunner {
	
	@BeforeClass
	public static void setup() {		
		Coreutils util = new Coreutils();
		try {
			util.preSetup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/main/resources/extent-config.xml"));
		Reporter.setSystemInfo("User Name", "Sameena");
		Reporter.setSystemInfo("Application Name", "Flight Booking Test Application");
		//Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}

}
