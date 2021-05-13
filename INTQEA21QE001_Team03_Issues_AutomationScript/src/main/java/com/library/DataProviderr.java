package com.library;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class DataProviderr extends BaseTestClass {
	
	
	/*******************************************************************
	 * Function Name : ArrayList<Object> getData( int start, int end)
	 * Description : To get data from the XLSX file and return it.
	 
	 *******************************************************************/
	
	public static ArrayList<Object[]> getdata(int start,int end) {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			setExcelPath("./excel/put.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for (int rowcnt =start;rowcnt<=end;rowcnt++) {
			
			
			String issueName = getCellData("Sheet1","IssueName", rowcnt);
			String description = getCellData("Sheet1","Description", rowcnt);
			String Category =getCellData("Sheet1","Category", rowcnt);
			String issueType = getCellData("Sheet1","IssueType", rowcnt);
			String responsibility = getCellData("Sheet1","Responsibility", rowcnt);
			String Reported_Date = getCellData("Sheet1","Reported_Date", rowcnt);
			String severity = getCellData("Sheet1","Severity", rowcnt);
			String priority = getCellData("Sheet1","Priority", rowcnt);
			String Due_Date = getCellData("Sheet1","Due_Date", rowcnt);
			String workPackageName = getCellData("Sheet1","WorkPackageName", rowcnt);
			
			Object ob[] = {issueName,description,Category,issueType,responsibility,Reported_Date,severity,priority,Due_Date,workPackageName};
			
			myData.add(ob);
			
			
		}
		
		
		
		
		return myData;
		
	}

}
