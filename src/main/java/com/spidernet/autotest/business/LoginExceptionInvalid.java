package com.spidernet.autotest.business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class LoginExceptionInvalid implements IBusiness {
	
	
	public boolean excute(WebDriver driver) throws Exception{
		
		driver.navigate().to(ConfigFile.getConfigProperties("URL"));
		
		//Date currentDate = new Date();
	    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
	    //ConfigFile.appendContentToLogFile(sdf.format(currentDate));
		
		ConfigFile.appendContentToLogFile("***** CASE loginExceptionInvalid ***** ");
		
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
			driver.findElement(By.xpath(ConfigFile.getElementProperties("username"))).sendKeys(ConfigFile.getValueProperties("username1"));
			
			ConfigFile.appendContentToLogFile("Testing with username1:");
			ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("username1"));
			
			//Find the element of password and put into it.
			driver.findElement(By.xpath(ConfigFile.getElementProperties("password"))).sendKeys(ConfigFile.getValueProperties("password1"));
			
			ConfigFile.appendContentToLogFile("Testing with password1:");
			ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("password1"));
			
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
		    	WebElement logoelement3 = driver.findElement(By.xpath(ConfigFile.getElementProperties("logonAlert")));
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