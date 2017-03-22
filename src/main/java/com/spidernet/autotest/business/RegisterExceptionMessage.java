package com.spidernet.autotest.business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class RegisterExceptionMessage implements IBusiness {
	

	public boolean excute(WebDriver driver) throws Exception{
		
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
				ConfigFile.appendContentToLogFile("Setp1: Register employee page is opened successfully");					
					
				//Put a Implicit wait, will wait for 5 seconds before verification
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
														
				//Click the Register button 
				driver.findElement(By.xpath(ConfigFile.getElementProperties("registerSubmitButton"))).submit();
					
				Thread.sleep(10000);
				
				boolean mark = true;
				
				//Verify error message will display if user did not input ER NO。
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("InputErNoMsg"))).getText().equals("请输入ER号"))
				{
					ConfigFile.appendContentToLogFile("Step2: Please input ER No..");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputErNoMsg"))).getText());
						
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step2: Register new employee with ER No..");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputErNoMsg"))).getText());
						
					mark = false;
				}
					
				//Verify error message will display if user did not input HR NO。
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("InputHrNoMsg"))).getText().equals("请输入HR号"))
				{
					ConfigFile.appendContentToLogFile("Step3: Please input ER No..");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputHrNoMsg"))).getText());
						
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step3: Register new employee with HR No..");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputHrNoMsg"))).getText());
						
					mark = false;
				}
				
                //Verify error message will display if user did not input Chinese Name。
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("InputChineseNameMsg"))).getText().equals("请输入中文名"))
				{
					ConfigFile.appendContentToLogFile("Step4: Please input Chinese Name.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputChineseNameMsg"))).getText());
						
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step4: Register new employee with Chinese Name.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputChineseNameMsg"))).getText());
						
					mark = false;
				}
				
                //Verify error message will display if user did not input English Name。
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("InputEngNameMsg"))).getText().equals("请输入英文名"))
				{
					ConfigFile.appendContentToLogFile("Step5: Please input English Name.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputEngNameMsg"))).getText());
						
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step5: Register new employee with English Name.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputEngNameMsg"))).getText());
						
					mark = false;
				}
				
                //Verify error message will display if user did not input Role。
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("InputRoleMsg"))).getText().equals("请选择角色"))
				{
					ConfigFile.appendContentToLogFile("Step6: Please input Role.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputRoleMsg"))).getText());
						
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step6: Register new employee with Role.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputRoleMsg"))).getText());
						
					mark = false;
				}
             
				//Verify error message will display if user did not input Level。
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("InputLevelMSg"))).getText().equals("请选择级别"))
				{
					ConfigFile.appendContentToLogFile("Step7: Please input Level.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputLevelMSg"))).getText());
						
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step7: Register new employee with level.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputLevelMSg"))).getText());
						
					mark = false;
				}
				
                //Verify error message will display if user did not input project。
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("InputProjectMsg"))).getText().equals("请选择项目"))
				{
					ConfigFile.appendContentToLogFile("Step8: Please input Project.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputProjectMsg"))).getText());
						
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step8: Register new employee with project.");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("InputProjectMsg"))).getText());
						
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
