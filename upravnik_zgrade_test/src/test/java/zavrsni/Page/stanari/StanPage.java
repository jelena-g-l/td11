package zavrsni.Page.stanari;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class StanPage {
	private WebDriver driver; 
	
	public StanPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getVlasnik() {
		return Utils.waitToBeClickable(driver, By.xpath("//h5[@class =' col-md-10')]/a"), 10);
	}
	public String getVlasnikString() {
		return Utils.waitToBeClickable(driver, By.xpath("//h5[@class =' col-md-10')]/a"), 10).getText();
	}
	public String getUkloniVlasnikaBtn() {
		return Utils.waitToBeClickable(driver, By.id("ukloniVlasnika"), 10).getText();
	}
	public WebElement getTableStanovi() {
		return Utils.waitForElementPresence(driver, By.id("stanovi"), 10);
	}
	public List<WebElement> getTableRows() {
		return this.getTableStanovi().findElements(By.tagName("tr"));
	}
	public WebElement getByVlasnik(String vlasnik) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + vlasnik + "\")]/../.."), 10);
	}
	public void getPostaviZaPredsednika(String vlasnik) {
		getByVlasnik(vlasnik).findElement(By.xpath("//button[contains(text(),'          Postavi za predsednika')]")).click();
	}
	public void getPostaviZaVlasnika(String vlasnik) {
		getByVlasnik(vlasnik).findElement(By.xpath("//button[contains(text(),'Postavi za vlasnika')]")).click();
	}
	public void getUkloni(String vlasnik) {
		getByVlasnik(vlasnik).findElement(By.xpath("//button[contains(text(),'Ukloni')]")).click();
	}
	public WebElement getFilter() {
		return Utils.waitForElementPresence(driver, By.id("filter"), 10);
	}
	public WebElement getFiltriraj() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Filtriraj')]"), 10);
	}
	public WebElement getTableKorisnici() {
		return Utils.waitForElementPresence(driver, By.id("korisnici"), 10);
	}
	public WebElement getTableStanari() {
		return Utils.waitForElementPresence(driver, By.id("stanari"), 10);
	}
	public List<WebElement> getTableRows2() {
		return this.getTableKorisnici().findElements(By.tagName("tr"));
	}
	public WebElement getByStanar(String stanar) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + stanar + "\")]/../.."), 10);
	}
	public void getDodajUStanare(String korisnik) {
		getByVlasnik(korisnik).findElement(By.xpath("//button[contains(text(),'Dodaj u stanare')]")).click();
	}
	public void getPostaviZaVlasnika2(String korisnik) {
		getByVlasnik(korisnik).findElement(By.xpath("//button[contains(text(),'Postavi za vlasnika')]")).click();
	}
	
	public void setFilter(String value) {
		WebElement imePrezimeEmail = getFilter();
		imePrezimeEmail.clear();
		imePrezimeEmail.sendKeys(value);
	}
	public boolean isStanarInTable(String stanar) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + stanar + "\")]/../.."));
	}
	public String getSuccessMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id='toast-container']/div/div"), 10).getText();
	}
	public String getSuccessMsgV() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id='toast-container']/div/div"), 10).getText();
	}
	

	public WebElement BtnUkloniVlasnika() {
		return Utils.waitToBeClickable(driver, By.id("ukloniVlasnika"), 10);
	}
	
	public boolean notPresentSuccessMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@id='toast-container']/div"), 10);
	}
	public boolean notPresentSuccessMsgV() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@id='toast-container']/div"), 10);
	}
	
	
}
