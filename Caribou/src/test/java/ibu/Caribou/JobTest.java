package ibu.Caribou;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class JobTest {
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
	void jobTest() throws InterruptedException {
		webDriver.get(baseUrl);

		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0, 2000)");
		Thread.sleep(2000);
		
		webDriver.findElement(By.cssSelector("#post-116002 > div.ghostkit-grid.ghostkit-grid-gap-md.ghostkit-custom-246ujX > div > div > "
				+ "div > div > div > a > span")).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0, 500)");
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("//*[@id=\"post-11149\"]/div[3]/div/div[1]/div/figure/a/img")).click();
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
		WebElement map = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-11311\"]/div[1]/div/div/div/"
				+ "div/div/div[1]/div[1]/div/div[1]/div/div/div[2]/div[2]")));
		
		WebElement job = webDriver.findElement(By.xpath("//*[@id=\"search-term\"]"));
		job.sendKeys("Barista");
		WebElement location = webDriver.findElement(By.xpath("//*[@id=\"search-location\"]"));
		location.sendKeys("Sarajevo");
		Select miles = new Select(webDriver.findElement(By.id("radius-select")));
		miles.selectByValue("50");
		
		webDriver.findElement(By.cssSelector("#post-11311 > div.ghostkit-grid.ghostkit-grid-gap-md.ghostkit-custom-1PGUUR > div > div > "
				+ "div > div > div > div:nth-child(1) > div.job-search > div.search-container.flex > button")).click();
		Thread.sleep(3000);
		
		String reply = webDriver.findElement(By.className("not-found")).getText();
		assertTrue(reply.contains("Unfortunately"));
	}

}
