package com.jasmine.drivers;

import org.openqa.selenium.WebDriver;

public class PageDriver {
	
	public static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	public static PageDriver instance =null;
	
	private PageDriver(){
		
	}
	
	public static PageDriver getInstance() {
		
		if(instance==null) {
			instance = new PageDriver();
		}
		return instance;
		
	}
	
	public WebDriver getDriver() {
		return webDriver.get();
	}
	
	public void setDriver(WebDriver driver) {
		webDriver.set(driver);
	
	}
	
	public static WebDriver getcurrentDriver() {
		return getInstance().getDriver();
		
	}

}
