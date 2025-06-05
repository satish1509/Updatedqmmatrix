package applicationHooks;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import io.qameta.allure.Allure;


	

	


	public class StepLogger implements ConcurrentEventListener {

	    @Override
	    public void setEventPublisher(EventPublisher publisher) {
	        // This tells Cucumber to call "afterStep" after each step finishes
	        publisher.registerHandlerFor(TestStepFinished.class, this::afterStep);
	    }

	    private void afterStep(TestStepFinished event) {
	        TestStep step = event.getTestStep();

	        // We only care about real Gherkin steps, not hooks
	        if (step instanceof PickleStepTestStep) {
	            PickleStepTestStep pickleStep = (PickleStepTestStep) step;

	            // Get the full step text, like "Given user navigated to the url"
	            String stepText = pickleStep.getStep().getKeyword() + pickleStep.getStep().getText();

	            // Mark step as passed or failed in Allure
	            if (event.getResult().getStatus().is(Status.PASSED)) {
	                Allure.step("✅ " + stepText);
	            } else {
	                Allure.step("❌ " + stepText);
	            }
	        }
	    }
	}



