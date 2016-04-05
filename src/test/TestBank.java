package test;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class TestBank {

	 		@Test
	public void testBank() throws InterruptedException {
	 System.out.println("*****Inside TestBank Class For Selenium Code Execution..\n");
	 Thread.sleep(18000);
	 DesiredCapabilities DesireCaps = new DesiredCapabilities();
	 DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS,"driver/phantomjs");
		System.out.print("*****Read the file in the path.......\n");		
		WebDriver driver = new PhantomJSDriver(DesireCaps);
		System.out.println("*****Driver Executed in linux......\n");	
	 			/*WebDriver driver = new FirefoxDriver();*/
		driver.get("http://genericbankui.mybluemix.net/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		//driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[2]/div/div/form/div[5]/div[1]/button")).click();
		
		System.out.println(driver.getTitle());

		
		String Title1=driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[2]/div/div/form/div[5]/div[1]/button")).getText();
		System.out.println("Title is " + Title1);
		
		//Login Page is successfully loaded
		Assert.assertTrue(Title1.contains("LOGIN"));
		
		// Perform Login //
		driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[2]/div/div/form/div[5]/div[1]/button")).click();
		driver.findElement(By.id("username")).sendKeys("demo");
		driver.findElement(By.id("password")).sendKeys("demo");
		String s1 = driver.findElement(
				By.xpath("html/body/div[2]/div/div/div/div[2]/div/div/form/div[5]/div[1]/button")).getText();
		System.out.println("Login Button" + s1);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[2]/div/div/form/div[5]/div[1]/button")).click();
    
		//Select Country/ Territory page. 
		Thread.sleep(5000);
		String Title2 = driver.findElement(
				By.xpath("html/body/div[2]/div/div[4]/div/div[2]/div[2]/div/div/form/div[1]/p")).getText();
		System.out.println("Title is " + Title2);
		
		//Select Country/ Territory page is success fully loaded.
		Assert.assertTrue(Title2.contains("Select Country/ Territory"));
		new Select(driver.findElement(By.name("from_country"))).selectByValue("2");
		new Select(driver.findElement(By.name("to_country"))).selectByIndex(3);
		String s2 = driver.findElement(By.xpath("html/body/div[2]/div/div[4]/div/div[2]/div[2]/div/div/form/div[2]/div[7]/button")).getText();
		System.out.println("End page button" + s2);
		driver.findElement(By.xpath("html/body/div[2]/div/div[4]/div/div[2]/div[2]/div/div/form/div[2]/div[7]/button")).click();
		Thread.sleep(4000);
		
		//Transfer details
		String Title3 = driver.findElement(
				By.xpath("html/body/div[2]/div/div[4]/div/div[2]/div[2]/div/div/form/div[1]/p")).getText();
		System.out.println("Title is " + Title3);
		//Transfer details page is successfully loaded.
		Assert.assertTrue(Title3.equalsIgnoreCase("Transfer Details"));
		
		driver.findElement(By.name("amount")).sendKeys("100");
		driver.findElement(By.name("transferinfo")).sendKeys("ABCD");
		driver.findElement(By.name("additioninfo")).sendKeys("abc");
		Thread.sleep(2000);
		String s3 = driver.findElement(By.xpath("html/body/div[2]/div/div[4]/div/div[2]/div[2]/div/div/form/div[2]/div[32]/button")).getText();
		System.out.println("Page next 1" + s3);
		driver.findElement(By.xpath("html/body/div[2]/div/div[4]/div/div[2]/div[2]/div/div/form/div[2]/div[32]/button")).click();
		Thread.sleep(3000);
		
		//Review details
		String Title4 = driver.findElement(
		By.xpath("html/body/div[2]/div/div[4]/div/div[2]/div[2]/div/div/form/div[1]/p")).getText();
		System.out.println("Title is " + Title4);
		//Review details page is successfully loaded.
		Assert.assertTrue(Title4.matches("Reviews Details"));
		String s4 = driver.findElement(By.xpath("html/body/div[2]/div/div[4]/div/div[2]/div[2]/div/div/form/div[2]/div[32]/button")).getText();
		System.out.println(s4);
		List<WebElement> options = driver.findElements(By.xpath("//div[32]/button"));
		int Rows_Count = options.size();
		options.get(0).click();
		Thread.sleep(4000);
		
		//Confirm and Submit details
		String Title5 = driver.findElement(
		By.xpath("html/body/div[2]/div/div[4]/div/div[2]/div[2]/div/div[1]/p")).getText();
		System.out.println("Title is " + Title5);
		//Confirm and Submit details page is successfully loaded.
		Assert.assertTrue(Title5.matches("Confirmation Information"));
		System.out.println(driver.findElement(By.linkText("Go - back to home")).getText());
		driver.findElement(By.linkText("Go - back to home")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -250);");
		//Home page. 
		Thread.sleep(5000);
		String Title6 = driver.findElement(
		By.xpath("html/body/div[2]/div/div[4]/div/div[2]/div[2]/div/div/form/div[1]/p")).getText();
		System.out.println("Title is " + Title6);
				
		//home page is success fully loaded.
		Assert.assertTrue(Title6.contains("Select Country/ Territory"));
		
		
		
		String s5 = driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div/div/div/a")).getText();
		System.out.println(s5);
		driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div/div/div/a")).click();
		Thread.sleep(2000);
		driver.quit();
		
	}
		
}
