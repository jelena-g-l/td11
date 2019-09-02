package zavrsni.Page.zgradaMeni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class KvaroviPage {
	private WebDriver driver; 
	
	public KvaroviPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getDodajBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//b[contains(text(),'Dodaj')]"), 10);
	}
	public WebElement getCheckBox() {
		return Utils.waitToBeClickable(driver, By.xpath("//input[@type = 'checkbox']"), 10);
	}
	
	public WebElement getKvaroviTable() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@_ngcontent-c15]/table"), 10);
	}
	public String getIme() {
		return Utils.waitForElementPresence(driver, By.className("naziv"), 10).getText();
	}
	public String getOpisKvara() {
		return Utils.waitForElementPresence(driver, By.id("opisKvara"), 10).getText();
	}
	public WebElement getKvarByOpis(String opis) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + opis + "\")]/../.."), 10);
	}
	public void pogledajKvarByOpis(String opis) {
		getKvarByOpis(opis).findElement(By.xpath("//span[contains(text(),'pogledaj'")).click();
	}
	public void izmeniKvarByOpis(String opis) {
		getKvarByOpis(opis).findElement(By.xpath("//span[contains(text(),'izmeni'")).click();
	}
	public void brisiKvarByOpis(String opis) {
		getKvarByOpis(opis).findElement(By.xpath("//span[contains(text(),'brisi'")).click();
	}
	public WebElement getMesto() {
		return Utils.waitForElementPresence(driver, By.id("mesto"), 10);
	}
	public void setMesto(String value){
    	WebElement mesto = getMesto();
		mesto.clear();
		mesto.sendKeys(value);
    }
	public WebElement getOpis() {
		return Utils.waitForElementPresence(driver, By.id("opis"), 10);
	}
	public void setOpis(String value){
    	WebElement opis = getOpis();
		opis.clear();
		opis.sendKeys(value);
    }
	public WebElement getIzaberiBtn() {
		return Utils.waitToBeClickable(driver, By.id("odgovorno_lice"), 10);
	}
	public WebElement getDodajKvarBtn() {
		return Utils.waitForElementPresence(driver, By.id("submit"), 10);
	}
	public WebElement getPretraga(){
		return Utils.waitToBeClickable(driver, By.xpath("//*[@placeholder = 'Pretraga']"), 10);
	}
	public void setPretraga(String value){
    	WebElement ime = getPretraga();
		ime.clear();
		ime.sendKeys(value);
    }
	public WebElement getOdustaniBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//buton[contains(text(),'Odustani')]"), 10);
	}
	public boolean isInTable(String tekst) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + tekst+ "\")]"));
	}
	public WebElement getPrihvatiBtn(String tekst) {
    	return Utils.waitToBeClickable(driver, By.id("button_3"), 10);
    }
	public WebElement getPogledajLink(String tekst) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),'pogledaj')]"), 10);
	}
	public WebElement getIzmeniLink(String tekst) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),'izmeni')]"), 10);
	}
	public WebElement getBrisiLink(String tekst) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),'brisi')]"), 10);
	}
}
