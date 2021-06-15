package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyOrderPage {
	
	WebDriver driver;
	WebElement productNameDescription;
	WebElement trashCanIcon;
	WebElement confirmationMessageEmptyCart;

	public MyOrderPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	// Path for Elements on the page
	
	public WebElement getConfirmationMessageEmptyCart () {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));   // path for confirmation that the cart is empty.
	}
	
	public WebElement getTrashCanIcon () {
		return driver.findElement(By.cssSelector("i[class=icon-trash]")); // path for trash can icon to delete the product from the cart.
	}
	
	public WebElement getProductNameDescription () {
		return driver.findElement(By.xpath("//*[@id=\"product_7_34_0_520342\"]/td[2]/p"));
	}
	
	// actions that can be taken on the page
	
	public String textConfirmationMessageEmptyCart () {
		return getConfirmationMessageEmptyCart().getText();
	}
	
	public void clickTrashCanIcon () {
		getTrashCanIcon().click();
	}
	
	public String textFromProductNameDesription () {				// verification that the product is in the cart.
		return getProductNameDescription().getText();
	}

}
