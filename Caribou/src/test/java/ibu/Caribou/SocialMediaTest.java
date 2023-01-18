package ibu.Caribou;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class SocialMediaTest {
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
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		String handle = webDriver.getWindowHandle();
		
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 4000)");
		Thread.sleep(2000);
		
		webDriver.findElement(By.cssSelector("#colophon > div.footer-container > div.footer-social > div > a:nth-child(1) > i")).click();
		Thread.sleep(2000);
		
		String title = webDriver.getTitle();
		assertEquals("Caribou Coffee® | Life Is Short. Stay Awake For It®", title);
		Thread.sleep(2000);
		
		webDriver.get("https://www.cariboucoffee.com/");
		Thread.sleep(2000);
		String url = webDriver.getCurrentUrl();
		assertEquals("https://www.cariboucoffee.com/", url);
		
		webDriver.switchTo().window(handle);
		
		js.executeScript("window.scrollBy(0, 4000)");
		Thread.sleep(2000);
		
		webDriver.findElement(By.cssSelector("#colophon > div.footer-container > div.footer-social > div > a:nth-child(2) > i")).click();
		Thread.sleep(2000);
		
		String titleF = webDriver.getTitle();
		assertEquals(title, titleF);
		Thread.sleep(2000);

	}

}
