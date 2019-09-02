package zavrsni.Page.stanari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class StanariRegistracijaPregledPage {
	private WebDriver driver;
	
	public StanariRegistracijaPregledPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getRegistracijaBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//b[contains(text(), 'Registracija')]"), 10);
	}
	public WebElement getPregledBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//b[contains(text(), 'Pregled')]"), 10);
	}

}
