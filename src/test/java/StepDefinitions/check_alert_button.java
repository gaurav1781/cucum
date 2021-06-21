package StepDefinitions;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class check_alert_button
{
	WebDriver dr=null;
	@Given("User logs in to icicidirect home page")
	public void home_page() throws FileNotFoundException, Exception
	{
		System.out.println("Inside Step-icicidirect home page");
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\Drivers\\geckodriver.exe");
		//prop=new Properties();	
		//FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//src//resources//projectconfig.properties");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.navigate().to("http://icicidirect.com");
	/* Code sets the file on system and fetches the username value*/
		String spath="D:\\Software\\Java Workspace\\cucum\\Keyword1.xlsx";
		utils.setExcelFile(spath, "First");
		dr.findElement(By.xpath("//*[@id=\"divSearch\"]/a[4]")).click();
		dr.findElement(By.xpath("//*[@id=\"txtuid\"]")).sendKeys(constants.constants.username);
	  //dr.findElement(By.xpath("//*[@id=\"txtPass\"]")).sendKeys("Dadgod08$$");
		dr.findElement(By.xpath("//*[@id=\"txtPass\"]")).sendKeys(utils.getExcelData(1, 1));
		String s=utils.getExcelData(1, 1);
		System.out.println("Password is "+ s);
		dr.findElement(By.xpath("//*[@id=\"txtDOB\"]")).sendKeys("AOFPP5897P");
		dr.findElement(By.xpath("//*[@id=\"btnlogin\"]")).click();
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
	@When("User clicks on Premium Portfolio link")
	public void click_alert_button()
	{
		System.out.println("Inside Step-user clicks on Premium Portfolio link");
		dr.findElement(By.xpath("//*[@id=\"pnlmnuprod\"]/div/ul/li[13]/a")).click();
	}
	@Then("User sees the content of Premium Portfolio link")
	public void verify_content_alertbtn()
	{
		System.out.println("Inside Step-verify content of alert button");
		dr.close();
		
	}
	@When("User clicks on NPS link")
	public void click_other_button()
	{
		System.out.println("Inside Step-user clicks on Other button");
		dr.findElement(By.xpath("//*[@id=\"pnlmnuprod\"]/div/ul/li[12]/a")).click();
	}
	@Then("user sees the content of NPS link")
	public void verify_content_othrbtn()
	{
		System.out.println("Inside Step-verify content of NPS button");
		
	}
	@When("User clicks on Global Invest link")
	public void click_global_inv_link()
	{
		System.out.println("Inside Step-user clicks on Other button");
		dr.findElement(By.xpath("//*[@id=\"pnlmnuprod\"]/div/ul/li[11]/a")).click();
	}
	@Then("user sees the content of Global Invest link")
	public void verify_content_bt1()
	{
		System.out.println("Inside Step-verify content of Global Invest button");
		
	}
}
