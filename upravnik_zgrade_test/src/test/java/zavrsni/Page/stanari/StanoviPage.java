package zavrsni.Page.stanari;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class StanoviPage {

	private WebDriver driver;
	
	public StanoviPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getStanoviTable() {
		return Utils.waitForElementPresence(driver, By.className("table table-hover"), 10);
	}
	public List<WebElement> getTableRows() {
		return this.getStanoviTable().findElements(By.tagName("tr"));
	}
	public WebElement getStanByVlasnik(String vlasnik) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + vlasnik + "\")]/../.."), 10);
	}
	public void viewStanariByVlasnik(String vlasnik) {
		getStanByVlasnik(vlasnik).findElement(By.className("btn btn-primary")).click();
	}
}
