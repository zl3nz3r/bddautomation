package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.InitPages;

import java.util.List;

public class EnterTodosSteps {

    String todoValue;

    @Given("user visit the todo list")
    public void user_visit_the_todo_list() {
        System.out.println("navigate");
    }
    @When("enter {string} to the todo list")
    public void enter_to_the_todo_list(String todoValue) {
        this.todoValue = todoValue;
        InitPages.todoPage.enterTodo(todoValue);
    }
    @Then("todo list update with new value")
    public void todo_list_update_with_new_value() {
        Assert.assertEquals(InitPages.todoPage.getTodo(todoValue),todoValue);

    }

    @When("enter todos to the list")
    public void enter_todos_to_the_list(DataTable dataTable) throws InterruptedException {

        List<String> rows = dataTable.asList();
        for (String row : rows) {
            InitPages.todoPage.enterTodo(row);
        }



    }

    @Then("todo list update with new values")
    public void todo_list_update_with_new_values(DataTable dataTable) {
        List<String> rows = dataTable.asList();



    }


}
