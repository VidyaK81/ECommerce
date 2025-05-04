package AppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ReportUtility;

import static Utilities.Utility.prop;

public class CartPage {

	WebDriver driver;
	ExtentTest test;
	public CartPage(WebDriver d,ExtentTest t)
	{
		driver=d;
		test = t;
	}
	
	public void clickeonCart(String product)
	{
      System.out.println("ClickonCart : " + product );		
      driver.findElement(By.xpath(prop.getProperty("clickCartLink"))).click();
      String cartProduct = driver.findElement(By.xpath(prop.getProperty("cartProd"))).getText();
      
      try
      {
    	  Assert.assertEquals(cartProduct, product);
    	  ReportUtility.log(product + " added to cart." , driver, test, Status.PASS);
    	  
      } catch(Exception error)
      {
    	  System.out.println(error);
      }
      
    }
}
