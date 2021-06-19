package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class OrderProductTests extends BaseTests{
	
	@BeforeMethod
	public void beforeEveryTest () {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1) 
	public void addProductToCart () {
		String textForAssertion = excelReader.getStringData("TS03-TC01", 14, 10);
		loginFunciton();
		myAccountPage.clickMyWishlistsButton();
		myWishlistsPage.clickOnTheProductName();
		productPage.clickAddToCartButton();
		productPage.clickClosePopupAfterAddingToCart();
		categoryProductPage.clickOnViewCartButton();
		String actualText = myOrderPage.textFromProductNameDesription();
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority = 2) 
	public void removeProductFromCart () throws InterruptedException {
		String textForAssertion = excelReader.getStringData("TS03-TC02", 13, 10);
		loginFunciton();
		myAccountPage.clickMyWishlistsButton();
		myWishlistsPage.clickOnTheProductName();
		productPage.clickAddToCartButton();
		productPage.clickProceedToCheckoutButton();
		myOrderPage.clickTrashCanIcon();
		wait.until(ExpectedConditions.textToBePresentInElement(myOrderPage.getConfirmationMessageEmptyCart(), textForAssertion));											// resi waiter.
		String actualText = myOrderPage.textConfirmationMessageEmptyCart();
		assertEquals(actualText, textForAssertion);
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
