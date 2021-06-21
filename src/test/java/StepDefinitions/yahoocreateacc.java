package StepDefinitions;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class yahoocreateacc
{
	WebDriver dr=null;
	@Given("browse is open")
	public void brows_open() throws FileNotFoundException
	{
		System.out.println("Inside Step-Google Browser Opening");
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\Drivers\\geckodriver.exe");
		//prop=new Properties();	
		//FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//src//resources//projectconfig.properties");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
	}
	@And("user is on icicidirect login page")
	public void user_on_home_page() throws InterruptedException
	{
		System.out.println("Inside Step-User is on icicidirect Home Page");
		dr.navigate().to("http://icicidirect.com");
	}
	@When("user fills mandatory fields and clicks login")
	public void user_enter_text_onscreen() throws InterruptedException
	{
		//excelutil.getExcelData(i, constants.constants.Col_TestStepId);
		System.out.println("Inside Step-user enter text and values onscreen");
		//dr.findElement(By.id("identifierId")).sendKeys("gaurav145");
		//dr.manage().window().maximize();
		dr.findElement(By.xpath("//*[@id=\"divSearch\"]/a[4]")).click();
		dr.findElement(By.xpath("//*[@id=\"txtuid\"]")).sendKeys(constants.constants.username);
		dr.findElement(By.xpath("//*[@id=\"txtPass\"]")).sendKeys("Dadgod08$$");
		dr.findElement(By.xpath("//*[@id=\"txtDOB\"]")).sendKeys("AOFPP5897P");
		dr.findElement(By.xpath("//*[@id=\"btnlogin\"]")).click();
		System.out.println("Wait for 10 seconds,Time is" + getCurrentTime());
		TimeUnit.SECONDS.sleep(10);
		System.out.println("And delay for 10 seconds,Time is" + getCurrentTime());
		String mainwindow=dr.getWindowHandle();
		System.out.println("Main window address is " + mainwindow);
		//return mainwindow;
		//user_click_alertbutton();
	}
	private String getCurrentTime() {
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		
		return sdf.format(cal.getTime());
	}
	@Then("user successfully logs in to icicidirect home page")
	public void user_navigate_to_search_results()
	{
		System.out.println("Inside Step-user is navigated to create account screen");
		dr.getPageSource().contains("brr");
		//dr.close();
		//dr.quit();
	}
	/*@Given("^User is on \"(.*?)\" home page$")
	public void user_on_icicidirect_homepage(String s2) throws InterruptedException
	{
		System.out.println(s2);
		//user_click_alertbutton(user_enter_text_onscreen());
	}*/
	
	
	//@When("^User is on \"(.*?)\" home page and clicks on Alert button$")
	@When("User is on ICICIDirect home page and clicks on Alert button")
	public void user_click_alertbutton() throws InterruptedException
	{
		System.out.println("Inside Step-user clicks on alert button");
		//System.out.println("Address of main windows is "+ mainwindow);
		//if(dr.findElement(By.xpath("//*[@id=\"pnlmnuprod\"]/div/ul/li[13]/a")) !=null)
		//*if(s.isEmpty())
		//{
			//System.out.println("Returned windows is " + s);
		//}
		//else
		//{
			dr.findElement(By.xpath("//*[@id=\"pnlmnuprod\"]/div/ul/li[13]/a")).click();
			
			String s1=dr.findElement(By.xpath("//*[@id=\"pnlmnuprod\"]/div/ul/li[13]/a")).getText();
			System.out.println("Text is " + s1);
			//dr.close();
			
		//}*/
			
		
	}
	@Then("user is taken to current messages")
	public void user_messages()
	{
		System.out.println("Inside Step-user routed to messages");
		//dr.findElement(By.xpath("//*[@id=\"pnlHeadLogin\"]")).click();
		
	}
}