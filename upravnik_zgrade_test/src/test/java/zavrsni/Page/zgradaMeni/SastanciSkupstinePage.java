package zavrsni.Page.zgradaMeni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import zavrsni.Utils.Utils;

public class SastanciSkupstinePage {
	private WebDriver driver;

	public SastanciSkupstinePage(WebDriver driver) {
		this.driver = driver;

	}
	public WebElement getDodajBtn() {
		return Utils.waitToBeClickable(driver,By.xpath("//b[contains(text(),'Dodaj')]"), 10);
	}
	public WebElement getKad() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),'Svi')]"), 10);
	}
	public WebElement izaberiSastanke(String value) {
		return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(),\"" + value + "\")]"), 10);
	}
	public Select getSelectKad() {
		return new Select(Utils.waitForElementPresence(driver, By.xpath("//select[contains(text(),'Svi')]"), 10));
	}
	public void setKad(String value){
		this.getSelectKad().selectByVisibleText(value);
	}
	public WebElement getSastanciTable() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@_ngcontent-c10]/table"), 10);
	}
	public String getIme() {
		return Utils.waitForElementPresence(driver, By.className("naziv"), 10).getText();
	}
	public String getPocetak() {
		return Utils.waitForElementPresence(driver, By.id("pocetakSkupstine"), 10).getText();
	}
	public String getKraj() {
		return Utils.waitForElementPresence(driver, By.className("low-impact-text"), 10).getText();
	}
	public WebElement getPogledaj() {
		return Utils.waitForElementPresence(driver, By.className("operacije low-impact-text"), 10);
	}
	public WebElement getSkupstinaByPocetak(String pocetak) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + pocetak + "\")]"), 10);
	}
	public void izmeniSkupstinuByPocetak(String pocetak) {
		getSkupstinaByPocetak(pocetak).findElement(By.xpath("//*[contains(text(),'izmeni')]")).click();
	}
	public void otkaziSkupstinuByPocetak(String pocetak) {
		getSkupstinaByPocetak(pocetak).findElement(By.xpath("//*[contains(text(),'otkazi sastanak')]")).click();
	}
	public void pregledajSkupstinuByPocetak(String pocetak) {
		getSkupstinaByPocetak(pocetak).findElement(By.xpath("//*[contains(text(),'Pregledaj tacke')]")).click();
	}
	public void pregledajZapisnikByPocetak(String pocetak) {
		getSkupstinaByPocetak(pocetak).findElement(By.xpath("//*[contains(text(),'Pregledaj zapisnik')]")).click();
	}
	public WebElement getIzmeniLink(String tekst) {
    	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'izmeni')]"), 10);
    }
	public WebElement getOtkaziSastanakLink(String tekst) {
    	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'otkazi sastanak')]"), 10);
    }
    public WebElement getPregledajTackeLink(String tekst) {
    	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'Pregledaj tacke')]"), 10);
    }
    public WebElement getPregledajZapisnikLink(String tekst) {
        	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'Pregledaj zapisnik')]"), 10);
        	 
    }
    public WebElement getPotvrdiBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(),'Potvrdi')]"), 10);
	}
    public String getSuccessMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id= 'toast-container']/div"), 10).getText();
	}
    public boolean notPresentSuccessMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@id= 'toast-container']/div"), 10);
	}
    public boolean isInTable(String tekst) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + tekst+ "\")]"));
	}
    public WebElement getUkloniLink(String tekst) {
    	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'ukloni')]"), 10);
    }
    public WebElement getPregledajAnketuLink(String tekst) {
    	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'Pregledaj anketu')]"), 10);
    }
    public WebElement getPotvrdiLink() {
    	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'potvrdi')]"), 10);
    }
    public WebElement getOdustaniLink() {
    	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'odustani')]"), 10);
    }
    public WebElement getPromenaTeksta() {
        return Utils.waitToBeClickable(driver, By.id("noviTekst"), 10);
    }
    public void setPromenaTeksta(String value){
    	WebElement noviTekst = getPromenaTeksta();
		noviTekst.clear();
		noviTekst.sendKeys(value);
    }
    

}
