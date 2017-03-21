package com.spidernet.autotest.business;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.spidernet.autotest.business.IBusiness;
import com.spidernet.autotest.business.LoginNormal;
import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class TestRegisterPage {
	
	static WebDriver driver = null;
	
	@BeforeClass
	public static void createDriver()  {
		try{
			driver = CommonUtils.createDriver(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public static void closeDriver() {
		CommonUtils.closeDriver(driver);		
	}

	@Test
	public void testExcute() {
		try{
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
				boolean result = object.excute(driver);
				if(result){
					ConfigFile.appendContentToLogFile("******* Case Pass :) ******* ");
					Assert.assertTrue(result);
				}
				else
				{
					ConfigFile.appendContentToLogFile("******* Case Fail :( ******* ");
				}	
				Thread.sleep(1000);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
