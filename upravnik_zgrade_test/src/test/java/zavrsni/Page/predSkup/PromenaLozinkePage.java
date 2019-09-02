package zavrsni.Page.predSkup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class PromenaLozinkePage {
	private WebDriver driver;
	public PromenaLozinkePage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getPromenaLozinkeForm() {
		return Utils.waitForElementPresence(driver, By.name("promenaLozinkeForm"), 10);
	}
	public WebElement getStaraLozinkaInput() {
		return Utils.waitForElementPresence(driver, By.id("staraLozinka"), 10);
	}
	public WebElement getNovaLozinkaInput() {
		return Utils.waitForElementPresence(driver, By.id("novaLozinka"), 10);
	}
	public WebElement getPotvrdaNoveLozinkeInput() {
		return Utils.waitForElementPresence(driver, By.id("potvrdaNoveLozinke"), 10);
	}
	public WebElement getPromeniteLozinkuBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[contains(text(),'Promenite lozinku')]"), 10);
	}
	public String getError(){
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class ='invalid-feedback ng-star-inserted']"), 10).getText();
	}
	public void setStaraLozinkaInput(String value){
    	WebElement lozinka = getStaraLozinkaInput();
		lozinka.clear();
		lozinka.sendKeys(value);
    }
	public void setNovaLozinkaInput(String value){
    	WebElement lozinka = getNovaLozinkaInput();
		lozinka.clear();
		lozinka.sendKeys(value);
    }
	public void setPotvrdaNoveLozinkeInput(String value){
    	WebElement lozinka = getPotvrdaNoveLozinkeInput();
		lozinka.clear();
		lozinka.sendKeys(value);
    }
	public void promenaLozinke(String staraLozinka, String novaLozinka, String potvrdaLozinke) {
		setStaraLozinkaInput(staraLozinka);
		setNovaLozinkaInput(novaLozinka);
		setPotvrdaNoveLozinkeInput(potvrdaLozinke);
		
	}
	public String getAlertMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id= 'toast-message']/div"), 10).getText();
	}
    public boolean notPresentAlertMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@id= 'toast-message']/div"), 10);
	}
	
}
