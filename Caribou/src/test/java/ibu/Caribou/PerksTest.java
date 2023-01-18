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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class PerksTest {
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
	void switchWindowsTest() throws InterruptedException {
		webDriver.get(baseUrl);
		String handle = webDriver.getWindowHandle();

		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("//*[@id=\"menu-item-364\"]/a")).click();
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 4000)");
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/div[10]/div[2]/div/main/article/div[11]/div/div/div/a")).click();
		Thread.sleep(3000);
		
		webDriver.switchTo().window(handle);
		Thread.sleep(3000);


	}

}
