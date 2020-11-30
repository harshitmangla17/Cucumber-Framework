package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	//driver.get("https://admin-demo.nopcommerce.com/login");
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//input[@class='email valid']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@class='password valid']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement loginBtn;
	
	public void setUserName(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pass1) {
		password.clear();
		password.sendKeys(pass1);
	}
	
	public void loginclick() {
	loginBtn.click();	
	}
	
	

}
