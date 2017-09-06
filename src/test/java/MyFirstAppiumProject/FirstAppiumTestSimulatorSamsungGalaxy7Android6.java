package MyFirstAppiumProject;

import org.testng.annotations.Test;

import AutomnationSupportClasses.captureScreenShot;
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

public class FirstAppiumTestSimulatorSamsungGalaxy7Android6 {

	private static AndroidDriver<WebElement> driver;
	Dimension size;
	String TestCaseName = this.getClass().getName();
	
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
	
	private void swipingDownVerticalByElementName(WebElement ele) throws InterruptedException {
		  
		boolean elementIsDisplayed=ele.isDisplayed();
		System.out.println("WebElement is display :"+elementIsDisplayed);
		int heightOfScreen=driver.manage().window().getSize().getHeight();
		System.out.println("Height of the screen is "+heightOfScreen);
		//int YCordinateOfElement=ele.getLocation().getY();
		//System.out.println("Height (Y cordinate of the Element is) "+YCordinateOfElement);
		int HeightofElement=ele.getSize().getHeight();
		System.out.println("initial height size??"+HeightofElement);
		
		while(HeightofElement<300)
		{
			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.8;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			driver.swipe(0,scrollStart,0,scrollEnd,2000);
			//get new YCordinate of Element after the swipe
			HeightofElement=ele.getSize().getWidth();
			System.out.println("height size after scrolling "+HeightofElement);
			//System.out.println("Height (Y cordinate of the Element after swipe is "+YCordinateOfElement);
		}
		
	}
	
	private void swipingUpVerticalByElementName(WebElement ele) throws InterruptedException {
		  
		boolean elementIsDisplayed=ele.isDisplayed();
		System.out.println("WebElement is display :"+elementIsDisplayed);
		int heightOfScreen=driver.manage().window().getSize().getHeight();
		System.out.println("Height of the screen is "+heightOfScreen);
		//int YCordinateOfElement=ele.getLocation().getY();
		//System.out.println("Height (Y cordinate of the Element is) "+YCordinateOfElement);
		int HeightofElement=ele.getSize().getHeight();
		System.out.println("initial height size??Up scroll"+HeightofElement);
		//300 seems like the magic number
		while(HeightofElement<300)
		{
			//Get the Dimension of screen.
			Dimension dimensions = driver.manage().window().getSize();
			
			//Find horizontal point where you wants to swipe. It is in middle of screen width.
			int startx =dimensions.getWidth()/2;
			
			//Find scrollStartY point which is at bottom side of screen.
			Double screenHeightStart = dimensions.getHeight() * 0.8;
			int scrollStartY = screenHeightStart.intValue();
			
			 //Find scrollEndY point which is at top side of screen.
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEndY = screenHeightEnd.intValue();
			//Swipe from Bottom to Top.
			driver.swipe(startx,scrollEndY,startx,scrollStartY,2000);
			//get new YCordinate of Element after the swipe
			//get new Height of Element after the swipe
			HeightofElement=ele.getSize().getWidth();
			System.out.println("size after scrolling "+HeightofElement);
			//YCordinateOfElement=ele.getLocation().getY();
			//System.out.println("Height (Y cordinate of the Element after swipe is "+YCordinateOfElement);
		}
		
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
		  driver.swipe(startx, starty, startx, endy, 10000);
		  Thread.sleep(3000);
	
		 }
	
