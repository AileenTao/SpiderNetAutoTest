package com.spidernet.autotest.business;

import org.openqa.selenium.WebDriver;

public abstract class BaseBusiness {
	
	public WebDriver driver = null;
	
	public abstract boolean execute() throws Exception;
	
}
