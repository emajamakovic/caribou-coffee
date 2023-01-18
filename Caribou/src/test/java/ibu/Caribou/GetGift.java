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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

class GetGift {
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
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		webDriver.findElement(By.linkText("SHOP")).click();
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(webDriver);
		wait.withTimeout(Duration.ofSeconds(5));
		wait.pollingEvery(Duration.ofMillis(250));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[2]/div/div/div/figure[2]/a/img")));
		
		webDriver.findElement(By.linkText("Shop Apparel")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apparel")));
		

		webDriver.findElement(By.xpath("//*[text()='Buffalo Plaid Sherpa Fleece with Walking Bou']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-89519\"]/div[2]/h1")));
		
		Select size=new Select(webDriver.findElement(By.id("pa_size")));
		size.selectByValue("medium");
		
		Select quantity=new Select(webDriver.findElement(By.xpath("//*[@id=\"product-89519\"]/div[2]/form/div/div[2]/div/select")));
		quantity.selectByValue("2");
		
		webDriver.findElement(By.cssSelector("#product-89519 > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[1]/div")));


}
}
