package zavrsni.Page.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import zavrsni.Utils.Utils;


public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLoginForm() {
		return Utils.waitForElementPresence(driver, By.xpath("//form(@name ='loginForm')"), 10);
	}
	public WebElement getEmail() {
		return Utils.waitForElementPresence(driver, By.id("email"), 20);
	}

	public void setEmail(String email) {
		WebElement emailInput = getEmail();
	    emailInput.clear();
		emailInput.sendKeys(email);
	}

	public WebElement getLozinka() {
		return Utils.waitForElementPresence(driver, By.id("lozinka"), 10);
	}

	public WebElement getUlogujSeBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@class= 'btn btn-primary']"), 10);
	}

	public void setLozinka(String lozinka) {
		WebElement lozinkaInput = getLozinka();
		lozinkaInput.clear();
		lozinkaInput.sendKeys(lozinka);
	}

	public void login(String email, String lozinka) {
		setEmail(email);
		setLozinka(lozinka);
		getUlogujSeBtn().click();
	}
	
	public String getError(){
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class ='alert alert-dismissible alert-danger']"), 10).getText();
	}

}
