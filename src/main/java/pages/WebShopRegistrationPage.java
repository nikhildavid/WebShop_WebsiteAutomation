package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Runtime.RunTimeEnvironment;

public class WebShopRegistrationPage {

	RunTimeEnvironment runtime;
	WebDriver driver;
	
	public WebShopRegistrationPage(RunTimeEnvironment runtime) {
		this.runtime=runtime;
		this.driver = runtime.driver;
	
		initialiseObjects();
		
	}
	
	@FindBy(xpath="//div[@class = 'page-title']/h1")
	WebElement wSRegistrationPage_Title;
	public void verifyRegistrationPage_Title(String Title) {
		runtime.library.clickElement(wSRegistrationPage_Title, "wSRegistrationPage_Title");
		runtime.library.AssertStringsEqual_True(runtime.library.readText(wSRegistrationPage_Title, "REgistration page title"), Title);
	}
	
	String genderXpath="//div[@class='gender']/input[@id='gender-%s']";
		public void selectGender(String gender) {
		runtime.library.clickElementList(genderXpath, gender);
	}
	
		@FindBy(xpath="//div[@class='inputs']/input[@id='FirstName']")
		WebElement wSRegistrationPage_FirstName;
		public void enterFirstName(String FirstName) {
			runtime.library.writeText(wSRegistrationPage_FirstName, "First Name", FirstName);
				}
		
		
		
		@FindBy(xpath="//div[@class='inputs']/input[@id='LastName']")
		WebElement wSRegistrationPage_LastName;
		public void enterLastName(String LastName) {
			runtime.library.writeText(wSRegistrationPage_LastName, "Last Name", LastName);
				}
		
		@FindBy(xpath="//div[@class='inputs']/input[@id='Email']")
		WebElement wSRegistrationPage_Email;
		public void enterEmail(String Email) {
			runtime.library.writeText(wSRegistrationPage_Email, "Email", Email);
				}
		
		@FindBy(xpath="//div[@class='inputs']/input[@id='Password']")
		WebElement wSRegistrationPage_Password;
		public void enterPassword(String Password) {
			runtime.library.writeText(wSRegistrationPage_Password, "Password", Password);
				}
		@FindBy(xpath="//div[@class='inputs']/input[@id='ConfirmPassword']")
		WebElement wSRegistrationPage_ConfirmPassword;
		public void confirmPassword(String Password) {
			runtime.library.writeText(wSRegistrationPage_ConfirmPassword, "Confirm Password", Password);
				}
		
		@FindBy(xpath="//input[@id='register-button']")
		WebElement wSRegistrationPage_RegisterButton;
		public void clickRegisterButton() {
			runtime.library.clickElement(wSRegistrationPage_RegisterButton, "Register Button");
		}
		@FindBy(xpath="//div[@class='result']")
		WebElement wSRegistrationPage_RegisterSuccessMessage;
		public void verifyRegistrationSuccessMessage(String Message) {
			runtime.library.AssertStringsEqual_True(runtime.library.readText(wSRegistrationPage_RegisterSuccessMessage, "Registration Success Message"), Message);
		}
		
		@FindBy(xpath="//input[@value='Continue']")
		WebElement wSRegistrationPage_ContinueButton;
		public void clickContinueButton() {
			runtime.library.clickElement(wSRegistrationPage_ContinueButton, "Continue Button");
		}
		
	
	private void initialiseObjects() {
		PageFactory.initElements(driver, this);
	}
}
