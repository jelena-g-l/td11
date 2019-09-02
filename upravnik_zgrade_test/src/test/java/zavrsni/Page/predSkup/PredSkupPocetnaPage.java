package zavrsni.Page.predSkup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class PredSkupPocetnaPage {
	private WebDriver driver;
	
	public PredSkupPocetnaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getZgradaVlasnikTable() {
		return Utils.waitForElementPresence(driver, By.id("zgradaVlasnik"), 10);
	}
	public List<WebElement> getTableRows() {
		return this.getZgradaVlasnikTable().findElements(By.tagName("tr"));
	}
	public WebElement getStranica() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(),\'Stranica')]"), 10);
	}
	public WebElement getZgradaStanujeTable() {
		return Utils.waitForElementPresence(driver, By.id("zgradaStanuje"), 10);
	}
	public List<WebElement> getTableRows2() {
		return this.getZgradaStanujeTable().findElements(By.tagName("tr"));
	}
	public WebElement getStranica2(String ulica) {
		return Utils.waitToBeClickable(driver, By.xpath("//*[contains(text(),\"" + ulica + "\")]/../.."), 10);
	}

}
