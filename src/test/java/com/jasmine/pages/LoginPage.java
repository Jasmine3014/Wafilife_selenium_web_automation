package com.jasmine.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.jasmine.drivers.PageDriver;
import com.jasmine.utilities.CommonMethod;
import com.jasmine.utilities.GetScreenShot;


public class LoginPage extends CommonMethod {

	ExtentTest test;
	
	public LoginPage (ExtentTest test) {
	
		PageFactory.initElements(PageDriver.getcurrentDriver(), this);
		this.test=test;
    }
	
	@FindBys({
		@FindBy(xpath="//input[@id='username']")
	})
	
	WebElement useremail;
	
	@FindBys({
		@FindBy(xpath="//input[@id='password']")
		
	})
	WebElement password;
	
	@FindBys({
		@FindBy(xpath="//input[@name='login']")
		
	})
	WebElement Login;
	
	

	// Report
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
	}

	@SuppressWarnings("unused")
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getcurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	// Fail
	@SuppressWarnings("unused")
	public void failCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getcurrentDriver(), "" + scName + "");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getcurrentDriver().quit();
	}


	
	
	public void login() throws IOException {
		
		try {
			test.info("please enter your email adddress");
			
			if(useremail.isDisplayed()) {
				useremail.sendKeys("jasminetripti5@gmail.com");
				passCase("You have successfully entered your email");
				timeout(2000);
				try {
					test.info("please enter your password");
					if(password.isDisplayed()) {
						password.sendKeys("jas12345");
						passCase("You have successfully entered your password");
						timeout(2000);
						try {
							test.info("please click on signin button");
							if(Login.isDisplayed()) {
								Login.click();
								timeout(2000);
								passCaseWithSC("You have successfully clicked on Sign In button","login_pass");
							}
						} catch (Exception e) {
							failCase("sign in button locators not found","login_fail");
						}
					}
				} catch (Exception e) {
					failCase("password locators not found","pass_fail");
				}
			
			}
			
		} catch (Exception e) {
			failCase("email locators not found","email_fail");
		}
	
}
	
	
}