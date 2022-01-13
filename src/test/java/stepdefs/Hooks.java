package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InitPages;

public class Hooks {

    String path = "C:\\Driver\\chromedriver.exe";
    public static WebDriver Driver;



    @Before
    public void beforScenrio( ){
        System.setProperty("webdriver.chrome.driver",path);
        Driver = new ChromeDriver();
        Driver.get("http://todomvc.com/examples/vue/");
        InitPages.init();




    }

    @After
    public void afterScenario( ){
        Driver.quit();
    }

}
