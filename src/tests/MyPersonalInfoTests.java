package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class MyPersonalInfoTests extends BaseTests{
	
	@BeforeMethod
	public void beforeEveryTest () {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1) 
	
	public void editPersonalInfo () {
		int dateOfBirth = excelReader.getIntData("TS04-TC04", 11, 12);
		String dateBirth = Integer.toString(dateOfBirth);
		int monthOfBirth = excelReader.getIntData("TS04-TC04", 11, 13);
		String monthBirth = Integer.toString(monthOfBirth);
		int yearOfBirth = excelReader.getIntData("TS04-TC04", 11, 14);
		String yearBirth = Integer.toString(yearOfBirth);
		String firstName = excelReader.getStringData("TS04-TC04", 12, 12);
		String lastName = excelReader.getStringData("TS04-TC04", 13, 12);
		String password = excelReader.getStringData("TS04-TC04", 14, 12);
		String textForAssertion = excelReader.getStringData("TS04-TC04", 15, 12);
		loginFunciton();
		myAccountPage.clickMyPersonalInformation();
		myPersonalInfoPage.clickMrsGenderRadioButton();
		myPersonalInfoPage.selectDateOfBirth(dateBirth);
		myPersonalInfoPage.selectMonthOfBirth(monthBirth);
		myPersonalInfoPage.selectYearOfBirth(yearBirth);
		myPersonalInfoPage.insertFirstName(firstName);
		myPersonalInfoPage.insertLastName(lastName);
		myPersonalInfoPage.insertPassword(password);
		myPersonalInfoPage.clickSaveButton();
		String actualText = myPersonalInfoPage.textFromConfirmationMessage();
		assertEquals(actualText, textForAssertion);
		myPersonalInfoPage.clickBackToYourAccountButton();
		setInitialPersonalInfo();
		assertEquals(actualText, textForAssertion);
		
	}
	
	@Test (priority = 2)
	public void updateWithMandatoryFieldsEmpty () {		
		String password = excelReader.getStringData("TS04-TC05", 12, 10);
		String textForAssertion = excelReader.getStringData("TS04-TC05", 13, 10);
		loginFunciton();
		myAccountPage.clickMyPersonalInformation();
		myPersonalInfoPage.getFirstNameField().clear();
		myPersonalInfoPage.getLastNameField().clear();
		myPersonalInfoPage.insertPassword(password);
		myPersonalInfoPage.clickSaveButton();
		String actualText = myPersonalInfoPage.textFromEmptyMandatoryFieldError();
		assertEquals(actualText, textForAssertion);
		
	}
		
	
	public void setInitialPersonalInfo () {
		int dateOfBirth = excelReader.getIntData("TS04-TC04", 11, 7);
		String dateBirth = Integer.toString(dateOfBirth);
		int monthOfBirth = excelReader.getIntData("TS04-TC04", 11, 8);
		String monthBirth = Integer.toString(monthOfBirth);
		int yearOfBirth = excelReader.getIntData("TS04-TC04", 11, 9);
		String yearBirth = Integer.toString(yearOfBirth);
		String firstName = excelReader.getStringData("TS04-TC04", 12, 7);
		String lastName = excelReader.getStringData("TS04-TC04", 13, 7);
		String password = excelReader.getStringData("TS04-TC04", 14, 7);
		myAccountPage.clickMyPersonalInformation();
		myPersonalInfoPage.clickMrGenderRadioButton();
		myPersonalInfoPage.selectDateOfBirth(dateBirth);
		myPersonalInfoPage.selectMonthOfBirth(monthBirth);
		myPersonalInfoPage.selectYearOfBirth(yearBirth);
		myPersonalInfoPage.insertFirstName(firstName);
		myPersonalInfoPage.insertLastName(lastName);
		myPersonalInfoPage.insertPassword(password);
		myPersonalInfoPage.clickSaveButton();
	}
	public void loginFunciton () {
		String emailAddress = excelReader.getStringData("TS01-TC01", 10, 10);
		String password = excelReader.getStringData("TS01-TC01", 11, 10);		
		homepage.clickSignInButton();
		loginPage.insertEmailAdress(emailAddress);
		loginPage.inserPassword(password);
		loginPage.clickSignInButton();
		
	}
	
	@AfterMethod
	public void afterEveryMethod() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
