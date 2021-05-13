package com.library;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.testng.Assert;
public class BaseTestClass {
	public static WebDriver driver;


	public static String path;
	public static FileInputStream fis = null;
	public static FileOutputStream fileOut = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;
	private static XSSFCell cell = null;
	public int indexSI=0;



	public BaseTestClass() {}

	/*******************************************************************
	 * Function Name : invokeBrowser(String browserName)
	 * Description : To invoke browser using try and catch.
	  
	 *******************************************************************/	
	public static void invokeBrowser(String browserName) {

		try {


			if (browserName.equalsIgnoreCase("Chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
			} else if (browserName.equalsIgnoreCase("Firefox")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				
			}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://pratesting.cognizant.com/");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}


	}	
	
	/*******************************************************************
	 * Function Name : clander(string data, string calendername
	 * Description : Select date , month and year from the calender.
	  
	 *******************************************************************/

	/***************** Select Date From Calendar *****************/
	
	public static void calander(String date,String Calendername) {
		try {

			if(Calendername.equalsIgnoreCase("Reported Date")) {
				driver.findElement(By.xpath("//*[@id='cal_DN_ReportedDate']")).click();
			}else if (Calendername.equalsIgnoreCase("Due Date")) {
				driver.findElement(By.xpath("//*[@id='cal_CM_DUEDATE']")).click();
			}
			String[] words=date.split("-");
			String date1=words[0];
			String month=words[1];
			String year=words[2];
			int months =Integer.parseInt(month);
			int month_number = Integer.parseInt(month);
			switch (months) 
			{
			case 1:  month="Jan"; break;
			case 2:  month="Feb"; break;
			case 3:  month="Mar"; break;
			case 4:  month="Apr"; break;
			case 5:  month="May"; break;
			case 6:  month="Jun"; break;
			case 7:  month="Jul"; break;
			case 8:  month="Aug"; break;
			case 9:  month="Sep"; break;
			case 10: month="Oct"; break;
			case 11: month="Nov"; break;
			case 12: month="Dec"; break;
			default: month="Jan"; break;
			}
			
			Select yearDropDown=new Select(driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div[1]/div/select[2]")));
			yearDropDown.selectByVisibleText(year);
			
			Select monthDropDown=new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/select[1]")));
			monthDropDown.selectByVisibleText(month);
			
			int dateNUmber=Integer.parseInt(date1);

			month_number= month_number-1;
			
			String dateXpath="//*[@class='ui-state-default' and text()='"+dateNUmber+"'] //parent::td[@data-month='"+month_number+"']";
			driver.findElement(By.xpath(dateXpath)).click();

		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}


	}	
	
	/*******************************************************************
	 * Function Name : String getTitle(Webdriver wd),
	 * Description : To get the title .
	  @throws IOexception 
	 *******************************************************************/

	public static String  getTitle(WebDriver Wd) {
		String expectedTitle= Wd.getTitle();
		return expectedTitle;
	}

	/*******************************************************************
	 * Function Name : selectDropDownValue(WebElement webElement, String value)
	 * Description : To select values from drop down by visible text.
	 *******************************************************************/
	
	public static void selectDropDownValue(WebElement webElement, String value){
		try
		{
			Select select = new Select(webElement);
			select.selectByVisibleText(value);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/*******************************************************************
	 * Function Name : verifyElementIsDisplayed(WebElement webElement)
	 * Description : To verify either element displayed or not.
	 *******************************************************************/
	
	
	public boolean veriyElementIsDisplayed(WebElement webElement){
		try
		{
			if(webElement.isDisplayed())
			{
				return true;
			}
			else 
			{
				return false;
			}

		    
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/*******************************************************************
	 * Function Name : setExcelPath(String pat)
	 * Description : To set Excel path in order to get data.
	 *******************************************************************/

	public static void  setExcelPath (String pat) {

		path = pat;
		try 
		{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} 
		catch (Exception e) 
		{

			e.printStackTrace();
		}
	}

	/*******************************************************************
	 * Function Name : getRowCount(String sheetName)
	 * Description : To get Row count from the Excel/XLSX sheet
	 *******************************************************************/
	
	public static int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else 
		{
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}
	
	/*******************************************************************
	 * Function Name : getCellData(String sheetName, string colName, int rowNum)
	 * Description : To get data from each cell of XLSX file
	 *******************************************************************/

	public static String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 1; i < row.getLastCellNum(); i++)
			{

				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			
			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum );
			
			if (row == null)
				return "";
			
			cell = row.getCell(col_Num);

			if (cell == null)
				return "";


			if (cell.getCellType().name().equals("STRING"))
				return cell.getStringCellValue();


			else if ((cell.getCellType().name().equals("NUMERIC")) || (cell.getCellType().name().equals("FORMULA")))
			{

				if(DateUtil.isCellDateFormatted(cell))
				{
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

					String cellText=String.valueOf(dateFormat.format(cell.getDateCellValue()));
					return cellText;
				}
				else 
				{
					String cellText=cell.getRawValue();
					return cellText;
				}



			}
			
			else if (cell.getCellType().BLANK != null)
				return "";
			
			else
				return String.valueOf(cell.getBooleanCellValue());

		} 
		catch (Exception e)
		{

			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}

	/*******************************************************************
	 * Function Name : List<WebElement> getallElementsOfDropDown(WebElement webElement)
	 * Description : To get all the elements from the dropdown ad return all 
	 *******************************************************************/

	public List<WebElement> getAllElementsOfDropDown(WebElement webElement){
		try {
			Select select = new Select(webElement);
			List<WebElement> allElements = select.getOptions();
			return allElements;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*******************************************************************
	 * Function Name :afterMyMehtod
	 * Description : To get the HTMl report
	 *******************************************************************/

	@AfterMethod
	public void afterMyMehtod(ITestResult result) throws IOException {
		indexSI++;
		if(result.getStatus()==ITestResult.FAILURE) {
			updateResult(result.getTestClass().getName(),indexSI,result.getName().toString(),"Fail");		}
         if(result.getStatus()==ITestResult.SUCCESS) {
        	 updateResult(result.getTestClass().getName(),indexSI,result.getName().toString(),"Pass");	
		}
        else {
        	updateResult(result.getTestClass().getName(),indexSI,result.getName().toString(),"Other");		
        }
	}
	public static void updateResult(String classname,int indexSI,String methodname,String response) throws IOException {
	
		String resultFile="./HTMLReport/Report.html";
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		File file=new File(resultFile);
		
		if(!file.exists()) {
			FileWriter fw=new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("<html>"+"\n");
			bw.write("<head><title>"+"Mainspring Application"+"</title>"+"\n");
			bw.write("</head>"+"\n");
			bw.write("<body>");
			bw.write("<h1>Mainspring Application</h1>"+"\n");
			bw.write("<h1 style= 'font-size:30px;'>Issue Report:</h1>");
			
			bw.flush();
			bw.close();
		}
		BufferedWriter bwl=new BufferedWriter(new FileWriter(file,true));
		if(indexSI==1) {
			bwl.write("<table align='center’ border='@' width='70%' height='10'>");
			bwl.write("<tr><td width='70%' </td></tr>");

			bwl.write("<table align='center’ border='1' width='70%' height='47'>");
			bwl.write("<tr>");
			bwl.write("<td colspan='1' align='center'><b><font color='#000000' face= ‘Tahoma’ size='2'>ScriptName =TestScript:&nbsp;&nbsp;&nbsp;</font></b><font colur='0000FF'></font></b></td>");
			bwl.write("<td colspan='2' align='left'><b><font color='#000000' face='Tahoma' size='2'>Start Time:"+dtf.format(now)+"&nbsp;</font></b><font colur='0000FF'></font></b></td>");
			bwl.write("</tr>");
			bwl.write("</tr>");
			bwl.write("<td bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Tahoma’ size='2'>S.No</font></b></td>");
			bwl.write("<td bgcolor='#CCCCFF’ align='left'><b><font color='#000000' face='Tahoma’ size='2'>  Class Name</font></b></td>");
			bwl.write("<td bgcolor='#CCCCFF' align='left'><b><font color='#000000' face='Tahoma’ size='2'> Test Name</font></b></td>");
			bwl.write("<td bgcolor='#CCCCFF’ align='center'><b><font color='#000000' face='Tahoma' size='2'> Response </font></b></td>");
			bwl.write("</tr>");
		

			 
		}
		bwl.write("<tr>" + "\n");

		bwl.write("<td bgcolor='#FFFFDC'align='Center'><font color='#000000' face='Tahoma’ size='2'>" + indexSI+"</font></td>" +"\n");
		bwl.write("<td bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='#000000' face='Tahoma’ size='2'>" + classname+"</font></b></td>" +"\n");
		bwl.write("<td bgcolor='#FFFFDC' valign='middle' align='left'><b><font color='#000000' face='Tahoma’ size='2'>" + methodname+"</font></b></td>" +"\n");
		bwl.write("<td bgcolor='#FFFFDC' valign='middle’ align='left'><b><font color='#000000' face='Tahoma’ size='2'>" + response+"</font></b></td>" +"\n");
		bwl.write("</tr>" + "\n");
		bwl.write("</body>");
		bwl.write("</html>");
	    bwl.flush();
		bwl.close();

		
	}




	
	
	


}