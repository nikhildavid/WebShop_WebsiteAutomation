package pages;

import Runtime.RunTimeEnvironment;

public class PageObjectManager {

	public RunTimeEnvironment runtime;

	public PageObjectManager(RunTimeEnvironment runtime) {
		this.runtime = runtime;

	}

	WebShopHomePage WShomepage;

	public WebShopHomePage getWShomepage() {
		if (WShomepage == null) {
			WShomepage = new WebShopHomePage(runtime);
			return WShomepage;
		}
		return WShomepage;
	}

	WebShopRegistrationPage WSRegistrationPage;

	public WebShopRegistrationPage getWSRegistrationPage() {
		if (WSRegistrationPage == null) {
			WSRegistrationPage = new WebShopRegistrationPage(runtime);
			return WSRegistrationPage;
		}
		return WSRegistrationPage;
	}

	WebShopLoginPage WSLoginPage;

	public WebShopLoginPage getWSLoginPage() {
		if (WSLoginPage == null) {
			WSLoginPage = new WebShopLoginPage(runtime);
			return WSLoginPage;
		}
		return WSLoginPage;
	}

	WebShopAddToCart WSAddToCart;

	public WebShopAddToCart getWSAddToCart() {
		if (WSAddToCart == null) {
			WSAddToCart = new WebShopAddToCart(runtime);
			return WSAddToCart;
		}
		return WSAddToCart;
	}
}
