package StepDefs;

import Pages.LinkedinSendMessage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

public class MyStepdefs extends ScenarioSteps {
    LinkedinSendMessage linkedinSendMessage;
    @Given("user launches the Linkedin url")
    public void user_launches_the_linkedin_url() {
        linkedinSendMessage.launchUI();
    }

    @When("user searches for a name {string}")
    public void user_searches_for_a_name(String name) {
        linkedinSendMessage.searchForProfile(name);
    }

    @When("user is on {string} profile")
    public void user_is_on_profile(String expectedName) {
       linkedinSendMessage.validateProfilePage(expectedName);
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
       linkedinSendMessage.clickOnButton(button);
    }

    @When("user provides {string} in the message")
    public void user_provides_in_the_message(String message) {
       linkedinSendMessage.sendTextMessage(message);
    }


    @When("user provides the login credentials")
    public void userProvidesTheLoginCredentials() {
        linkedinSendMessage.enterCredentials();
    }
}

