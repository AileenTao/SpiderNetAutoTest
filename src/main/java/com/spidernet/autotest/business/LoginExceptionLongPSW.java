package com.spidernet.autotest.business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class LoginExceptionLongPSW implements IBusiness {
	
	public boolean excute(WebDriver driver) throws Exception{
		
		driver.navigate().to(ConfigFile.getConfigProperties("URL"));
		  
		ConfigFile.appendContentToLogFile("***** CASE loginExceptionLongPSW ***** ");
		
		String currentURL1 = driver.getCurrentUrl();
		ConfigFile.appendContentToLogFile("Opening logon page with URL: ");
		ConfigFile.appendContentToLogFile(currentURL1);
		
		if (CommonUtils.isElementPresent(driver,By.xpath(ConfigFile.getElementProperties("logonButton"))))
		{
			WebElement logoelement1 = driver.findElement(By.xpath(ConfigFile.getElementProperties("logonButton")));
			
			if(logoelement1.getText().equals("登录"))
			{
				ConfigFile.appendContentToLogFile("Setp1: The logon page is opened successfully");
			}
			
			//Maximize the browser
			driver.manage().window().maximize();
			
			//Find the element of name and put into it
			driver.findElement(By.xpath(ConfigFile.getElementProperties("username"))).sendKeys(ConfigFile.getValueProperties("username6"));
			
			ConfigFile.appendContentToLogFile("Testing with username6:");
			ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("username6"));
			
			//Find the element of password and put into it.
			driver.findElement(By.xpath(ConfigFile.getElementProperties("password"))).sendKeys(ConfigFile.getValueProperties("password6"));
			
			ConfigFile.appendContentToLogFile("Testing with password6:");
			ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("password6"));
			
			//Click on the logon button
			driver.findElement(By.xpath(ConfigFile.getElementProperties("logonButton"))).click();
			
			//Put a Implicit wait, will wait for 10 seconds before throwing verification
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			
		    if (CommonUtils.isElementPresent(driver,By.xpath(ConfigFile.getElementProperties("userinfo")))){
		    	
		    	WebElement logoelement2 = driver.findElement(By.xpath(ConfigFile.getElementProperties("userinfo")));
		    	
		    	if(logoelement2.getText().equals(ConfigFile.getValueProperties("userinfo")))
				{
				    ConfigFile.appendContentToLogFile("Step2: Logged on the SpiderNet successfully");
				    return false;
				}
		    	else
				{
				    ConfigFile.appendContentToLogFile("Step2: Logged on the SpiderNet but with incorrect user:");
				    ConfigFile.appendContentToLogFile(logoelement2.getText());
				    return false;
				}
		    	
		    }
		    else
		    {
		    	ConfigFile.appendContentToLogFile("Step2: Logining the SpiderNet Failed. The error message is as following:");
		    	WebElement logoelement3 = driver.findElement(By.xpath(ConfigFile.getElementProperties("userNameLengh")));
		    	ConfigFile.appendContentToLogFile(logoelement3.getText());
		    	return true;
		    } 
		}
		else
		{
			ConfigFile.appendContentToLogFile("Setp1:Opening the logon page Failed");
			return false;
		}
		
	}

}
