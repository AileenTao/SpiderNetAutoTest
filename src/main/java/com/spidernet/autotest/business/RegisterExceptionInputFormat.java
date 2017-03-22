package com.spidernet.autotest.business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class RegisterExceptionInputFormat implements IBusiness {
	

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
				
				//Exception for special characters
				//Find the element of ER number and input number
				driver.findElement(By.xpath(ConfigFile.getElementProperties("erNumber"))).sendKeys(ConfigFile.getValueProperties("erNumber2"));
				
				ConfigFile.appendContentToLogFile("ER Number:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("erNumber2"));
				
				//Find the element of HR number and input number
				driver.findElement(By.xpath(ConfigFile.getElementProperties("hrNumber"))).sendKeys(ConfigFile.getValueProperties("hrNumber2"));
				
				ConfigFile.appendContentToLogFile("HR Number:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("hrNumber2"));
					
				
				//Find the element of Chinese name and input name
				driver.findElement(By.xpath(ConfigFile.getElementProperties("chineseName"))).sendKeys(ConfigFile.getValueProperties("chineseName2"));
				
				ConfigFile.appendContentToLogFile("Chinese name:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("chineseName2"));
				
				//Find the element of English Name and input name
				driver.findElement(By.xpath(ConfigFile.getElementProperties("englishName"))).sendKeys(ConfigFile.getValueProperties("englishName2"));
				
				ConfigFile.appendContentToLogFile("English Name:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("englishName2"));
					
				driver.findElement(By.xpath(ConfigFile.getElementProperties("empType")));
				Thread.sleep(3000);	
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("erFormatAlert"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Step2: Special characters are not allowed in ER number. Alert is shown as following:");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("erFormatAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step2: No alert for special characters for ER number");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("erFormatAlert"))).getText());
					mark = false;
				}
				
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("hrFormatAlert"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Step3: Special characters are not allowed in HR Number. Alert is shown as following:");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("hrFormatAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step3: No alert for special characters for HR number");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("hrFormatAlert"))).getText());
					
					mark = false;
				}
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("chNameSpecCharAlert"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Step4: Special characters are not allowed in Chinese Name. Alert is shown as following:");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("chNameSpecCharAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step4: No alert for special characters for Chinese Name");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("chNameSpecCharAlert"))).getText());
					mark = false;
				}
				
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("enNameSpecCharAlert"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Step5: Special characters are not allowed in English name. Alert is shown as following:");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("enNameSpecCharAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step5: No alert for special characters for English Name");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("enNameSpecCharAlert"))).getText());
					
					mark = false;
				}
				
				Thread.sleep(3000);	
				
				
				
				//Exception for long input 
				driver.findElement(By.xpath(ConfigFile.getElementProperties("registerMenu"))).click();
				
				driver.findElement(By.xpath(ConfigFile.getElementProperties("erNumber"))).sendKeys(ConfigFile.getValueProperties("erNumber3"));
				
				ConfigFile.appendContentToLogFile("ER Number:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("erNumber3"));
				
				driver.findElement(By.xpath(ConfigFile.getElementProperties("hrNumber"))).sendKeys(ConfigFile.getValueProperties("hrNumber3"));
				
				ConfigFile.appendContentToLogFile("HR Number:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("hrNumber3"));				
				
				driver.findElement(By.xpath(ConfigFile.getElementProperties("chineseName"))).sendKeys(ConfigFile.getValueProperties("chineseName3"));
				
				ConfigFile.appendContentToLogFile("Chinese name:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("chineseName3"));				

				driver.findElement(By.xpath(ConfigFile.getElementProperties("englishName"))).sendKeys(ConfigFile.getValueProperties("englishName3"));
				
				ConfigFile.appendContentToLogFile("English Name:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("englishName3"));
					
				driver.findElement(By.xpath(ConfigFile.getElementProperties("empType")));
				Thread.sleep(3000);	
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("erFormatAlert"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Step6: Testing with long ER number. Alert is shown as following:");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("erFormatAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step6: No alert for long ER number");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("erFormatAlert"))).getText());
					mark = false;
				}
				
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("hrFormatAlert"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Step7: Testing with long HR Number. Alert is shown as following:");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("hrFormatAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step7: No alert for long HR number");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("hrFormatAlert"))).getText());
					
					mark = false;
				}
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("chNameLenghAlert"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Step8: Testing with long Chinese Name. Alert is shown as following:");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("chNameLenghAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step8: No alert for long Chinese Name");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("chNameLenghAlert"))).getText());
					mark = false;
				}
				
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("enNameLenghAlert"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Step9: Testing with long English name. Alert is shown as following:");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("enNameLenghAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step9: No alert for long English Name");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("enNameLenghAlert"))).getText());
					
					mark = false;
				}
				
				Thread.sleep(3000);
				
				
				//Exception for short input 
				driver.findElement(By.xpath(ConfigFile.getElementProperties("registerMenu"))).click();
				
				driver.findElement(By.xpath(ConfigFile.getElementProperties("erNumber"))).sendKeys(ConfigFile.getValueProperties("erNumber4"));
				
				ConfigFile.appendContentToLogFile("ER Number:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("erNumber4"));
				
				driver.findElement(By.xpath(ConfigFile.getElementProperties("hrNumber"))).sendKeys(ConfigFile.getValueProperties("hrNumber4"));
				
				ConfigFile.appendContentToLogFile("HR Number:");
				ConfigFile.appendContentToLogFile(ConfigFile.getValueProperties("hrNumber4"));				
				
				driver.findElement(By.xpath(ConfigFile.getElementProperties("chineseName")));
				
				Thread.sleep(3000);	
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("erFormatAlert"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Step10: Testing with short ER number. Alert is shown as following:");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("erFormatAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step10: No alert for short ER number");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("erFormatAlert"))).getText());
					mark = false;
				}
				
				
				if (driver.findElement(By.xpath(ConfigFile.getElementProperties("hrFormatAlert"))).isDisplayed())
				{
					ConfigFile.appendContentToLogFile("Step11: Testing with short HR Number. Alert is shown as following:");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("hrFormatAlert"))).getText());
					
				}
				else 
				{
					ConfigFile.appendContentToLogFile("Step11: No alert for short HR number");
					ConfigFile.appendContentToLogFile(driver.findElement(By.xpath(ConfigFile.getElementProperties("hrFormatAlert"))).getText());
					
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
