package AutomnationSupportClasses;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class captureScreenShot {
	public void takeScreenShot(WebDriver driver,String FileName){
		 String destinationDirectory = "screenshots";
		 //pause for 3 secs so page loads up
		 try {
			 Thread.sleep(3000);
		 	} catch (InterruptedException e1) {
		 	  e1.printStackTrace();
		 	}
		 //get current date
		 DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss.SSS");
		 Date currentDate=new Date();
		 String DateTimeStr=dateFormat.format(currentDate);

		  // Take screenshot and store as a file format
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		// Create folder under project with name "screenshots" provided to destDir
		 
		  try{
		  					  
			// Create one directory
			  boolean success = (
			  new File(destinationDirectory)).mkdir(); // Create folder under project with name "screenshots" provided to destDir.
			  
			  if (success) {
				  System.out.println("Directory: " + destinationDirectory + " created");
				  }  
			  
		  }
		  catch(Exception e){//Catch exception if any
			  	System.err.println("Error: " + e.getMessage());
		  }
		  
		  //create a new file under newly created directory and save the file
		  	try {
		  		// now copy the  screenshot to desired location using copyFile method

		  		FileUtils.copyFile(src, new File(destinationDirectory+"\\"+FileName+"DateTime"+DateTimeStr+".png"));
		       }

		  	catch (IOException e)

		  	{

		  		System.out.println(e.getMessage());

		    }

		}
}

