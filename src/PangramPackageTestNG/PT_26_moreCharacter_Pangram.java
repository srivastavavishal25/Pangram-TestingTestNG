package PangramPackageTestNG;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PT_26_moreCharacter_Pangram {

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


}
