package PangramPackageTestNG;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PT_SiteSecurityTest {

	@Test
	public void TC1_PT_SiteSecurityTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumPractice\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String source = "https://pangram-checker.com/";
		driver.manage().window().maximize();
		driver.get(source);
		// Soft Assertion
		SoftAssert sa = new SoftAssert();
		{

			String destination = driver.getCurrentUrl();
			if (source.contains(destination)) {
				System.out.println("Site is secure");
				sa.assertTrue(true);
			} else {
				System.out.println("Non Secure");
				sa.assertTrue(false);
			}
		}
		driver.quit();
	}
}
