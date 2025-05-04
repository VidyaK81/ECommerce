package NixonexE_commerce.NixonexE_commerce;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import AppPages.AddtoCartPage;
import AppPages.CartPage;
import AppPages.SigninPage;
import AppPages.PlaceOrder;
import AppPages.SearchProduct;
import Utilities.Utility;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import Utilities.Extentreporter;
import Utilities.ReportUtility;

public class AppTest {
  WebDriver driver;
  Utility objUtil;
  SigninPage objLoginpage;
  SearchProduct objSearch;
  AddtoCartPage objAdd;
  String product;
  CartPage objCart;
  PlaceOrder objOrder;
  static ExtentReports reports;
  static ExtentTest test;
  
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	  reports = Extentreporter.getReports();
	  test = reports.createTest("OrangeHRM Login");
	 
	  objUtil = new Utility(driver);
	  objUtil.launchApp();
	  ReportUtility.log("App Launched", driver, test, Status.INFO);
	 }
  
  @Test(priority =1)
  public void registration() {
	  objLoginpage = new SigninPage(driver, test);
	  objLoginpage.signup();
	 }
  
  @Test(priority = 2)
  public void searchProduct() throws InterruptedException
  {
	  objSearch = new SearchProduct(driver,test);
	  objSearch.searchProd();
	 
  }
  
  @Test(priority = 3)
  public void AddtoCart()
  {
      objAdd = new AddtoCartPage(driver,test);
      product = objAdd.addtoCart();
  }
  
  @Test(priority=4)
  public void cartClick()
  {
	  objCart = new CartPage(driver,test);
	  objCart.clickeonCart(product);
  }
  
  @Test(priority=5)
  public void placeOrder()
  {
	  objOrder = new PlaceOrder(driver,test);
	  objOrder.placeOrder();
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
	  reports.flush();
  }

}
