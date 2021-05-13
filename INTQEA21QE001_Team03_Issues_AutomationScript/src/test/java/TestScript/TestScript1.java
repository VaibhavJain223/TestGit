package TestScript;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.library.BaseTestClass;
import com.library.Data;
import com.report.Extent_Report;

import Pages.IssueDetails;
import Pages.LoginPage;
public class TestScript1 extends BaseTestClass {
	
	ExtentReports report = Extent_Report.getreport();
	ExtentTest logge ;
	public Logger log = Logger.getLogger("devpinoyLogger");
	public int  dataCount=1;
    
	/*******************************************************************
	 * Function Name : setup()
	 * Description : To open browser
	 *******************************************************************/
	
	@BeforeSuite
	public void setup() {

		invokeBrowser("Chrome");
		log.debug(" Browser opened successfully ");
	}
	
	/*******************************************************************
	 * Function Name : login()
	 * Description : To login to the website.
	  @throws exception 
	 *******************************************************************/
	
	@Test
	public void login() throws Exception {
		logge = report.createTest("Login to the website");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.Login();
		log.debug("login successfully ");


	}
	
	/*******************************************************************
	 * Function Name : testdata(String b.....)
	 * Description : To enter the input data into the issue page.
	  @throws Exception 
	 *******************************************************************/
	
	
	@Test(priority = 1,dataProvider="getTestData",dataProviderClass=Data.class)
	public void testdata(String b,String c,String d,String f,String g,String date1,String i,String j,String date2,String k) throws Exception {
		String str="Entering  data set  Number "+dataCount+" to the ISSUES page";
		logge = report.createTest(str);
		//logge = report.createTest("Entering data to the ISSUES page");
		IssueDetails issue = PageFactory.initElements(driver, IssueDetails.class);
		driver.switchTo().frame("contentframe");
		
		issue.setName(b);
		issue.setDescription(c);
		issue.setCategory(d);
		issue.setType(f);
		issue.setResponsibility(g);
		issue.setCalender(date1);
		issue.setSeverity(i);
		issue.setPriority(j);
		issue.setCalender1(date2);
		issue.setWorkPackage(k);
		issue.clickSave();
		dataCount++;
		driver.switchTo().parentFrame();
		log.debug("Test Passed successfully");

	}
	
	@AfterMethod
	public void result(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE ) {
			logge.fail(result.getName());
			logge.fail(result.getThrowable());
            
		}else if(result.getStatus() == ITestResult.SUCCESS){
           
			logge.pass(result.getName());
		
		}else if(result.getStatus() == ITestResult.SKIP) {
			logge.skip("Test Case : "+result.getName()+" has been skipped");
		
		}
		
		
		
	}
	
	/*******************************************************************
	 * Function Name : close()
	 * Description : To close the browser
	 *******************************************************************/
	
	@AfterSuite
	public void close() {
		report.flush();
		driver.close();
		log.debug(" Browser closed successfully ");
		
	}
	


}