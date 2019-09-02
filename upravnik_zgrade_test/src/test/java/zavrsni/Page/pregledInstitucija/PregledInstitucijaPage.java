package zavrsni.Page.pregledInstitucija;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import zavrsni.Utils.Utils;

public class PregledInstitucijaPage {

private WebDriver driver; 
	
	public PregledInstitucijaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getPretragaImePrezimeEmail() {
		return Utils.waitForElementPresence(driver, By.id("filter"), 10);
	}
	public void setPretragaPretragaImePrezimeEmail(String value) {
		WebElement imePrezimeEmail = getPretragaImePrezimeEmail();
		imePrezimeEmail.clear();
		imePrezimeEmail.sendKeys(value);
	}
	public WebElement getPretragaBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(),'Pretraga')]"), 10);
	}
	public boolean isInstitucijaInTable(String institucija) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + institucija + "\")]/../.."));
	}
	public WebElement getRegistracijaBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//b[contains(text(), 'Registracija')]"), 10);
	}
	public WebElement getPregledBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//b[contains(text(), 'Pregled')]"), 10);
	}
	//public void getTitle() {
		//return Utils.waitForTitle(driver,"Nijedna institucija sa trazenim kriterijumom nije prondajena!",10).until(ExpectedConditions.titleIs("Nijedna institucija sa trazenim kriterijumom nije prondajena!"));
	//}
    // public String getString(String title) {
    	// return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + title + "\")]/../.."), 10).getText();
    // }
	public boolean isStringPresent(String string) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + string + "\")]"));
	}
}
