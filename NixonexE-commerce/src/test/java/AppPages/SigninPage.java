package AppPages;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static Utilities.Utility.prop;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ReportUtility;

public class SigninPage {
	WebDriver driver;
	ExtentTest test;
	
	public SigninPage(WebDriver d,ExtentTest t)
	{
		driver = d;
		test = t;	
	}
	
	public void signup()
	{
		driver.findElement(By.xpath(prop.getProperty("signup"))).click();
	   // Wait for modal to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        
        //Send data to modal
        Random random = new Random();
        modal.findElement(By.id("sign-username")).sendKeys("vskul"+random.nextInt(1000) );
        modal.findElement(By.id("sign-password")).sendKeys("Test@123");
        modal.findElement(By.cssSelector("button[onclick='register()")).click();
       
        // Handle alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        
        //Check sign up success
        try {
             Assert.assertEquals(alert.getText(), "Sign up successful.","This user already exist.");
        
            }catch(Exception error)
            {
            	System.out.println(error);
            }
        alert.accept();
        ReportUtility.log("Sign Up Successful", driver, test, Status.PASS);
		}
	}