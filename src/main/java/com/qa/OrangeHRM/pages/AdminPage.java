package com.qa.OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestUtility;

public class AdminPage extends TestUtility {

    WebDriver driver;

    // Constructor
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements using @FindBy
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminTab;

    @FindBy(xpath = "//button[text()=' Add ']")
    WebElement addButton;

    @FindBy(xpath = "(//div[text()='-- Select --'])[1]")
    WebElement userRoleDropdown;

    @FindBy(xpath = "(//*[text()='Admin'])[3]")
    WebElement userRoleOptionAdmin;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameInput;

    @FindBy(xpath="//span[text()='Kathleen  Abshire']")
    WebElement employeename;
    @FindBy(xpath = "(//*[text()='-- Select --'])[1]")
    WebElement statusDropdown;

    @FindBy(xpath = "//span[text()='Enabled']")
    WebElement statusEnabled;

    @FindBy(xpath = "(//*[text()='Enabled'])/following::input[1]")
    WebElement usernameInput;

    @FindBy(xpath = "(//*[text()='Enabled'])/following::input[2]")
	static
    WebElement passwordInput;

    @FindBy(xpath = "(//*[text()='Enabled'])/following::input[3]")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
     WebElement successMessageToast;
    
    @FindBy(xpath="//input[@placeholder='Type for hints...']/preceding::div[text()='-- Select --']")
    WebElement adminselect;

    @FindBy(xpath="//div[@class='oxd-select-text--after']/following::span[text()='Admin']")
    WebElement adminvalue;
    
    @FindBy(xpath="//input[@placeholder='Type for hints...']/following::div[@class='oxd-select-text-input']")
    WebElement status;
    @FindBy(xpath="//div[@class='oxd-select-text-input']/following::span[text()='Enabled']")
    WebElement enabled;
    @FindBy(xpath="//div[@class='oxd-table-body']")
    WebElement results;
    
    @FindBy(xpath="//label[text()='Username']/following::input[@class='oxd-input oxd-input--active']")
    WebElement usernamesearch;

    // ============ Methods ============

    public void clickAdminTab() {
        clickElement(adminTab);
    }

    public void clickAddButton() {
        clickElement(addButton);
    }

    public void selectUserRoleAdmin() {
        clickElement(userRoleDropdown);
        clickElement(userRoleOptionAdmin);
    }

    public void clickonemployeenamefield() {
        clickElement(employeeNameInput);
    }

    public void entername(String name) {
        enterText(employeeNameInput, name);
    }

    public void selectemployee() {
        clickElement(employeename);  // assuming employeename is a WebElement like the dropdown option
    }

    // Method to return a dynamic locator for employee name option
    

    public void selectStatusEnabled() {
        clickElement(statusDropdown);
        clickElement(statusEnabled);
    }

    public  void enterUsername() {
    	TestUtility.enterRandomUsername(usernameInput);
    }

    public static void enterPassword() {
        enterRandomPassword(passwordInput);
    }
    public void enterConfirmPassword() {
        String confirmPassword = TestUtility.getRandomPassword();
        confirmPasswordInput.sendKeys(confirmPassword);
        System.out.println("Entered Confirm Password: " + confirmPassword);
    }
    	
    
    

    public void clickSubmit() {
        clickElement(submitButton);
    }
    public void detailssaved() {
    	printIfDisplayed(successMessageToast);
    	
    }
    public void clickonuserrole() {
    	clickElement(adminselect);
    }

    public void selectadmin() {
    	clickElement(adminvalue);
    }
    
    public void clickonstatus() {
    	clickElement(status);

    }
    public void selectenable() {
    	clickElement(enabled);

    }
    public void validate() {
    	printIfDisplayed(results);
    }
    
    public void usernameinput(String data) {
    	TestUtility.enterText(usernamesearch, data);

    	
    }
}
