package zavrsni.Page.zgradaMeni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class DodajSkupstinuPage {
	private WebDriver driver;
	public DodajSkupstinuPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getPocetakDatumVreme() {
		return Utils.waitForElementPresence(driver, By.name("pocetakSkupstine"), 10);
	}
	public void setPocetakDatumVreme(String datumVreme) {
		WebElement pocetakDatumVremeInput = getPocetakDatumVreme();
		pocetakDatumVremeInput.clear();
		pocetakDatumVremeInput.sendKeys(datumVreme);
	}
	public WebElement getKrajDatumVreme() {
		return Utils.waitForElementPresence(driver, By.name("zavrsetakSkupstine"), 10);
	}
	public void setKrajDatumVreme(String datumVreme) {
		WebElement krajDatumVremeInput = getKrajDatumVreme();
		krajDatumVremeInput.clear();
		krajDatumVremeInput.sendKeys(datumVreme);
	}
	public WebElement getPotvrdiBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(),'Potvrdi)']"), 10);
	}
	
	
}
