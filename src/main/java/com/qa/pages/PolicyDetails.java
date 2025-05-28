package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PolicyDetails {
	
	public PolicyDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

}
