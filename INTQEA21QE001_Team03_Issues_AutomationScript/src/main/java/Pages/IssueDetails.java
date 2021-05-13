package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.library.BaseTestClass;


/*******************************************************************
 * Function Name : IssueDetails
 * Description : Extends the Parent class BaseTestClass into IssueDetails
  @throws IOexception 
 *******************************************************************/

public class IssueDetails extends BaseTestClass{


	By name = By.xpath("//td//input[@name='CM_Name']");
	By description = By.xpath("//td//textarea[@name='CM_Description']");
	By issueCategory = By.xpath("//td//select[@name='DN_IssueCategory']"); 
	By issueType = By.xpath("//td//select[@name='DN_IssueType']"); 
	By responsibility = By.xpath("//td//select[@name='DN_Responsibility']"); 

	By reportedBy = By.xpath("//td//input[@name='DN_ReportedBy']");
	By severity = By.xpath("//td//select[@name='DN_Severity1']"); 
	By priority = By.xpath("//td//select[@name='CM_Priority']"); 

	By workPackageName = By.xpath("//td//select[@name='DN_WorkPackageName']"); 
	By save = By.id("SaveAddNewBtn");

	/*******************************************************************
	 * Functions Name : setName (String issueName),setDecription(String des), setCategory(String category)
	 * Description : To send data using xpath.  

	 *******************************************************************/


	public void setName(String issueName) {
		driver.findElement(name).sendKeys(issueName);

	}

	public void setDescription(String des) {
		driver.findElement(description).sendKeys(des);
	}

	public void setCategory(String category) {
		WebElement elementCategory= driver.findElement(issueCategory); 
		selectDropDownValue(elementCategory,category);
	}

	public void setType(String type) {
		WebElement elementIssueType= driver.findElement(issueType);
		selectDropDownValue(elementIssueType,type);
	}

	public void setResponsibility(String rName) {
		WebElement elementRes= driver.findElement(responsibility);
		selectDropDownValue(elementRes,rName);
	}

	public void setCalender(String date) {
		calander(date,"Reported Date"); 
	}


	/*******************************************************************
	 * Functions Name : setSeverity(String severityType), setPriority(String priorityType),
		                    setCalender(String date), setWorkPackage(String workPackage)
	 * Description : To select type from dropdown and date from calendar.
		  @throws IOexception 
	 *******************************************************************/

	public void setSeverity(String severityType) {
		WebElement elementSev= driver.findElement(severity);
		selectDropDownValue(elementSev,severityType);
	}

	public void setPriority(String priorityType) {
		WebElement elementPr= driver.findElement(priority);
		selectDropDownValue(elementPr,priorityType);
	}

	public void setCalender1(String date) {
		calander(date,"Due Date"); 
	}

	public void setWorkPackage(String workPackage) {
		WebElement elementWP= driver.findElement(workPackageName);
		selectDropDownValue(elementWP,workPackage);
	}

	/*******************************************************************
	 * Function Name : clicksave()
	 * Description : to click on save button 
	 *******************************************************************/


	public void clickSave() {
		driver.findElement(save).click();
	}




}


