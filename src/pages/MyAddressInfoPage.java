package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyAddressInfoPage {
	
	Select select;
	WebDriver driver;
	WebElement myAddressLine1;
	WebElement myAddressLine2;
	WebElement saveButton;
	WebElement cityField;
	WebElement postCodeField;
	WebElement state;
	WebElement homePhone;
	WebElement addressTitle;

	public MyAddressInfoPage(WebDriver driver) {
		super();
		this.driver = driver;
		
	}
	
	// Path for Elements on the page
	
	public WebElement getAddressTitle () {
		return driver.findElement(By.id("alias"));
	}
	
	public WebElement getHomePhone () {
		return driver.findElement(By.id("phone"));
	}
	
	public WebElement getState () {
		return driver.findElement(By.id("id_state"));
	}
	
	public WebElement getMyPostCodeField () {
		return driver.findElement(By.id("postcode"));
	}
	
	public WebElement getMyCityField () {
		return driver.findElement(By.id("city"));
	}
	
	public WebElement getMyAddressLine1 () {
		return driver.findElement(By.id("address1"));
	}
	
	public WebElement getMyAddressLine2 () {
		return driver.findElement(By.id("address2"));
	}
	
	public WebElement getSaveButton () {
		return driver.findElement(By.id("submitAddress"));
	}
	
	// actions that can be taken on the page
	
	public void chooseState () {
		select = new Select(getState());
		select.selectByValue("9");						// Value is "Florida"
							
	}
	
	public void insertAddressTitle (String addressTitle) {     //address title field
		getAddressTitle().clear();
		getAddressTitle().sendKeys(addressTitle);
	}
	
	public void insertHomePhone (String phoneNum) { 		// home phone number
		getHomePhone().clear();
		getHomePhone().sendKeys(phoneNum);
	}
	
	public void clickState () {							// click on the state drop-down menu
		getState().click();
	}
	
	public void insertPostalCode (String postalCode) {  // postal code field
		getMyPostCodeField().clear();
		getMyPostCodeField().sendKeys(postalCode);
	}
	
	public void insertCityField (String city) { 		// city field
		getMyCityField().clear();
		getMyCityField().sendKeys(city);
	}
	
	public void insertMyaddressLine1 (String address) { 	// main address
		getMyAddressLine1().clear();
		getMyAddressLine1().sendKeys(address);
	}
	
	public void insertMyAddressLine2 (String address) {		// 2nd address
		getMyAddressLine2().clear();
		getMyAddressLine2().sendKeys(address);
	}
	
	public void clickSaveButton () {
		getSaveButton().click();
	}
	

}
