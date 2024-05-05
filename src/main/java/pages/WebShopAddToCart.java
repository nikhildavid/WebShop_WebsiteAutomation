package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Runtime.RunTimeEnvironment;

public class WebShopAddToCart {

	RunTimeEnvironment runtime;
	WebDriver driver;
	
	public WebShopAddToCart(RunTimeEnvironment runtime) {
		this.runtime=runtime;
		this.driver = runtime.driver;
	
		initialiseObjects();
		
	}
	String addToCartXpath="//*[@class='product-title']/a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//input";
	public void addToCart(String productDesc) {
		runtime.library.clickElementList(addToCartXpath, productDesc);
	}
	
	
	@FindBy(xpath="//div[@id='bar-notification'][@style='display: block;']")
	WebElement productAddedToCartMessage;
	public void verifyProductAddedToCartMessage() {
		runtime.library.verifyElement_isDisplayed(productAddedToCartMessage, "Product is added to Cart");
	}
	
	
	
	private void initialiseObjects() {
		PageFactory.initElements(driver, this);
	}
}
