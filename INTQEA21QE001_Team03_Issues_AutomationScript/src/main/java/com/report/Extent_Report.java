package com.report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Report {

	public static ExtentReports report;
	

	/*******************************************************************
	 * Function Name : ExtentReposts getreport()
	 * Description : To generate report and return it.
	
	 *******************************************************************/
	
	public static ExtentReports getreport()  {
	
		if(report == null) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/testReport.html");
			report =  new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Build Number", "10.8.1");
			
			
			htmlReporter.config().setDocumentTitle("MainSpring Application");
			htmlReporter.config().setReportName("Issues Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setTimeStampFormat("MMM dd yyyy , HH:mm:ss");
		}
		return report;
		
	}

}
