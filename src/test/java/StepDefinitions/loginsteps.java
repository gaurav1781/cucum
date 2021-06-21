package StepDefinitions;

import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps
{
	WebDriver dr=null;
@Given("browser is open")
public void browser_open() throws FileNotFoundException
{
	System.out.println("Inside Step-Google Browser Opening");
	System.setProperty("webdriver.gecko.driver","D:\\Selenium\\Drivers\\geckodriver.exe");
	//prop=new Properties();	
	//FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//src//resources//projectconfig.properties");
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
	dr=new ChromeDriver();
}
@And("user is on google home page")
public void user_on_home_page()
{
	System.out.println("Inside Step-User is on Google Home Page");
	dr.navigate().to("http://google.com");
}
@When("user enters text on screen")
public void user_enter_text_onscreen()
{
	System.out.println("Inside Step-user enters text on search screen");
	dr.findElement(By.name("q")).sendKeys("Tester Melbourne");
}
@And("hits enter")
public void user_hits_enter()
{
	System.out.println("Inside Step-User hits enter");
	dr.findElement(By.name("q")).sendKeys(Keys.ENTER);
}
@Then("user is navigated to search results")
public void user_navigate_to_search_results()
{
	System.out.println("Inside Step-Verifying serach results page");
	dr.getPageSource().contains("brr");
	dr.close();
	dr.quit();
}
}
