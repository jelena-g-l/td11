package zavrsni.Page.stanari;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class StanariPregledPage {
	private WebDriver driver; 
	
	public StanariPregledPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getPregledStanari() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@class = 'row justify-content-md-center ng-star-inserted']"), 10);
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
	public WebElement getTablePregledStanari() {
		return Utils.waitForElementPresence(driver, By.xpath("//table[@class = 'table table-hover']"), 10);
	}
	public List<WebElement> getTableRows() {
		return this.getTablePregledStanari().findElements(By.tagName("tr"));
	}
	public WebElement getStanByIme(String ime) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."), 10);
	}
	
	
	
	public boolean isStanarInTable(String stanar) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + stanar + "\")]/../.."));
	}
	public WebElement getRowByStanar(String stanar) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + stanar + "\")]/../.."), 10);
	}
	
	public void goToStanar(String stanar) {
		getRowByStanar(stanar).findElement(By.className("col-md-11")).click();
		
	}
	public String getErrorTekstStanar() {
		return Utils.waitForElementPresence(driver, By.xpath("//h2[contains(text(),'Nijedan stanar sa trazenim kriterijumom nije prondajen!')]"), 10).getText();
	}

}
