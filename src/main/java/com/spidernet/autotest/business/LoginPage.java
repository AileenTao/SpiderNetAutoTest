package com.spidernet.autotest.business;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class LoginPage  implements IBusiness{

	public boolean excute(WebDriver driver) throws Exception {
		
		IBusiness loginExceptionInvalid = new LoginExceptionInvalid();
		IBusiness loginExceptionEmptyName = new LoginExceptionEmptyName();
		LoginNormal loginNormal = new LoginNormal();
		
		//loginNormal.setUserName(userName);
		
		List<IBusiness> list = new ArrayList<IBusiness>();

		list.add(loginExceptionEmptyName);
		list.add(loginExceptionInvalid);
		list.add(loginNormal);
		
		for(IBusiness object:list){
			if(object.excute(driver)){
				ConfigFile.appendContentToLogFile("******* Case Pass :) ******* ");
			}
			else
			{
				ConfigFile.appendContentToLogFile("******* Case Fail :( ******* ");
			}	
				
		}
		
		return true;
	}
	
	
	public static void main(String[] args) throws Exception{
		WebDriver driver = null;
		driver = CommonUtils.createDriver(driver);
		//driver.navigate().to(ConfigFile.getConfigProperties("URL"));

		new LoginPage().excute(driver);
		
		CommonUtils.closeDriver(driver);
	}
}
