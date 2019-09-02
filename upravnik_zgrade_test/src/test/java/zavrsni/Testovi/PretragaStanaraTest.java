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
	public class PretragaStanaraTest {
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
		
			pocetnaPage.getPocetnaAdmin().isDisplayed();
			pocetnaPage.getStanariLink().isDisplayed();
			pocetnaPage.getStanariLink().click();
			assertEquals(driver.getCurrentUrl(), baseUrl + "stanari");
			assertTrue(stanariRegistracijaPregledPage.getPregledBtn().isDisplayed());
			stanariRegistracijaPregledPage.getPregledBtn().click();
				
		}
		
		//Kada je input za pretragu prazan i kada se klikne na dugme Pretraga izbaci tabelu sa svim rezultatima.
		//Kada se ukuca jedno slovo u input polje kao rezultat se dobija tabela sa rezultatima koji sadrze u sebi zadato slovo(ne nuzno pocetno).
		@Test
		public void pretragaStanaraTest(){
			assertEquals(driver.getCurrentUrl(), baseUrl + "stanari/pregled");
			
			assertTrue(stanariPregledPage.getPretragaImePrezimeEmail().isDisplayed());
			assertTrue(stanariPregledPage.getPretragaBtn().isDisplayed());
			
			assertTrue(stanariPregledPage.getPretragaImePrezimeEmail().isDisplayed());
			assertTrue(stanariPregledPage.getPretragaBtn().isDisplayed());
			
		     stanariPregledPage.setPretragaPretragaImePrezimeEmail("Marko Markovic");
		     stanariPregledPage.getPretragaBtn().click();
		     
		    //assertTrue(stanariPregledPage.getTablePregledStanari().isDisplayed());
			assertTrue(stanariPregledPage.isStanarInTable("Marko Markovic"));
		     
		}
		
		@Test
		public void pretragaNepostojeciStanarTest(){
			assertEquals(driver.getCurrentUrl(), baseUrl + "stanari/pregled");
			assertTrue(stanariPregledPage.getTablePregledStanari().isDisplayed());
			assertTrue(stanariPregledPage.getPretragaBtn().isDisplayed());
		
			stanariPregledPage.setPretragaPretragaImePrezimeEmail("Jelena Jelenic");
		    stanariPregledPage.getPretragaBtn().click();
			
			String expected = "Nijedan stanar sa trazenim kriterijumom nije prondajen!";
			assertEquals(stanariPregledPage.getErrorTekstStanar(), expected);
		}
		
		
		@AfterSuite
		public void closeSelenium() {
			meniPage.getIzlogujteSeBtn().click();
			driver.quit();
		}
}
