package zavrsni.Page.zgrade;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rs.ac.uns.testdevelopment.ssluzba.helpers.Utils;

public class ZgradaPage {

	private WebDriver driver;
	
	public ZgradaPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getZgradaTable() {
		return Utils.waitForElementPresence(driver, By.className("table table-hover"), 10);
	}
	public List<WebElement> getTableRows() {
		return this.getZgradaTable().findElements(By.tagName("tr"));
	}
	public WebElement getVlasnik(String vlasnik) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + vlasnik + "\")]/../.."), 10);
	}
	public WebElement getVlasnikIStanariBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Vlasnik i stanari')]"), 10);
	}
	public WebElement getRowByBroj(String broj) {
			return Utils.waitForElementPresence(driver, By.xpath("//th[@class = 'col-md-2'][contains(text(), 'broj']"), 10);
		
	}
	
	public WebElement getVlasnikIStanariBtn1() {
		return Utils.waitToBeClickable(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-stanovi/div/div[1]/table/tbody/tr[2]/td[2]/a"), 10);
	}
}
