package com.jasmine.tests;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jasmine.drivers.PageDriver;
import com.jasmine.pages.LoginPage;
import com.jasmine.utilities.CommonMethod;
import com.jasmine.utilities.extentFactory;


public class LoginTest extends CommonMethod{
	
	ExtentReports report;
	ExtentTest ParentTest;
	ExtentTest ChlidTest;
	
	@BeforeClass
	public void OpenURL() throws InterruptedException {
		report = extentFactory.getInstance();
		ParentTest = report.createTest("<p style=\"color:#FF6000; font-size:13px\"><b>My History</b></p>").assignAuthor("QA Team").assignDevice("Windows");
		PageDriver.getcurrentDriver().get(url);
		timeout(4000);
		
	}
	
	@Test
	public void loginToShop() throws IOException, InterruptedException {
		ChlidTest = ParentTest.createNode("<p style=\"color:#FF6000; font-size:13px\"><b>Login</b></p>");
		LoginPage loginpage = new LoginPage(ChlidTest);
		loginpage.login();
		
	}
	
	
	@AfterClass
	public void report() {
		report.flush();
	}
	

}
