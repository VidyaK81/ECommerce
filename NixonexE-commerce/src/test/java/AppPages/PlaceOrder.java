package AppPages;

import static Utilities.Utility.prop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ReportUtility;

public class PlaceOrder {
	WebDriver driver;
	ExtentTest test;
	public PlaceOrder(WebDriver d,ExtentTest t)
	{
		driver=d;
		test = t;
	}
	
	public void placeOrder() {
		driver.findElement(By.xpath(prop.getProperty("placeOrder"))).click();
		
		// Wait for modal to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));
        // Send data to modal
        modal.findElement(By.id("name")).sendKeys("vskul");
        modal.findElement(By.id("country")).sendKeys("India");
        modal.findElement(By.id("city")).sendKeys("Pune");
        modal.findElement(By.id("card")).sendKeys("54545454545454545454545454545454");
        modal.findElement(By.id("month")).sendKeys("08");
        modal.findElement(By.id("year")).sendKeys("28");
        // Place order
        modal.findElement(By.cssSelector("button[onclick='purchaseOrder()")).click();
        String strMessage = driver.findElement(By.xpath(prop.getProperty("msgThankyou"))).getText();
        try {
        	Assert.assertEquals(strMessage, "Thank you for your purchase!");
        	ReportUtility.log("Purchase Successful." , driver, test, Status.PASS);
        } catch(Exception error)
        {
        	System.out.println(error);
        }
     driver.findElement(By.xpath(prop.getProperty("btnOk"))).click();   
	}

}
