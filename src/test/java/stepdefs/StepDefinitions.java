package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.InitPages;

import static org.junit.Assert.*;

public class StepDefinitions {
    @Given("today is Sunday")
    public void today_is_Sunday() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        InitPages.todoPage.enterTodo("entered");

    }

    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("third");
    }
}
