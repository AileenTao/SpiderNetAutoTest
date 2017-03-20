package com.spidernet.autotest.business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

//public static WebDriver createDriver(WebDriver driver) throws IOException {
public class LoginNormal  implements IBusiness {
	private String userName=null;
	private String password=null;
	public boolean excute(WebDriver driver) throws Exception{
		
		driver.navigate().to(ConfigFile.getConfigProperties("URL"));
		
		//String currentURL1 = driver.getCurrentUrl();
		//ConfigFile.appendContentToLogFile("Opening logon page with URL: ");
		//ConfigFile.appendContentToLogFile(currentURL1);
		
		ConfigFile.appendContentToLogFile("***** CASE loginNormal ***** ");
		
		if (CommonUtils.isElementPresent(driver,By.xpath(ConfigFile.getElementProperties("logonButton"))))
		{
			WebElement logoelement1 = driver.findElement(By.xpath(ConfigFile.getElementProperties("logonButton")));
			
			if(logoelement1.getText().equals("登录"))
			{
				ConfigFile.appendContentToLogFile("Setp1: The logon page is opened successfully");
			}
			
			//Maximize the browser
			driver.manage().window().maximize();
			
			String inputUserName=null;
			//Find the element of name and put into it
			if(null!=this.userName){
				inputUserName=this.userName;
			}else{
				inputUserName=ConfigFile.getValueProperties("username");
			}
			driver.findElement(By.xpath(ConfigFile.getElementProperties("username"))).sendKeys(inputUserName);
			
			ConfigFile.appendContentToLogFile("Testing with username:");
			ConfigFile.appendContentToLogFile(inputUserName);
			
			String inputPassword=null;
			//Find the element of password and put into it.
			if(null!=this.password){
				inputPassword=this.password;
			}else{
				inputPassword=ConfigFile.getValueProperties("password");
			}
			driver.findElement(By.xpath(ConfigFile.getElementProperties("password"))).sendKeys(inputPassword);
			
			ConfigFile.appendContentToLogFile("Testing with password:");
			ConfigFile.appendContentToLogFile(inputPassword);
			
			//Click on the logon button
			driver.findElement(By.xpath(ConfigFile.getElementProperties("logonButton"))).click();
			
			//Put a Implicit wait, will wait for 10 seconds before throwing verification
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			//Verify if logon successfully
			
		    if (CommonUtils.isElementPresent(driver,By.xpath(ConfigFile.getElementProperties("userinfo")))){
		    	
		    	WebElement logoelement2 = driver.findElement(By.xpath(ConfigFile.getElementProperties("userinfo")));
		    	
		    	if(logoelement2.getText().equals(ConfigFile.getValueProperties("userinfo")))
				{
				    ConfigFile.appendContentToLogFile("Step2: Logged on the SpiderNet successfully");
				   
				    return true;
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
		    	ConfigFile.appendContentToLogFile("Step2: Logining the SpiderNet Failed");
		    	return false;
		    } 
		}
		else
		{
			ConfigFile.appendContentToLogFile("Setp1:Opening the logon page Failed");
			return false;
		}
			
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) throws Exception{
		WebDriver driver = null ;
		new LoginNormal().excute(driver);
	}
}
