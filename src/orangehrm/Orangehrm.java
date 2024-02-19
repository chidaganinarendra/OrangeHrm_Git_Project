package orangehrm;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Orangehrm {

	WebDriver driver;
	
	@Test(priority = 1)
	public void EnterTheULRInBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	    
	}
	@Test(priority = 2)
	public void user_enter_the_vaild_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
	}
	@Test(priority = 3)
	public void click_on_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(5000);
	   
	}
	@Test(priority = 4)
	public void user_is_navigated_to_home_page() {
		Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).size()>0,"User is navigated to Home page");
	}
	@Test(priority = 5)
	public void close_the_browser() {
	    driver.close();
	}
 }
