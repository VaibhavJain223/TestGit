package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.library.BaseTestClass;

public class LoginPage extends BaseTestClass {

	//WebDriver wd;

	/*******************************************************************
	 * Function Name : Login()
	 * Description : To login and invoke issue page and click add Icon.
	  @throws Exception 
	 *******************************************************************/

	public  void Login() throws Exception {
		// TODO Auto-generated method stub

		By navbar=By.xpath("//*[@id='navbar']/div[3]/div[1]"); 
		By projectIcon= By.xpath("//*[@id='projectIcon']/ul/li[1]/a");
		By homeIcon=By.xpath("//a[@id='LOCK_Home']");
		By monitorIcon=By.xpath("//a[@id='LOCK_Monitor']");
		By monitorSubMenu=By.xpath("//li[4]//div[1]//div[2]//div[1]//ul[1]");
		By issueIcon=By.xpath("//a[@id='LOCK_Issues']");
		By addIcon=By.xpath("//span[@id='KEY_BUTTON_Add-btnIconEl']");



		Thread.sleep(90000);

		driver.findElement(navbar).click();

		WebDriverWait wait = new WebDriverWait(driver,30);		//Declaration of wait object

		driver.findElement(projectIcon).click();			    //click on the project icon

		wait.until(ExpectedConditions.visibilityOfElementLocated(homeIcon));		//top menu check 

		WebElement top_menu = driver.findElement(monitorIcon);		//top menu element

		Actions action = new Actions(driver);

		action.moveToElement(top_menu).build().perform();		//to hover over the MONITOR element
		try
		{

			wait.until(ExpectedConditions.visibilityOfElementLocated(monitorSubMenu));		//wait till the sub menu for MONITOR is shown

		} 

		catch (Exception e)
		{

			e.printStackTrace();
		}
		driver.findElement(issueIcon).click();		//click on ISSUES

		wait.until(ExpectedConditions.visibilityOfElementLocated(addIcon));		//wait till the sub menu for MONITOR is shown


		driver.findElement(addIcon).click();		//click on the add icon


	}

}




