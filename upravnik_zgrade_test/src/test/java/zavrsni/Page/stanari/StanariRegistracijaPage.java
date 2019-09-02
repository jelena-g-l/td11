package zavrsni.Page.stanari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class StanariRegistracijaPage {
	private WebDriver driver; 
	
	public StanariRegistracijaPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getRegistracijaForm() {
		return Utils.waitForElementPresence(driver, By.xpath("//form[@class = 'col-md-6 box ng-untouched ng-pristine ng-invalid']"), 10);
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
	public WebElement getIme() {
		return Utils.waitForElementPresence(driver, By.id("ime"), 20);
	}
	public void setIme(String value) {
		WebElement ime = getIme();
	    ime.clear();
		ime.sendKeys(value);
	}
	public WebElement getPrezime() {
		return Utils.waitForElementPresence(driver, By.id("prezime"), 20);
	}
	public void setPrezime(String value) {
		WebElement prezime = getPrezime();
		prezime.clear();
		prezime.sendKeys(value);
	}
	public WebElement getRegistrujteBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Registrujte')]"), 10);
	}
	public WebElement getRegistrujteBtnDesabled() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[contains(text(), 'Registrujte')]"), 10);
	}
	public WebElement getResetujBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Resetuj')]"), 10);
	}
	public void createStanar(String email, String lozinka, String ime, String prezime) {
		setEmail(email);
		setLozinka(lozinka);
		setIme(ime);
		setPrezime(prezime);
		//getRegistrujteBtn().click();
	}
	public String getUspesnoSteRegistrovaliMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@aria-label = 'Uspesno ste registrovali stanara!']"), 10).getText();
	}
	public String getErrorEmailZauzetMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id= 'toast-container']/div/div"), 10).getText();
	}
	public String getErrorInputEmailLozinka() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class = 'invalid-feedback ng-star-inserted']"), 10).getText();
	}
	public String getErrorInputi() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[contains(text(), 'Ovo polje ne sme biti prazno!')]"), 10).getText();
	}
	//public boolean notPresentErrorMsg() {
	//	return Utils.isElementNotPresent(driver, By.xpath("//div[@aria-label = 'Uspesno ste registrovali stanara!']"), 10);
	//}
	public boolean notPresentErrorMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@class ='toast-error']"), 10);
	}
	public boolean notPresentSuccessMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@class ='toast-success']"), 10);
	}
	
	
	
	
}
