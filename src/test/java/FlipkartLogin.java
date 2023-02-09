import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartLogin {
	
	public WebDriver driver;
	@BeforeMethod
	
	public void OpenApp() {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.flipkart.com");
	 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}
		
	@Test
	 public void Flipkart() throws InterruptedException {
	 driver.findElement(By.name("q")).sendKeys("ipad");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("(//span[@class='r85cly'])[2]")).click();
	
	 //String filter="Connectivity";
			
	 driver.findElement(By.xpath("//div[text()='Connectivity']")).click();
	 driver.findElement(By.xpath("//div[text()='Wi-Fi Only']")).click();
	 driver.findElement(By.xpath("//div[@class='col col-7-12']/descendant::div[text()='APPLE iPad (9th Gen) 256 GB ROM 10.2 inch with Wi-Fi Only (Silver)']")).click();
	
	 String mainPage = driver.getWindowHandle();
	 Set<String> ipadPage = driver.getWindowHandles();
	 Iterator<String> It = ipadPage.iterator();
	 while(It.hasNext())
	{
		String child_Window=It.next();
		if(!mainPage.equals(child_Window))
		{
			driver.switchTo().window(child_Window);
			System.out.println(driver.switchTo().window(child_Window).getTitle());
		}
	}
	 
	// To Scroll the page down
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element = driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _2U9uOA ihZ75k')]"));
	js.executeScript("arguments[0].scrollIntoView();", element);
	element.click();
	
	//provided Number and OTP was sent to verified / Clicked on Login
	driver.findElement(By.xpath("//input[@class='_2IX_2- _17N0em']")).sendKeys("7076236423");
	driver.findElement(By.xpath("//span[text()='CONTINUE']")).click();
		
	// Address selected
	driver.findElement(By.name("address")).click();
	driver.findElement(By.xpath("//button[@class='_2KpZ6l RLM7ES _3AWRsL']")).click();
	
	// Terms and Condition Selected
	driver.findElement(By.xpath("//button[text()='Accept & Continue']")).click();	
	
	// payment Mode
	driver.findElement(By.xpath("//img[@src=\"https://img1a.flixcart.com/linchpin-web/fk-cp-zion/img/phonepe_logo_28.svg\"]")).click();
	
	driver.quit();
			
}


}
