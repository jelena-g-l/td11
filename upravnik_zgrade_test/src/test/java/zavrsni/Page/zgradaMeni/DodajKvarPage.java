package zavrsni.Page.zgradaMeni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class DodajKvarPage {
	private WebDriver driver;
	public DodajKvarPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getLokacijaKvara() {
		return Utils.waitForElementPresence(driver, By.name("mesto"), 10);
	}
	public void setLokacijaKvara(String lokacijaKvara) {
		WebElement lokacijaKvaraInput = getLokacijaKvara();
		lokacijaKvaraInput.clear();
		lokacijaKvaraInput.sendKeys(lokacijaKvara);
	}
	public WebElement getOpisKvara() {
		return Utils.waitForElementPresence(driver, By.name("opis"), 10);
	}
	public void setOpisKvara(String opisKvara) {
		WebElement opisKvaraInput = getOpisKvara();
		opisKvaraInput.clear();
		opisKvaraInput.sendKeys(opisKvara);
	}
	public WebElement getOdgovornoLiceBtn() {
		return Utils.waitToBeClickable(driver, By.id("odgovorno_lice'"), 10);
	}
	public WebElement getDodajBtn() {
		return Utils.waitToBeClickable(driver, By.id("submit"), 10);
	}

}
