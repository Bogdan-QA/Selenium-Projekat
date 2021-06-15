package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Homepage {
	
	WebDriver driver;
	WebElement signInButton;

	public Homepage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	// Path for Elements on the page
	
	public WebElement getSignInButton () {
		return driver.findElement(By.className("login"));
	}
	
	// actions that can be taken on the page
	
	public void clickSignInButton () {			
		getSignInButton().click();
	}
	
	public String textFromSignInButton () {			// text for the verification that log out was successful.
		return getSignInButton().getText();
	}

}
