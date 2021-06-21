package StepDefinitions;

import java.io.FileNotFoundException;
import constants.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class placeorder
{
	WebDriver dr=null;
	@Given("User is on icicidirect home page")
	public void home_page() throws FileNotFoundException, Exception
	{
		System.out.println("Inside Step-icicidirect home page");
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\Drivers\\geckodriver.exe");
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
			dr=new ChromeDriver();
			dr.navigate().to("http://icicidirect.com");
			dr.findElement(By.xpath("//*[@id=\"divSearch\"]/a[4]")).click();
			dr.findElement(By.xpath("//*[@id=\"txtuid\"]")).sendKeys(constants.username);
			dr.findElement(By.xpath("//*[@id=\"txtPass\"]")).sendKeys("Dadgod08$$");
			dr.findElement(By.xpath("//*[@id=\"txtDOB\"]")).sendKeys("AOFPP5897P");
			dr.findElement(By.xpath("//*[@id=\"btnlogin\"]")).click();
		}
			catch(WebDriverException e)
			{
			System.out.println("Element does not exist");
			}
		System.out.println("Wait for 10 seconds,Time is" + getCurrentTime());
		TimeUnit.SECONDS.sleep(10);
		System.out.println("And delay for 10 seconds,Time is" + getCurrentTime());
		String mainwindow=dr.getWindowHandle();
		System.out.println("Main window address is " + mainwindow);
	}
	private String getCurrentTime() {
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		
		return sdf.format(cal.getTime());
	}
	@When("user clicks on Place Order link")
	public void placeorder_button()
	{
		System.out.println("Inside Step-user clicks on Premium Portfolio link");
		dr.findElement(By.xpath("//*[@id=\"pnlmnudsp\"]/div[1]/div/ul/li[3]/a")).click();
	}
	@Then("user chooses Cash Buy option")
	public void cashbuy_option()
	{
		System.out.println("Inside Step-User chooses cash buy option");
		
		
	}
	@And("Selects NSE Option")
	public void choose_NSE()
	{
		System.out.println("Inside Step-Fills stock code");
		dr.findElement(By.xpath("//*[@id=\"pnltabtrans\"]/div/div[2]/div[1]/label")).click();
		
	}
	@And("Fills Stock code")
	public void fills_stockcode()
	{
		System.out.println("Inside Step-Fills stock code");
		dr.findElement(By.xpath("//*[@id=\"stcode\"]")).sendKeys("ICIC");
	}
	@And("Fills quantity")
	public void fills_quantity()
	{
		System.out.println("Inside Step-Fills quantity");
		dr.findElement(By.xpath("//*[@id=\"FML_QTY\"]")).sendKeys("10");
		
	}
	@And("Fills Limit Price")
	public void limit_price()
	{
		System.out.println("Inside Step-Fills Limit Price");
		dr.findElement(By.xpath("//*[@id=\"FML_ORD_LMT_RT\"]")).sendKeys("100");
		
	}
	@And("Clicks on Buy")
	public void click_buy()
	{
		System.out.println("Inside Step-User clicks on Buy button");
		
		try{dr.findElement(By.xpath("//*[@id=\"pnltabtrans\"]/div/div[7]/div[2]/input")).click();}
			catch(NoSuchElementException e) 
			{
			System.out.println("Element does not exists");
			}
		
	}
	@Then("User is routed to Booked order page")
	public void booking_page()
	{
		System.out.println("Inside Step-User is on booking page");
		
		
	}
}
