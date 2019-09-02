package zavrsni.Testovi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.beans.PropertyEditorSupport;
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
public class PredSkupTest {

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
		
		loginPage.login("predSkup@gmail.com", "Bar5slova");
		
		
		
	    }
	
	@Test(priority=1)
	public void predsednikObavestenjaTest(){
		assertTrue(predSkupPocetnaPage.getZgradaStanujeTable().isDisplayed());
		assertTrue(predSkupPocetnaPage.getZgradaVlasnikTable().isDisplayed());
		
		predSkupPocetnaPage.getStranica().click();
		//assertTrue(obavestenjaPage.getObavestenjaTable().isDisplayed());
		assertTrue(obavestenjaPage.getDodajBtn().isDisplayed());
		obavestenjaPage.getDodajBtn().click();
		assertTrue(obavestenjaPage.getTekstObavestenja().isDisplayed());
		assertTrue(obavestenjaPage.getPotvrdiBtn().isDisplayed());
		obavestenjaPage.setTekstObavestenja("Obavestenje");
		obavestenjaPage.getPotvrdiBtn().click();
		String expected = "Obavestenje uspesno dodato!";
		assertEquals(obavestenjaPage.getSuccessMsg(), expected);
		obavestenjaPage.notPresentSuccessMsg();
		
	    zgradaMeniPage.getObavestenjaLink().click();
	    assertTrue(obavestenjaPage.isTekstInTable("Obavestenje"));
	    assertTrue(obavestenjaPage.getIzmeniLink("Obavestenja").isDisplayed());
	    obavestenjaPage.getIzmeniLink("Obavestenja").click();
	    assertTrue(obavestenjaPage.getOdustaniLink("Obavestenja").isDisplayed());
	    assertTrue(obavestenjaPage.getPotvrdiLink("Obavestenja").isDisplayed());
	    assertTrue(obavestenjaPage.getBrisiLink("Obavestenja").isDisplayed());
	    obavestenjaPage.getOdustaniLink("Obavestenja").click();
	    assertTrue(obavestenjaPage.getIzmeniLink("Obavestenja").isDisplayed());
	    obavestenjaPage.getIzmeniLink("Obavestenja").click();
	    assertTrue(obavestenjaPage.getPromenaTeksta().isDisplayed());
	    
	    obavestenjaPage.getPromenaTeksta().click();
	    obavestenjaPage.setPromenaTeksta("Novo obavestenje");
	    obavestenjaPage.getPotvrdiLink("Novo obavestenje").click();
	    
	    
	   String expected1 = "Uspesno izmenjeno obavestenje";
		assertEquals(obavestenjaPage.getSuccessMsg(), expected1);
		obavestenjaPage.notPresentSuccessMsg();
		assertTrue(obavestenjaPage.isTekstInTable("Novo obavestenje"));
		obavestenjaPage.getBrisiLink("Novo obavestenje").click();
		String expected2 = "Uspesno izbrisano obavestenje";
		assertEquals(obavestenjaPage.getSuccessMsg(), expected2);
		obavestenjaPage.notPresentSuccessMsg();
		assertFalse(obavestenjaPage.isTekstInTable("Novo obavestenje"));
	} 
	
	@Test(priority=2)
	public void predsednikPredTacDnevRedaTest(){
		//assertTrue(predSkupPocetnaPage.getZgradaStanujeTable().isDisplayed());
		//assertTrue(predSkupPocetnaPage.getZgradaVlasnikTable().isDisplayed());
		
		//predSkupPocetnaPage.getStranica().click();
		assertTrue(zgradaMeniPage.getPredloziTackeDnevnogRedaLink().isDisplayed());
		zgradaMeniPage.getPredloziTackeDnevnogRedaLink().click();
		assertTrue(predloziTackeDrevnogReda.getDodajBtn().isDisplayed());
		predloziTackeDrevnogReda.getDodajBtn().click();
		
		assertTrue(dodajTackeDnevRedaPage.getTekstTackeDnevReda().isDisplayed());
		dodajTackeDnevRedaPage.getTekstTackeDnevReda().click();
		dodajTackeDnevRedaPage.setTekstTackeDnevReda("Nova tacka");
		assertTrue(dodajTackeDnevRedaPage.getPotvrdiBtn().isDisplayed());
		dodajTackeDnevRedaPage.getPotvrdiBtn().click();
		
		String expected4 = "Predlog tacke dnevnog reda uspesno dodat";
		assertEquals(dodajTackeDnevRedaPage.getSuccessMsg(), expected4);
		dodajTackeDnevRedaPage.notPresentSuccessMsg();
		
		zgradaMeniPage.getPredloziTackeDnevnogRedaLink().click();
		assertTrue(predloziTackeDrevnogReda.isInTable("Nova tacka"));
		
		assertTrue(predloziTackeDrevnogReda.getIzmeniLink("Nova tacka").isDisplayed());
		predloziTackeDrevnogReda.getIzmeniLink("Nova tacka").click();
	    assertTrue(predloziTackeDrevnogReda.getOdustaniLink("Nova tacka").isDisplayed());
	    assertTrue(predloziTackeDrevnogReda.getPotvrdiLink("Nova tacka").isDisplayed());
	    assertTrue(predloziTackeDrevnogReda.getBrisiLink("Nova tacka").isDisplayed());
	    predloziTackeDrevnogReda.getOdustaniLink("Nova tacka").click();
	    assertTrue(predloziTackeDrevnogReda.getIzmeniLink("Nova tacka").isDisplayed());
	    predloziTackeDrevnogReda.getIzmeniLink("Nova tacka").click();
	    assertTrue(predloziTackeDrevnogReda.getPromenaTeksta().isDisplayed());
	    
	    predloziTackeDrevnogReda.getPromenaTeksta().click();
	    predloziTackeDrevnogReda.setPromenaTeksta("Nova nova tacka");
	    predloziTackeDrevnogReda.getPotvrdiLink("Nova nova tacka").click();
	    
	    
	   String expected5 = "Tacka uspesno izmenjena";
		assertEquals(predloziTackeDrevnogReda.getSuccessMsg(), expected5);
		predloziTackeDrevnogReda.notPresentSuccessMsg();
		assertTrue(predloziTackeDrevnogReda.isInTable("Nova nova tacka"));
		
		
		assertTrue(predloziTackeDrevnogReda.getIzaberiteSkupstinu().isDisplayed());
		predloziTackeDrevnogReda.getIzaberiteSkupstinu().click();
		predloziTackeDrevnogReda.getSkupstinuIzMenija("22:55 05.12.2020 - 00:00 19.12.2020").click();
		assertTrue(predloziTackeDrevnogReda.izaberiSkupstinu("22:55 05.12.2020 - 00:00 19.12.2020").isDisplayed());
		predloziTackeDrevnogReda.izaberiSkupstinu("22:55 05.12.2020 - 00:00 19.12.2020").click();
		
		assertTrue(predloziTackeDrevnogReda.getDodajPredlogBtn("Nova nova tacka").isDisplayed());
		predloziTackeDrevnogReda.getDodajPredlogBtn("Nova nova tacka").click();
		
		String expected6 = "Tacka uspesno dodata u skupstinu";
		
		assertEquals(predloziTackeDrevnogReda.getSuccessMsg(), expected6);
		predloziTackeDrevnogReda.notPresentSuccessMsg();
		
		//Ne treba!
		//predloziTackeDrevnogReda.getBrisiLink("Nova nova tacka").click();
       // String expected7 = "Tacka uspesno izbrisana";
		
		//assertEquals(predloziTackeDrevnogReda.getSuccessMsg(), expected7);
		//predloziTackeDrevnogReda.notPresentSuccessMsg();
		
		
	} 
	@Test(priority=3)
	public void predsednikSastanciSkupstineTest(){
		//assertTrue(predSkupPocetnaPage.getZgradaStanujeTable().isDisplayed());
		//assertTrue(predSkupPocetnaPage.getZgradaVlasnikTable().isDisplayed());
		
		//predSkupPocetnaPage.getStranica().click();
		assertTrue(zgradaMeniPage.getSastanciSkupstineLink().isDisplayed());
		zgradaMeniPage.getSastanciSkupstineLink().click();
		assertTrue(sastanciSkupstinePage.getKad().isDisplayed());
		sastanciSkupstinePage.getKad().click();
		sastanciSkupstinePage.izaberiSastanke("Buduci Sastanci").click();;
		
		
		assertTrue(sastanciSkupstinePage.isInTable("Pocetak skupstine - 22:55 05.12.2020"));
		
		assertTrue(sastanciSkupstinePage.getIzmeniLink("Pocetak skupstine - 22:55 05.12.2020").isDisplayed());
		
		//sastanciSkupstinePage.izmeniSkupstinuByPocetak("Pocetak skupstine - 22:55 05.12.2020");
		sastanciSkupstinePage.pregledajSkupstinuByPocetak("Pocetak skupstine - 22:55 05.12.2020");
		
		assertTrue(sastanciSkupstinePage.isInTable("Nova nova tacka")); 
		assertTrue(sastanciSkupstinePage.getIzmeniLink("Nova nova tacka").isDisplayed()); 
		assertTrue(sastanciSkupstinePage.getUkloniLink("Nova nova tacka").isDisplayed()); 
		assertTrue(sastanciSkupstinePage.getPregledajAnketuLink("Nova nova tacka").isDisplayed());
		sastanciSkupstinePage.getIzmeniLink("Nova nova tacka").click(); 
		
		assertTrue(sastanciSkupstinePage.getPotvrdiLink().isDisplayed()); 
		assertTrue(sastanciSkupstinePage.getOdustaniLink().isDisplayed()); 
		assertTrue(sastanciSkupstinePage.getPromenaTeksta().isDisplayed());
		sastanciSkupstinePage.setPromenaTeksta("Novija tacka");
		sastanciSkupstinePage.getPotvrdiLink().click();
		
        String expected8 = "Tacka uspesno izmenjena";
		
		assertEquals(sastanciSkupstinePage.getSuccessMsg(), expected8);
		sastanciSkupstinePage.notPresentSuccessMsg();
		
		sastanciSkupstinePage.getUkloniLink("Novija tacka").click();
		String expected9 = "Tacka uspesno uklonjena";
			
		assertEquals(sastanciSkupstinePage.getSuccessMsg(), expected9);
		sastanciSkupstinePage.notPresentSuccessMsg();
		
		zgradaMeniPage.getSastanciSkupstineLink().click();
		sastanciSkupstinePage.getKad().click();
		sastanciSkupstinePage.izaberiSastanke("Buduci Sastanci").click();
		assertTrue(sastanciSkupstinePage.isInTable("Pocetak skupstine - 22:55 05.12.2020"));
		
		assertTrue(sastanciSkupstinePage.getIzmeniLink("Pocetak skupstine - 22:55 05.12.2020").isDisplayed());
		sastanciSkupstinePage.getIzmeniLink("Pocetak skupstine - 22:55 05.12.2020").click();
		assertTrue(sastanciSkupstinePage.getPotvrdiBtn().isDisplayed());
		sastanciSkupstinePage.getPotvrdiBtn().click();
        String expected7 = "Sastanak uspesno izmenjen!";
		
		assertEquals(sastanciSkupstinePage.getSuccessMsg(), expected7);
		sastanciSkupstinePage.notPresentSuccessMsg();
		
		
	} 
	@Test(priority=4)
	public void predsednikKvaroviTest(){
		//assertTrue(predSkupPocetnaPage.getZgradaStanujeTable().isDisplayed());
		//assertTrue(predSkupPocetnaPage.getZgradaVlasnikTable().isDisplayed());
				
		//predSkupPocetnaPage.getStranica().click();
		
		assertTrue(zgradaMeniPage.getKvaroviLink().isDisplayed());
		zgradaMeniPage.getKvaroviLink().click();
		assertTrue(kvaroviPage.getDodajBtn().isDisplayed());
		kvaroviPage.getDodajBtn().click();
		assertTrue(kvaroviPage.getMesto().isDisplayed());
		assertTrue(kvaroviPage.getOpis().isDisplayed());
		assertTrue(kvaroviPage.getIzaberiBtn().isDisplayed());
		assertFalse(kvaroviPage.getDodajKvarBtn().isEnabled());
		kvaroviPage.setMesto("Lift");
		kvaroviPage.setOpis("Kvar u liftu.");
		kvaroviPage.getIzaberiBtn().click();
		assertTrue(kvaroviPage.getPretraga().isDisplayed());
		kvaroviPage.getPretraga().click();
		kvaroviPage.setPretraga("Marko");
		assertTrue(kvaroviPage.isInTable("Marko Markovic"));
		assertTrue(kvaroviPage.getPrihvatiBtn("Marko Markovic").isDisplayed());
		kvaroviPage.getPrihvatiBtn("Marko Markovic").click();
		assertTrue(kvaroviPage.isInTable("Marko Markovic"));
		assertTrue(kvaroviPage.getDodajKvarBtn().isEnabled());
		kvaroviPage.getDodajKvarBtn().click();
		String expected10 = "Kvar uspesno dodat";
		assertEquals(sastanciSkupstinePage.getSuccessMsg(), expected10);
		sastanciSkupstinePage.notPresentSuccessMsg();
		
		zgradaMeniPage.getKvaroviLink().click();
		assertTrue(kvaroviPage.isInTable("Kvar u liftu."));
		assertTrue(kvaroviPage.getPogledajLink("Kvar u liftu.").isDisplayed());
		assertTrue(kvaroviPage.getIzmeniLink("Kvar u liftu.").isDisplayed());
		assertTrue(kvaroviPage.getBrisiLink("Kvar u liftu.").isDisplayed());
		kvaroviPage.getBrisiLink("Kvar u liftu.").click();
		String expected11 = "Uspesno izbrisan kvar";
		assertEquals(sastanciSkupstinePage.getSuccessMsg(), expected11);
		sastanciSkupstinePage.notPresentSuccessMsg();
		
		
	}
	
	
		@AfterSuite
		public void closeSelenium() {
			meniPage.getIzlogujteSeBtn().click();
			driver.quit();
		}

}
