package com.spidernet.autotest.business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class RegisterExceptionExistedUser implements IBusiness {
	

	public boolean excute(WebDriver driver) throws Exception{
		
		driver.findElement(By.xpath(ConfigFile.getElementProperties("registerMenu"))).click();
		
		
		//Put a Implicit wait, will wait for 5 seconds before verification
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	    String currentURL2 = driver.getCurrentUrl();
	    ConfigFile.appendContentToLogFile("Opening register employee page: ");
		ConfigFile.appendContentToLogFile(currentURL2);
	    
		boolean mark = true;
	    //Verify if register page is opened successfully
		if (CommonUtils.isElementPresent(driver,By.xpath(ConfigFile.getElementProperties("registerHeader"))))
		{
			if (driver.findElement(By.xpath(ConfigFile.getElementProperties("registerHeader"))).getText().equals("新员工注册"))
			{
				ConfigFile.appendContentToLogFile("Setp1: Register employee page is opened successfully");					
				
				//Find the element of ER number and input number
				driver.findElement(By.xpath(ConfigFile.getElementProperties("erNumber"))).sendKeys(ConfigFile.getValueProperties("erNumber1"));
				
				ConfigFile.appendContentToLogFile("ER Number:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("erNumber1"));
				
				
				driver.findElement(By.xpath(ConfigFile.getElementProperties("hrNumber"))).sendKeys(ConfigFile.getValueProperties("hrNumber1"));
				
				ConfigFile.appendContentToLogFile("HR Number:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("hrNumber1"));
					
				
				driver.findElement(By.xpath(ConfigFile.getElementProperties("chineseName")));
					
				
				Thread.sleep(2000);	
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("erExistAlert"))).isDisplayed() && driver.findElement(By.xpath(ConfigFile.getElementProperties("erExistAlert"))).getText().equals("ER号已存在"))
				{
					ConfigFile.appendContentToLogFile("Step2: Alert for existed ER number is shown as following.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("erExistAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step2: No alert for existed ER number");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("erExistAlert"))).getText());
					mark = false;
				}
				
				//Find the element of HR number and input number
				
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("hrExistAlert"))).isDisplayed()&& driver.findElement(By.xpath(ConfigFile.getElementProperties("hrExistAlert"))).getText().equals("HR号已存在"))
				{
					ConfigFile.appendContentToLogFile("Step3: Alert for existed HR number is shown as following.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("hrExistAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step3: No alert for existed HR number");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("hrExistAlert"))).getText());
					
					mark = false;
				}
				
				return mark;
			}
			else
			{
				ConfigFile.appendContentToLogFile("Setp1: Openning Register employee page failed. Current page is :");	
				ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("registerHeader"))).getText());
				return false;
			}
			
		}
		else
		{
			ConfigFile.appendContentToLogFile("Setp1: Openning Register employee page failed");
			return false;
		}
		
	}

}
