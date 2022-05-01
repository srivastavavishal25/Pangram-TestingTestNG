package PangramPackageTestNG;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class PanagramTesting {

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

	@Test
//Test Case	--When more then 26 characters but not  Pangram	
	public void TC2_PT_26_moreCharacter_nonPangram() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumPractice\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String source = "https://pangram-checker.com/";
		driver.get(source);
		driver.manage().window().maximize();
		SoftAssert sa = new SoftAssert();
		driver.findElement(By.name("phrase")).sendKeys("dgfhggddefghijklmnopqrstuvwxyzsdftenfd");
		driver.findElement(By.cssSelector("button.button.success")).click();
		Thread.sleep(500);
		String expectedmsg = driver.findElement(By.className("dialog-content")).getText();
		String actualmsg = "Pangram: false Missing Letters";
		if (expectedmsg.contains(actualmsg))
			System.out.println("String is not Pangram-Test pass");
		else
			System.out.println("Test Fail");
		driver.quit();

	}

	@Test
//Test Case --When more then 26 characters with  Pangram	
	public void TC3_PT_26_moreCharacter_Pangram() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumPractice\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String source = "https://pangram-checker.com/";
		driver.manage().window().maximize();
		driver.get(source);
		SoftAssert sa = new SoftAssert();
		driver.findElement(By.name("phrase")).sendKeys("abcdefghijklmnopqrstuvwxyzsdftenfd");
		driver.findElement(By.cssSelector("button.button.success")).click();
		Thread.sleep(500);
		String expectedmsg = driver.findElement(By.className("dialog-content")).getText();
		String actualmsg = "Pangram: true Missing Letters";
		if (expectedmsg.contains(actualmsg))
			System.out.println("String is Pangram-Test pass");
		else
			System.out.println("Test Fail");
		driver.quit();

	}

	@Test
//Test Case -- Click Try Again & it should return on previous screen
	public void TC4_PT_TryAgain() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumPractice\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String source = "https://pangram-checker.com/";
		driver.get(source);
		driver.manage().window().maximize();
		SoftAssert sa = new SoftAssert();
		driver.findElement(By.name("phrase")).sendKeys("abcdefghijklmnopqrstuvwxyzsdftenfd");
		driver.findElement(By.cssSelector("button.button.success")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("button.button.primary")).click();
		Thread.sleep(500);
		// sa.assertTrue(driver.findElement(By.name("phrase")).isDisplayed());
		if (driver.findElement(By.name("phrase")).isDisplayed())
			System.out.println("Try Again returns to previous screen- Test Pass");
		else
			System.out.println("Try Again not working- Test Fail");
		driver.quit();
	}

	@Test
	// Test Case -- On click of "X" icon text should be cleared
	public void TC5_PT_ClickOn_X_Sign() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumPractice\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String source = "https://pangram-checker.com/";
		driver.get(source);
		driver.manage().window().maximize();
		SoftAssert sa = new SoftAssert();
		driver.findElement(By.name("phrase")).sendKeys("abcdefghijklmnopqrstuvwxyzsdftenfd");
		Thread.sleep(500);
		driver.findElement(By.className("default-icon-cross")).click();
		Thread.sleep(500);
		if (driver.findElement(By.name("phrase")).getText().contains(""))
			System.out.println("Text cleared- TC passed");
		else
			System.out.println("Text not cleared- TC Fail");
		driver.quit();

	}

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
