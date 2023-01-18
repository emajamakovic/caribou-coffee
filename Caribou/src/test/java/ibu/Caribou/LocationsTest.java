package ibu.Caribou;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.Action;

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
import org.openqa.selenium.interactions.Actions;

class LocationsTest {
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
	void doubleClickToZoomTest() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(1000);
		
		webDriver.findElement(By.cssSelector("#menu-item-370 > a")).click();
		Thread.sleep(5000);
		
		Actions builder = new Actions(webDriver);
		
		WebElement zoom = webDriver.findElement(By.cssSelector("#dir-map-mobile-map > div.mapboxgl-control-container > "
				+ "div.mapboxgl-ctrl-bottom-right > div.mapboxgl-ctrl.mapboxgl-ctrl-group > "
				+ "button.mapboxgl-ctrl-icon.mapboxgl-ctrl-zoom-in"));
		org.openqa.selenium.interactions.Action doubleClick = builder.moveToElement(zoom).doubleClick().moveByOffset(20, -50).build();
		doubleClick.perform();
		Thread.sleep(3000);
		

	}

}
