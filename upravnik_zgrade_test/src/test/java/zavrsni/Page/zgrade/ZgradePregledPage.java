package zavrsni.Page.zgrade;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import zavrsni.Utils.Utils;

public class ZgradePregledPage {
	private WebDriver driver;

	public ZgradePregledPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPrikaz() {
		return Utils.waitForElementPresence(driver, By.id("prikaz"), 10);
	}
	public Select getSelectPrikaz() {
		return new Select(Utils.waitForElementPresence(driver, By.id("prikaz"), 10));
	}
	public void setPrikaz(String value){
		this.getSelectPrikaz().selectByVisibleText(value);
	}
	public WebElement  getPretragaUlicaBroj() {
		return Utils.waitForElementPresence(driver, By.id("ulicaBroj"), 10);
	}
	public void setPretragaUlicaBroj(String value) {
		WebElement ulicaBroj = getPretragaUlicaBroj();
		ulicaBroj.clear();
		ulicaBroj.sendKeys(value);
	}
	
	public WebElement getPretragaGrad() {
		return Utils.waitForElementPresence(driver, By.id("mesto"), 10);
	}
	public void setPretragaGrad(String value) {
		WebElement grad = getPretragaGrad();
		grad.clear();
		grad.sendKeys(value);
	}
	public WebElement getPretragaBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[contains(text(),'Pretraga')]"), 10);
	}
	//nije dobar selektor
	public WebElement getTableZgrade() {
		return Utils.waitForElementPresence(driver, By.xpath("//table[@class = 'table table-hover']"), 10);
	}
	public List<WebElement> getTableRows() {
		return this.getTableZgrade().findElements(By.tagName("tr"));
	}
	public boolean isZgradaInTable(String zgrada) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + zgrada + "\")]/../.."));
	}
	public WebElement getRowByUlica(String ulica) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + ulica + "\")]/../.."), 10);
	}
	
	public void goToZgradaByUlica(String ulica) {
		getRowByUlica(ulica).findElement(By.className("col-md-6")).click();
	}
	public WebElement getRowByPredsenik(String predsednik) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + predsednik + "\")]/../.."), 10);
	}
	public void goToStanarByPredsednik(String predsednik) {
		getRowByUlica(predsednik).findElement(By.className("col-md-3")).click();
	}
	
	public WebElement getAdresaZgradeLink(String ulica) {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(),\"" + ulica + "\")]"), 10);
	}
	public WebElement getPredStanLink(String predsednik) {
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(),\"" + predsednik + "\")]"), 10);
	}
	public String getErrorTekst() {
		return Utils.waitForElementPresence(driver, By.xpath("//h2[contains(text(),'Nijedna zgrada sa trazenim kriterijumima nije prondajena!')]"), 10).getText();
	}
	
}
