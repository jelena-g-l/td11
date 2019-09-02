package zavrsni.Testovi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import zavrsni.Utils.Utils;
 
@Test
public class DodavanjeZgradeTest {
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
		
	} 
	
	
	 @Test(priority = 1)
	public void dodajZgradu() {
		pocetnaPage.getPocetnaAdmin().isDisplayed();
		assertEquals(driver.getCurrentUrl(), baseUrl + "pocetna");
		pocetnaPage.getZgradeLink().isDisplayed();
		pocetnaPage.getZgradeLink().click();
		
		assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade");
		assertTrue(zgradeDodavanjePage.getFormDodavanje().isDisplayed());
		
		assertTrue(zgradeDodavanjePage.getMesto().isDisplayed());
		assertTrue(zgradeDodavanjePage.getUlica().isDisplayed());
		assertTrue(zgradeDodavanjePage.getBroj().isDisplayed());
		assertTrue(zgradeDodavanjePage.getBrojStanova().isDisplayed());
		assertTrue(zgradeDodavanjePage.getDodajteBtnDesabled().isDisplayed());
		assertTrue(zgradeDodavanjePage.getResetujteBtn().isDisplayed());
		
		zgradeDodavanjePage.createZgrada("Novi Sad", "Beogradska", "41", "76");
		
		
		String expected = "Uspesno ste dodali zgradu!";
		
		assertEquals(zgradeDodavanjePage.getUspesnoSteUneliMsg(), expected);
		zgradeDodavanjePage.notPresentSuccessMsg();
		//boolean isPresent = true;
		//assertEquals(zgradePregledPage.isZgradaInTable("Proleterska 4, Beograd"), isPresent);

		
	} 
	@Test(priority=4)
	public void dodajIstuZgradu() {
		//assertEquals(driver.getCurrentUrl(), baseUrl + "pocetna");
		//pocetnaPage.getZgradeLink().isDisplayed();
		//pocetnaPage.getZgradeLink().click();
		assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade");
		//assertTrue(zgradeDodavanjePage.getFormDodavanje().isDisplayed());
		
		zgradeDodavanjePage.createZgrada("Novi Sad", "Beogradska", "41", "76");
		//assertTrue(zgradeDodavanjePage.getDodajteBtnDesabled().isDisplayed());
		//zgradeDodavanjePage.getDodajteBtn().click();
        String expected1 = "Vec postoji zgrada na toj adresi!";
		
		assertEquals(zgradeDodavanjePage.getErrorVecPostoji(), expected1);
		zgradeDodavanjePage.notPresentErrorMsg();
	}
	 
	@Test(priority=2)
	public void testReset() {
		//assertEquals(driver.getCurrentUrl(), baseUrl + "pocetna");
		//pocetnaPage.getZgradeLink().isDisplayed();
		//pocetnaPage.getZgradeLink().click();
		
		assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade");
		//assertTrue(zgradeDodavanjePage.getFormDodavanje().isDisplayed());
		zgradeDodavanjePage.setUlica("Motorska");
		//String ulica = zgradeDodavanjePage.getUlica().getText();
		//String expected = "Kotorska";
		//assertEquals(ulica, expected);
		assertTrue(zgradeDodavanjePage.getResetujteBtn().isDisplayed());
		zgradeDodavanjePage.getResetujteBtn().click();
		String ulica2 = zgradeDodavanjePage.getUlica().getText();
		String expected2 = "";
		assertEquals(expected2, ulica2);

	
	} 
	@Test(priority=3)
	public void dodajPrazno() {
		//assertEquals(driver.getCurrentUrl(), baseUrl + "pocetna");
		//pocetnaPage.getZgradeLink().isDisplayed();
		//pocetnaPage.getZgradeLink().click();
		
		assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade");
		
		zgradeDodavanjePage.setMesto("");
		zgradeDodavanjePage.setUlica("");
		zgradeDodavanjePage.setBroj("");
		zgradeDodavanjePage.setBrojStanova("");
		String expected = "Ovo polje ne sme biti prazno!";
		assertEquals(zgradeDodavanjePage.getErrorInput(), expected );
		
	}
	@Test(priority=5)
	public void daLiJeUTabeli() {
	assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade");
	assertTrue(zgradeDodavanjePregledPage.getPregledBtn().isDisplayed());
	zgradeDodavanjePregledPage.getPregledBtn().click();
	assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade/pregled");
	
	//nije dobar selektor izgleda
	//assertTrue(zgradePregledPage.getTableZgrade().isDisplayed());
	
	//Kada su oba inputa za pretrage prazna i kada se klikne na dugme Pretraga izbaci tabelu sa svim rezultatima..
	//Kada se ukuca samo jedno slovo u bilo koje od ova dva polja kao rezultat se dobija tabela sa rezultatima koji sadrze u sebi zadato slovo(ne nuzno pocetno).
	assertTrue(zgradePregledPage.getPretragaUlicaBroj().isDisplayed());
	assertTrue(zgradePregledPage.getPretragaGrad().isDisplayed());
	assertTrue(zgradePregledPage.getPretragaBtn().isDisplayed());
	
	zgradePregledPage.setPretragaUlicaBroj("Beogradska 41");
	zgradePregledPage.setPretragaGrad("Novi Sad");
	zgradePregledPage.getPretragaBtn().click();
	
	//assertTrue(zgradePregledPage.getTableZgrade().isDisplayed());
	assertTrue(zgradePregledPage.isZgradaInTable("Beogradska 41, Novi Sad"));
}
	
	
	@AfterSuite
	public void closeSelenium() {
		meniPage.getIzlogujteSeBtn().click();
		driver.quit();
	}
}
