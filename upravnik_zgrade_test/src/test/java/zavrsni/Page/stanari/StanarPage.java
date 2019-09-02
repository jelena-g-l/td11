package zavrsni.Page.stanari;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class StanarPage {
	private WebDriver driver; 
	
	public StanarPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getTableStan() {
		return Utils.waitForElementPresence(driver, By.id("stan"), 10);
	}
	public List<WebElement> getTableRows() {
		return this.getTableStan().findElements(By.tagName("tr"));
	}
	public WebElement getByZgrada(String zgrada) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + zgrada + "\")]/../.."), 10);
	}
	public WebElement getByBrojStana(String broj) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + broj + "\")]/../.."), 10);
	}
	public WebElement getTableVlasnikStanova() {
		return Utils.waitForElementPresence(driver, By.id("vlasnikStanova"), 10);
	}
	public List<WebElement> getTableRows2() {
		return this.getTableVlasnikStanova().findElements(By.tagName("tr"));
	}
	

}
