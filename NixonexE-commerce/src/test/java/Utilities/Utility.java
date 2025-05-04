package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Utility {
	
    WebDriver driver;
	public static File file;
	public static FileInputStream fis;
	public static Properties prop;
	
	public Utility(WebDriver d)
	{
		driver = d;
		try {
			file = new File("C:\\Capstone project -Staragile\\NixonexE-commerce\\Application.properties");
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
 public void launchApp()
   {
	   driver.get(prop.getProperty("appUrl"));
   }
 }
