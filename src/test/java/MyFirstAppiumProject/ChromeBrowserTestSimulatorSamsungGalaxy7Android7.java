package MyFirstAppiumProject;

import org.testng.annotations.Test;

import AutomnationSupportClasses.captureScreenShot;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ChromeBrowserTestSimulatorSamsungGalaxy7Android7 {

	private static AndroidDriver<WebElement> driver;
	Dimension size;
	String TestCaseName = this.getClass().getName();
	
	@BeforeClass
	  
	  public void setup() throws InterruptedException, MalformedURLException{
		  
		 //Prints Out the Test Case Name in the console for debugging purpose
		  
		  System.out.println("TEST CASE RUNNING :"+ TestCaseName);
		  
		  //setting up Appium
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		// set the capability to execute test in chrome browser
		  capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
		  
		  capabilities.setCapability("deviceName", "Galaxy S7");
		  capabilities.setCapability("platformName", "Android");
		  capabilities.setCapability("platformVersion", "6");
		  //capabilities.setCapability("appPackage", "com.noggin.oca");
		  //capabilities.setCapability("appActivity", "com.noggin.oca.MainActivity");
		  //capabilities.setCapability("autoWebview","true");
		  
		  driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  //driver.context("NATIVE_APP");
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  Thread.sleep(2000);
		  
		  
	  }
	  
	  @Test
	  public void test() throws Exception{
		  
		  	//Create an object to take screen shot
		  
		  captureScreenShot captureMobileScreen=new captureScreenShot();
		  
		  driver.get("https://sabbir1.nogginapp.io");
	        //Thread.sleep(10000);
	        System.out.println("Page title is: " + driver.getTitle());
	        System.out.println("Page URL is: " + driver.getCurrentUrl());
	        
	        //String pageSource=driver.getPageSource();
	        
	       try	{ 
		    	   //try login page
		        WebElement EmailAddress=driver.findElement(By.xpath("//label[text()='Email address']/../input"));
		        WebElement Password=driver.findElement(By.xpath("//label[text()='Password']/../input"));
		        WebElement SingInButton=driver.findElement(By.xpath("//span[text()='Sign in']"));
		        System.out.println(SingInButton.getText());
		        //Enter user Name and Password
		        EmailAddress.sendKeys("ssubhan@noggin.com.au");
		        Password.sendKeys("qaTestNoggin");
		        
		        captureMobileScreen.takeScreenShot(driver, TestCaseName);//take screenshot of the mobile screen
		        //Click Signin button
		        SingInButton.click();
	        
	       		}
	       catch (NoSuchElementException e)
		       {
		    	   //check if user in logged in
	    	   //System.out.println(throw NoSuchElementException);
		                      
		          
		       }
	      // System.out.println("Page title is: " + driver.getTitle());
	      // System.out.println("Page URL is: " + driver.getCurrentUrl());
	     
	      WebElement CreateTaskButton=driver.findElement(By.xpath("//span[text()='Create a task']"));
	      captureMobileScreen.takeScreenShot(driver, TestCaseName);//take screenshot of the mobile screen
	      System.out.println(CreateTaskButton.getText());
	           
		   Thread.sleep(10000);//pause
		      
	       

	  }
	  
	  @AfterClass
	  public void treadDown(){
		  driver.quit();
	  }
	  
	  
 

}
