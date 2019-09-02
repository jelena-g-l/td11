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
import zavrsni.Page.stanari.StanPage;
import zavrsni.Page.stanari.StanarPage;
import zavrsni.Page.stanari.StanariPregledPage;
import zavrsni.Page.stanari.StanariRegistracijaPage;
import zavrsni.Page.stanari.StanariRegistracijaPregledPage;
import zavrsni.Page.stanari.StanoviPage;
import zavrsni.Page.zgrade.ZgradeDodavanjePage;
import zavrsni.Page.zgrade.ZgradeDodavanjePregledPage;
import zavrsni.Page.zgrade.ZgradePregledPage;

@Test
public class RegistracijaStanaraTest {

	private WebDriver driver;
	private LoginPage loginPage;
	private AdminPocetnaPage pocetnaPage;
	private AdminMeniPage meniPage;
	private String baseUrl;
	private ZgradeDodavanjePage zgradeDodavanjePage;
	private ZgradePregledPage zgradePregledPage;
	private ZgradeDodavanjePregledPage zgradeDodavanjePregledPage;
	private StanariRegistracijaPage stanariRegistracijaPage;
	private StanariRegistracijaPregledPage stanariRegistracijaPregledPage;
	private StanariPregledPage stanariPregledPage;
	private StanarPage stanarPage;
	private StanoviPage stanoviPage;
	private StanPage stanPage;
	
	
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
		stanariRegistracijaPage = new StanariRegistracijaPage(driver);
	    stanariRegistracijaPregledPage = new StanariRegistracijaPregledPage(driver);
		stanariPregledPage = new StanariPregledPage(driver);
		stanarPage = new StanarPage(driver);
	    stanoviPage = new StanoviPage(driver) ;
		stanPage = new StanPage(driver);
		
