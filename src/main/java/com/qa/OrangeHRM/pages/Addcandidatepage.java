package com.qa.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestUtility;

public class Addcandidatepage {

    WebDriver driver;

    public Addcandidatepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitmentButton;

    @FindBy(xpath = "//*[text()=' Add ']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//div[text()='-- Select --']")
    private WebElement vacancyDropdown;
    
    @FindBy(xpath = "//span[text()='Automation QA chromium 1747377754679']")
    private WebElement automationQAJobRole;


    @FindBy(xpath = "//input[@placeholder='Type here']/preceding::input[@placeholder='Type here']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Type here']/following::input[@placeholder='Type here']")
    private WebElement contactInput;

    @FindBy(xpath = "//div[text()='Browse']")
    private WebElement browseButton;

    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    private WebElement keywordsInput;

    @FindBy(xpath = "//input[@placeholder='mm-dd-yyyy']")
    private WebElement dateInput;

    @FindBy(xpath = "//input[@placeholder='mm-dd-yyyy']/following::div[text()='4']")
    private WebElement selectDate;

    @FindBy(xpath = "//label[text()='Notes']/following::textarea[@placeholder='Type here']")
    private WebElement notesInput;

    @FindBy(xpath = "//input[@type='checkbox']/following::span")
    private WebElement consentCheckbox;
   
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    WebElement successMessageToast;
    @FindBy(xpath = "//*[text()=' Save ']")
    private WebElement saveButton;
    @FindBy(xpath = "//*[text()=' Shortlist ']")
    private WebElement shortlistButton;



    // ==== Reused Utility Methods ====

    public void clickRecruitment() {
        TestUtility.clickElement(recruitmentButton);
    }

    public void clickAddButton() {
        TestUtility.clickElement(addButton);
    }

    public void enterFirstName() {
        TestUtility.enterRandomFirstName(firstNameInput);
    }

    public void enterMiddleName(String middleName) {
        TestUtility.enterText(middleNameInput, middleName);
    }

    public void enterLastName() {
        TestUtility.enterRandomLastName(lastNameInput);
    }

    public void clickVacancyDropdown() {
        TestUtility.clickElement(vacancyDropdown);
        // Add dropdown handling logic here if needed
    }
    
 

    public void enterEmail(String email) {
        TestUtility.enterText(emailInput, email);
        
    }
    public void vacancies() {
    	TestUtility.clickElement(vacancyDropdown);
        TestUtility.clickElement(automationQAJobRole);

    }

    public void enterContactNumber(String contactNumber) {
        TestUtility.enterText(contactInput, contactNumber);
    }

    public void uploadResume(String filePath) throws Exception {
        TestUtility.clickElement(browseButton);
        TestUtility.fileupload(filePath);
    }
    public void enterdate() {
    	 TestUtility.clickElement(dateInput);
    	 TestUtility.clickElement(selectDate);
    	 TestUtility.clickElement(consentCheckbox);

    	 
    }
    

    public void enterKeywords(String keywords) {
        TestUtility.enterText(keywordsInput, keywords);
    }

    public void pickDate() {
        TestUtility.clickElement(dateInput);
        TestUtility.clickElement(selectDate);
    }
public void entermobilenumber() {
	TestUtility.enterRandomMobileNumber(contactInput);
}
    public void enterNotes(String notes) {
        TestUtility.enterText(notesInput, notes);
    }

    public void clickConsentCheckbox() {
        TestUtility.clickElement(consentCheckbox);
    }

    public void clickSubmitButton() {
        TestUtility.clickElement(submitButton);
    }
    public void detailssaved() {
    	TestUtility.printIfDisplayed(successMessageToast);
    }
    public void clickShortlistButton() {
    	TestUtility.clickElement(shortlistButton);
    }
    public void clickSaveButton() {
    	TestUtility.clickElement(saveButton);
    }

}
