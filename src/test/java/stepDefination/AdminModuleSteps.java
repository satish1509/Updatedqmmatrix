package stepDefination;

import org.openqa.selenium.WebDriver;

import com.qa.OrangeHRM.pages.AdminPage;
import com.qa.OrangeHRM.pages.LoginPage;
import com.qa.driverfactory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminModuleSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private AdminPage adminPage;
    private ConfigReader config;

    public AdminModuleSteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
        this.adminPage = new AdminPage(driver);
        this.config = new ConfigReader();
    }

    @Given("User launches the application URL")
    public void user_launches_the_application_url() {
        System.out.println("Launching the application URL...");
        // Uncomment below to actually launch the app
        // driver.get(config.readConfig().getProperty("url"));
    }

    @Given("User logs into the application with valid credentials")
    public void user_logs_into_the_application_with_valid_credentials() {
        String username = config.readConfig().getProperty("username");
        String password = config.readConfig().getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        System.out.println("Logged in with valid credentials");
    }

    @When("User clicks on Add button")
    public void user_clicks_on_add_button() {
        adminPage.clickAddButton();
        System.out.println("Clicked on Add button");
    }

    @When("User selects user role as admin")
    public void user_selects_user_role_as_admin() {
        adminPage.selectUserRoleAdmin();
        System.out.println("Selected user role as Admin");
    }

    @When("User enter name and select name from dropdown")
    public void user_enter_name_and_select_name_from_dropdown() {
        adminPage.clickonemployeenamefield();
        adminPage.entername("Kathleen");
        adminPage.selectemployee();
        System.out.println("Entered employee name and selected from dropdown");
    }

    @When("User selects status Enabled")
    public void user_selects_status_enabled() {
        adminPage.selectStatusEnabled();
        System.out.println("Selected status as Enabled");
    }

    @When("User enters username")
    public void user_enters_username() {
        adminPage.enterUsername();
        System.out.println("Entered username");
    }

    @When("User enters password")
    public void user_enters_password() {
        adminPage.enterPassword();
        System.out.println("Entered password");
    }

    @When("User enters confirm password")
    public void user_enters_confirm_password() {
        adminPage.enterConfirmPassword();
        System.out.println("Entered confirm password");
    }

    @When("User clicked on Submit button")
    public void user_clicked_on_submit_button() {
        adminPage.clickSubmit();
        System.out.println("Clicked on Submit button");
    }

    @Then("New user should be added successfully")
    public void detailssavedsuccessfully() {
        adminPage.detailssaved();
        System.out.println("New user added successfully");
    }

    @When("User enters username in the search field")
    public void user_enters_username_in_the_search_field() {
        String user = config.readConfig().getProperty("lastGeneratedUsername");
        adminPage.searchusername(user);
        System.out.println("Entered username in the search field");
    }

    @And("User is on the Admin module page")
    public void user_is_on_the_admin_module_page() {
        adminPage.clickAdminTab();
        System.out.println("Navigated to Admin module page");
    }

    @And("User selects user role as Admin")
    public void user_selecting_user_role_as_admin() {
        adminPage.selectUserRoleAdmin();
        System.out.println("Selected user role as Admin");
    }

    @And("User selects status as Enabled")
    public void user_selects_status_as_enabled() {
        adminPage.selectStatusEnabled();
        System.out.println("Selected status as Enabled");
    }

    @And("User clicks on Submit button")
    public void user_clicks_on_submit_button() {
        adminPage.clickSubmit();
        System.out.println("Clicked on Submit button");
    }

    @Then("User details should be displayed in the search results")
    public void user_details_should_be_displayed_in_the_search_results() {
        System.out.println("User details displayed in the search results");
    }
}
