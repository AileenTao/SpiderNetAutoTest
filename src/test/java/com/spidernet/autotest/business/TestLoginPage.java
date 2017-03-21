package com.spidernet.autotest.business;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.spidernet.autotest.business.IBusiness;
import com.spidernet.autotest.business.LoginExceptionEmptyName;
import com.spidernet.autotest.business.LoginExceptionInvalid;
import com.spidernet.autotest.business.LoginNormal;
import com.spidernet.autotest.util.CommonUtils;
import com.spidernet.autotest.util.ConfigFile;

public class TestLoginPage {
	
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
			IBusiness loginExceptionInvalid = new LoginExceptionInvalid();
			IBusiness loginExceptionEmptyName = new LoginExceptionEmptyName();
			IBusiness loginExceptionEmptyPSW = new LoginExceptionEmptyPSW();
			IBusiness loginExceptionNamewithSpecialChar = new LoginExceptionNamewithSpecialChar();
			IBusiness loginExceptionLongName = new LoginExceptionLongName();
			IBusiness loginExceptionLongPSW = new LoginExceptionLongPSW();
			LoginNormal loginNormal = new LoginNormal();
			//loginNormal.setUserName(userName);
			
			List<IBusiness> list = new ArrayList<IBusiness>();
			list.add(loginExceptionEmptyName);
			list.add(loginExceptionEmptyPSW);
			list.add(loginExceptionInvalid);
			list.add(loginExceptionNamewithSpecialChar);
			list.add(loginExceptionLongName);
			list.add(loginExceptionLongPSW);
			list.add(loginNormal);
			
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
