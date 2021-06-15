package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTests{
	
		
	@BeforeMethod
	public void beforeEveryTest () {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1) 
	public void logoutFunction () {														// logout for the button in the right corner
		String textForAssertion = excelReader.getStringData("TS02-TC01", 10, 10);
		loginFunction();			
		myAccountPage.clickSignOutButton();
		String actualText = homepage.textFromSignInButton();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority = 2)
	public void logoutFunctionBottomButton () {											// logout for the button in the bottom of the page
		String textForAssertion = excelReader.getStringData("TS02-TC02", 10, 10);
		loginFunction();
		myAccountPage.clickSignOutBottomButton();
		String actualText = homepage.textFromSignInButton();
		assertEquals(actualText, textForAssertion);
	}
	
	
	@AfterMethod
	public void afterEveryMethod() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	public void loginFunction () {
		String emailAddress = excelReader.getStringData("TS01-TC01", 10, 10);
		String password = excelReader.getStringData("TS01-TC01", 11, 10);
		homepage.clickSignInButton();
		loginPage.insertEmailAdress(emailAddress);
		loginPage.inserPassword(password);
		loginPage.clickSignInButton();
	}

}
