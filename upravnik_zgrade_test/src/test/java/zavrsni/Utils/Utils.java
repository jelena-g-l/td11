package zavrsni.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public static boolean isPresent(WebDriver webdriver, By selector) {
		
		try {
			webdriver.findElement(selector);
		} catch (NoSuchElementException e) {
			
			return false;
		}
		return true;
		
	}
	
	public static boolean isElementNotPresent(WebDriver driver,By selector, int waitInterval) {
		try {
	   (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.invisibilityOfElementLocated(selector));
		return false;
		} catch (NoSuchElementException e) {
		return true;
		}
	}
	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}
	
	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}
	
	public static void waitForTitle(WebDriver driver, String title, int waitInterval){
		 (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.titleIs(title));
	}
	
	
	
}
