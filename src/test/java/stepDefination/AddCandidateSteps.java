package stepDefination;

import org.openqa.selenium.WebDriver;

import com.qa.OrangeHRM.pages.Addcandidatepage;
import com.qa.OrangeHRM.pages.LoginPage;
import com.qa.driverfactory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCandidateSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private Addcandidatepage add;
    private ConfigReader config;

    public AddCandidateSteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
        this.add = new Addcandidatepage(driver);
        this.config = new ConfigReader();
    }

    // ------------------- Background Steps -------------------

    @Given("the application is opened in a web browser")
    public void launchApplication() {
        driver.get(config.readConfig().getProperty("url"));
        System.out.println("Application is opened");
    }

    @And("the user provides valid login credentials to access the dashboard")
    public void loginToApplication() {
        String username = config.readConfig().getProperty("username");
        String password = config.readConfig().getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        System.out.println("Logged in with valid credentials");
    }

    @And("the user navigated to recruitment module")
    public void accessRecruitmentModule() {
        add.clickRecruitment();
        System.out.println("Navigated to Recruitment module");
    }

    // ------------------- Scenario Steps -------------------

    @Given("I am on the dashboard")
    public void i_am_on_the_dashboard() {
        System.out.println("User is on the OrangeHRM dashboard");
    }

    @When("I click on the Recruitment menu")
    public void clickRecruitment() {
        add.clickRecruitment();
    }

    @And("I click on Add Candidate")
    public void clickAddCandidate() {
        add.clickAddButton();
    }
    @And("I select job vacancy")
    public void selectJobVacancy() {
    	add.vacancies();
    }
    
    @And("I click on Shortlist button")
    public void clickOnShortlistButton() {
        add.clickShortlistButton();
    }

    	@And("I click on Save button")
    	public void clickOnSaveButton() {
    		add.clickSaveButton();
    	}

    

    @And("I enter candidate name {string}")
    public void enterCandidateName(String middleName) {
        add.enterFirstName(); // using Faker/random
        add.enterMiddleName(middleName); // from step
        add.enterLastName(); // using Faker/random
    }

    @And("I enter email {string}")
    public void enterEmail(String email) {
        add.enterEmail(email);
    }
    @And("I enter mobile number")
    public void enterMobileNumber() {
    	
    	add.entermobilenumber();
    }
    

    @And("I upload resume")
    public void uploadResume() throws Exception {
    	String filePath = config.readConfig().getProperty("StringfilePath");

    	add.uploadResume(filePath);
    	add.enterdate();
    }

    @And("I click on Save")
    public void clickSaveCandidate() {
        add.clickSubmitButton();
    }

    @Then("the candidate should be added successfully")
    public void verifyCandidateAdded() {
    	add.detailssaved();
        System.out.println("Candidate added successfully");
    }
}
