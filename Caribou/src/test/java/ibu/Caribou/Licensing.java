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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class Licensing {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Downloads\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		webDriver=new ChromeDriver(options);
		baseUrl="https://www.cariboucoffee.com/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void licensing() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.linkText("LICENSING")).click();
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
		WebElement map = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-45640\"]/div[1]/div/div/div/figure/img")));
		
		webDriver.findElement(By.id("choice_2_18_1")).click();
		webDriver.findElement(By.id("input_2_2_3")).sendKeys("Ema");
		webDriver.findElement(By.id("input_2_2_6")).sendKeys("Jamaković");
		webDriver.findElement(By.id("input_2_3")).sendKeys("ema.jamakovic@stu.ibu.edu.ba");
		webDriver.findElement(By.id("input_2_6")).sendKeys("Caribou");
		webDriver.findElement(By.id("input_2_5_3")).sendKeys("Minneapolis");
		webDriver.findElement(By.id("input_2_5_5")).sendKeys("55401");

		Select country=new Select(webDriver.findElement(By.id("input_2_5_4")));
		country.selectByValue("Minnesota");
		
		Select entitylocation=new Select(webDriver.findElement(By.id("input_2_9_4")));
		entitylocation.selectByValue("Minnesota");
		
		webDriver.findElement(By.id("choice_2_10_1")).click();
		webDriver.findElement(By.id("choice_2_16_3")).click();
		
		
//		webDriver.findElement(By.id("gform_submit_button_2")).click();

	
	}

}
