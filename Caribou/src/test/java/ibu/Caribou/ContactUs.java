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

class ContactUs {
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
	void contactUs() {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		webDriver.findElement(By.linkText("CONTACT US")).click();
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(webDriver);
		wait.withTimeout(Duration.ofSeconds(5));
		wait.pollingEvery(Duration.ofMillis(250));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#post-102 > figure > img")));
		
		Select question=new Select(webDriver.findElement(By.id("input_3_1")));
		question.selectByValue("Perks Inquiry");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field_3_13")));
		
		Select field=new Select(webDriver.findElement(By.id("input_3_14")));
		field.selectByValue("Perks Inquiry - Check In");
		webDriver.findElement(By.id("input_3_2")).sendKeys("Almina");
		webDriver.findElement(By.id("input_3_3")).sendKeys("Šehić");
		webDriver.findElement(By.id("input_3_4")).sendKeys("almina.sehic@stu.ibu.edu.ba");
		webDriver.findElement(By.id("input_3_5")).sendKeys("061270905");
		webDriver.findElement(By.id("input_3_7")).sendKeys("How do I earn points?");
		
//		webDriver.findElement(By.id("gform_submit_button_3")).click();


		
	}

}
