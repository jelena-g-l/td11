package zavrsni.Page.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class AdminMeniPage {
	private WebDriver driver;
	public AdminMeniPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getPocetna() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@class='navbar-nav mr-auto']/li[1]/a"), 10);
	}
	public WebElement getZgrade() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@class='navbar-nav mr-auto']/li[2]/a"), 10);
	}
	public WebElement getStanari() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@class='navbar-nav mr-auto']/li[3]/a"), 10);
	}
	public WebElement getInstitucije() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@class='navbar-nav mr-auto']/li[4]/a"), 10);
	}
	public WebElement getFirme() {
		return Utils.waitToBeClickable(driver, By.xpath("//*[@class='navbar-nav mr-auto']/li[5]/a"), 10);
	}
	
	public String getLoginConfirmationEmailString(String email) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@class = 'nav-link active']"), 10).getText();
	}			
	public WebElement getIzlogujteSeBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Izlogujte se')]"), 10);
	}
	
	

}
