package com.spidernet.autotest.business;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class RegisterNormal implements IBusiness 
{
	

	public boolean excute(WebDriver driver) throws Exception
	{
		
		driver.findElement(By.xpath(ConfigFile.getElementProperties("registerMenu"))).click();
		
		
		//Put a Implicit wait, will wait for 5 seconds before verification
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	    String currentURL2 = driver.getCurrentUrl();
	    ConfigFile.appendContentToLogFile("Opening register employee page: ");
		ConfigFile.appendContentToLogFile(currentURL2);
	    
	    
	    //Verify if register page is opened successfully
		if (CommonUtils.isElementPresent(driver,By.xpath(ConfigFile.getElementProperties("registerHeader"))))
		{
			if (driver.findElement(By.xpath(ConfigFile.getElementProperties("registerHeader"))).getText().equals("新员工注册"))
			{
				ConfigFile.appendContentToLogFile("Setp3: Register employee page is opened successfully");					
				
				//Find the element of ER number and input number
				driver.findElement(By.xpath(ConfigFile.getElementProperties("erNumber"))).sendKeys(ConfigFile.getValueProperties("erNumber"));
				
				ConfigFile.appendContentToLogFile("ER Number:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("erNumber"));
				
				//Find the element of HR number and input number
				driver.findElement(By.xpath(ConfigFile.getElementProperties("hrNumber"))).sendKeys(ConfigFile.getValueProperties("hrNumber"));
				
				ConfigFile.appendContentToLogFile("HR Number:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("hrNumber"));
				
				//Find the element of Chinese name and input name
				driver.findElement(By.xpath(ConfigFile.getElementProperties("chineseName"))).sendKeys(ConfigFile.getValueProperties("chineseName"));
				
				ConfigFile.appendContentToLogFile("Chinese name:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("chineseName"));
				
				//Find the element of English Name and input name
				driver.findElement(By.xpath(ConfigFile.getElementProperties("englishName"))).sendKeys(ConfigFile.getValueProperties("englishName"));
				
				ConfigFile.appendContentToLogFile("English Name:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("englishName"));
				
				//Find the element of Employee type and input 
				Select empType = new Select(driver.findElement(By.xpath(ConfigFile.getElementProperties("empType"))));
				empType.selectByVisibleText(ConfigFile.getValueProperties("empType"));
				
				ConfigFile.appendContentToLogFile("Employee type:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("empType"));
				
				
				//Find the element of Employee level and input 
				Select empLevel = new Select(driver.findElement(By.xpath(ConfigFile.getElementProperties("empLevel"))));
				empLevel.selectByVisibleText(ConfigFile.getValueProperties("empLevel"));
				ConfigFile.appendContentToLogFile("Employee level:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("empLevel"));
				
				//Find the element of Project name and input 
				Select projectName = new Select(driver.findElement(By.xpath(ConfigFile.getElementProperties("projectName"))));
				projectName.selectByVisibleText(ConfigFile.getValueProperties("projectName"));
				
				ConfigFile.appendContentToLogFile("Project name:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("projectName"));
				
				//Put a Implicit wait, will wait for 5 seconds before verification
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("map"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Setp4: Capability map is activated successfully.");
					
					//Select the item of capability map
					List<WebElement> checks = driver.findElements(By.cssSelector("input[type=checkbox]"));
					for(WebElement check:checks)
					{
						check.click();
					}
					
					//Put a Implicit wait, will wait for 5 seconds before verification
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					Thread.sleep(5000);
					
			        //Click the cancel button of capability map
					driver.findElement(By.xpath(ConfigFile.getElementProperties("mapCancel"))).click();
					
					//Re_sumbit Register button.
					projectName.selectByVisibleText(ConfigFile.getValueProperties("projectName_null"));
					
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					Thread.sleep(5000);
					
					projectName.selectByVisibleText(ConfigFile.getValueProperties("projectName"));
					
					for (int i =0;i< checks.size();i++)
					{
						checks.get(i);
						if (driver.findElement(By.cssSelector("input[type=checkbox]")).isSelected())
						{
							ConfigFile.appendContentToLogFile("Setp5: Cancel Button can work");
		
						}
						else
						{
							ConfigFile.appendContentToLogFile("Setp5: Cancel Button can not Work");
						}
					}
					//Click the submit button of capability map 
					driver.findElement(By.xpath(ConfigFile.getElementProperties("mapSubmit"))).click();
					
					ConfigFile.appendContentToLogFile("Setp6: Submit capability map.");
														
					//Click the Register button 
					driver.findElement(By.xpath(ConfigFile.getElementProperties("registerSubmitButton"))).submit();
					
					Thread.sleep(1000);
					if (driver.findElement(By.xpath(ConfigFile.getElementProperties("registerAlert"))).isDisplayed())
					{
						ConfigFile.appendContentToLogFile("Step7: Register the new employee.");
						ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("registerAlert"))).getText());
						
						return true;
					}
					else 
					{
						ConfigFile.appendContentToLogFile("Step7: Registering the new employee failed.");
						ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("registerAlert"))).getText());
						
						return false;
					}
					
				}
				else
				{
					ConfigFile.appendContentToLogFile("Setp4: Capability map is not activated.");	
					return false;
				}
			}
			else
			{
				ConfigFile.appendContentToLogFile("Setp3: Openning Register employee page failed. Current page is :");	
				ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("registerHeader"))).getText());
				return false;
			}
			
		}
		else
		{
			ConfigFile.appendContentToLogFile("Setp3: Openning Register employee page failed");
			return false;
		}
		
	}

}
