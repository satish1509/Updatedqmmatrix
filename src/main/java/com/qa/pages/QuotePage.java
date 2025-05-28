package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.driverfactory.DriverFactory;

public class QuotePage {
	
	public QuotePage(WebDriver driver) // parameterized constructor create
	{
		PageFactory.initElements(driver, this); // initialize the webelement
	}

	
}
