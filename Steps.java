package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import pageObjects.LoginPage;

public class Steps {
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("^Open the chrome browser and open URL and maximize window$")
	public void open_the_chrome_browser_and_open_URL_and_maximize_window()  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Harshit Mangla\\Documents\\Selenium Drivers\\chromedriver1.exe");
		driver= new ChromeDriver();
		lp= new LoginPage(driver);
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   
	}

	@When("^User enters the username and password$")
	public void user_enters_the_username_and_password()  {
		lp.setUserName("admin@yourstore.com");
		lp.setPassword("admin");
	   
	}

	@When("^User click on the login button$")
	public void user_click_on_the_login_button() {
	   lp.loginclick();
	}

	@Then("^User should be able to login successfully$")
	public void user_should_be_able_to_login_successfully()  {
		if(driver.getPageSource().contains("Dashboard"))
			System.out.println("Logged In Successfully");
	   
	}

	@When("^User enters the invalid username and password$")
	public void user_enters_the_invalid_username_and_password()  {
		lp.setUserName("admin@yourstore1.com");
		lp.setPassword("admin1");
	  if(driver.getPageSource().contains("Dashboard"))
		  driver.quit();
	  else
		  System.out.println("Entered Invalid Credentials");
	}

	@When("^User click the login button$")
	public void user_click_the_login_button()  {
	   lp.loginclick();
	}

	@Then("^User should not be able to login successfully$")
	public void user_should_not_be_able_to_login_successfully()  {
		 if(driver.getPageSource().contains("Login was unsuccessful."))
			 System.out.println("Not Logged In");
	    
	}



}
