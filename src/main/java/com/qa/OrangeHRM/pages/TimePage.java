package com.qa.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestUtility;

public class TimePage extends TestUtility {

    WebDriver driver;

    // Constructor
    public TimePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(xpath = "//span[text()='Time']")
    WebElement timeTab;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement welcomepage;

    @FindBy(xpath = "//input[@placeholder='mm-dd-yyyy']")
    WebElement timesheetPeriodInput;

    @FindBy(xpath = "//button[text()=' Submit ']")
    WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast--success')]")
    WebElement successMessageToast;

    // New elements for Timesheet dropdown and My Timesheet
    @FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item' and text()='Timesheets ']")
    WebElement timesheetDropdown;
    @FindBy(xpath = "//p[text()='Timesheet Period']/following::i[@class='oxd-icon bi-chevron-left']")
    private WebElement lastWeek;

    @FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item' and text()='Timesheets ']/following::a[text()='My Timesheets']")
    WebElement myTimesheetOption;

    // ============ Methods ============

    public void clickTimeTab() {
        clickElement(timeTab);
    }

    public void dashboarddisplayed() {
        printIfDisplayed(welcomepage);
    }

    public void isTimesheetPeriodDisplayed() {
        printIfDisplayed(timesheetPeriodInput);
    }

    public void clickSubmitButton() {
        clickElement(submitButton);
    }

    public void verifySubmissionSuccessMessage() {
        printIfDisplayed(successMessageToast);
    }

    // New methods for clicking dropdown and my timesheet
    public void clickTimesheetDropdown() {
        clickElement(timesheetDropdown);
    }

    public void clickMyTimesheet() {
        clickElement(myTimesheetOption);
        clickElement(lastWeek);

    }
}