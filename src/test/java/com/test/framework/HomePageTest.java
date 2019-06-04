

package com.test.framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPageObjects;
import res.base;

public class HomePageTest extends base {
	
	private Logger log =  LogManager.getLogger(HomePageTest.class.getName());
@BeforeTest
public void openBrowser() throws IOException {
	driver=initializeDriver();
	
}
	
	@Test(dataProvider="testData")
	public void navigatingToPage(String username,String email) throws IOException {
		
		//driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		
		LandingPageObjects l = new LandingPageObjects(driver);
	l.register().click();
	l.username().sendKeys(username);
	l.email().sendKeys(email);
		log.debug("To test the debug");
		log.error("to test the error");
	}
	@AfterTest
	public void close() {
		
		driver.close();
	}
	

	
	
	@DataProvider
	public Object testData() {
		Object[][] data  = new Object[2][2];
				//({8,11};(12,9);(10,25));
		data[0][0]="userName1";
		data[0][1]="bksfgsgf@gals.com";
		
		data[1][0]="userName2";
		data[1][1]="bksfgsgf@gals.com";
		return data;
		
	}

}
