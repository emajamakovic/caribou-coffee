package ibu.Caribou;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

class Shop {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Downloads\\chromedriver.exe");
		webDriver=new ChromeDriver();
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
	void shopDrinkware() {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		webDriver.findElement(By.linkText("SHOP")).click();
		FluentWait<WebDriver>wait=new FluentWait<WebDriver>(webDriver);
		wait.withTimeout(Duration.ofSeconds(5));
		wait.pollingEvery(Duration.ofMillis(250));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div/figure[2]/a/img")));
		
		webDriver.findElement(By.partialLinkText("Drinkware")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("orderby")));
		
		Select orderby=new Select(webDriver.findElement(By.name("orderby")));
		orderby.selectByValue("price-desc");
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id=\"main\"]/form/select/option[3]")));
		
		WebElement orderbyselector=webDriver.findElement(By.name("orderby"));
		webDriver.findElement(RelativeLocator.with(By.xpath("//*[@id=\"main\"]/ul/li[3]/a[1]"))
				.below(orderbyselector)).click();		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("perks-note"), "Login"));
		
		String label=webDriver.findElement(By.className("perks-note")).getText();
		assertTrue(label.contains("Caribou Perks"));
		
	}

}
