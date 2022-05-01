package PangramPackageTestNG;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PT_ClickOn_X_Sign {

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

}
