package zavrsni.Testovi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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
import zavrsni.Page.predSkup.PredSkupMeniPage;
import zavrsni.Page.predSkup.PredSkupPocetnaPage;
import zavrsni.Page.predSkup.PromenaLozinkePage;
import zavrsni.Page.stanari.StanPage;
import zavrsni.Page.stanari.StanarPage;
import zavrsni.Page.stanari.StanariPregledPage;
import zavrsni.Page.stanari.StanariRegistracijaPage;
import zavrsni.Page.stanari.StanariRegistracijaPregledPage;
import zavrsni.Page.stanari.StanoviPage;
import zavrsni.Page.zgradaMeni.DodajObavestenjePage;
import zavrsni.Page.zgradaMeni.DodajSkupstinuPage;
import zavrsni.Page.zgradaMeni.DodajTackeDnevRedaPage;
import zavrsni.Page.zgradaMeni.KvaroviPage;
import zavrsni.Page.zgradaMeni.ObavestenjaPage;
import zavrsni.Page.zgradaMeni.PredloziTacDnevRedaPage;
import zavrsni.Page.zgradaMeni.SastanciSkupstinePage;
import zavrsni.Page.zgrade.ZgradaMeniPage;
import zavrsni.Page.zgrade.ZgradaPage;
import zavrsni.Page.zgrade.ZgradeDodavanjePage;
import zavrsni.Page.zgrade.ZgradeDodavanjePregledPage;
import zavrsni.Page.zgrade.ZgradePregledPage;

@Test
public class PromenaLozinkeTest {

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
	private PredSkupPocetnaPage predSkupPocetnaPage;
	private PredSkupMeniPage predSkupMeniPage;
	private ObavestenjaPage obavestenjaPage;
	private PredloziTacDnevRedaPage predloziTackeDrevnogReda;
	private SastanciSkupstinePage sastanciSkupstinePage;
	private DodajTackeDnevRedaPage dodajTackeDnevRedaPage;
	private DodajSkupstinuPage dodajSkupstinuPage;
	private DodajObavestenjePage dodajObavestenjePage;
	private PromenaLozinkePage promenaLozinkePage;
	
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
		predSkupPocetnaPage = new PredSkupPocetnaPage(driver);
		predSkupMeniPage = new PredSkupMeniPage(driver);
		obavestenjaPage = new ObavestenjaPage(driver);
		predloziTackeDrevnogReda = new PredloziTacDnevRedaPage(driver);
		sastanciSkupstinePage = new SastanciSkupstinePage(driver);
		dodajTackeDnevRedaPage = new DodajTackeDnevRedaPage(driver) ;
		dodajSkupstinuPage = new DodajSkupstinuPage(driver);
		dodajObavestenjePage = new DodajObavestenjePage (driver);
		promenaLozinkePage = new PromenaLozinkePage(driver);
		
