package com.qa.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.utils.ConfigReader;
import com.qa.utils.TestUtility;

public class BuzzPage extends TestUtility {

    WebDriver driver;

    ConfigReader config = new ConfigReader(); // ConfigReader instance

    // Constructor
    public BuzzPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ========== WebElements ==========

    @FindBy(xpath = "//span[text()='Buzz']")
    WebElement buzzTab;

    @FindBy(xpath = "//*[text()='Buzz Newsfeed']")
    WebElement buzzNewsfeedLabel;

    @FindBy(xpath = "//form/div/textarea")
    WebElement buzzTextArea;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement postButton;

    @FindBy(xpath = "//*[text()='I'm in tata consultancy services']")
    WebElement postedMessage;

    // ========== Methods ==========

    public void clickBuzzTab() throws InterruptedException {
        clickElement(buzzTab);
        Thread.sleep(3000);
    }

    public void verifyBuzzNewsfeedDisplayed() {
        printIfDisplayed(buzzNewsfeedLabel);
    }

    public void enterBuzzMessage(String message) {
        enterText(buzzTextArea, message);
    }

    public void clickPostButton() {
        clickElement(postButton);
    }

    public void verifyPostedMessageDisplayed() {
        printIfDisplayed(postedMessage);
    }
}
