package stepDefination;

import org.openqa.selenium.WebDriver;

import com.qa.OrangeHRM.pages.BuzzPage;
import com.qa.OrangeHRM.pages.LoginPage;
import com.qa.driverfactory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Buzzsteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private BuzzPage buzzPage;
    private ConfigReader config;

    public Buzzsteps() {
        this.driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
        this.buzzPage = new BuzzPage(driver);
        this.config = new ConfigReader();
    }

    @Given("User opens the application")
    public void user_opens_the_application() {
        System.out.println("Opening the OrangeHRM application...");
        // driver.get(config.readConfig().getProperty("url"));
    }

    @Given("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        String username = config.readConfig().getProperty("username");
        String password = config.readConfig().getProperty("password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        System.out.println("Logged in with valid credentials");
    }

    @When("User navigates to the Buzz tab")
    public void user_navigates_to_the_buzz_tab() throws InterruptedException {
        buzzPage.clickBuzzTab();
        System.out.println("Clicked on Buzz tab");
    }

    @And("Buzz Newsfeed should be displayed")
    public void buzz_newsfeed_should_be_displayed() {
        buzzPage.verifyBuzzNewsfeedDisplayed();
        System.out.println("Buzz Newsfeed is displayed");
    }

    @And("User enters the Buzz message")
    public void user_enters_the_buzz_message() {
        buzzPage.enterBuzzMessage("I'm in tata consultancy services");
        System.out.println("Entered Buzz message");
    }

    @And("User clicks on the Post button")
    public void user_clicks_on_the_post_button() throws InterruptedException {
        buzzPage.clickPostButton();
        System.out.println("Clicked on Post button");
        Thread.sleep(4000);
    }

    @Then("The message should be posted on the Buzz feed")
    public void the_message_should_be_posted_on_the_buzz_feed() {
        buzzPage.verifyPostedMessageDisplayed();
        System.out.println("Buzz message successfully posted and displayed");
    }
}