		loginPage.login("predSkup@gmail.com", "Bar5slova");
		
		
		
	    }
	/*
	@Test(priority=1)
	public void promenaLozinke(){
		assertTrue(predSkupMeniPage.getPromenaLozinke().isDisplayed());
		predSkupMeniPage.getPromenaLozinke().click();
		assertTrue(promenaLozinkePage.getPromenaLozinkeForm().isDisplayed());
		assertTrue(promenaLozinkePage.getStaraLozinkaInput().isDisplayed());
		assertTrue(promenaLozinkePage.getNovaLozinkaInput().isDisplayed());
		assertTrue(promenaLozinkePage.getPotvrdaNoveLozinkeInput().isDisplayed());
		assertTrue(promenaLozinkePage.getPromeniteLozinkuBtn().isDisplayed());
		
		promenaLozinkePage.getStaraLozinkaInput().click();
		promenaLozinkePage.setStaraLozinkaInput("Bar5slova");
		promenaLozinkePage.setNovaLozinkaInput("Lozinka2");
		promenaLozinkePage.setPotvrdaNoveLozinkeInput("Lozinka2");
		promenaLozinkePage.getPromeniteLozinkuBtn().click();
		
		String expected = "Lozinka uspesno izmenjena!";
		assertEquals(sastanciSkupstinePage.getSuccessMsg(), expected);
		sastanciSkupstinePage.notPresentSuccessMsg();
		
        loginPage.login("predSkup@gmail.com", "Lozinka2");
		
		String expectedLoginEmailString = "predSkup@gmail.com   ";
		assertEquals(meniPage.getLoginConfirmationEmailString("predSkup@gmail.com   "),expectedLoginEmailString);
		
	} */
	@Test(priority=1)
	public void prazno(){
		assertTrue(predSkupMeniPage.getPromenaLozinke().isDisplayed());
		predSkupMeniPage.getPromenaLozinke().click();
		assertTrue(promenaLozinkePage.getPromenaLozinkeForm().isDisplayed());
		promenaLozinkePage.promenaLozinke("", "", "");
		assertFalse(promenaLozinkePage.getPromeniteLozinkuBtn().isEnabled());
		
	}
	
	@Test(priority=2)
	public void pogresnaLozinka(){
		assertTrue(predSkupMeniPage.getPromenaLozinke().isDisplayed());
		predSkupMeniPage.getPromenaLozinke().click();
		assertTrue(promenaLozinkePage.getPromenaLozinkeForm().isDisplayed());
		promenaLozinkePage.promenaLozinke("Bar4slova", "Lozinka2", "Lozinka2");
		promenaLozinkePage.getPromeniteLozinkuBtn().click();
		String expected1 = "Pogresna lozinka!";
		assertEquals(sastanciSkupstinePage.getSuccessMsg(), expected1);
		sastanciSkupstinePage.notPresentSuccessMsg();
	}
	@Test(priority=4)
	public void prazno3(){

		assertTrue(predSkupMeniPage.getPromenaLozinke().isDisplayed());
		predSkupMeniPage.getPromenaLozinke().click();
		assertTrue(promenaLozinkePage.getPromenaLozinkeForm().isDisplayed());
		promenaLozinkePage.promenaLozinke("Bar5slova", "Lozinka2", "");
		assertFalse(promenaLozinkePage.getPromeniteLozinkuBtn().isEnabled());
	}
	@Test(priority=3)
	public void pogresnaPotvrdaLozinke(){

		assertTrue(predSkupMeniPage.getPromenaLozinke().isDisplayed());
		predSkupMeniPage.getPromenaLozinke().click();
		assertTrue(promenaLozinkePage.getPromenaLozinkeForm().isDisplayed());
		promenaLozinkePage.promenaLozinke("Bar5slova", "Lozinka2", "Lozinka1");
		assertFalse(promenaLozinkePage.getPromeniteLozinkuBtn().isEnabled());
	}
	
	@Test(priority=5)
	public void promenaLozinke(){
		assertTrue(predSkupMeniPage.getPromenaLozinke().isDisplayed());
		predSkupMeniPage.getPromenaLozinke().click();
		assertTrue(promenaLozinkePage.getPromenaLozinkeForm().isDisplayed());
		assertTrue(promenaLozinkePage.getStaraLozinkaInput().isDisplayed());
		assertTrue(promenaLozinkePage.getNovaLozinkaInput().isDisplayed());
		assertTrue(promenaLozinkePage.getPotvrdaNoveLozinkeInput().isDisplayed());
		assertTrue(promenaLozinkePage.getPromeniteLozinkuBtn().isDisplayed());
		
		promenaLozinkePage.getStaraLozinkaInput().click();
		promenaLozinkePage.setStaraLozinkaInput("Bar5slova");
		promenaLozinkePage.setNovaLozinkaInput("Lozinka2");
		promenaLozinkePage.setPotvrdaNoveLozinkeInput("Lozinka2");
		promenaLozinkePage.getPromeniteLozinkuBtn().click();
		
		String expected = "Lozinka uspesno izmenjena!";
		assertEquals(sastanciSkupstinePage.getSuccessMsg(), expected);
		sastanciSkupstinePage.notPresentSuccessMsg();
		
        loginPage.login("predSkup@gmail.com", "Lozinka2");
		
		String expectedLoginEmailString = "predSkup@gmail.com   ";
		assertEquals(meniPage.getLoginConfirmationEmailString("predSkup@gmail.com   "),expectedLoginEmailString);
		
	} 
	@AfterSuite
	public void closeSelenium() {
		predSkupMeniPage.getIzlogujteSeBtn().click();
		driver.quit();
	}

}
