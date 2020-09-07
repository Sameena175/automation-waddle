package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	Properties prop;
	
	public ReadConfigFile() {
	
	//String propName = "./ConfigProperty.properties";
	File src = new File("./Configuration/ConfigProperty.properties");
	try {
		FileInputStream fis = new FileInputStream(src);
		 prop=new Properties();
		prop.load(fis);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public String getChromeDriverPath() {
		return prop.getProperty("chromeDriverPath");
	}
	public String getAppURL() {
		return prop.getProperty("applicationURL");
	}
	public String getBrowserName() {
		return prop.getProperty("BrowserName");
	}
	
	public String getgeckoDriverPath() {
		return prop.getProperty("geckoDriverPath");
	}
	
	
	
}
