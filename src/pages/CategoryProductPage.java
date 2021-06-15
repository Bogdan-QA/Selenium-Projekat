package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryProductPage {
	
	WebDriver driver;
	WebElement addBlouseToCartButton;
	WebElement closePopupWindowForAddedToCartProduct;
	WebElement viewMyCartButton;
	WebElement quickViewImageBlouse;

	public CategoryProductPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	// Path for Elements on the page
	
	public WebElement getQuickViewImageBlouse () {
		return driver.findElement(By.cssSelector("img[title=Blouse]"));
	}
	
	public WebElement getViewMyCartButton () {
		return driver.findElement(By.cssSelector("a[title=\"View my shopping cart\"]"));
	}
	
	public WebElement getAddBlouseToCartButton () {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]"));
	}
	
	public WebElement getClosePopupWindowForAddedToCartProduct () {
		return driver.findElement(By.cssSelector("span[title=\"Close window\"]"));
	}
	
	// actions that can be taken on the page
	
	public void clickQuickViewBlouseButton () {
		getQuickViewImageBlouse().click();
	}
	
	public void clickOnViewCartButton () {
		getViewMyCartButton().click();
	}
	
	public void clickAddBlouseToCartButton ( ) {
		getAddBlouseToCartButton().click();
	}
	
	public void clickClosePopupWindow () {						// close pop-up window that occurs when the product was added to the cart.
		getClosePopupWindowForAddedToCartProduct().click();
	}
	

}
