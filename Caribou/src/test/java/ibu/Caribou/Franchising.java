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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

class Franchising {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Korisnik\\Downloads\\chromedriver.exe");
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
	void franchising() {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		webDriver.findElement(By.xpath("//*[@id=\"menu-item-83871\"]/a")).click();
		
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(webDriver);
		wait.withTimeout(Duration.ofSeconds(5));
		wait.pollingEvery(Duration.ofMillis(250));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"metaslider_82453\"]/ul[1]/li[1]/img")));
		
		String qualifications=webDriver.findElement(By.xpath("//*[@id=\"post-82392\"]/div[1]/div/div/div/p[1]")).getText();
		assertTrue(qualifications.contains("experienced, multi-unit operators"));
		
		webDriver.findElement(By.id("input_6_1")).sendKeys("Ema");
		webDriver.findElement(By.id("input_6_2")).sendKeys("Jamaković");
		webDriver.findElement(By.id("input_6_3")).sendKeys("ema.jamakovic@stu.ibu.edu.ba");

		webDriver.findElement(By.id("input_6_4")).sendKeys("999999999");
		webDriver.findElement(By.id("input_6_5_1")).sendKeys("Rosulje");
		webDriver.findElement(By.id("input_6_5_2")).sendKeys("Visoko");
		webDriver.findElement(By.id("input_6_5_5")).sendKeys("71300");

		Select country=new Select(webDriver.findElement(By.id("input_6_5_6")));
		country.selectByValue("Bosnia and Herzegovina");
		
		webDriver.findElement(By.id("choice_6_6_0")).click();
		webDriver.findElement(By.id("choice_6_7_0")).click();
		webDriver.findElement(By.id("choice_6_9_0")).click();
		
//		webDriver.findElement(By.id("gform_submit_button_6")).click();
	
	}

}
