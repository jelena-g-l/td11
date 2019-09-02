package zavrsni.Page.zgrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class ZgradeDodavanjePage {
	private WebDriver driver;
	
	public ZgradeDodavanjePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	public WebElement getDodavanjeBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Dodavanje')]"), 10);
	}
	public WebElement getPregledBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Pregled')]"), 10);
	}
	public WebElement getFormDodavanje() {
		return Utils.waitForElementPresence(driver, By.xpath("//form[@class='col-md-6 box ng-untouched ng-pristine ng-invalid']"), 10);
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
	public WebElement getBrojStanova() {
		return Utils.waitForElementPresence(driver, By.id("brojStanova"), 10);
	}
	public void setBrojStanova(String value) {
		WebElement brojStanova = getBrojStanova();
		brojStanova.clear();
		brojStanova.sendKeys(value);
	}
	public WebElement getDodajteBtnDesabled() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[contains(text(), 'Dodajte')]"), 10);
	}
	public WebElement getDodajteBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Dodajte')]"), 10);
	}
	public WebElement getResetujteBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Resetujte')]"), 10);
	}
	public String getErrorInput() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[contains(text(), 'Ovo polje ne sme biti prazno!')]"), 10).getText();
	}
	public String getErrorVecPostoji() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@aria-label = 'Vec postoji zgrada na toj adresi!']"), 10).getText();
	}
	public String getUspesnoSteUneliMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@aria-label = 'Uspesno ste dodali zgradu!']"), 10).getText();
	}
	public boolean notPresentErrorMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@class ='toast-error']"), 10);
	}
	public boolean notPresentSuccessMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@class ='toast-success']"), 10);
	}
	public void createZgrada(String mesto, String ulica, String broj, String brojStanova) {
		setMesto(mesto);
		setUlica(ulica);
		setBroj(broj);
		setBrojStanova(brojStanova);
		getDodajteBtn().click();
	}
}
