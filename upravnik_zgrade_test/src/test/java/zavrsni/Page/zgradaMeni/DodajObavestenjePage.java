package zavrsni.Page.zgradaMeni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class DodajObavestenjePage {
	private WebDriver driver;
	public DodajObavestenjePage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getTekstObavestenja() {
		return Utils.waitForElementPresence(driver, By.id("tekstObavestenja"), 10);
	}
	public WebElement getPotvrdiBtn() {
		return Utils.waitToBeClickable(driver, By.id("dodajObavestenje"), 10);
	}
}
