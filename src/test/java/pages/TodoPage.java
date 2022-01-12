package pages;
import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static stepdefs.Hooks.Driver;
public class TodoPage {
public TodoPageMap map;

private WebDriverWait wait;

    public TodoPage() {
        this.map = new TodoPageMap();
        wait = new WebDriverWait(Driver, Duration.ofSeconds(30));

    }

    public void enterTodo(String todo){
        wait.until(ExpectedConditions.visibilityOf(map.todoInputBox));
        map.todoInputBox.sendKeys(todo);
    }
}

class TodoPageMap{
    public WebElement todoInputBox = Driver.findElement(By.cssSelector("input[class=\"new-todo\"]"));
}
