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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Onlineordering {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Downloads\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--start-maximized");
		webDriver=new ChromeDriver(option);
		baseUrl="https://www.cariboucoffee.com/";
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
	void onlineOrdering() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.linkText("WAYS TO ORDER")).click();
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"metaslider_94644\"]/ul[1]/li/img")));
		
		webDriver.findElement(By.xpath("//*[@id=\"post-94520\"]/div[5]/div/div[1]/div/div[2]/div/a/span")).click();
		webDriver.findElement(By.id("q")).clear();
		webDriver.findElement(By.id("q")).sendKeys("Minneapolis, Minnesota, United States");
		webDriver.findElement(By.xpath("//*[@id=\"js-mapbox-typeahead\"]/div/div/div/div/button[2]")).click();
		
		Thread.sleep(2000);
		
		WebElement locator=webDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[2]/div[2]/div/div"));
		webDriver.findElement(RelativeLocator.with(By.linkText("Order Now")).below(locator)).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("online-ordering-is-currently-unavailable")));
		
		String text=webDriver.findElement(By.id("online-ordering-is-currently-unavailable")).getText();
		assertTrue(text.contains("Online Ordering is Currently Unavailable"));
	}
//ima izmjena uslikaj ponovo
}
