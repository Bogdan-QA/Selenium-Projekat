package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistsTests extends BaseTests{
	
	@BeforeMethod
	public void beforeEveryTest () {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1) 
	public void createNewWishlist () {
		String wishlistName = excelReader.getStringData("TS04-TC06", 9, 10);
		String textForAssertion = excelReader.getStringData("TS04-TC06", 10, 10);
		loginFunciton();
		myAccountPage.clickMyWishlistsButton();
		myWishlistsPage.insertWishlistName(wishlistName);
		myWishlistsPage.clickWishlistSaveButton();
		String actualText = myWishlistsPage.textFromWishlistConfirmationMessage();
		assertEquals(actualText, textForAssertion);
	}
		
	@Test (priority = 2)
	public void addProductToWishlist () {
		int numForAssertion = excelReader.getIntData("TS04-TC07", 15, 10);
		String textForAssertion = Integer.toString(numForAssertion);
		loginFunciton();
		myAccountPage.clickMyWishlistsButton();
		myWishlistsPage.clickOnTheProductName();
		productPage.clickOnAddToWishlistButton();
		productPage.clickOntheCloseButton();
		myAccountPage.clickMyAccountButton();
		myAccountPage.clickMyWishlistsButton();
		myWishlistsPage.clickOnProductNameInWishlist();
		String actualText = myWishlistsPage.productQuantityFromList();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority = 3)
	public void deleteWishlist () {
		loginFunciton();
		myAccountPage.clickMyWishlistsButton();
		myWishlistsPage.clickXToDeleteWishlist();
		driver.switchTo().alert().accept();
		try {
			myWishlistsPage.getDeleteWishlistButton();
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
