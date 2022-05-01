package PangramPackageTestNG;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PT_26_moreCharacter_nonPangram {
	
	@Test
	//Test Case	--When more then 26 characters but not  Pangram	
		public void TC2_PT_26_moreCharacter_nonPangram() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumPractice\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String source = "https://pangram-checker.com/";
			driver.get(source);
			driver.manage().window().maximize();
			SoftAssert sa = new SoftAssert();
			driver.findElement(By.name("phrase")).sendKeys("gfhdyrhfgtcgdfrvhyfgrtdjsudhfgrtedfr");
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
}
