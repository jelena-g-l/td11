package zavrsni_ispit_12_07_2019.Testovi;

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
import zavrsni.Page.institucije.DodavanjeInstitucijaPage;
import zavrsni.Page.login.LoginPage;
import zavrsni.Page.pregledInstitucija.PregledInstitucijaPage;
import zavrsni.Page.zgrade.ZgradeDodavanjePage;
import zavrsni.Page.zgrade.ZgradeDodavanjePregledPage;
import zavrsni.Page.zgrade.ZgradePregledPage;

@Test
public class DodavanjeInstitucijaTest {

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
		
	} 
	
   @Test(priority=1)
   public void NegPraznoDodavanjeInstitucijeTest(){
	    pocetnaPage.getPocetnaAdmin().isDisplayed();
		assertEquals(driver.getCurrentUrl(), baseUrl + "pocetna");
		pocetnaPage.getInstitucijeLink().isDisplayed();
		pocetnaPage.getInstitucijeLink().click();
		
		assertEquals(driver.getCurrentUrl(), baseUrl + "institucije");
		//assertTrue(dodavanjeInstitucijaPage.getInstitucijaForm().isDisplayed());
		assertTrue(dodavanjeInstitucijaPage.getEmail().isDisplayed());
		assertTrue(dodavanjeInstitucijaPage.getLozinka().isDisplayed());
		assertTrue(dodavanjeInstitucijaPage.getNaziv().isDisplayed());
		assertTrue(dodavanjeInstitucijaPage.getMesto().isDisplayed());
		assertTrue(dodavanjeInstitucijaPage.getUlica().isDisplayed());
		assertTrue(dodavanjeInstitucijaPage.getBroj().isDisplayed());
		assertTrue(dodavanjeInstitucijaPage.getBrojTelefona().isDisplayed());
		assertFalse(dodavanjeInstitucijaPage.getRegistrujteBtnDesabled().isEnabled());
		assertTrue(dodavanjeInstitucijaPage.getResetujteBtn().isDisplayed());
		
		dodavanjeInstitucijaPage.createInstitucija("", "", "", "", "", "", "");
		
		String expected= "Ovo polje ne sme biti prazno!";
		assertEquals(dodavanjeInstitucijaPage.getErrorInput(), expected );
		assertFalse(dodavanjeInstitucijaPage.getRegistrujteBtnDesabled().isEnabled());
		
   }
   @Test(priority=2)
   public void NegNevalidanEmailDodavanjeInstitucijeTest(){
	    
	   
		assertEquals(driver.getCurrentUrl(), baseUrl + "institucije");
		
		dodavanjeInstitucijaPage.createInstitucija("ciklonizacija.gmail.com", "Bar5slova", "Ciklonizacija", "Novi Sad", "Telepska", "3", "021333444");
		
		String expected1= "Neispravna email adresa!";

		assertEquals(dodavanjeInstitucijaPage.getErrorInputEmail(), expected1 );
		assertFalse(dodavanjeInstitucijaPage.getRegistrujteBtnDesabled().isEnabled());
		assertTrue(dodavanjeInstitucijaPage.getResetujteBtn().isDisplayed());
		dodavanjeInstitucijaPage.getResetujteBtn();
   }
   
  /* @Test(priority=3)
   public void NegSlovaUmestoBrojaInstitucijeTest(){
	    
	   
		assertEquals(driver.getCurrentUrl(), baseUrl + "institucije");
		
		dodavanjeInstitucijaPage.createInstitucija("ciklonizacija@gmail.com", "Bar5slova", "Ciklonizacija", "Novi Sad", "Telepska", "t", "021333444");
		
		
		
		String expected1= "";

		assertEquals(dodavanjeInstitucijaPage.getBroj().getText(), expected1 );
		assertFalse(dodavanjeInstitucijaPage.getRegistrujteBtnDesabled().isEnabled());
		assertTrue(dodavanjeInstitucijaPage.getResetujteBtn().isDisplayed());
		dodavanjeInstitucijaPage.getResetujteBtn();
   }*/
   
   @Test(priority=4)
   public void NegSlovaUmestoBrojaTelInstitucijeTest(){
	    
	   
		assertEquals(driver.getCurrentUrl(), baseUrl + "institucije");
		
		dodavanjeInstitucijaPage.createInstitucija("cik@gmail.com", "Bar5slova", "Ciklon", "Novi Sad", "Telepska", "3", "12345678");
		
		assertTrue(dodavanjeInstitucijaPage.getResetujteBtn().isDisplayed());
		dodavanjeInstitucijaPage.getResetujteBtn();
		
		String expected1= "Broj mora imati najmanje 9 cifara!";

		assertEquals(dodavanjeInstitucijaPage.getErrorInputBrojTelefona(), expected1 );
		assertFalse(dodavanjeInstitucijaPage.getRegistrujteBtnDesabled().isEnabled());
		assertTrue(dodavanjeInstitucijaPage.getResetujteBtn().isDisplayed());
		dodavanjeInstitucijaPage.getResetujteBtn();
   }
   
   
   @Test(priority=5)
   public void NegNevalidnaLozinkaDodavanjeInstitucijeTest(){
	    
	   
		assertEquals(driver.getCurrentUrl(), baseUrl + "institucije");
		
		dodavanjeInstitucijaPage.createInstitucija("ciklonizacija@gmail.com", "Barslova", "Ciklonizacija", "Novi Sad", "Telepska", "3", "021333444");
		
		String expected2= "Neispravna lozinka!";

		assertEquals(dodavanjeInstitucijaPage.getErrorInputLozinka(), expected2 );
		assertFalse(dodavanjeInstitucijaPage.getRegistrujteBtnDesabled().isEnabled());
		assertTrue(dodavanjeInstitucijaPage.getResetujteBtn().isDisplayed());
		dodavanjeInstitucijaPage.getResetujteBtn();
   }
   @Test(priority=6)
   public void DodavanjeInstitucijeTest(){
	    
	   
		assertEquals(driver.getCurrentUrl(), baseUrl + "institucije");
		
		dodavanjeInstitucijaPage.createInstitucija("policija@gmail.com", " Bar8slova", "Policija", "Novi Sad", " Cara Lazara", " 45", " 1122334455");
		assertTrue(dodavanjeInstitucijaPage.getRegistrujteBtn().isEnabled());
		dodavanjeInstitucijaPage.getRegistrujteBtn().click();
		
		String expected = "Uspesno ste registrovali instituciju!";
		assertTrue(dodavanjeInstitucijaPage.PresentSuccessMsg());
		dodavanjeInstitucijaPage.notPresentSuccessMsg();
				
   }
   @Test(priority=7)
   public void DaLiSeDodalaInstitucijaTest(){
	   assertTrue(pregledInstitucijaPage.getPregledBtn().isDisplayed());
	   pregledInstitucijaPage.getPregledBtn().click();
	   
	   assertEquals(driver.getCurrentUrl(), baseUrl + "institucije/pregled");
	
	     
	    
		assertTrue(pregledInstitucijaPage.isInstitucijaInTable("Policija"));
		
		
		meniPage.getIzlogujteSeBtn().click();
		
		loginPage.login("policija@gmail.com", "Bar8slova");
		assertTrue(meniPage.getIzlogujteSeBtn().isDisplayed());
		
		String expectedLoginEmailString = "policija@gmail.com   ";
		assertEquals(meniPage.getLoginConfirmationEmailString("policija@gmail.com"),expectedLoginEmailString);
		
   }
   
   
   
   @AfterSuite
	public void closeSelenium() {
		meniPage.getIzlogujteSeBtn().click();
		driver.quit();
	}
}
