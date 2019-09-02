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
import zavrsni.Page.stanari.StanPage;
import zavrsni.Page.stanari.StanarPage;
import zavrsni.Page.stanari.StanariPregledPage;
import zavrsni.Page.stanari.StanariRegistracijaPage;
import zavrsni.Page.stanari.StanariRegistracijaPregledPage;
import zavrsni.Page.stanari.StanoviPage;
import zavrsni.Page.zgradaMeni.KvaroviPage;
import zavrsni.Page.zgrade.ZgradaMeniPage;
import zavrsni.Page.zgrade.ZgradaPage;
import zavrsni.Page.zgrade.ZgradeDodavanjePage;
import zavrsni.Page.zgrade.ZgradeDodavanjePregledPage;
import zavrsni.Page.zgrade.ZgradePregledPage;
import zavrsni.Utils.Utils;

@Test
public class ZgradaStanariTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private AdminPocetnaPage pocetnaPage;
	private AdminMeniPage meniPage;
	private String baseUrl;
	private ZgradeDodavanjePage zgradeDodavanjePage;
	private ZgradePregledPage zgradePregledPage;
	private ZgradeDodavanjePregledPage zgradeDodavanjePregledPage;
	private ZgradaPage zgradaPage;
	private ZgradaMeniPage zgradaMeniPage;
	private StanariRegistracijaPage stanariRegistracijaPage;
	private StanariRegistracijaPregledPage stanariRegistracijaPregledPage;
	private StanariPregledPage stanariPregledPage;
	private StanarPage stanarPage;
	private StanoviPage stanoviPage;
	private StanPage stanPage;
	private KvaroviPage kvaroviPage;
	
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
		zgradaPage = new ZgradaPage(driver);
		zgradaMeniPage = new ZgradaMeniPage(driver);
		stanariRegistracijaPage = new StanariRegistracijaPage(driver);
	    stanariRegistracijaPregledPage = new StanariRegistracijaPregledPage(driver);
		stanariPregledPage = new StanariPregledPage(driver);
		stanarPage = new StanarPage(driver);
	    stanoviPage = new StanoviPage(driver) ;
		stanPage = new StanPage(driver);
		kvaroviPage = new KvaroviPage(driver);
		
		
		loginPage.login("admin@gmail.com", "Bar5slova");
	
		pocetnaPage.getPocetnaAdmin().isDisplayed();
		pocetnaPage.getZgradeLink().isDisplayed();
		pocetnaPage.getZgradeLink().click();
		assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade");
		
	}
	 @Test(priority = 1)
		public void dodajZgradu1() {
			
			assertTrue(zgradeDodavanjePage.getFormDodavanje().isDisplayed());
			
			assertTrue(zgradeDodavanjePage.getMesto().isDisplayed());
			assertTrue(zgradeDodavanjePage.getUlica().isDisplayed());
			assertTrue(zgradeDodavanjePage.getBroj().isDisplayed());
			assertTrue(zgradeDodavanjePage.getBrojStanova().isDisplayed());
			assertTrue(zgradeDodavanjePage.getDodajteBtnDesabled().isDisplayed());
			assertTrue(zgradeDodavanjePage.getResetujteBtn().isDisplayed());
			
			zgradeDodavanjePage.createZgrada("Novi Sad", "Boska Buhe", "4", "2");
			
			
			String expected = "Uspesno ste dodali zgradu!";
			
			assertEquals(zgradeDodavanjePage.getUspesnoSteUneliMsg(), expected);
			zgradeDodavanjePage.notPresentSuccessMsg();
	 }
	@Test(priority = 2)
	public void getZgradaStanStanariTest(){
		assertTrue(zgradeDodavanjePregledPage.getPregledBtn().isDisplayed());
		zgradeDodavanjePregledPage.getPregledBtn().click();
		//zgradePregledPage.getTableZgrade().isDisplayed();
		assertEquals(driver.getCurrentUrl(), baseUrl + "zgrade/pregled");
		assertTrue(zgradePregledPage.getPretragaUlicaBroj().isDisplayed());
		assertTrue(zgradePregledPage.getPretragaGrad().isDisplayed());
		assertTrue(zgradePregledPage.getPretragaBtn().isDisplayed());
		
		zgradePregledPage.setPretragaUlicaBroj("Boska Buhe 4");
		zgradePregledPage.setPretragaGrad("Novi Sad");
		zgradePregledPage.getPretragaBtn().click();
		
		//assertTrue(zgradePregledPage.getTableZgrade().isDisplayed());
		assertTrue(zgradePregledPage.isZgradaInTable("Boska Buhe 4, Novi Sad"));
		
		zgradePregledPage.getAdresaZgradeLink("Boska Buhe 4, Novi Sad").click();
		assertTrue(zgradePregledPage.getTableZgrade().isDisplayed());
		
		zgradaMeniPage.getKvaroviLink().click();
		assertTrue(kvaroviPage.getCheckBox().isDisplayed());
		kvaroviPage.getCheckBox().click();
		assertTrue(kvaroviPage.getCheckBox().isSelected());
		
		zgradaMeniPage.getStanoviLink().click();
		assertTrue(zgradePregledPage.getTableZgrade().isDisplayed());
		
		zgradaPage.getVlasnikIStanariBtn1().click();
		assertTrue(stanPage.getFilter().isDisplayed());
		assertTrue(stanPage.getFiltriraj().isDisplayed());

		stanPage.setFilter("Janko Jankovic");
		stanPage.getFiltriraj().click();;
		assertTrue(stanPage.isStanarInTable("Janko Jankovic"));
		stanPage.getDodajUStanare("Janko Jankovic");
		
		String expected = "Uspesno ste dodali stanara!";
		assertEquals(stanPage.getSuccessMsg(), expected);
		stanPage.notPresentSuccessMsg();
		
		assertTrue(stanPage.getTableStanari().isDisplayed());
		assertTrue(stanPage.isStanarInTable("Janko Jankovic"));
		stanPage.getPostaviZaVlasnika("Janko Jankovic");
		String expected1 = "Uspesno ste postavili vlasnika!";
		assertEquals(stanPage.getSuccessMsgV(), expected1);
		stanPage.notPresentSuccessMsgV();
		
		
		stanPage.getPostaviZaPredsednika("Janko Jankovic");
		String expected2 = "Uspesno ste postavili predsednika zgrade!";
		assertEquals(stanPage.getSuccessMsgV(), expected2);
		stanPage.notPresentSuccessMsgV();
		
		assertTrue(stanPage.BtnUkloniVlasnika().isDisplayed());
		stanPage.BtnUkloniVlasnika().click();;
		String expected3 = "Uspesno ste uklonili vlasnika!";
		assertEquals(stanPage.getSuccessMsg(), expected3);
		stanPage.notPresentSuccessMsg();
		
		stanPage.getUkloni("Janko Jankovic");
		String expected4 = "Uspesno ste uklonili stanara!";
		assertEquals(stanPage.getSuccessMsgV(), expected4);
		stanPage.notPresentSuccessMsgV();
		
		
	}
	
	
	@AfterSuite
	public void closeSelenium() {
		meniPage.getIzlogujteSeBtn().click();
		driver.quit();
	}
}
