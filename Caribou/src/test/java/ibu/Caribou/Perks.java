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

class Perks {
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
	void perksQuestions() {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		webDriver.findElement(By.linkText("PERKS")).click();
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(webDriver);
		wait.withTimeout(Duration.ofSeconds(5));
		wait.pollingEvery(Duration.ofMillis(250));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#post-132858 > figure.wp-block-image.alignfull.size-full.ghostkit-d-sm-none.ghostkit-d-md-block > img")));
		
		webDriver.findElement(By.linkText("SEE ALL FAQS")).click();
		
		webDriver.findElement(By.partialLinkText("Points")).click();	
		
		WebElement questions=webDriver.findElement(By.xpath("//*[@id=\"gift-cards\"]/div[2]/div[2]/div"));
		String text=questions.getText();
		assertTrue(text.contains("How do I earn points? "));		
		
	}

}
