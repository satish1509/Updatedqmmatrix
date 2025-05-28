package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.driverfactory.DriverFactory;
import com.qa.utils.EleInt;

public class Homepage {
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	

}
