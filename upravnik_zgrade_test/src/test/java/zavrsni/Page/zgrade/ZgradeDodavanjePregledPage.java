package zavrsni.Page.zgrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class ZgradeDodavanjePregledPage {
	private WebDriver driver;
	
	public ZgradeDodavanjePregledPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement getDodavanjeBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(), 'Dodavanje')]"), 10);
	}
	public WebElement getPregledBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//b[contains(text(), 'Pregled')]"), 10);
	}
	
}
