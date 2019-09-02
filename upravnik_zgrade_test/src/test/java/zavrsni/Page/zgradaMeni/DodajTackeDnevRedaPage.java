package zavrsni.Page.zgradaMeni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;

public class DodajTackeDnevRedaPage {
	private WebDriver driver;
	public DodajTackeDnevRedaPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getTekstTackeDnevReda() {
		return Utils.waitForElementPresence(driver, By.id("tekstPtdr"), 10);
	}
	public WebElement getPotvrdiBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(),'Potvrdi')]"), 10);
	}
	public void setTekstTackeDnevReda(String value){
    	WebElement tekst = getTekstTackeDnevReda();
		tekst.clear();
		tekst.sendKeys(value);
    
    }
	public String getSuccessMsg() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id= 'toast-container']/div"), 10).getText();
	}
    public boolean notPresentSuccessMsg() {
		return Utils.isElementNotPresent(driver, By.xpath("//*[@id= 'toast-container']/div"), 10);
	}
}
