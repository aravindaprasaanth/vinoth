package com.Driven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Employee extends libGlobal {
	public static WebDriver driver;
	
	public Employee() {
		PageFactory.initElements(driver, this);
	}
	

	private void BeforeClass() {
	getDriver();
	loadUrl("https://adactinhotelapp.com/");
	maximizeWindow();
	
}
  

}


