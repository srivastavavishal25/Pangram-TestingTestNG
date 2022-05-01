package PangramPackageTestNG;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PT_Submit_WithoutText {

	@Test
	// Test Case -- Click on Submit without text
		public void TC6_PT_Submit_WithoutText() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumPractice\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String source = "https://pangram-checker.com/";
			driver.get(source);
			driver.manage().window().maximize();
			SoftAssert sa = new SoftAssert();
			driver.findElement(By.cssSelector("button.button.success")).click();
			Thread.sleep(500);
			String expectedmsg = driver.findElement(By.className("dialog-content")).getText();
			String actualmsg = "Pangram: false Missing Letters: a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
			if (expectedmsg.contains(actualmsg))
				System.out.println("String matched- all 26 characters available-Test Passed");
			else
				System.out.println("Test Fail-some Alphabets are missing");
			driver.quit();

		}

}
