package pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class MyAddressesPage {
	
//	Actions action = new Actions(driver);
//	action.sendKeys(Keys.ESCAPE).build().perform();
	Actions action;
	WebDriver driver;
	WebElement updateButton;
	WebElement deleteButton;
	WebElement addNewAddress;
	WebElement address2Name;		// confirmation that the second address is added to address num 1
	WebElement locationOfSecondAddress;			// confirmation that the whole address can be added.
	WebElement deleteButtonSecondAddress;

	public MyAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	// Path for Elements on the page
	
	public WebElement getDeleteButtonSecondAddress () {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]/span/i"));
	}
	
	public WebElement getLocationOfSecondAddress () {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[1]/h3"));
	}
	
	public WebElement getUpdateButton () {
		return driver.findElement(By.cssSelector("a[title=Update]"));
	}
	
	public WebElement getDeleteButton () {
		return driver.findElement(By.cssSelector("a[title=Delete]"));
	}
	
	public WebElement getAddNewAddress () {
		return driver.findElement(By.cssSelector("a[title*=Add]"));
	}
	
	public WebElement getAddress2Name () {
		return driver.findElement(By.cssSelector("span[class*=address2]"));
	}
	
	
	// actions that can be taken on the page
	
	public void sendEnterKey () {
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
	}
	
	public void clickDeleteButtonOfSecondAddress () {
		getDeleteButtonSecondAddress().click();
	}
	
	public String textOfSecondAddress () {
		return getLocationOfSecondAddress().getText(); 			// confirmation text for second address
	}
	
	public void clickUpdateButton () {
		getUpdateButton().click();
	}
	
	public void clickDeleteButton () {
		getDeleteButton().click();
	}
	
	public void clickAddNewAddress () {
		getAddNewAddress().click();
	}
	
	public String textFromAddress2 () {			// confirmation that in the address number 1 can be updated and added address number 2
		return getAddress2Name().getText();
	}
	

}
