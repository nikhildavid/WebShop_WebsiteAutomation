package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Runtime.RunTimeEnvironment;

public class WebShopHomePage {

	RunTimeEnvironment runtime;
	WebDriver driver;
	
	public WebShopHomePage(RunTimeEnvironment runtime) {
		this.runtime=runtime;
		this.driver = runtime.driver;
	
		initialiseObjects();
		
	}
	
	@FindBy(xpath="//a[@class='ico-register']")
	WebElement wSHomePage_RegisterButton;
	public void clickWSHomePage_RegisterButton() {
		runtime.library.clickElement(wSHomePage_RegisterButton, "wSHomePage_RegisterButton");
	}
	
	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement wSHomePage_LogoutButton;
	public void clickWSHomePage_LogoutButton() {
		runtime.library.clickElement(wSHomePage_LogoutButton, "wSHomePage_LogoutButton");
	}
	
	public void verifyLogoutIsSuccess() {
		runtime.library.verifyElement_isDisplayed(wSHomePage_RegisterButton, "User is logged out");
	}
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement wSHomePage_LoginButton;
	public void clickWSHomePage_LoginButton() {
		runtime.library.clickElement(wSHomePage_LoginButton, "wSHomePage_LoginButton");
	}
	
	
	@FindBy(xpath="//a[@class='ico-cart']/span[@class='cart-label']")
	WebElement wSHomePage_ShoppingCartButton;
	public void clickWSHomePage_ShoppingCartButton() {
		runtime.library.clickElement(wSHomePage_ShoppingCartButton, "wSHomePage_ShoppingCartButton");
	}
	
	@FindBy(xpath="//a[@class='ico-wishlist']/span[@class='cart-label']")
	WebElement wSHomePage_WishListButton;
	public void clickWSHomePage_WishListButton() {
		runtime.library.clickElement(wSHomePage_WishListButton, "wSHomePage_WishListButton");
	}
	
	String CategoryLinkXpath= "//div[@class='block block-category-navigation']//li/a[contains(text(),'%s')]";
	public void clickwSHomePage_CategoryLink(String Category) {
		runtime.library.clickElementList(CategoryLinkXpath, Category);
	}
	
	String CategoryTitleXpath = "//div[@class='page-title']/h1[contains(text(),'%s')]";
	public void verifywSHomePage_CategoryTitle(String Category) {
		
	runtime.library.AssertStringsEqual_True(runtime.library.readTextElementList(CategoryTitleXpath, Category), Category);
		
	}
	
	@FindBy(xpath="//div[@class='topic-html-content-title']")
	WebElement wSHomePageContent;
	public void verifyHomePageContent() {
		runtime.library.verifyElement_isDisplayed(wSHomePageContent, "User is in Home Page");
	}
	private void initialiseObjects() {
		PageFactory.initElements(driver, this);
	}
}
