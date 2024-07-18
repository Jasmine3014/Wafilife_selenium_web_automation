package com.jasmine.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentFactory {
	
	public static final ExtentReports extentReoprts = new ExtentReports();
	public synchronized static ExtentReports getInstance() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/reprot.html");
		reporter.config().setReportName("Automation b-24");
		extentReoprts.attachReporter(reporter);
		
		return extentReoprts;
		
	}

}
