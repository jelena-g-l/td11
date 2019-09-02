package zavrsni.Page.zgradaMeni;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;



public class ObavestenjaPage {
	private WebDriver driver;
	
	public ObavestenjaPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getDodajBtn() {
		return Utils.waitToBeClickable(driver, By.id("dodajObavestenje"), 10);
	}
	public WebElement getObavestenjaTable() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@_ngcontent-c7]/table"), 10);
	}
	public String getIme() {
		return Utils.waitForElementPresence(driver, By.className("naziv"), 10).getText();
	}
	public String getTekstObavestenjaIzTabele() {
		return Utils.waitForElementPresence(driver, By.id("stariTekst"), 10).getText();
	}
	public WebElement getNovoObavestenjeForm() {
		return Utils.waitForElementPresence(driver, By.xpath("//form[@name= 'novoObavestenjeForm']"), 10);
	}
	public WebElement getTekstObavestenja() {
		return Utils.waitForElementPresence(driver, By.id("tekstObavestenja"), 10);
	}
    public void setTekstObavestenja(String value){
    	WebElement tekst = getTekstObavestenja();
		tekst.clear();
		tekst.sendKeys(value);
    
    }
    public WebElement getPotvrdiBtn() {
		return Utils.waitForElementPresence(driver, By.id("dodajObavestenje"), 10);
	}
    public String getSuccessMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id= 'toast-container']/div"), 10).getText();
	}
    public boolean notPresentSuccessMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@id= 'toast-container']/div"), 10);
	}
    public boolean isTekstInTable(String tekst) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + tekst+ "\")]/../.."));
	}
    public WebElement getStariTekst(String stariTekst) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + stariTekst + "\")]"), 10);
	}
    public void getIzmeniTekst(String stariTekst) {
		getStariTekst(stariTekst).findElement(By.xpath("//*[@id= 'izmeniObavestenje']")).click();
	}
    public void getMenjanjeTeksta(String stariTekst) {
		getStariTekst(stariTekst).findElement(By.id("noviTekst")).click();
	}
    public WebElement getPromenaTeksta() {
    	return Utils.waitToBeClickable(driver, By.id("noviTekst"), 10);
    }
    public void setPromenaTeksta(String value){
    	WebElement noviTekst = getPromenaTeksta();
		noviTekst.clear();
		noviTekst.sendKeys(value);
    }
    public WebElement getPotvrdiLink(String tekst) {
    	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'potvrdi')]"), 10);
    }
    public WebElement getOdustaniLink(String tekst) {
    	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'odustani')]"), 10);
    }
    	public WebElement getBrisiLink(String tekst) {
        	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'brisi')]"), 10);
        	 
    }
    	//radi
    	public WebElement getIzmeniLink(String tekst) {
        	return Utils.waitToBeClickable(driver, By.xpath("//*[@id='izmeniObavestenje']"), 10);
        }
    	
}
