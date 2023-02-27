package com.test;

import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
//import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;

import com.base.BaseClass;
import com.listeners.MyListener;
import com.pages.LoginPage;
 @Listeners(MyListener.class)
public class LoginTest extends BaseClass {

	LoginPage lp=null;
	@BeforeSuite
	public void setUp() throws Exception {
		
		initialization();
		reportInit();
		lp=new LoginPage(driver);
	}
	
	
	@Test
	public void test01() {
		
		lp.loginToApplication("kiran@gmail.com", "123456");
	
	}
	
//	@Test
//	public void test02() {
//		
//		AssertJUnit.assertTrue(false);
//	}
	
	@Test
	public void test03() {
		
		throw new SkipException("Skipping test case");
	}
}
