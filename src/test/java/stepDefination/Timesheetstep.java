package stepDefination;

import org.openqa.selenium.WebDriver;
import com.qa.OrangeHRM.pages.LoginPage;
import com.qa.OrangeHRM.pages.TimePage;
import com.qa.driverfactory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.en.*;

public class Timesheetstep {

    private WebDriver driver;
    private LoginPage loginPage;
    private TimePage timePage;
    private ConfigReader config;

    public Timesheetstep() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
        this.timePage = new TimePage(driver);
        this.config = new ConfigReader();
    }

    @Given("user launches URL")
    public void user_launches_url() {
        System.out.println("Launching the application URL");
        // driver.get(config.readConfig().getProperty("url")); // Uncomment if needed
    }

    @And("User signs into the orange hrm with valid credentials")
    public void user_signs_into_orangehrm_with_valid_credentials() {
        String username = config.readConfig().getProperty("username");
        String password = config.readConfig().getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        System.out.println("Logged in with valid credentials");
    }

    @And("User navigated into to the dashboard")
    public void user_is_navigated_to_dashboard() {
        timePage.dashboarddisplayed();
        System.out.println("Dashboard is displayed");
    }

    @When("User clicks on the Time button")
    public void user_clicks_on_time_tab() {
        timePage.clickTimeTab();
        System.out.println("Clicked on Time tab");
    }

    @And("User clicked on Timesheet dropdown")
    public void user_clicks_on_timesheet_dropdown() {
        timePage.clickTimesheetDropdown();
        System.out.println("Clicked on Timesheet dropdown");
    }

    @When("User cliked on my timesheet")
    public void user_clicks_on_my_timesheet() {
        timePage.clickMyTimesheet();
        System.out.println("Clicked on My Timesheet");
    }

    @Then("Timesheet period for current week is displayed")
    public void timesheet_period_should_be_displayed() {
        timePage.isTimesheetPeriodDisplayed();
        System.out.println("Timesheet period displayed");
    }

    @And("User clicks on Submit Button")
    public void user_clicks_on_submit_button() {
        timePage.clickSubmitButton();
        System.out.println("Clicked on Submit button");
    }

    @Then("Timesheet is submitted successfully")
    public void timesheet_should_be_submitted_successfully() {
        timePage.verifySubmissionSuccessMessage();
        System.out.println("Timesheet submitted successfully");
    }
}
