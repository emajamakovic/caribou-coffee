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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class OfficeCoffeeTest {
	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Almina\\Documents\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		webDriver = new ChromeDriver(option);
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
	void foodService() throws InterruptedException {
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.linkText("OFFICE COFFEE")).click();
		WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gform_wrapper_5\"]/div/p")));
		
		webDriver.findElement(By.id("input_5_1")).sendKeys("Almina");
		webDriver.findElement(By.id("input_5_2")).sendKeys("Šehić");
		webDriver.findElement(By.id("input_5_3")).sendKeys("almina.sehic@stu.ibu.edu.ba");
		
		webDriver.findElement(By.id("input_5_5")).sendKeys("Caribou");
		webDriver.findElement(By.id("input_5_4")).sendKeys("777777777");

		webDriver.findElement(By.id("input_5_6_3")).sendKeys("Sarajevo");
		webDriver.findElement(By.id("input_5_6_5")).sendKeys("71000");
		
		Select country=new Select(webDriver.findElement(By.id("input_5_6_6")));
		country.selectByValue("Bosnia and Herzegovina");
		
		webDriver.findElement(By.id("label_5_21_0")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#field_5_12")));
		
		webDriver.findElement(By.id("label_5_12_2")).click();

		webDriver.findElement(By.id("label_5_22_0")).click();
		
		Select coffee=new Select(webDriver.findElement(By.id("input_5_13")));
		coffee.selectByValue("Equator");
		
		webDriver.findElement(By.id("label_5_19_1")).click();


		//webDriver.findElement(By.id("gform_submit_button_5")).click();
	}

}