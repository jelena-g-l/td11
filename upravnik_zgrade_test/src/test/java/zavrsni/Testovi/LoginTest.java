package zavrsni.Testovi;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import zavrsni.Page.admin.AdminMeniPage;
import zavrsni.Page.admin.AdminPocetnaPage;
import zavrsni.Page.login.LoginPage;
import zavrsni.Page.predSkup.PredSkupMeniPage;



@Test
public class LoginTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private AdminPocetnaPage pocetnaPage;
	private AdminMeniPage meniPage;
	private String baseUrl;
	private PredSkupMeniPage predSkupMeniPage;


	
	@BeforeTest
	public void setupSelenium() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://localhost:8080");

		loginPage = new LoginPage(driver);
		pocetnaPage = new AdminPocetnaPage(driver);
		meniPage = new AdminMeniPage(driver);
		predSkupMeniPage = new PredSkupMeniPage(driver);
	}	
	
	/*@BeforeTest
	public void setupPages() {
		loginPage = new LoginPage(driver);
		pocetnaPage = new PocetnaPage(driver);
		meniPage = new MeniPage(driver);
}*/
	@Test(priority=1)
	public void loginAdmin() {
		loginPage.login("admin@gmail.com", "Bar5slova");
		assertTrue(meniPage.getIzlogujteSeBtn().isDisplayed());
		
		String expectedLoginEmailString = "admin@gmail.com   ";
		assertEquals(meniPage.getLoginConfirmationEmailString("admin@gmail.com"),expectedLoginEmailString);
		meniPage.getIzlogujteSeBtn().click();
	}
	@Test(priority=2)
	public void loginPredSkup() {
		loginPage.login("predSkup@gmail.com", "Bar5slova");
		
		String expectedLoginEmailString = "predSkup@gmail.com   ";
		assertEquals(meniPage.getLoginConfirmationEmailString("predSkup@gmail.com   "),expectedLoginEmailString);
		assertTrue(meniPage.getIzlogujteSeBtn().isDisplayed());
		meniPage.getIzlogujteSeBtn().click();
	} 
	@Test(priority=3)
	public void loginStanar() {
		loginPage.login("marko@gmail.com", "Bar5slova");
		
		String expectedLoginEmailString = "marko@gmail.com   ";
		assertEquals(meniPage.getLoginConfirmationEmailString("marko@gmail.com   "),expectedLoginEmailString);
		assertTrue(meniPage.getIzlogujteSeBtn().isDisplayed());
		
		
	}
	
	@Test(priority=4)
	public void logout(){
		meniPage.getIzlogujteSeBtn().click();
		
		assertTrue(loginPage.getUlogujSeBtn().isDisplayed());
		driver.quit();
	} 
	@AfterTest
	public void quitSelenium(){
		
		driver.quit();
	}
	
	
}