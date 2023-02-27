package com.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utils.PropertiesUtils;

public class BaseClass {

	public static WebDriver driver=null;
	public static ExtentReports report=null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	public static Logger log=Logger.getLogger(BaseClass.class);
	
public void initialization() throws Exception {
	System.out.println("initializing browser");//console
	log.info("initializing browser"); //console n file
	String browsername=PropertiesUtils.readProperty("browser");
	
	if(browsername.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	driver.manage().window().maximize();
	driver.get(PropertiesUtils.readProperty("url"));
	
  }
	public void reportInit() {
		
		report=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report.attachReporter(spark);
	}



}