package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistsPage {
	
	WebDriver driver;
	WebElement wishlistNameField;
	WebElement wishlistSaveButton;
	WebElement wishlistConfirmationMessage;
	WebElement productImage;
	WebElement quantityOfProducts;
	WebElement openWishList;
	WebElement deleteWishlistButton;
	

	public MyWishlistsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	// Path for Elements on the page
	
	public WebElement getDeleteWishlistButton () {
		return driver.findElement(By.cssSelector("i[class=icon-remove]"));
	}
	
	public WebElement getOpenWishlist () {
		return driver.findElement(By.cssSelector("a[onclick*=javascript]"));
	}
	
	public WebElement getQuantityOfProducts () {					// product name in the list
		return driver.findElement(By.id("quantity_7_34"));
	}
	
	public WebElement getProductImage () {
		return driver.findElement(By.xpath("//*[@id=\"best-sellers_block_right\"]/div/ul/li[1]/div/h5/a"));
	}
	
	public WebElement getWishlistConfirmationMessage () {					// confirmation message that wishlist was made successfully.
		return driver.findElement(By.cssSelector("td[style*=width]"));
	}
	
	public WebElement getWishlistSaveButton () {
		return driver.findElement(By.id("submitWishlist"));
	}
	
	public WebElement getWishlistNameField () {
		return driver.findElement(By.id("name"));
	}
	
	// actions that can be taken on the page
	
	public void clickXToDeleteWishlist () {
		getDeleteWishlistButton().click();
	}
	
	public String productQuantityFromList () {
		return getQuantityOfProducts().getAttribute("value");
	}
	
	public void clickOnProductNameInWishlist () {			//click on the name of the wishlist. to open and see products
		getOpenWishlist().click();
	}
	
	public void clickOnTheProductName () {			// product name in the left corner.
		getProductImage().click();
	}
	
	public String textFromWishlistConfirmationMessage () {
		return getWishlistConfirmationMessage().getText();
	}
	
	public void insertWishlistName (String name) {
		getWishlistNameField().clear();
		getWishlistNameField().sendKeys(name);
	}
	
	public void clickWishlistSaveButton () {
		getWishlistSaveButton().click();
	}
	
	

}
