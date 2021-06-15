package tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class MyAddressTests extends BaseTests{
	
	
	
	@BeforeMethod
	public void beforeEveryTest () {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	public void updateAddress () {
		String address2 = excelReader.getStringData("TS04-TC01", 11, 10);
		String textForAssertion = excelReader.getStringData("TS04-TC01", 13, 10);
		loginFunciton();
		myAccountPage.clickMyAddresses();
		myAddressesPage.clickUpdateButton();
		myAddressInfoPage.insertMyAddressLine2(address2);
		myAddressInfoPage.clickSaveButton();
		String actualText = myAddressesPage.textFromAddress2();
		assertEquals(actualText, textForAssertion);
		myAddressesPage.clickUpdateButton();
		myAddressInfoPage.getMyAddressLine2().clear();
		myAddressInfoPage.clickSaveButton();
		String actualText2 = myAddressesPage.textFromAddress2();
		assertEquals(actualText2, "");
		
	}
	
	@Test (priority=2) 
	public void addAddress () {
		String address = excelReader.getStringData("TS04-TC02", 11, 10);
		String city = excelReader.getStringData("TS04-TC02", 12, 10);
		int postalCode = excelReader.getIntData("TS04-TC02", 14, 10);
		String postalCode2= Integer.toString(postalCode);
		String homePhone = excelReader.getStringData("TS04-TC02", 15, 10);
		String addressTitle = excelReader.getStringData("TS04-TC02", 16, 10);
		String textForAssertion = excelReader.getStringData("TS04-TC02", 17, 10);
		loginFunciton();
		myAccountPage.clickMyAddresses();
		myAddressesPage.clickAddNewAddress();
		myAddressInfoPage.insertMyaddressLine1(address);
		myAddressInfoPage.insertCityField(city);
		myAddressInfoPage.chooseState();
		myAddressInfoPage.insertPostalCode(postalCode2);
		myAddressInfoPage.insertHomePhone(homePhone);
		myAddressInfoPage.insertAddressTitle(addressTitle);
		myAddressInfoPage.clickSaveButton();
		String actucalText = myAddressesPage.textOfSecondAddress();
		assertEquals(actucalText, textForAssertion);		
	}
	
	@Test (priority = 3)
	public void deleteAddress () {
		loginFunciton();
		myAccountPage.clickMyAddresses();
		myAddressesPage.clickDeleteButtonOfSecondAddress();
		driver.switchTo().alert().accept();
		try {
			myAddressesPage.getDeleteButtonSecondAddress();
		} catch (Exception e) {
			assertTrue(true);
		}
		
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
