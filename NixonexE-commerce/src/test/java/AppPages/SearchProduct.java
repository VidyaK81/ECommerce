package AppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ReportUtility;

import static Utilities.Utility.prop;

public class SearchProduct {
WebDriver driver;
ExtentTest test;
	public SearchProduct(WebDriver d,ExtentTest t)
	{
		driver = d;
		test = t;
	}
	
	public void searchProd() throws InterruptedException
	{
		driver.findElement(By.xpath(prop.getProperty("catLaptop"))).click();
		String productCat = driver.findElement(By.xpath(prop.getProperty("catLaptop"))).getText();
		System.out.println( productCat + " clicked");
		Thread.sleep(2000);
		ReportUtility.log("Selected category " + productCat, driver, test, Status.PASS);
	}
}
