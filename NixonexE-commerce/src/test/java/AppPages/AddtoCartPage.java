package AppPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ReportUtility;

import static Utilities.Utility.prop;

import java.time.Duration;


public class AddtoCartPage {

	WebDriver driver;
	Alert alert;
	ExtentTest test;
	public AddtoCartPage(WebDriver d,ExtentTest t)
	{
		driver = d;
		test = t;
	}
	
	public String  addtoCart()
	{
		//System.out.println("Selected product:" + driver.findElement(By.xpath(prop.getProperty("prodLaptop"))).getText());
		driver.findElement(By.xpath(prop.getProperty("prodLaptop"))).click();
		
		String product = driver.findElement(By.xpath(prop.getProperty("prodDName"))).getText();
		System.out.println("Selected product is:" + product);                  
		driver.findElement(By.xpath(prop.getProperty("addtocartBtn"))).click();
		// Verify product is added to cart
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.alertIsPresent());
		 alert=driver.switchTo().alert();
		 String alertText = alert.getText();
		 try {
		      Assert.assertEquals(alertText, "Product added");
		 }
		 catch (Exception error)
		 {
			System.out.println(error);   
		 }
		alert.accept();
		ReportUtility.log(product + " is selected." , driver, test, Status.PASS);
		return product;
	}
	
	
}
