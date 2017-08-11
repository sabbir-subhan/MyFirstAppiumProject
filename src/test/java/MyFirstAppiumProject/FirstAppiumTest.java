package MyFirstAppiumProject;

import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FirstAppiumTest {

	private static AndroidDriver<WebElement> driver;
	Dimension size;
	
	private void clickHamburgerMenu(){
		  //click on HamburgerMenu
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
							e.printStackTrace();
			}
		  //WebDriverWait waitForOCAHamburgerMenu=new WebDriverWait(driver,60);
		  WebElement OCAHamburgerMenu=driver.findElement(By.id("iconbar"));
		  System.out.println(OCAHamburgerMenu.getLocation());
		  //waitForOCAHamburgerMenu.until(ExpectedConditions.visibilityOf(OCAHamburgerMenu));
		  OCAHamburgerMenu.click();
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
						e.printStackTrace();
		}
	}
	
	private void swipingVerticalToptoBotton() throws InterruptedException {
		  //Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		   
		  //Find swipe start and end point from screen's with and height.
		  //Find starty point which is at bottom side of screen.
		  int starty = (int) (size.height * 0.80);
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.20);
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		  //Swipe from Bottom to Top.
		  driver.swipe(startx, starty, startx, endy, 30000);
		  Thread.sleep(3000);
	
		 }
	
	private boolean swipeVerticalUpOrDown(WebElement ele) throws InterruptedException{
		boolean elementIsDisplayed=ele.isDisplayed();
		System.out.println("WebElement is display :"+elementIsDisplayed);
		int heightOfScreen=driver.manage().window().getSize().getHeight();
		System.out.println("Height of the screen is "+heightOfScreen);
		int YCoOrdinateOfElement=ele.getLocation().getY();
		System.out.println("Height (Y cordinate of the Element is) "+YCoOrdinateOfElement);
		
		//decide if Appium needs to swipe Up Or Down based element location's Y co-ordinate
		//if Element's Y coordinate is greater than Height of screen, we need swipe down vertical
		//otherwise swipe up vertical
		boolean ShouldSwipeDown=false;
		if(YCoOrdinateOfElement>heightOfScreen){
			return ShouldSwipeDown=true;
			} 
		else {
				return ShouldSwipeDown;			
			}
		}	
		

	private void swipingVerticalByElementName(WebElement ele) throws InterruptedException {
		  
		boolean elementIsDisplayed=ele.isDisplayed();
		System.out.println("WebElement is display :"+elementIsDisplayed);
		int heightOfScreen=driver.manage().window().getSize().getHeight();
		System.out.println("Height of the screen is "+heightOfScreen);
		int YCordinateOfElement=ele.getLocation().getY();
		System.out.println("Height (Y cordinate of the Element is) "+YCordinateOfElement);
		
		while(YCordinateOfElement>heightOfScreen)
		{
			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			driver.swipe(0,scrollStart,0,scrollEnd,2000);
			//get new YCordinate of Element after the swipe
			YCordinateOfElement=ele.getLocation().getY();
			System.out.println("Height (Y cordinate of the Element after swipe is "+YCordinateOfElement);
		}
		//System.out.println(ele.getLocation());
		//System.out.println("Positive height: "+ ele.getSize().getHeight());
		//System.out.println("Width: "+ ele.getSize().getWidth());
		 }
	
	  @BeforeClass
	  
	  public void setup() throws InterruptedException, MalformedURLException{
		  
		 //Prints Out the Test Case Name in the console for debugging purpose
		  String TestCaseName = this.getClass().getName();
		  System.out.println("TEST CASE RUNNING :"+ TestCaseName);
		  
		  //setting up Appium
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "Galaxy S6");
		  capabilities.setCapability("platformName", "Android");
		  capabilities.setCapability("platformVersion", "5.1.1");
		  capabilities.setCapability("appPackage", "com.noggin.oca");
		  capabilities.setCapability("appActivity", "com.noggin.oca.MainActivity");
		  //capabilities.setCapability("automationName","uiautomator2");
		  
		  driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  Thread.sleep(12000);
		  
		  
	  }
	  
	  @Test
	  public void test() throws Exception{
		  //System.out.println(driver.getPageSource());
		  //Click on OCA Icon need find better options
		  WebDriverWait waitOCAICon = new WebDriverWait(driver, 30);
		  WebElement OCAIcon=driver.findElement(By.xpath("//com.sec.android.app.launcher.views.HomeItemView[@text='OCA']"));
		  waitOCAICon.until(ExpectedConditions.visibilityOf(OCAIcon));
		  OCAIcon.click();
		  
		  //OCA landing page
			  //Click on login button
		      System.out.println("Clicking on Login button");
			  WebElement LoginButton=driver.findElementById("sessionMenu");
			  LoginButton.click();
		  //OCA Domain page
			  //Enter Domain URL
			  System.out.println("Enter OCA Domain");
			  WebElement OCADomainTextBox=driver.findElement(By.id("sessionDomain"));
			  OCADomainTextBox.sendKeys("https://im1.oca-test-stable-el7sec.lan.noggin.com.au");
			  //Click on Submit
			  System.out.println("Clicn on Submit button");
			  WebElement OCADoamianSubmitButton=driver.findElementByAccessibilityId("Submit");
			  OCADoamianSubmitButton.click();
			  
		 //OCA UserName/Password page
			  //Enter UserName 
			  WebElement UserNameTextBox=driver.findElement(By.id("sessionUsername"));
			  UserNameTextBox.sendKeys("ssubhan");
			//Enter Password 
			  WebElement PasswordTextBox=driver.findElement(By.id("sessionPassword"));
			  PasswordTextBox.sendKeys("123test");
			  //hide the keyboard so Submit button is visible
			  driver.hideKeyboard();
			//Click on Submit
			  WebElement OCAUserNamePasswordSubmitButton=driver.findElement(By.id("sessionSubmit"));
			  OCAUserNamePasswordSubmitButton.click();
		//Should reach on Set Pin Page based on OCA settings
			  //now set the pin to 1234
			  WebElement Num1PinButton=driver.findElement(By.id("pin1"));
			  Num1PinButton.click();	
			  
			  WebElement Num2PinButton=driver.findElement(By.id("pin2"));
			  Num2PinButton.click();
			  
			  WebElement Num3PinButton=driver.findElement(By.id("pin3"));
			  Num3PinButton.click();
			  
			  WebElement Num4PinButton=driver.findElement(By.id("pin4"));
			  Num4PinButton.click();
			  
			  //Click on Submit button
			  WebElement OCAPInSubmitButton=driver.findElement(By.id("sessionPINSubmit"));
			  OCAPInSubmitButton.click();
		//should land on the OCA Dashboard page
			  //Click yes on Notifications popup
			  WebElement DashboardNotificationsYesButton=driver.findElementByAccessibilityId("Yes");
			  DashboardNotificationsYesButton.click();
			  
			  //scroll up and down in Dashboard page
			  //this.swipingVertical();
			  //click on HamburgerMenu
			  this.clickHamburgerMenu();
			  
			 
		//should land on OCA Menu page
			  //click on ABout button
			  WebElement AboutButton=driver.findElement(By.id("aboutMenu"));
			  swipingVerticalByElementName(AboutButton);
			  AboutButton.click();
			  
		//go back to OCA Menu Page
			  
			  driver.pressKeyCode(AndroidKeyCode.BACK);
			  //System.out.println(driver.getPageSource());
			  //click on Event buttons
			  WebElement EventButton=driver.findElement(By.id("emeMenu"));
			  EventButton.click();
			  this.swipingVerticalToptoBotton();
			 
		//go back to OCA Menu Page
			  driver.pressKeyCode(AndroidKeyCode.BACK);
			
			  //Click on Log buttons
			  WebElement LogButton=driver.findElement(By.id("logMenu"));
			  LogButton.click();
			  this.swipingVerticalToptoBotton();
		//go back to OCA Menu Page
			  driver.pressKeyCode(AndroidKeyCode.BACK);
			
			  //Click on Risk buttons
			  WebElement RiskButton=driver.findElement(By.id("riskMenu"));
			  RiskButton.click();
			  //this.swipingVertical();
		//go back to OCA Menu Page
			  driver.pressKeyCode(AndroidKeyCode.BACK);
			  
			  //Click on Report buttons
			  WebElement RportButton=driver.findElement(By.id("reportMenu"));
			  RportButton.click();
			  this.swipingVerticalToptoBotton();
		//go back to OCA Menu Page
			  driver.pressKeyCode(AndroidKeyCode.BACK);
			
			  
			  //Click on Asset button
			  WebElement AssetButton=driver.findElement(By.id("assetMenu"));
			  AssetButton.click();
			  this.swipingVerticalToptoBotton();
		//click on HamburgerMenu and go back to OCA Menu Page
			  driver.pressKeyCode(AndroidKeyCode.BACK);
						  			  
		  Thread.sleep(30000);
	  }
	  
	  @AfterClass
	  public void treadDown(){
		  driver.quit();
	  }
	  
	  
 

}
