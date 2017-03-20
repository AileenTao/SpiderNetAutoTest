package com.spidernet.autotest.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonUtils {
	/**
	 * 
	 * @param driver
	 * @param by
	 * @return
	 */
	public static boolean isElementPresent(WebDriver driver,By by) { 
    	try { 
    		driver.findElement(by); 
    		return true; 
    	} catch (Exception e) { 
    		e.printStackTrace(); 
    		return false; 
    	} 
    }
	/**
	 * 
	 * @param driver
	 * @return
	 * @throws IOException
	 */
	public static WebDriver createDriver(WebDriver driver) throws IOException {
		if(null==driver){
			System.setProperty(ConfigFile.getConfigProperties("driver"),ConfigFile.getConfigProperties("driverPath"));
			driver = new FirefoxDriver();
			//Put a Implicit wait, will wait for 10 seconds before throwing exception
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		return driver;
	}
	/**
	 * 
	 * @param driver
	 */
	public static void closeDriver(WebDriver driver) {
		if(null!=driver){
			driver.close();
			driver=null;
		}
	}
}
