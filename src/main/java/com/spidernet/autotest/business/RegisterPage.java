package com.spidernet.autotest.business;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class RegisterPage implements IBusiness{

	public boolean excute(WebDriver driver) throws Exception {
		

		IBusiness loginNormal = new LoginNormal();
		IBusiness registerNormal = new RegisterNormal();
		IBusiness logOff = new LogOff();
		LoginNormal loginNormal2 = new LoginNormal();

		loginNormal2.setUserName(ConfigFile.getValueProperties("erNumber"));
		loginNormal2.setPassword(ConfigFile.getValueProperties("empPassowrd"));
		List<IBusiness> list = new ArrayList<IBusiness>();

		list.add(loginNormal);
		list.add(registerNormal);
		list.add(logOff);
		list.add(loginNormal2);
		
		for(IBusiness object:list){
			if(object.excute(driver)){
				ConfigFile.appendContentToLogFile("******* Case Pass :) ******* ");
			}
			else
			{
				ConfigFile.appendContentToLogFile("******* Case Fail :( ******* ");
				break;
			}	
			Thread.sleep(1000);
				
		}
		
		return true;
	}
	
	
	public static void main(String[] args) throws Exception{
		WebDriver driver = null;
		driver = CommonUtils.createDriver(driver);
		//driver.navigate().to(ConfigFile.getConfigProperties("URL"));

		new RegisterPage().excute(driver);
		
		CommonUtils.closeDriver(driver);
	}
}