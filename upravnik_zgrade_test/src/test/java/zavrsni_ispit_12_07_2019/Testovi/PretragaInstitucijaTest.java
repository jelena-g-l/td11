package zavrsni_ispit_12_07_2019.Testovi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import zavrsni.Page.admin.AdminMeniPage;
import zavrsni.Page.admin.AdminPocetnaPage;
import zavrsni.Page.institucije.DodavanjeInstitucijaPage;
import zavrsni.Page.login.LoginPage;
import zavrsni.Page.pregledInstitucija.PregledInstitucijaPage;

@Test
public class PretragaInstitucijaTest {

	private WebDriver driver;
	private LoginPage loginPage;
	private AdminPocetnaPage pocetnaPage;
	private AdminMeniPage meniPage;
	private String baseUrl;
	private DodavanjeInstitucijaPage dodavanjeInstitucijaPage;
	private PregledInstitucijaPage pregledInstitucijaPage;
	
	@BeforeSuite
	public void setupSelenium() {
		baseUrl = "http://localhost:8080/";
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
		
		loginPage = new LoginPage(driver);
		pocetnaPage = new AdminPocetnaPage(driver);
		meniPage = new AdminMeniPage(driver);
		dodavanjeInstitucijaPage = new DodavanjeInstitucijaPage(driver);
		pregledInstitucijaPage = new PregledInstitucijaPage (driver);
		loginPage.login("admin@gmail.com", "Bar5slova");
		
		
		assertEquals(driver.getCurrentUrl(), baseUrl + "pocetna");
		pocetnaPage.getInstitucijeLink().isDisplayed();
		pocetnaPage.getInstitucijeLink().click();

	
		
		assertEquals(driver.getCurrentUrl(), baseUrl + "institucije");
		assertTrue(pregledInstitucijaPage.getPregledBtn().isDisplayed());
		   pregledInstitucijaPage.getPregledBtn().click();
		   
		   assertEquals(driver.getCurrentUrl(), baseUrl + "institucije/pregled");
		
	}
	
	@Test(priority=1)
	public void pretragaImena(){
		
		
			
			assertTrue(pregledInstitucijaPage.getPretragaImePrezimeEmail().isDisplayed());
			assertTrue(pregledInstitucijaPage.getPretragaBtn().isDisplayed());
			pregledInstitucijaPage.setPretragaPretragaImePrezimeEmail("Policija");
			pregledInstitucijaPage.getPretragaBtn().click();
			
			assertTrue(pregledInstitucijaPage.isInstitucijaInTable("Policija"));
			pregledInstitucijaPage.getPretragaImePrezimeEmail().clear();
	}
	@Test(priority=2)
	public void pretragaEmaila(){
	
		   
		  
			
			assertTrue(pregledInstitucijaPage.getPretragaImePrezimeEmail().isDisplayed());
			assertTrue(pregledInstitucijaPage.getPretragaBtn().isDisplayed());
			pregledInstitucijaPage.setPretragaPretragaImePrezimeEmail("policija@gmail.com");
			pregledInstitucijaPage.getPretragaBtn().click();
			
			assertTrue(pregledInstitucijaPage.isInstitucijaInTable("policija@gmail.com"));
			pregledInstitucijaPage.getPretragaImePrezimeEmail().clear();
	}
	@Test(priority=3)
	public void pretragaNepostojecegEmaila(){
		
	
			
			assertTrue(pregledInstitucijaPage.getPretragaImePrezimeEmail().isDisplayed());
			assertTrue(pregledInstitucijaPage.getPretragaBtn().isDisplayed());
			pregledInstitucijaPage.setPretragaPretragaImePrezimeEmail("pica@gmail.com");
			pregledInstitucijaPage.getPretragaBtn().click();
			
			String expected= "Nijedna institucija sa trazenim kriterijumom nije prondajena!";
			assertTrue(pregledInstitucijaPage.isStringPresent("Nijedna institucija sa trazenim kriterijumom nije prondajena!"));
			
	}
	
	@AfterSuite
	public void closeSelenium() {
		meniPage.getIzlogujteSeBtn().click();
		driver.quit();
	}
}
