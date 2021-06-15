package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage {
	
	WebDriver driver;
	WebElement emailFieldForLogin;
	WebElement passwordField;
	WebElement signInButton;
	WebElement errorLoginMessage;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	// Path for Elements on the page
	
	public WebElement getEmailFieldForLogin () {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordField () {
		return driver.findElement(By.id("passwd"));
	}
	
	public WebElement getSignInButton () {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getErrorLoginMessage () {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p"));
	}
	
	
	
	
	
	// actions that can be taken on the page
	
	public void insertEmailAdress (String emailAdress) {
		getEmailFieldForLogin().clear();
		getEmailFieldForLogin().sendKeys(emailAdress);
	}
	
	public void inserPassword (String password) {
		getPasswordField().clear();
		getPasswordField().sendKeys(password);
	}
	
	public void clickSignInButton () {
		getSignInButton().click();
	}
	
	public String textFromErrorLoginMessage () {		// verification that the login function wasn't successful
		return getErrorLoginMessage().getText();
	}
	

}
