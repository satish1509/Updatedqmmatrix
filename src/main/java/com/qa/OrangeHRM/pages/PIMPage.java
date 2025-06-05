package com.qa.OrangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestUtility;

public class PIMPage {

    WebDriver driver;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login Elements
    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "(//*[text()='Admin Two'])[1]")
    private WebElement userInfo;

    // Navigation Tabs
    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimTab;

    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement addEmployeeTab;

    // Add Employee Form
    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "middleName")
    private WebElement middleNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='lastName']/following::div/input")
    private WebElement employeeIdField;

    @FindBy(xpath = "//div[@class='employee-image-wrapper']")
    private WebElement photographUploadInput;

    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    private WebElement createLoginSwitch;

    @FindBy(xpath = "//input[@fdprocessedid='txhcpb']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@fdprocessedid='9i673']")
    private WebElement passwordField;

    @FindBy(xpath = "/input[@fdprocessedid='61k0xv']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']")
    private WebElement savedEmployeeNameToast;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active']/preceding::input[@placeholder='Type for hints...']")
    private WebElement employeeNameInput;


    // ========== Action Methods ==========

    public void openURL(String url) {
        TestUtility.openPage(driver, url);
    }

    public void enterLoginCredentials(String user, String pass) {
        TestUtility.enterText(username, user);
        TestUtility.enterText(password, pass);
    }

    public void clickLogin() {
        TestUtility.clickElement(loginButton);
    }



    public void navigateToAddEmployee() {
        TestUtility.clickElement(pimTab);
        TestUtility.clickElement(addEmployeeTab);
    }
    public void search() {
        TestUtility.clickElement(pimTab);
        TestUtility.clickElement(employeeNameInput);
        TestUtility.enterText(employeeNameInput, TestUtility.generatedFirstName);    	
    }

//    public void fillEmployeeDetails() {
//        String firstName = ConfigReader.getValue("firstname");
//        String lastName = ConfigReader.getValue("lastname");
//        
//        System.out.println("First Name from config: " + firstName);
//        System.out.println("Last Name from config: " + lastName);
    public void enterfirstname() {
      TestUtility.enterRandomFirstName(firstNameField);
  }
    public void enterlastname() {
    	
        TestUtility.enterRandomLastName(lastNameField);

    	
    }
    
    public void loginid() {
    	
    	TestUtility.getText(employeeIdField);
    }


    
    public void enableLoginCreation() {
        TestUtility.clickElement(createLoginSwitch);
    }

    public void enterLoginDetails(String loginUsername, String loginPassword, String confirmPassword) {
        TestUtility.enterText(usernameField, loginUsername);
        TestUtility.enterText(passwordField, loginPassword);
        TestUtility.enterText(confirmPasswordField, confirmPassword);
    }

    public void clickSave() {
        System.out.println("hello world abcd");

        TestUtility.clickElement(saveButton);
        System.out.println("hello world abcd");

    }

    public void isEmployeeSaved() {
    	TestUtility.printIfDisplayed(savedEmployeeNameToast);
    }

    public void getSavedEmployeeId() {
       TestUtility.getText(employeeIdField);
    }
    public void enterEmployeeName() {
    	TestUtility.clickElement(employeeNameInput);
        TestUtility.enterRandomFirstName(employeeNameInput);

    	
    }
}
