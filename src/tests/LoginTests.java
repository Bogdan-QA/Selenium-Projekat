package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{
	
	@BeforeMethod
	public void beforeEveryTest () {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1) 
	public  void loginValidCredentials () {
		String emailAddress = excelReader.getStringData("TS01-TC01", 10, 10);
		String password = excelReader.getStringData("TS01-TC01", 11, 10);	
		String textForAssertion = excelReader.getStringData("TS01-TC01", 13, 10);
		homepage.clickSignInButton();
		loginPage.insertEmailAdress(emailAddress);
		loginPage.inserPassword(password);
		loginPage.clickSignInButton();			
		String actualText = myAccountPage.textFromSignOutButton();		
		assertEquals(actualText, textForAssertion);		
	}
	
	@Test (priority = 2)
	public void loginInvalidCredentials () {
		String emailAddress = excelReader.getStringData("TS01-TC02", 10, 10);
		String password = excelReader.getStringData("TS01-TC02", 11, 10);
		String textForAssertion = excelReader.getStringData("TS01-TC02", 13, 10);
		homepage.clickSignInButton();
		loginPage.insertEmailAdress(emailAddress);
		loginPage.inserPassword(password);
		loginPage.clickSignInButton();
		String actualText = loginPage.textFromErrorLoginMessage();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority = 3)
	public void loginValidEmailInvalidPassword () {
		String emailAddress = excelReader.getStringData("TS01-TC03", 10, 10);
		String password = excelReader.getStringData("TS01-TC03", 11, 10);
		String textForAssertion = excelReader.getStringData("TS01-TC03", 13, 10);
		homepage.clickSignInButton();
		loginPage.insertEmailAdress(emailAddress);
		loginPage.inserPassword(password);
		loginPage.clickSignInButton();
		String actualText = loginPage.textFromErrorLoginMessage();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority = 4) 
	public void loginInvalidEmailValidPassword () {
		String emailAddress = excelReader.getStringData("TS01-TC04", 10, 10);
		String password = excelReader.getStringData("TS01-TC04", 11, 10);
		String textForAssertion = excelReader.getStringData("TS01-TC04", 13, 10);
		homepage.clickSignInButton();
		loginPage.insertEmailAdress(emailAddress);
		loginPage.inserPassword(password);
		loginPage.clickSignInButton();
		String actualText = loginPage.textFromErrorLoginMessage();
		assertEquals(actualText, textForAssertion);
		
	}
	
	@Test (priority = 5)
	public void loginEmptyEmailValidPassword () {		
		String password = excelReader.getStringData("TS01-TC05", 11, 10);
		String textForAssertion = excelReader.getStringData("TS01-TC05", 13, 10);
		homepage.clickSignInButton();
		loginPage.inserPassword(password);
		loginPage.getEmailFieldForLogin().clear();
		loginPage.clickSignInButton();
		String actualText = loginPage.textFromErrorLoginMessage();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority = 6)
	public void loginValidEmailEmptyPassword () {		
		String emailAddress = excelReader.getStringData("TS01-TC06", 10, 10);
		String textForAssertion = excelReader.getStringData("TS01-TC06", 13, 10);
		homepage.clickSignInButton();
		loginPage.insertEmailAdress(emailAddress);
		loginPage.getPasswordField().clear();	
		loginPage.clickSignInButton();
		String actualText = loginPage.textFromErrorLoginMessage();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority = 7) 
	public void loginEmptyCredentials () {
		String textForAssertion = excelReader.getStringData("TS01-TC07", 13, 10);
		homepage.clickSignInButton();
		loginPage.getEmailFieldForLogin().clear();
		loginPage.getPasswordField().clear();
		loginPage.clickSignInButton();
		String actualText = loginPage.textFromErrorLoginMessage();
		assertEquals(actualText, textForAssertion);
	}
	
	
	@AfterMethod
	public void afterEveryMethod() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	public void loginFunciton () {
		String emailAddress = excelReader.getStringData("TS01-TC01", 10, 10);
		String password = excelReader.getStringData("TS01-TC01", 11, 10);		
		homepage.clickSignInButton();
		loginPage.insertEmailAdress(emailAddress);
		loginPage.inserPassword(password);
		loginPage.clickSignInButton();
		
	}

}
