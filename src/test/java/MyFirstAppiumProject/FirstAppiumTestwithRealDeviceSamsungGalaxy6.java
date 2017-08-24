package MyFirstAppiumProject;

import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FirstAppiumTestwithRealDeviceSamsungGalaxy6 {

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
		  //System.out.println(OCAHamburgerMenu.getLocation());
		  //waitForOCAHamburgerMenu.until(ExpectedConditions.visibilityOf(OCAHamburgerMenu));
		  OCAHamburgerMenu.click();
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
						e.printStackTrace();
		}
	}
	
	private void waitForProgressionAnimation(){
		  
		//Default wait 10 secs
		  WebDriverWait ProgressAminationWait = new WebDriverWait(driver, 10);
		  try{
		  WebElement ProgressAminationElement=driver.findElementByAccessibilityId("loading");
		  if(ProgressAminationElement.isDisplayed()){
			  System.out.println("Progress Animation is displaying");
			  ProgressAminationWait.until(ExpectedConditions.invisibilityOf(ProgressAminationElement));
		  }
		  }
		  catch (NoSuchElementException e)
		  {
			  System.out.println("Progress Animation is NOT displayed-No need worry");
		  }
		  
		 
	}
	
	private void swipingDownVerticalByElementName(WebElement ele) throws InterruptedException {
		  
		//boolean elementIsDisplayed=ele.isDisplayed();
		//System.out.println("WebElement is display :"+elementIsDisplayed);
		//int heightOfScreen=driver.manage().window().getSize().getHeight();
		//System.out.println("Height of the screen is "+heightOfScreen);
		//int YCordinateOfElement=ele.getLocation().getY();
		//System.out.println("Height (Y cordinate of the Element is) "+YCordinateOfElement);
		int HeightofElement=ele.getSize().getHeight();
		//System.out.println("initial height size??"+HeightofElement);
		
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
			//System.out.println("height size after scrolling "+HeightofElement);
			//System.out.println("Height (Y cordinate of the Element after swipe is "+YCordinateOfElement);
		}
		
	}
	
	private void swipingUpVerticalByElementName(WebElement ele) throws InterruptedException {
		  
		boolean elementIsDisplayed=ele.isDisplayed();
		//System.out.println("WebElement is display :"+elementIsDisplayed);
		int heightOfScreen=driver.manage().window().getSize().getHeight();
		//System.out.println("Height of the screen is "+heightOfScreen);
		//int YCordinateOfElement=ele.getLocation().getY();
		//System.out.println("Height (Y cordinate of the Element is) "+YCordinateOfElement);
		int HeightofElement=ele.getSize().getHeight();
		//System.out.println("initial height size??Up scroll"+HeightofElement);
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
			//System.out.println("size after scrolling "+HeightofElement);
			//YCordinateOfElement=ele.getLocation().getY();
			//System.out.println("Height (Y cordinate of the Element after swipe is "+YCordinateOfElement);
		}
		
	}
	
	private boolean swipeVerticalUpOrDown(WebElement ele) throws InterruptedException{
		boolean elementIsDisplayed=ele.isDisplayed();
		//System.out.println("WebElement is display :"+elementIsDisplayed);
		int heightOfScreen=driver.manage().window().getSize().getHeight();
		//System.out.println("Height of the screen is "+heightOfScreen);
		int YCoOrdinateOfElement=ele.getLocation().getY();
		//System.out.println("Height (Y cordinate of the Element is) "+YCoOrdinateOfElement);
		
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
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  Thread.sleep(12000);
		  
		  
	  }
	  
	  @Test
	  public void test() throws Exception{
		  //System.out.println(driver.getPageSource());
		  
		  //Click on Home Screen
		 // WebElement Home=driver.findElementByAccessibilityId("Applications");
		  //Home.click();
		  
		  //Click on OCA Icon need find better options
		  WebDriverWait waitOCAICon = new WebDriverWait(driver, 10);
		  WebElement OCAIcon=driver.findElement(By.xpath("//com.sec.android.app.launcher.views.HomeItemView[@text='OCA']"));
		  waitOCAICon.until(ExpectedConditions.visibilityOf(OCAIcon));
		  OCAIcon.click();
		  
		  //OCA landing page
			  //Click on login button
		      System.out.println("Clicking on Login button");
			  WebElement LoginButton=driver.findElementById("sessionMenu");
			  LoginButton.click();
			  //check if loading amination is displaying or not.
			  this.waitForProgressionAnimation();
		  //OCA Domain page
			  //Enter Domain URL
			  System.out.println("Enter OCA Domain");
			  WebElement OCADomainTextBox=driver.findElement(By.id("sessionDomain"));
			  OCADomainTextBox.sendKeys("https://im1.oca-test-stable-el7sec.lan.noggin.com.au");
			  //Click on Submit
			  System.out.println("Click on Submit button");
			  WebElement OCADoamianSubmitButton=driver.findElementByAccessibilityId("Submit");
			  OCADoamianSubmitButton.click();
			//check if loading amination is displaying or not.
			  this.waitForProgressionAnimation();
			  
		 //OCA UserName/Password page
			  //Enter UserName 
			  WebElement UserNameTextBox=driver.findElement(By.id("sessionUsername"));
			  System.out.println("Enter User Name");
			  UserNameTextBox.sendKeys("ssubhan");
			//Enter Password 
			  WebElement PasswordTextBox=driver.findElement(By.id("sessionPassword"));
			  System.out.println("Enter Password");
			  PasswordTextBox.sendKeys("123test");
			  //hide the keyboard so Submit button is visible
			  driver.hideKeyboard();
			//Click on Submit
			  WebElement OCAUserNamePasswordSubmitButton=driver.findElement(By.id("sessionSubmit"));
			  System.out.println("Click User Name/Password submit button");
			  OCAUserNamePasswordSubmitButton.click();
			//check if loading amination is displaying or not.
			  this.waitForProgressionAnimation();
		//Should reach on Set Pin Page based on OCA settings
			  Boolean IsPINPadDisplayed=false;
			  try{
				  WebElement PINPadDisplayed=driver.findElementByAccessibilityId("Set up PIN lock");
				  IsPINPadDisplayed=PINPadDisplayed.isDisplayed();
				  System.out.println("Pin Pad is displayed");
				  
				  
			  }
			  catch(NoSuchElementException e){
				  //Pinpad is NOT displayed
				  IsPINPadDisplayed=false;
				  System.out.println("Pin Pad is NOT displayed");
			  }
			  
			  
			  
			  //now set the pin to 1234
			  if (IsPINPadDisplayed){
				  System.out.println("Enter PIN as 1234");
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
				//check if loading amination is displaying or not.
				  this.waitForProgressionAnimation();
			  }
		//should land on the OCA Dashboard page
			  //Click yes on Notifications popup
			  WebElement DashboardNotificationsYesButton=driver.findElementByAccessibilityId("Yes");
			  System.out.println("Click on Notifications pop up");
			  DashboardNotificationsYesButton.click();
			
			  //click on HamburgerMenu
			  System.out.println("Click on Hamburger Menu");
			  this.clickHamburgerMenu();
						  
			 
		//should land on OCA Menu page
			  //click on ABout button
			  WebElement AboutButton=driver.findElement(By.id("aboutMenu"));
			  
			  //Check if Appium needs swipe up or down
			  boolean swipeDownAboutMenu=this.swipeVerticalUpOrDown(AboutButton);
			  if (swipeDownAboutMenu){
			  this.swipingDownVerticalByElementName(AboutButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(AboutButton);
			  }
			  
			  System.out.println("Click on About icon");
			  AboutButton.click();
			//check if loading amination is displaying or not.
			  this.waitForProgressionAnimation();
			  Thread.sleep(3000);
			  
		//go back to OCA Menu Page
			  
			  System.out.println("Click on Hamburger Menu");
			  this.clickHamburgerMenu();
			  //System.out.println(driver.getPageSource());
			  //click on Event buttons
			  WebElement EventButton=driver.findElement(By.id("emeMenu"));
			  
			  //Check if Appium needs swipe up or down
			  boolean swipeDownEvent=this.swipeVerticalUpOrDown(EventButton);
			  if (swipeDownEvent){
			  this.swipingDownVerticalByElementName(EventButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(EventButton);
			  }
			  
			  System.out.println("Click on Event Icon");
			  EventButton.click();
			//check if loading amination is displaying or not.
			  this.waitForProgressionAnimation();
			  Thread.sleep(3000);
			 
		//go back to OCA Menu Page
			  System.out.println("Click on Hamburger Menu");
			  this.clickHamburgerMenu();
			
			  //Click on Log buttons
			  WebElement LogButton=driver.findElement(By.id("logMenu"));
			
			  //Check if Appium needs swipe up or down
			  boolean swipeDownLog=this.swipeVerticalUpOrDown(LogButton);
			  if (swipeDownLog){
			  this.swipingDownVerticalByElementName(LogButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(LogButton);
			  }
			  
			  System.out.println("Click on Log Icon");
			  LogButton.click();
			//check if loading amination is displaying or not.
			  this.waitForProgressionAnimation();
			  
			  Thread.sleep(3000);
		//go back to OCA Menu Page
			  System.out.println("Click on Hamburger Menu");
			  this.clickHamburgerMenu();
			
			  //Click on Risk buttons
			  WebElement RiskButton=driver.findElement(By.id("riskMenu"));
			//Check if Appium needs swipe up or down
			  boolean swipeDownRisk=this.swipeVerticalUpOrDown(RiskButton);
			  if (swipeDownRisk){
			  this.swipingDownVerticalByElementName(RiskButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(RiskButton);
			  }
			  System.out.println("Click on Risk Icon");
			  RiskButton.click();
				//check if loading amination is displaying or not.
			  this.waitForProgressionAnimation();
			  Thread.sleep(3000);
			  //this.swipingVertical();
		//go back to OCA Menu Page
			  System.out.println("Click on Hamburger Menu");
			  this.clickHamburgerMenu();
			
			  
			  //Click on Report buttons
			  WebElement RportButton=driver.findElement(By.id("reportMenu"));
			//Check if Appium needs swipe up or down
			  boolean swipeDownRport=this.swipeVerticalUpOrDown(RportButton);
			  if (swipeDownRport){
			  this.swipingDownVerticalByElementName(RportButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(RportButton);
			  }
			  
			  System.out.println("Click on Report Icon");
			  RportButton.click();
				//check if loading amination is displaying or not.
			  this.waitForProgressionAnimation();
			  Thread.sleep(3000);
		//go back to OCA Menu Page
			  System.out.println("Click on Hamburger Menu");
			  this.clickHamburgerMenu();
			
			  
			  //Click on Asset button
			  WebElement AssetButton=driver.findElement(By.id("assetMenu"));
			 
			  //Check if Appium needs swipe up or down
			  boolean swipeDownAsset=this.swipeVerticalUpOrDown(AssetButton);
			  if (swipeDownAsset){
			  this.swipingDownVerticalByElementName(AssetButton);
			  }
			  else{
				  this.swipingUpVerticalByElementName(AssetButton);
			  }
			  
			  System.out.println("Click on Asset Icon");
			  AssetButton.click();
			//check if loading amination is displaying or not.
			  this.waitForProgressionAnimation();
			  
			  Thread.sleep(3000);
		//click on HamburgerMenu and go back to OCA Menu Page
			  System.out.println("Click on Hamburger Menu");
			  this.clickHamburgerMenu();
			  Thread.sleep(3000);
						  			  
		 
	  }
	  
	  @AfterClass
	  public void treadDown(){
		  driver.quit();
	  }
	  
	  
 

}
