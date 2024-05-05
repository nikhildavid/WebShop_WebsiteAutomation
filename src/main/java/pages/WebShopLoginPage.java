package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Runtime.RunTimeEnvironment;

public class WebShopLoginPage {

	RunTimeEnvironment runtime;
	WebDriver driver;
	
	public WebShopLoginPage(RunTimeEnvironment runtime) {
		this.runtime=runtime;
		this.driver = runtime.driver;
	
		initialiseObjects();
		
	}
	@FindBy(xpath="//div[@class='page-title']/h1[contains(text(),'Welcome')]")
	WebElement wsLoginPage_WelcomeMessage;
	public void verifyLoginPage_WelcomeMessage() {
		runtime.library.verifyElement_isDisplayed(wsLoginPage_WelcomeMessage, "LoginPage Welcome Message");
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement wsLoginPage_Email;
	public void enterEmail(String Email) {
		runtime.library.writeText(wsLoginPage_Email, "Entered Email", Email);
	}
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement wsLoginPage_Password;
	public void enterPassword(String Password) {
		runtime.library.writeText(wsLoginPage_Password, "Entered Password", Password);
	}
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement wsLoginPage_SubmitLogin;
	public void submitLogin() {
		runtime.library.clickElement(wsLoginPage_SubmitLogin, "Submit Login Button");
	}
	
	@FindBy(xpath="//div[@class='header-links']//a[@class='account']")
	WebElement wsLoginPage_LoggedInUser;
	public void verifyLoggedInUserInformation(String Email) {
		runtime.library.AssertStringsEqual_True(runtime.library.readText(wsLoginPage_LoggedInUser, "Logged in User"), Email);
	}

	
	
	private void initialiseObjects() {
		PageFactory.initElements(driver, this);
	}
}
