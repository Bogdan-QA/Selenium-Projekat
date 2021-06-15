package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountPageTests extends BaseTests{
	
	@BeforeMethod
	public void beforeEveryTest () {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
		loginFunction();		
	}
	
//	@Test
//	public void orderHistoryAndDetails () {
//		String textForAssertion = excelReader.getStringData("TS03-TC02", 10, 10);
//		myAccountPage.clickOrderHistoryAndDetails();
//	}
	
	
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
