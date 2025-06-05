package stepDefination;

import com.qa.OrangeHRM.pages.LeaveApplyPage;
import com.qa.OrangeHRM.pages.LoginPage;
import com.qa.driverfactory.DriverFactory;
import com.qa.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class ApplyLeaveSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private LeaveApplyPage leaveApplyPage;

    public ApplyLeaveSteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
        this.leaveApplyPage = new LeaveApplyPage(driver);
    }

    // ---------- Login Steps ----------

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orangehrm_login_page() {
        System.out.println("Navigated to OrangeHRM login page.");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        String username = new ConfigReader().readConfig().getProperty("username");
        String password = new ConfigReader().readConfig().getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be logged into the OrangeHRM dashboard")
    public void i_should_be_logged_into_the_orangehrm_dashboard() {
        System.out.println("Successfully logged into the dashboard.");
    }

    // ---------- Leave Application Steps ----------

    @Given("I am on the dashboard after login")
    public void i_am_on_the_dashboard_after_login() {
        System.out.println("User is on the dashboard after login.");
    }

    @When("I click on the Leave menu")
    public void i_click_on_the_leave_menu() {
        leaveApplyPage.clickLeaveTab();
    }

    @And("I click on the Apply Leave option")
    public void i_click_on_the_apply_leave_option() {
        leaveApplyPage.clickApplyLeave();
    }

    @And("I select casual leave from the leave type dropdown")
    public void i_select_casual_leave_from_the_leave_type_dropdown() {
        leaveApplyPage.selectLeaveType(); // Assumes default is "Casual Leave"
    }

    @And("I select the from date")
    public void i_select_the_from_date() {
        leaveApplyPage.selectFromDate();
    }

    @And("I select the to date")
    public void i_select_the_to_date() {
        leaveApplyPage.selectToDate();
    }

    @And("I select partial days as Start Day Only and time as Half Day - Morning")
    public void i_select_partial_days_as_start_day_only_and_time_as_half_day_morning() throws InterruptedException {
        leaveApplyPage.selectPartialDays();
    }

    @And("I enter comment {string}")
    public void i_enter_comment(String comment) {
        leaveApplyPage.enterComment(comment);
    }

    @And("I click on the Apply button")
    public void i_click_on_the_apply_button() {
        leaveApplyPage.clickSubmit();
    }

    @Then("the leave should be applied successfully")
    public void the_leave_should_be_applied_successfully() {
        leaveApplyPage.savedsuccessfully();

    }
}
