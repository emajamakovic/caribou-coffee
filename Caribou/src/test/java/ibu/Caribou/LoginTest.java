package ibu.Caribou;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class LoginTest {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Almina\\Documents\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		webDriver = new ChromeDriver(options);
		baseUrl = "https://www.cariboucoffee.com/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void lostYourPasswordTest() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[10]/nav/div/ul/li[1]/a")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[10]/div[2]/div/main/article/div/div[2]/div[1]/fieldset/form/p[4]/a")).click();
		Thread.sleep(2000);

		WebElement email = webDriver.findElement(By.name("email"));
		email.sendKeys("username@gmail.com");
		
		webDriver.findElement(By.xpath("/html/body/div[10]/div[2]/div/main/form/fieldset/button")).click();

	}

}