	private void swipingVerticalByElementName(WebElement ele) throws InterruptedException {
		  
		boolean elementIsDisplayed=ele.isDisplayed();
		System.out.println(elementIsDisplayed);
		int heightOfScreen=driver.manage().window().getSize().getHeight();
		System.out.println("Height of the screen is "+heightOfScreen);
		int YCordinateOfElement=ele.getLocation().getY();
		System.out.println("Height (Y cordinate of the Element is "+YCordinateOfElement);
		//System.out.println(elementIsDisplayed);
		//System.out.println(ele.getLocation());
		//System.out.println("height: "+ ele.getSize().getHeight());
		//System.out.println("Width: "+ ele.getSize().getWidth());
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
	
	public void pressKey(int androidKeyCode){
        try {
            //AndroidDriver androidDriver = (AndroidDriver) appiumDriver;
        	driver.pressKeyCode(androidKeyCode);
            System.out.println("Key " + androidKeyCode + " clicked");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
	
	  @BeforeClass
	  
	  public void setup() throws InterruptedException, MalformedURLException{
		  
		 //Prints Out the Test Case Name in the console for debugging purpose
		  
		  System.out.println("TEST CASE RUNNING :"+ TestCaseName);
		  
		  //setting up Appium
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "Galaxy S7");
		  capabilities.setCapability("platformName", "Android");
		  capabilities.setCapability("platformVersion", "6");
		  capabilities.setCapability("appPackage", "com.noggin.oca");
		  capabilities.setCapability("appActivity", "com.noggin.oca.MainActivity");
		  //capabilities.setCapability("autoWebview","true");
		  
		  driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  //driver.context("NATIVE_APP");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  Thread.sleep(2000);
		  
		  
	  }
	  
	  @Test
	  public void test() throws Exception{
		  //Create an object to take screen shot
		  
		  captureScreenShot captureMobileScreen=new captureScreenShot();
		  
		  //System.out.println(driver.getPageSource());
		  //Click on OCA Icon need find better options
		 
		  //Click on Home Screen
		  WebElement Home=driver.findElementByAccessibilityId("Apps");
		  Home.click();
		  
		  //Tap on OCA Icon
		  WebElement OCAIcon=driver.findElementByAccessibilityId("OCA");
		  OCAIcon.click();
		  
		  
		  //OCA landing page
			  //Click on login button
			  WebElement LoginButton=driver.findElementByAccessibilityId(" LOGIN");
			  captureMobileScreen.takeScreenShot(driver, TestCaseName);//take screenshot of the mobile screen
			  LoginButton.click();
		  //OCA Domain page
			  //Enter Domain URL
			  
			  WebElement OCADomainTextBox=driver.findElementById("sessionDomain");
			  OCADomainTextBox.sendKeys("https://bitnoiseqa.nogginoca.com");
			  //Click on Submit
			  WebElement OCADoamianSubmitButton=driver.findElementByAccessibilityId("Submit");
			  OCADoamianSubmitButton.click();
			  
		 //OCA UserName/Password page
			  //Enter UserName 
			  WebElement UserNameTextBox=driver.findElementByAccessibilityId("Username");
			  UserNameTextBox.sendKeys("sabbir");
			//Enter Password 
			  WebElement PasswordTextBox=driver.findElementByAccessibilityId("Password");
			  PasswordTextBox.sendKeys("123test");
			  //hide the keyboard so Submit button is visible
			  driver.hideKeyboard();
			//Click on Submit
			  WebElement OCAUserNamePasswordSubmitButton=driver.findElementByAccessibilityId("Submit");
			  OCAUserNamePasswordSubmitButton.click();
			 
		//Should reach T&C page
			 
			  Thread.sleep(5000);
			  WebElement AcceptButton=driver.findElementByAccessibilityId("Accept");
			  AcceptButton.click();
			  			  
			  
		/*
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
			  
			    */
			  
			 
			//click on ABout button
			  Thread.sleep(5000);
			  WebElement AboutButton=driver.findElement(By.id("aboutMenu"));
			  //Check if Appium needs swipe up or down
			  boolean swipeDownAboutMenu=this.swipeVerticalUpOrDown(AboutButton);
			  if (swipeDownAboutMenu){
			  this.swipingDownVerticalByElementName(AboutButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(AboutButton);
			  }
			  captureMobileScreen.takeScreenShot(driver, TestCaseName);
			  AboutButton.click();
			  captureMobileScreen.takeScreenShot(driver, TestCaseName);
		//go back to OCA Menu Page
			  
			  driver.pressKeyCode(AndroidKeyCode.BACK);
			  //System.out.println(driver.getPageSource());
			  //click on Event buttons
			  WebElement EventButton=driver.findElement(By.id("emeMenu"));
			  boolean swipeDownEvent=this.swipeVerticalUpOrDown(EventButton);
			  if (swipeDownEvent){
			  this.swipingDownVerticalByElementName(EventButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(EventButton);
			  }
			  EventButton.click();
			  //Enter a search Text and enter press enter 
			  WebElement EventSearchTextBox=driver.findElement(By.id("emeSearch"));
			  EventSearchTextBox.sendKeys("appium");
			  //press enter key
			  driver.pressKeyCode(AndroidKeyCode.ENTER);
			  Thread.sleep(5000);
			  this.clickHamburgerMenu();
			  
		//go back to OCA Menu Page
			  //driver.pressKeyCode(AndroidKeyCode.BACK);
			
			  //Click on Log buttons
			  WebElement LogButton=driver.findElement(By.id("logMenu"));
			  boolean swipeDownLog=this.swipeVerticalUpOrDown(LogButton);
			  if (swipeDownLog){
			  this.swipingDownVerticalByElementName(LogButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(LogButton);
			  }
			  
			  LogButton.click();
			  //this.swipingVerticalToptoBotton();
		//go back to OCA Menu Page
			  this.clickHamburgerMenu();
			
			  //Click on Risk buttons
			  WebElement RiskButton=driver.findElement(By.id("riskMenu"));
			  
			  boolean swipeDownRisk=this.swipeVerticalUpOrDown(RiskButton);
			  if (swipeDownRisk){
			  this.swipingDownVerticalByElementName(RiskButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(RiskButton);
			  }
			  
			  RiskButton.click();
			  //this.swipingVertical();
		//go back to OCA Menu Page
			  this.clickHamburgerMenu();
			  
			  //Click on Report buttons
			  WebElement RportButton=driver.findElement(By.id("reportMenu"));
			  boolean swipeDownRport=this.swipeVerticalUpOrDown(RportButton);
			  if (swipeDownRport){
			  this.swipingDownVerticalByElementName(RportButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(RportButton);
			  }
			  RportButton.click();
			
		//go back to OCA Menu Page
			  this.clickHamburgerMenu();
			
			  
			  //Click on Asset button
			  WebElement AssetButton=driver.findElement(By.id("assetMenu"));
			  boolean swipeDownAsset=this.swipeVerticalUpOrDown(AssetButton);
			  if (swipeDownAsset){
			  this.swipingDownVerticalByElementName(AssetButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(AssetButton);
			  }
			  AssetButton.click();
			 
		//click on HamburgerMenu and go back to OCA Menu Page
			  this.clickHamburgerMenu();
						  			  
		  Thread.sleep(5000);
		 
	  }
	  
	  @AfterClass
	  public void treadDown(){
		  driver.quit();
	  }
	  
	  
 

}
