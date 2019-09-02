package zavrsni.Page.zgrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class ZgradaMeniPage {
	private WebDriver driver;
	public ZgradaMeniPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getStanoviLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(), 'Stanovi')]"), 10);
	}
	public WebElement getObavestenjaLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(), 'Obavestenja')]"), 10);
	}
	public WebElement getPredloziTackeDnevnogRedaLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(), 'Predlozi tacke dnevnog reda')]"), 10);
	}
	public WebElement getSastanciSkupstineLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(), 'Sastanci skupstine')]"), 10);
	}
	public WebElement getKvaroviLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(), 'Kvarovi')]"), 10);
	}
	

}
