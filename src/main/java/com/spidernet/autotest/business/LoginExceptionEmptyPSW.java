package com.spidernet.autotest.business;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class LoginExceptionEmptyPSW implements IBusiness {
	
	public boolean excute(WebDriver driver) throws Exception{
		
		driver.navigate().to(ConfigFile.getConfigProperties("URL"));
		
		ConfigFile.appendContentToLogFile("***** CASE loginExceptionEmptyPSW ***** ");
		
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
			driver.findElement(By.xpath(ConfigFile.getElementProperties("username"))).sendKeys(ConfigFile.getValueProperties("username5"));
			
			ConfigFile.appendContentToLogFile("Testing with username5:");
			ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("username5"));
			
			//Find the element of password and put into it.
			driver.findElement(By.xpath(ConfigFile.getElementProperties("password"))).sendKeys(ConfigFile.getValueProperties("password5"));
			
			ConfigFile.appendContentToLogFile("Testing with password5:");
			ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("password5"));
		
			//Click on the logon button
			driver.findElement(By.xpath(ConfigFile.getElementProperties("logonButton"))).click();

			//Put a Implicit wait, will wait for 10 seconds before throwing verification
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			
			
			if(CommonUtils.isElementPresent(driver,By.xpath(ConfigFile.getElementProperties("inputPSW"))))
			{
				WebElement logoelement2 = driver.findElement(By.xpath(ConfigFile.getElementProperties("inputPSW")));
				ConfigFile.appendContentToLogFile(logoelement2.getText());
				return true;
			}
			
			else 
			{
				return false;
			}
		}
			
		else			
		{
			return false;
		}
	}

}
