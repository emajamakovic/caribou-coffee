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

class FoodService {
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
		webDriver.quit();;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void foodService() {
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.linkText("FOOD SERVICE")).click();
		WebDriverWait wait=new WebDriverWait(webDriver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("post-45726")));
		
		webDriver.findElement(By.id("input_4_1")).sendKeys("Ema");
		webDriver.findElement(By.id("input_4_2")).sendKeys("Jamaković");
		webDriver.findElement(By.id("input_4_3")).sendKeys("ema.jamakovic@stu.ibu.edu.ba");
		webDriver.findElement(By.id("input_4_5")).sendKeys("Caribou");
		webDriver.findElement(By.id("input_4_4")).sendKeys("999999999");

		webDriver.findElement(By.id("input_4_6_3")).sendKeys("Sarajevo");
		webDriver.findElement(By.id("input_4_6_5")).sendKeys("31000");
		
		Select country=new Select(webDriver.findElement(By.id("input_4_6_6")));
		country.selectByValue("Bosnia and Herzegovina");
		
		Select businessType=new Select(webDriver.findElement(By.id("input_4_8")));
		businessType.selectByValue("University/College");
		
		webDriver.findElement(By.id("choice_4_11_0")).click();
		webDriver.findElement(By.id("choice_4_12_2")).click();
		
		Select coffeeBrand=new Select(webDriver.findElement(By.id("input_4_13")));
		coffeeBrand.selectByValue("Lavazza");

		webDriver.findElement(By.id("choice_4_15_2")).click();
		webDriver.findElement(By.id("choice_4_17_0")).click();
		webDriver.findElement(By.id("choice_4_18_2")).click();
		webDriver.findElement(By.id("choice_4_19_1")).click();
		
//		webDriver.findElement(By.id("gform_submit_button_4")).click();



	}

}
