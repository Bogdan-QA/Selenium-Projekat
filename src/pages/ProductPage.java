package pages;

import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	
	WebDriver driver;
	WebElement addToWishlistButton;
	WebElement closeButtonPopUpWindow;
	WebElement addToCartButton;
	WebElement closeButtonPopUpWindowAfterAddingToCart;
	WebElement proceedToCheckoutButton;

	public ProductPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	// Path for Elements on the page
	
	public WebElement getProceedToCheckoutButton () {
		return driver.findElement(By.cssSelector("a[title=\"Proceed to checkout\"]"));  // path for checkout button in the pop-up window.
	}
	
	public WebElement getCloseButtonPopUpWindowAfterAddingToCart () {
		return driver.findElement(By.cssSelector("span[title=\"Close window\"]"));
	}
	
	public WebElement getAddToCartButton () {							// path for add to cart button on the product page through wishlist.
		return driver.findElement(By.id("add_to_cart"));
	}
	
	public WebElement getCloseButtonPopUpWindow () {						// path for close button of the pop-up window (add to wishlist)
		return driver.findElement(By.cssSelector("a[title=Close]"));
	}
	
	public WebElement getAddToWishlistButton () {
		return driver.findElement(By.id("wishlist_button"));
	}
	
	// actions that can be taken on the page
	
	public void clickProceedToCheckoutButton () {
		getProceedToCheckoutButton().click();
	}
	
	public void clickClosePopupAfterAddingToCart () {
		getCloseButtonPopUpWindowAfterAddingToCart().click();
	}
	
	public void clickAddToCartButton () {
		getAddToCartButton().click();
	}
	
	public void clickOntheCloseButton () {								// click on the close button for add to wishlist pop-up window.
		getCloseButtonPopUpWindow().click();
	}
	
	public void clickOnAddToWishlistButton () {
		getAddToWishlistButton().click();
	}
	
	

}