		loginPage.login("admin@gmail.com", "Bar5slova");
		
	} 
	 @Test(priority = 1)
		public void registrujStanara() {
			assertEquals(driver.getCurrentUrl(), baseUrl + "pocetna");
			meniPage.getStanari().isDisplayed();
			meniPage.getStanari().click();
			
			assertEquals(driver.getCurrentUrl(), baseUrl + "stanari");
			assertTrue(stanariRegistracijaPage.getRegistracijaForm().isDisplayed());
			
			assertTrue(stanariRegistracijaPage.getEmail().isDisplayed());
			assertTrue(stanariRegistracijaPage.getLozinka().isDisplayed());
			assertTrue(stanariRegistracijaPage.getIme().isDisplayed());
			assertTrue(stanariRegistracijaPage.getPrezime().isDisplayed());
			assertTrue(stanariRegistracijaPage.getRegistrujteBtnDesabled().isDisplayed());
			assertTrue(stanariRegistracijaPage.getResetujBtn().isDisplayed());
			
			stanariRegistracijaPage.createStanar("Misa@gmail.com", "Bar5slova", "Misa", "Misic");
			stanariRegistracijaPage.getRegistrujteBtn().click();
			
			String expected = "Uspesno ste registrovali stanara!";
			
			assertEquals(stanariRegistracijaPage.getUspesnoSteRegistrovaliMsg(), expected);
			
			
			stanariRegistracijaPage.notPresentSuccessMsg();
			
		}
		@Test(priority=2)
		public void dodajIstogStanara() {
			//pocetnaPage.getPocetnaAdmin().isDisplayed();
			//assertEquals(driver.getCurrentUrl(), baseUrl + "pocetna");
			//meniPage.getStanari().isDisplayed();
			//meniPage.getStanari().click();
			assertEquals(driver.getCurrentUrl(), baseUrl + "stanari");
			//assertTrue(zgradeDodavanjePage.getFormDodavanje().isDisplayed());
			
			stanariRegistracijaPage.createStanar("Misa@gmail.com", "Bar5slova", "Misa", "Misic");
			stanariRegistracijaPage.getRegistrujteBtn().click();
			
			String expected1 = "E-mail adresa: lisa@gmail.com je zauzeta!";
			
			assertEquals(stanariRegistracijaPage.getErrorEmailZauzetMsg(), expected1);
			stanariRegistracijaPage.notPresentErrorMsg();
		}
		
		@Test(priority=3)
		public void testReset() {
			//pocetnaPage.getPocetnaAdmin().isDisplayed();
			//assertEquals(driver.getCurrentUrl(), baseUrl + "pocetna");
			//meniPage.getStanari().isDisplayed();
			//meniPage.getStanari().click();
			
			assertEquals(driver.getCurrentUrl(), baseUrl + "stanari");
			stanariRegistracijaPage.createStanar("Misa@gmail.com", "Bar5slova", "Misa", "Misic");
			assertTrue(stanariRegistracijaPage.getResetujBtn().isDisplayed());
			stanariRegistracijaPage.getResetujBtn().click();
			
			assertEquals(stanariRegistracijaPage.getEmail().getText(), "");
			assertEquals(stanariRegistracijaPage.getLozinka().getText(), "");
			assertEquals(stanariRegistracijaPage.getIme().getText(), "");
			assertEquals(stanariRegistracijaPage.getPrezime().getText(), "");

		
		} 
		@Test(priority=4)
		public void dodajPrazno() {
			//pocetnaPage.getPocetnaAdmin().isDisplayed();
			//assertEquals(driver.getCurrentUrl(), baseUrl + "pocetna");
			//meniPage.getStanari().isDisplayed();
			//meniPage.getStanari().click();
			
			assertEquals(driver.getCurrentUrl(), baseUrl + "stanari");
			stanariRegistracijaPage.createStanar("", "", "", "");
			
			String expected2 = "Ovo polje ne sme biti prazno!";
			assertEquals(stanariRegistracijaPage.getErrorInputi(), expected2 );
			
			
		
		}
		@Test(priority=8)
		public void daLiJeUTabeliStanar() {
		
		assertEquals(driver.getCurrentUrl(), baseUrl + "stanari");
		assertTrue(stanariRegistracijaPregledPage.getPregledBtn().isDisplayed());
		stanariRegistracijaPregledPage.getPregledBtn().click();
		assertEquals(driver.getCurrentUrl(), baseUrl + "stanari/pregled");
		
		
		assertTrue(stanariPregledPage.getPretragaImePrezimeEmail().isDisplayed());
		assertTrue(stanariPregledPage.getPretragaBtn().isDisplayed());
		
	     stanariPregledPage.setPretragaPretragaImePrezimeEmail("Misa Misic");
	     stanariPregledPage.getPretragaBtn().click();
		
		
		
		//assertTrue(zgradePregledPage.getTableZgrade().isDisplayed());
		assertTrue(stanariPregledPage.isStanarInTable("Misa Misic"));
	}
		
		@Test(priority=5)
		public void nevalidanEmail(){
			
			assertEquals(driver.getCurrentUrl(), baseUrl + "stanari");
			stanariRegistracijaPage.createStanar("pera.gmailcom", "Bar5slova", "Pera", "Peric");
			
			String expected3 = "Neispravna email adresa!";
			assertEquals(stanariRegistracijaPage.getErrorInputEmailLozinka(), expected3 );
			stanariRegistracijaPage.getResetujBtn().click();
		}
		@Test(priority=6)
        public void nevalidnaLozinka1(){
        	
			assertEquals(driver.getCurrentUrl(), baseUrl + "stanari");
			stanariRegistracijaPage.createStanar("pera@gmail.com", "Barslova", "Pera", "Peric");
			
			String expected3 = "Neispravna lozinka!";
			assertEquals(stanariRegistracijaPage.getErrorInputEmailLozinka(), expected3 );
			stanariRegistracijaPage.getResetujBtn().click();
		}
		@Test(priority=7)
        public void nevalidnaLozinka2(){
			
			assertEquals(driver.getCurrentUrl(), baseUrl + "stanari");
			stanariRegistracijaPage.createStanar("pera@gmail.com", "bar5slova", "Pera", "Peric");
			
			String expected3 = "Neispravna lozinka!";
			assertEquals(stanariRegistracijaPage.getErrorInputEmailLozinka(), expected3 );
			stanariRegistracijaPage.getResetujBtn().click();
		}
		
		@AfterSuite
		public void closeSelenium() {
			meniPage.getIzlogujteSeBtn().click();
			driver.quit();
		}

}
