package zavrsni.Testovi;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import zavrsni.Page.admin.AdminMeniPage;
import zavrsni.Page.admin.AdminPocetnaPage;
import zavrsni.Page.login.LoginPage;

@Test
public class LoginTestNegativni {

		private WebDriver driver;
		private LoginPage loginPage;
		private AdminPocetnaPage pocetnaPage;
		private AdminMeniPage meniPage;
		private String baseUrl;


		
		@BeforeSuite
		public void setupSelenium() {
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.navigate().to("http://localhost:8080");

		}	
		
		@BeforeTest
		public void setupPages() {
			loginPage = new LoginPage(driver);
			pocetnaPage = new AdminPocetnaPage(driver);
			meniPage = new AdminMeniPage(driver);
	}
		@Test(priority = 2)
		public void loginPrazno() throws InterruptedException {
			loginPage.login("", "");
			String expectedError = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
			assertEquals(loginPage.getError(), expectedError);
			
		}
		
       
		@Test(priority = 1)
		public void loginPraznaLozinka() throws InterruptedException {
			loginPage.login("admin@gmail.com", "");
			String expectedError = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
			assertEquals(loginPage.getError(), expectedError);
			
		}
		
		@Test(priority = 3)
		public void loginMalaSlovaLozinka() throws InterruptedException {
			loginPage.login("admin@gmail.com", "aaaaaa");
			String expectedError = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
			assertEquals(loginPage.getError(), expectedError);
			
		}
		@Test(priority = 4)
		public void loginVelikaSlovaLozinka() {
			loginPage.login("admin@gmail.com", "AAAAAA");
			String expectedError = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
			assertEquals(loginPage.getError(), expectedError);
		}
			@Test(priority = 5)
			public void loginBrojeviLozinka() throws InterruptedException{
				loginPage.login("admin@gmail.com", "111111");
				String expectedError = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
				assertEquals(loginPage.getError(), expectedError);	
			
		}
			@Test(priority = 6)
			public void loginVelikaMalaLozinka() throws InterruptedException{
				loginPage.login("admin@gmail.com", "Baaaaa");
				String expectedError = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
				assertEquals(loginPage.getError(), expectedError);
				
			}
			@Test(priority = 7)
			public void loginMalaBrojLozinka() throws InterruptedException {
				loginPage.login("admin@gmail.com", "aaaaa1");
				String expectedError = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
				assertEquals(loginPage.getError(), expectedError);
				
			}
			@Test(priority = 8)
			public void loginVelikBrojLozinka() throws InterruptedException {
				loginPage.login("admin@gmail.com", "AAAAA1");
				String expectedError = "Lozinka nije validnog formata (Mora biti bar jedno veliko slovo, veliko malo slovo i broj i minimalne duzine 6)!";
				assertEquals(loginPage.getError(), expectedError);
				
			}
			@Test(priority = 9)
			public void loginPogresnaLozinka() throws InterruptedException {
				loginPage.login("admin@gmail.com", "Bar4slova");
				String expectedError = "Pogresan email ili lozinka!";
				assertEquals(loginPage.getError(), expectedError);
				
			}
			@Test(priority =10)
			public void loginNevalidanEmail() throws InterruptedException {
				loginPage.login("admingmail.com", "Bar5slova");
				String expectedError = "Email nije validnog formata!";
				assertEquals(loginPage.getError(), expectedError);
				
			} 
			@Test(priority = 11)
			public void loginPrazanEmail() throws InterruptedException {
				loginPage.login("", "Bar5slova");
				String expectedError = "Email nije validnog formata!";
				assertEquals(loginPage.getError(), expectedError);
				
			}
		
		
		@AfterTest
		public void closeSelenium() {
			driver.quit();
		}
	

}
