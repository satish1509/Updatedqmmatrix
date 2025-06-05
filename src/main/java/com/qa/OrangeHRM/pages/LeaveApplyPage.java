package com.qa.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.utils.TestUtility;

public class LeaveApplyPage {

    WebDriver driver;

    public LeaveApplyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Menu navigation
    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leaveTab;

    @FindBy(xpath = "//a[text()='Apply']")
    private WebElement applyLeaveButton;

    // Leave type
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
    private WebElement leaveTypeDropdown;

    @FindBy(xpath = "//span[text()='Casual Leave']")
    private WebElement casualLeaveOption;

    // From and To Dates
    @FindBy(xpath = "//div[@class='oxd-date-input']/preceding::input[@placeholder='mm-dd-yyyy']")
    private WebElement fromDateInput;

    @FindBy(xpath = "//div[@class='oxd-date-input']/preceding::input[@placeholder='mm-dd-yyyy']/following::div[text()='9']")
    private WebElement fromDateSelect;

    @FindBy(xpath = "//div[@class='oxd-date-input']/following::input[@placeholder='mm-dd-yyyy']")
    private WebElement toDateInput;

    @FindBy(xpath = "//div[@class='oxd-date-input']/following::input[@placeholder='mm-dd-yyyy']/following::div[text()='10']")
    private WebElement toDateSelect;

    // Partial Days
    @FindBy(xpath = "(//input[@placeholder='mm-dd-yyyy'])[2]/following::div[@tabindex='0']")
    private WebElement partialDaysDropdown;

    @FindBy(xpath = "//span[text()='Start Day Only']")
    private WebElement startDayOnlyOption;

    @FindBy(xpath = "//div[text()='Start Day Only']/following::*[text()='-- Select --']")
    private WebElement startDayTimeDropdown;

    @FindBy(xpath = "//div[text()='-- Select --']/following::span[text()='Half Day - Morning']")
    private WebElement halfDayMorningOption;

    // Comment
    @FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
    private WebElement commentBox;

    // Submit
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    private WebElement savedEmployeeNameToast;

    // Action methods

    public void clickLeaveTab() {
        TestUtility.clickElement(leaveTab);
    }

    public void clickApplyLeave() {
        TestUtility.clickElement(applyLeaveButton);
    }

    public void selectLeaveType() {
        TestUtility.clickElement(leaveTypeDropdown);
        TestUtility.clickElement(casualLeaveOption);
    }

    public void selectFromDate() {
        TestUtility.clickElement(fromDateInput);
        TestUtility.clickElement(fromDateSelect);
    }

    public void selectToDate() {
        TestUtility.clickElement(toDateInput);
        TestUtility.clickElement(toDateSelect);
    }

    public void selectPartialDays() throws InterruptedException {
        TestUtility.clickElement(partialDaysDropdown);
        TestUtility.clickElement(startDayOnlyOption);
        TestUtility.clickElement(startDayTimeDropdown);
TestUtility.clickElement(halfDayMorningOption);


    }

    public void enterComment(String comment) {
        TestUtility.enterText(commentBox, comment);
    }

    public void clickSubmit() {
        TestUtility.clickElement(submitButton);
    }
    public void savedsuccessfully() {
    	
    	TestUtility.printIfDisplayed(savedEmployeeNameToast);   
    	}

    // Complete method to apply leave
    public void applyLeave(String comment) throws InterruptedException {
        clickLeaveTab();
        clickApplyLeave();
        selectLeaveType();
        selectFromDate();
        selectToDate();
        selectPartialDays();
        enterComment(comment);
        clickSubmit();
    }
}
