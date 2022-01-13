package pages;
import org.openqa.selenium.By;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
        map.todoInputBox.sendKeys(Keys.ENTER);
    }

    public String getTodo(String todovalue){
        wait.until(ExpectedConditions.visibilityOf(map.todoElement(todovalue)));
        return map.todoElement(todovalue).getText();
    }

    public void visitUrl() {
        Driver.navigate().to("http://todomvc.com/examples/vue/");
    }

    public List<String> getTodoValues(){
         List<String> todovalues = new ArrayList<String>(map.todos.size());
         for(int i=0;i<map.todos.size();i++){
             todovalues.add(map.todos.get(i).getText());
         }
         return todovalues;
    }

    public void clickCompleteButton(int todoIndex){
        wait.until(ExpectedConditions.visibilityOf(map.completeButton(todoIndex)));
        map.completeButton(todoIndex).click();
    }
}

class TodoPageMap{

    public WebElement todoInputBox = Driver.findElement(By.cssSelector("input[class=\"new-todo\"]"));
    public List<WebElement> todos = Driver.findElements(By.cssSelector("div[class=\"view\"]>label"));
    public WebElement todoElement(String todoElementValue){
        WebElement todoElement = Driver.findElement(By.xpath("//*[contains(text(), '"+todoElementValue+"')]"));
        return todoElement;
    }
    public WebElement completeButton(int todoIndex) {
        WebElement completeButton = Driver.findElement(By.xpath("/html/body/section/section/ul/li[1]/div/input"));
        return  completeButton;
    }


}
