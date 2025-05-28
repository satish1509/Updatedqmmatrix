package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.utils.EleInt;

public class CustomerDetailsPage {
	EleInt elem;
	
    public  CustomerDetailsPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
    }

	@FindBy(xpath="//input[@name='propertyhouseNo']")
	WebElement houseno;
	public void enterhouseno(String val)
	{
		houseno.sendKeys(val);
	}
   
     
   

}
