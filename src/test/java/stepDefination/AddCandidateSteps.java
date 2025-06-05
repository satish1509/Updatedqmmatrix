package stepDefination;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCandidateSteps {
	@Given("I am on the dashboard")
    public void i_am_on_the_dashboard() {
        System.out.println("User is on the OrangeHRM dashboard");
    }
	@When("I click on the Recruitment menu")
	public void clickRecruitment() {
	    System.out.println("Clicked on Recruitment menu");
	}

	@When("I click on Add Candidate")
	public void clickAddCandidate() {
	    System.out.println("Clicked on Add Candidate");
	}

	@When("I enter candidate name {string}")
	public void enterCandidateName(String name) {
	    System.out.println("Entered candidate name: " + name);
	}

	@When("I enter email {string}")
	public void enterEmail(String email) {
	    System.out.println("Entered email: " + email);
	}

	@When("I upload resume")
	public void uploadResume() {
	    System.out.println("Uploaded resume");
	}

	@When("I click on Save")
	public void clickSaveCandidate() {
	    System.out.println("Clicked Save for candidate");
	}

	@Then("the candidate should be added successfully")
	public void verifyCandidateAdded() {
	    System.out.println("Candidate added successfully");
	}


}
