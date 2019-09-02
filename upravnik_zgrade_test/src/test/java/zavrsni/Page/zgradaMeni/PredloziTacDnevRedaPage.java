package zavrsni.Page.zgradaMeni;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import zavrsni.Utils.Utils;



public class PredloziTacDnevRedaPage {
	private WebDriver driver;
	
	public PredloziTacDnevRedaPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getDodajBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//b[contains(text(),'Dodaj')]"), 10);
	}
	public WebElement getIzaberiteSkupstinu() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(), 'Izaberite skupstinu u koju zelite dodati tacku')]"), 10);
	}
	public WebElement getSkupstinuIzMenija(String tekst) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(), \"" + tekst + "\")]"), 10);
	}
	public Select getSelectIzaberiteSkupstinu(String value) {
		return new Select(Utils.waitForElementPresence(driver, By.xpath("//*[contains(@value= \"" + value+ "\")]"), 10));
	}
	
	//public void setIzaberiteSkupstinu(String value){
	//	this.getSelectIzaberiteSkupstinu().selectByVisibleText(value);
	//}
	public WebElement getPredloziTable() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@_ngcontent-c9]/table"), 10);
	}
	public String getIme() {
		return Utils.waitForElementPresence(driver, By.className("naziv"), 10).getText();
	}
	public String getTekstTacke() {
		return Utils.waitForElementPresence(driver, By.id("stariTekst"), 10).getText();
	}
	public WebElement getTackaByTekst(String tekst) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + tekst + "\")]/../.."), 10);
	}
	public void dodajTackuByTekst(String tekst) {
		getTackaByTekst(tekst).findElement(By.className("btn btn-success")).click();
	}
	public void izmeniTackuByTekst(String tekst) {
		getTackaByTekst(tekst).findElement(By.xpath("//span[contains(text(),'izmeni')]")).click();
	}
	public void brisiTackuByTekst(String tekst) {
		getTackaByTekst(tekst).findElement(By.xpath("//span[contains(text(),'brisi')]")).click();
	}
	public WebElement izaberiSkupstinu(String value) {
		return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(),\"" + value + "\")]"), 10);
	}
	public boolean isInTable(String tekst) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + tekst+ "\")]"));
	}
	public WebElement getIzmeniLink(String tekst) {
    	return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(), 'izmeni')]"), 10);
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
    	public WebElement getPromenaTeksta() {
        	return Utils.waitToBeClickable(driver, By.id("noviTekst"), 10);
        }
        public void setPromenaTeksta(String value){
        	WebElement noviTekst = getPromenaTeksta();
    		noviTekst.clear();
    		noviTekst.sendKeys(value);
        }
        public String getSuccessMsg() {
    		return Utils.waitForElementPresence(driver, By.xpath("//*[@id= 'toast-container']/div"), 10).getText();
    	}
        public boolean notPresentSuccessMsg() {
    		return Utils.isElementNotPresent(driver, By.xpath("//*[@id= 'toast-container']/div"), 10);
    	}
        public WebElement getDodajPredlogBtn(String tekst) {
    		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(),'Dodaj predlog tacke u izabranu skupstinu')]"), 10);
    	}
}
