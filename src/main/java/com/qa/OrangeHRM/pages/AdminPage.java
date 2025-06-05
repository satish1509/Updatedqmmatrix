package com.qa.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.ConfigReader;
import com.qa.utils.TestUtility;

public class AdminPage extends TestUtility {

    WebDriver driver;

    ConfigReader config = new ConfigReader(); // Constructor

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

    @FindBy(xpath = "//span[text()='Kathleen  Abshire']")
    WebElement employeename;

    @FindBy(xpath = "(//*[text()='-- Select --'])[1]")
    WebElement statusDropdown;

    @FindBy(xpath = "//span[text()='Enabled']")
    WebElement statusEnabled;

    @FindBy(xpath = "//div[4]/div/div[2]/input")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@type='password']/preceding::input[@type='password']")
    WebElement passwordInput;  // <-- Made non-static

    @FindBy(xpath = "//input[@type='password']/following::input[@type='password']")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    WebElement successMessageToast;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']/preceding::div[text()='-- Select --']")
    WebElement adminselect;

    @FindBy(xpath = "//div[@class='oxd-select-text--after']/following::span[text()='Admin']")
    WebElement adminvalue;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']/following::div[@class='oxd-select-text-input']")
    WebElement status;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']/following::span[text()='Enabled']")
    WebElement enabled;

    @FindBy(xpath = "//*[text()='anthony.dibbert']")
	static
    WebElement results;

    @FindBy(xpath = "//label[text()='Username']/following::input[@class='oxd-input oxd-input--active']")
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
        clickElement(employeename);
    }

    public void selectStatusEnabled() {
        clickElement(statusDropdown);
        clickElement(statusEnabled);
    }

    public void enterUsername() {
        TestUtility.enterUsername(usernameInput);
    }

    public void searchusername(String str) {
        TestUtility.enterText(usernamesearch, str);
    }

    public void enterPassword() {
        TestUtility.enterRandomPassword(passwordInput);
    }

    public void enterConfirmPassword() {
        String confirmPassword = TestUtility.getRandomPassword();
        confirmPasswordInput.clear();
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

    public static void validate() {
        try {
			printIfDisplayed(results);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void usernameinput(String data) {
        TestUtility.enterText(usernamesearch, data);
    }

}
