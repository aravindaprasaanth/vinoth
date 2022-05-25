package com.Driven;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

public class CopyExcel2 extends libGlobal{

	public static void main(String[] args) throws IOException {
		libGlobal c=new libGlobal();
		c.getDriver();
		c.loadUrl("https://adactinhotelapp.com/");
		WebElement id = c.findElementById("username");
		String data = c.getData("Sheet1", 1, 0);
		c.type(id, data);
		WebElement id2 = c.findElementById("password");
		String data2 = c.getData("Sheet1", 2, 1);
		c.type(id2, data2);
		
		 
		

	}

}
