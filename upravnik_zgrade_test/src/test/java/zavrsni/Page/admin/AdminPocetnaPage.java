package zavrsni.Page.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;



public class AdminPocetnaPage {
	private WebDriver driver;
	public AdminPocetnaPage(WebDriver driver) {
		
		this.driver = driver;
		
		}
	public WebElement getPocetnaAdmin() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id='opcije']"), 10);
	}

	public WebElement getZgradeLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id='opcije']/li[1]/a"), 10);
	}
	public WebElement getStanariLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id='opcije']/li[2]/a"), 10);
	}
	public WebElement getInstitucijeLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id='opcije']/li[3]/a"), 10);
	}
	public WebElement getFirmeLink() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@id='opcije']/li[4]/a"), 10);
	}

}
