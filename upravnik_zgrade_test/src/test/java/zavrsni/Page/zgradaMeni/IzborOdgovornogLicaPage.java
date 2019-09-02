package zavrsni.Page.zgradaMeni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class IzborOdgovornogLicaPage {
	private WebDriver driver;
	public IzborOdgovornogLicaPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getIzborOdgovornogTable() {
		return Utils.waitForElementPresence(driver, By.className("table table-hover"), 10);
	}
	public String getIme() {
		return Utils.waitForElementPresence(driver, By.className("col-md-2"), 10).getText();
	}
	public WebElement getOdgovornogByIme(String ime) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ime + "\")]/../.."), 10);
	}
	public void getprihvatiBtn(String ime) {
		getOdgovornogByIme(ime).findElement(By.id("button_4")).click();
	}
	public WebElement getOdustaniBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(),'Odustani')]"), 10);
	}

}
