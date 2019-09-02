package zavrsni.Page.predSkup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class PredSkupMeniPage {
	private WebDriver driver;
	
	public PredSkupMeniPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getPocetna() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(),'Pocetna')]"), 10);
	}
	public WebElement getZgrade() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(),'Dodeljeni kvarovi')]"), 10);
	}
	public WebElement getPromenaLozinke() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(),'Promena lozinke')]"), 10);
	}
	public WebElement getLoginConfirmationEmailString(String email) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + email + "\")]"), 10);
				
}
	public WebElement getIzlogujteSeBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Izlogujte se')]"), 10);
	}

}
