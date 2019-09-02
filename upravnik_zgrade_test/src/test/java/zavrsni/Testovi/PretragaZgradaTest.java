package zavrsni.Testovi;

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
import zavrsni.Page.login.LoginPage;
import zavrsni.Page.zgrade.ZgradeDodavanjePage;
import zavrsni.Page.zgrade.ZgradeDodavanjePregledPage;
import zavrsni.Page.zgrade.ZgradePregledPage;

@Test
public class PretragaZgradaTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private AdminPocetnaPage pocetnaPage;
	private AdminMeniPage meniPage;
	private String baseUrl;
	private ZgradeDodavanjePage zgradeDodavanjePage;
	private ZgradePregledPage zgradePregledPage;
	private ZgradeDodavanjePregledPage zgradeDodavanjePregledPage;
	
	
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
		zgradeDodavanjePage = new ZgradeDodavanjePage(driver);
		zgradePregledPage = new ZgradePregledPage(driver);
		zgradeDodavanjePregledPage = new ZgradeDodavanjePregledPage(driver);
		
		loginPage.login("admin@gmail.com", "Bar5slova");
	
		pocetnaPage.getPocetnaAdmin().isDisplayed();
		pocetnaPage.getZgradeLink().isDisplayed();
		pocetnaPage.getZgradeLink().click();
		assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade");
		assertTrue(zgradeDodavanjePregledPage.getPregledBtn().isDisplayed());
		zgradeDodavanjePregledPage.getPregledBtn().click();
			
	} 
	//Kada su oba inputa za pretrage prazna i kada se klikne na dugme Pretraga izbaci tabelu sa svim rezultatima..
	//Kada se ukuca samo jedno slovo u bilo koje od ova dva polja kao rezultat se dobija tabela sa rezultatima koji sadrze u sebi zadato slovo(ne nuzno pocetno).
	@Test
	public void pretragaZgradeTest(){
		assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade/pregled");
		assertTrue(zgradePregledPage.getPretragaUlicaBroj().isDisplayed());
		assertTrue(zgradePregledPage.getPretragaGrad().isDisplayed());
		assertTrue(zgradePregledPage.getPretragaBtn().isDisplayed());
		
		zgradePregledPage.setPretragaUlicaBroj("Boska Buhe 42");
		zgradePregledPage.setPretragaGrad("Novi Sad");
		zgradePregledPage.getPretragaBtn().click();
		
		//assertTrue(zgradePregledPage.getTableZgrade().isDisplayed());
		assertTrue(zgradePregledPage.isZgradaInTable("Boska Buhe 42, Novi Sad"));
	}
	
	@Test
	public void pretragaNepostojeceZgradeTest(){
		assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade/pregled");
		assertTrue(zgradePregledPage.getPretragaUlicaBroj().isDisplayed());
		assertTrue(zgradePregledPage.getPretragaGrad().isDisplayed());
		assertTrue(zgradePregledPage.getPretragaBtn().isDisplayed());
		
		zgradePregledPage.setPretragaUlicaBroj("Molska 7");
		zgradePregledPage.setPretragaGrad("Padinska Skela");
		zgradePregledPage.getPretragaBtn().click();
		
		String expected = "Nijedna zgrada sa trazenim kriterijumima nije prondajena!";
		assertEquals(zgradePregledPage.getErrorTekst(), expected);
	}
	
	
	@AfterSuite
	public void closeSelenium() {
		meniPage.getIzlogujteSeBtn().click();
		driver.quit();
	}
}
