package zavrsni.Page.institucije;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class DodavanjeInstitucijaPage {

private WebDriver driver; 
	
	public DodavanjeInstitucijaPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getInstitucijaForm() {
		return Utils.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-institucije/div/app-registruj-instituciju/div/form"), 10);
	}
	public WebElement getEmail() {
		return Utils.waitForElementPresence(driver, By.id("email"), 20);
	}
	public void setEmail(String value) {
		WebElement email = getEmail();
	    email.clear();
		email.sendKeys(value);
	}
	public WebElement getLozinka() {
		return Utils.waitForElementPresence(driver, By.id("lozinka"), 10);
	}
	public void setLozinka(String value) {
		WebElement lozinka = getLozinka();
		lozinka.clear();
		lozinka.sendKeys(value);
	}
	public WebElement getNaziv() {
		return Utils.waitForElementPresence(driver, By.id("naziv"), 20);
	}
	public void setNaziv(String value) {
		WebElement naziv = getNaziv();
	    naziv.clear();
		naziv.sendKeys(value);
	}
	public WebElement getMesto() {
		return Utils.waitForElementPresence(driver, By.id("mesto"), 10);
	}
	public void setMesto(String value) {
		WebElement mesto = getMesto();
		mesto.clear();
		mesto.sendKeys(value);
	}
	public WebElement getUlica() {
		return Utils.waitForElementPresence(driver, By.id("ulica"), 10);
	}
	public void setUlica(String value) {
		WebElement ulica = getUlica();
		ulica.clear();
		ulica.sendKeys(value);
	}
	
	public WebElement getBroj() {
		return Utils.waitForElementPresence(driver, By.id("broj"), 10);
	}
	public void setBroj(String value) {
		WebElement broj = getBroj();
		broj.clear();
		broj.sendKeys(value);
	}
	public WebElement getBrojTelefona() {
		return Utils.waitForElementPresence(driver, By.id("brojTelefona"), 10);
	}
	
	public void setBrojTelefona(String value) {
		WebElement brojTelefona = getBrojTelefona();
		brojTelefona.clear();
		brojTelefona.sendKeys(value);
	}
	
	public WebElement getRegistrujteBtnDesabled() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[contains(text(), 'Registrujte')]"), 10);
	}
	public WebElement getRegistrujteBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Registrujte')]"), 10);
	}
	public WebElement getResetujteBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Resetujte')]"), 10);
	}
	public String getErrorInput() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[contains(text(), 'Ovo polje ne sme biti prazno!')]"), 10).getText();
	}
		
	public String getErrorInputEmail() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[contains(text(), 'Neispravna email adresa!')]"), 10).getText();
	}
	public String getErrorInputLozinka() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[contains(text(), 'Neispravna lozinka!')]"), 10).getText();
	}
	public String getErrorInputBrojTelefona() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[contains(text(), 'Broj mora imati najmanje 9 cifara!')]"), 10).getText();
	}
	public void createInstitucija(String email, String lozinka, String naziv, String mesto, String ulica, String broj,String brojTelefona) {
		setEmail(email);
		setLozinka(lozinka);
		setNaziv(naziv);
		setMesto(mesto);
		setUlica(ulica);
		setBroj(broj);
		setBrojTelefona(brojTelefona);
		//getRegistrujteBtn().click();
	}
	
	public boolean PresentSuccessMsg() {
		return Utils.isPresent(driver, By.xpath("//*[@id='toast-container']/div/div"));
	}
	public boolean notPresentErrorMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@class ='toast-error']"), 10);
	}
	public boolean notPresentSuccessMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("///*[@id='toast-container']/div/div"), 10);
	}
}
