package ibu.Caribou;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Register {
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
	void register(){
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		String login=webDriver.findElement(By.linkText("LOGIN")).getAttribute("href");
		webDriver.get(login);
		webDriver.findElement(By.id("reg_first_name")).sendKeys("Ema");
		webDriver.findElement(By.id("reg_last_name")).sendKeys("Jamaković");
		webDriver.findElement(By.id("reg_birthday")).sendKeys("31/07/2001");
		webDriver.findElement(By.id("reg_zip")).sendKeys("71300");
		webDriver.findElement(By.id("reg_billing_phone")).sendKeys("061270905");
		webDriver.findElement(By.id("reg_email")).sendKeys("ema.jamakovic@stu.ibu.edu.ba");
		webDriver.findElement(By.id("reg_password")).sendKeys("password");
		
		webDriver.findElement(By.id("email_notifications")).click();
//		webDriver.findElement(By.xpath("//*[@id=\"post-453\"]/div/div[2]/div[2]/fieldset/form/p[7]/button")).click();





	}

}
