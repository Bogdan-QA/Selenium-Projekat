package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MyAccountPage {
	
	WebDriver driver;
	WebElement signOutButton;
	WebElement signOutBottomButton;
	WebElement orderHistoryAndDetails;
	WebElement orderHistoryAndDetailsMessage;
	WebElement myAddresses;
	WebElement myPersonalInformation;
	WebElement myWishlistsButton;
	WebElement myAccountButton;
	WebElement womenProductsButton;

	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	// Path for Elements on the page
	
	public WebElement getWomenProductsButton () {
		return driver.findElement(By.cssSelector("a[title=Women]"));
	}
	
	public WebElement getMyAccountButton () {
		return driver.findElement(By.cssSelector("a[class=account]"));
	}
	
	public WebElement getMyWishlistsButton () {
		return driver.findElement(By.cssSelector("a[title*=wishlists]"));
	}
	
	public WebElement getMyPersonalInformation () {
		return driver.findElement(By.cssSelector("a[title=Information]"));
	}
	
	public WebElement getsignOutButton () {
		return driver.findElement(By.cssSelector("a[title*=Log]"));
	}
	
	public WebElement getSignOutBottomButton () {
		return driver.findElement(By.cssSelector("a[title*=Sign]"));
	}
	
	public WebElement getOrderHistoryAndDetails () {
		return driver.findElement(By.cssSelector("a[title=Orders]"));
	}
	
	public WebElement getOrderHistoryAndDetailsMessage () {
		return driver.findElement(By.cssSelector("p[class*=info-title]"));   // treba da izmenis. uzmi produkt kad dodje vreme.
	}
	
	public WebElement getMyAddressesButton () {
		return driver.findElement(By.cssSelector("a[title=Addresses]"));
	}
	
	
	
	
	// actions that can be taken on the page
	
	public void clickWomenProductsButton () {						// click on the Women button in the top left corner
		getWomenProductsButton().click();
	}
	
	public void clickMyAccountButton () {
		getMyAccountButton().click();
	}
	
	public void clickMyWishlistsButton () {
		getMyWishlistsButton().click();
	}
	
	public void clickMyPersonalInformation () {
		getMyPersonalInformation().click();
	}
	
	public String textFromSignOutButton () {		// verifictaion text for the login function
		return getsignOutButton().getText();
	}
	
	public void clickSignOutButton () {
		getsignOutButton().click();
	}
	
	public void clickSignOutBottomButton () {
		getSignOutBottomButton().click();
	}
	
	public void clickOrderHistoryAndDetails () {
		getOrderHistoryAndDetails().click();
	}
	
	public String textFromOrderHistoryAndDetailsMessage () {   // verification text that order history can be shown.
		return getOrderHistoryAndDetails().getText();
	}
	
	public void clickMyAddresses () {
		getMyAddressesButton().click();
	}

}
