package com.spidernet.autotest.business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class LogOff implements IBusiness {
	
	public boolean excute(WebDriver driver) throws Exception{
		
		if (CommonUtils.isElementPresent(driver,By.xpath(ConfigFile.getElementProperties("uerButton"))))
		{
			driver.findElement(By.xpath(ConfigFile.getElementProperties("uerButton"))).click();
			
			if (CommonUtils.isElementPresent(driver,By.xpath(ConfigFile.getElementProperties("logOffButton"))))
			{
				driver.findElement(By.xpath(ConfigFile.getElementProperties("logOffButton"))).click();
				
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
				
				if (CommonUtils.isElementPresent(driver,By.xpath(ConfigFile.getElementProperties("logonButton"))))
				{
					WebElement logoelement1 = driver.findElement(By.xpath(ConfigFile.getElementProperties("logonButton")));
				
					if(logoelement1.getText().equals("登录"))
					{
						ConfigFile.appendContentToLogFile("The user has logged off successfully");
					}
					return true;
				}
				
				else
				{
					ConfigFile.appendContentToLogFile("Logging off failed");
					return false;
				}
			}
			else
			{
				ConfigFile.appendContentToLogFile("Can not find the logoff button");
				return false;
			}
		}
		else
		{
			ConfigFile.appendContentToLogFile("Can not find the user button");
			return false;
		}
				
	}

}
