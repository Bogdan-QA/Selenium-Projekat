package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class MyPersonalInformationPage {
	
	Select select;
	WebDriver driver;
	WebElement mrGenderRadioButton;
	WebElement mrsGenderRadioButton;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement dateOfBirthField;
	WebElement monthOfBirth;
	WebElement yearOfBirth;
	WebElement passwordField;
	WebElement saveButton;
	WebElement confirmationMessageOnUpdate;
	WebElement backToYourAccountButton;
	WebElement emptyMandatoryFieldError;

	public MyPersonalInformationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	// Path for Elements on the page
	
	public WebElement getEmptyMandatoryFieldError () {									//confirmation text that the update is not possible without mandatory fields.
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/p"));
	}
	
	public WebElement getBackToYourAccountButton () {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a"));
	}
	
	public WebElement getConfirmationMessageOnUpdate () {								// confirmation of the successful update.
		return driver.findElement(By.cssSelector("p[class*=alert]"));
	}
	
	public WebElement getSaveButton () {
		return driver.findElement(By.cssSelector("button[name=submitIdentity]"));
	}
	
	public WebElement getPasswordField () {
		return driver.findElement(By.id("old_passwd"));
	}
	
	public WebElement getYearOfBirth () {
		return driver.findElement(By.id("years"));
	}
	
	public WebElement getMonthOfBirth () {
		return driver.findElement(By.id("months"));
	}
	
	public WebElement getDateOfBirthField () {
		return driver.findElement(By.id("days")); 			
	}
	
	public WebElement getMrGenderRadioButton () {
		return driver.findElement(By.id("id_gender1"));
	}
	
	public WebElement getMrsGenderRadioButton () {
		return driver.findElement(By.id("id_gender2"));
	}
	
	public WebElement getFirstNameField () {
		return driver.findElement(By.id("firstname"));
	}
	
	public WebElement getLastNameField () {
		return driver.findElement(By.id("lastname"));
	}
	
	// actions that can be taken on the page
	
	public String textFromEmptyMandatoryFieldError () {
		return getEmptyMandatoryFieldError().getText();
	}
	
	public void clickBackToYourAccountButton () {
		getBackToYourAccountButton().click();
	}
	
	public String textFromConfirmationMessage () {
		return getConfirmationMessageOnUpdate().getText();
	}
	
	public void clickSaveButton () {
		getSaveButton().click();
	}
	
	public void insertPassword (String password) {
		getPasswordField().clear();
		getPasswordField().sendKeys(password);
	}
	
	public void selectYearOfBirth (String date) {
		select = new Select(getYearOfBirth());
		select.selectByValue(date);
	}
	
	public void selectMonthOfBirth (String date) {
		select = new Select(getMonthOfBirth());
		select.selectByValue(date);
	}
	
	public void selectDateOfBirth (String date) {
		select = new Select(getDateOfBirthField());
		select.selectByValue(date);
	}
	
	public void clickMrGenderRadioButton () {
		getMrGenderRadioButton().click();
	}
	
	public void clickMrsGenderRadioButton () {
		getMrsGenderRadioButton().click();
	}
	
	public void insertFirstName (String firstName) {
		getFirstNameField().clear();
		getFirstNameField().sendKeys(firstName);
	}
	
	public void insertLastName (String lastName) {
		getLastNameField().clear();
		getLastNameField().sendKeys(lastName);
	}
	

}
