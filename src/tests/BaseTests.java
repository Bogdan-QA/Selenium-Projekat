package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.*;

public class BaseTests {
	
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor js;
	ExcelReader excelReader;
	WebDriver driver;
	String homeURL;
	Homepage homepage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	MyAddressInfoPage myAddressInfoPage;
	MyPersonalInformationPage myPersonalInfoPage;
	MyWishlistsPage myWishlistsPage;
	ProductPage productPage;
	CategoryProductPage categoryProductPage;
	MyOrderPage myOrderPage;

	@BeforeClass
	public void beforeAllTests() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		homeURL = "http://automationpractice.com/index.php";
		excelReader = new ExcelReader("data/Selenium Projekat.xlsx");
		homepage = new Homepage(driver);
		loginPage = new LoginPage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAddressesPage = new MyAddressesPage(driver);
		myAddressInfoPage = new MyAddressInfoPage(driver);
		myPersonalInfoPage = new MyPersonalInformationPage(driver);
		myWishlistsPage = new MyWishlistsPage(driver);
		productPage = new ProductPage(driver);
		categoryProductPage = new CategoryProductPage(driver);
		myOrderPage = new MyOrderPage(driver);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);

	}

	@AfterClass

	public void afterAllTests() {
		driver.close();
	}

}
