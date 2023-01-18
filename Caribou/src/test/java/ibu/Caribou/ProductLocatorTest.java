package ibu.Caribou;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ProductLocatorTest {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Almina\\Documents\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		webDriver = new ChromeDriver(options);
		baseUrl = "https://www.cariboucoffee.com/product-locator/";
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
	void failedZipCodestest() throws InterruptedException {
		webDriver.get(baseUrl);
		
		WebElement zipCode = webDriver.findElement(By.xpath("//*[@id=\"store-locator\"]/div[1]/input"));
		zipCode.sendKeys("55416");
		
		webDriver.findElement(By.cssSelector("#store-locator > div:nth-child(1) > button")).click();
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#store-locator > div.results")));
		
		String failedSearch = webDriver.findElement(By.className("results")).getText();
		assertTrue(failedSearch.contains("Unable to find stores."));
	}

}
