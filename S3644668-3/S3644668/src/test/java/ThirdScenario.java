import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;



/**
 * @Tester Ahmed Basha A Altowairqi   S3644668 
 */

 /**       Here is the test plan : 
 *      
 *         1- Opening the website page.
 *         2- Locate the sign in button and click.
 *         3- Locate the Email field and insert the email. 
 *         4- Locate the password field and insert pass.
 *         5- Locate the sign in button and click.
 *         6- Locate T Shirts button and click.
 *         7- Locate the list button and click to change the page view.
 *         8- Locate Add To cart button and click.
 *         9- Locate proceed to checkout button and click.
 *         10-Locate The plus button and click to increase the number to five.
 *         11-Locate proceed to checkout button and click.
 *         12-Locate terms of service check box and click. then click checkout. 
 *         13-Locate pay by bank wire button and click. 
 *         14-Locate confirm button and click. 
 *         15-Locate sign out button and click.  
 * 
 */


@SpiraTestConfiguration(
		// following are REQUIRED
		url = "https://rmit-university.spiraservice.net",
		login = "s3644668", 
		rssToken = "{96018675-3EDE-4D15-A81D-8AA732173610}", 
		projectId = 510,
		releaseId = 548
		

		
)
@TestMethodOrder(OrderAnnotation.class) // << this annotation is for using @order, or adding order to my test-cases
public class ThirdScenario{
	// define all your variables that you need to initialise through different tests
	private static ChromeDriver driver;
	private String expectedResult;
	private String actualResult;
	private WebElement element;
	private WebDriverWait wait;
	private boolean Check;
	private Select s; 
	private Actions act  = new Actions(driver);
	
	

	@BeforeAll
	// setup my driver here through @BeforeAll, this method is running once before
	// all test-cases
	public static void setup() {
	
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	@Order(1) 
	@SpiraTestCase(testCaseId = 8856)
	// 1- Opening the website page.
	public void testwebsite() {

		driver.get("http://automationpractice.com/index.php");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		// Checking by the page title. 
		expectedResult = "My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);

	}
    
	@Test
	@Order(2) 
	@SpiraTestCase(testCaseId = 8857)
	// 2- Locate the sign in button and click.
	public void signInButtonTest() {
		
		driver.findElement(By.xpath("//*[text()='\n" + 
				"			Sign in\n" + 
				"		']")).click(); 
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		// Checking by the page title. 
		expectedResult = driver.getTitle();
		actualResult = "Login - My Store";
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	@Order(3) 
	@SpiraTestCase(testCaseId = 9982)
	//3- Locate the Email field and insert the email.
	public void EmailButtonTest() {
		driver.findElement(By.xpath("//*[@id='email']")).click() ;
		element =driver.findElement(By.xpath("//*[@id='email']"));
		// Here a bug .. Users can just enter the email by English
		element.sendKeys("AhmedB@gmail.com"); 
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expectedResult = element.getAttribute("value");
		actualResult= "AhmedB@gmail.com";
	    assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	@Order(4) 
	@SpiraTestCase(testCaseId = 9984)
	// 4- Locate the password field and insert pass.
	public void passTest() {
		element = driver.findElement(By.xpath("//*[@name='passwd']"));
	    element.sendKeys("hello"); 
		expectedResult = element.getAttribute("value");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		//cecking
		actualResult= "hello";
		assertEquals(expectedResult, actualResult);
	
	}
	
	@Test
	@Order(5) 
	@SpiraTestCase(testCaseId = 10001)
	// 5- Locate the sign in button and click.
	public void signInTest() {
		
		driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click(); 
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		// Checking by the page title. 
		expectedResult = driver.getTitle();
		
		actualResult = "My account - My Store";
     	assertEquals(expectedResult, actualResult);
     	
	}
	
	@Test
	@Order(6) 
	@SpiraTestCase(testCaseId = 11143)
	// 6- Locate T-Shirts button and click.
	public void TShirtsTest() {
		
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a")).click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		 
		expectedResult = "T-shirts - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	
	}
	
	@Test
	@Order(7) 
	@SpiraTestCase(testCaseId = 11015)
	// 7- Locate the list button and click to change the page view.
	public void ListbuttonTest() {
		
		driver.findElement(By.xpath("//*[@id='list']")).click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
	    element = driver.findElement(By.xpath("//*[@id='list']"));
		
		if (element.isDisplayed())
		{
			Check = true ;
		}
		else
		{
			Check = false ;
		}
		// Checking by true and false
		assertTrue(Check);

	}
	
	@Test
	@Order(8) 
	@SpiraTestCase(testCaseId = 11150)
	// 8- Locate Add To cart button and click.
	public void AddTocartTest() {
		
		element =driver.findElement(By.xpath("//div[@id='center_column']/ul/li[1]/div/div/div[3]/div/div[2]/a[1]"));
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		act.moveToElement(element).click().build().perform();

		if (element.isDisplayed())
		{
			Check = true ;
		}
		else
		{
			Check = false ;
		}
		// Checking by true and false
		assertTrue(Check);
	
	}
	
	@Test
	@Order(9) 
	@SpiraTestCase(testCaseId = 11245)
	// 9- Locate proceed to checkout button and click.
	public void CheckoutTest() {
		
		driver.findElement(By.xpath("//*[text()='\n" + 
				"							Proceed to checkout']")).click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		expectedResult = "Order - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	
	}
	
	@Test
	@Order(10) 
	@SpiraTestCase(testCaseId = 11246)
	// 10- Locate The plus button and click to increase the number to five.
	public void plusTest() {
		
		for (int i=0 ; i<4 ; i++)
		{
			// click the plus button                                  
			driver.findElement(By.xpath("//tr[@id='product_1_1_0_218761']/td[5]/div/a[2]")).click();
			
			// Waiting 5 seconds. 
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		}
		
		element = driver.findElement(By.xpath("//input[@name='quantity_1_1_0_218761_hidden']"));
		expectedResult = element.getAttribute("value");
		actualResult = "1";
		if (actualResult.equals(expectedResult))
		{
			Check = true ;
		}
		else
		{
			Check = false ;
		}
		// Checking by true and false
		assertTrue(Check);
	}
	
	@Test
	@Order(11) 
	@SpiraTestCase(testCaseId = 11473)
	//11- Locate proceed to checkout button and click.
	public void proceedtTest() {
		// here doing twice to go to shipping
		for (int i=0 ; i<2 ; i++)
		{
			driver.findElement(By.xpath("//*[text()='Proceed to checkout']")).click();
			// Waiting 5 seconds. 
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  
		}
		// here to make sure if the check box in enable to click or not
		element = driver.findElement(By.id("cgv"));
		if (element.isEnabled())
		{
			Check = true ;
		}
		else
		{
			Check = false ;
		}
		// Checking by true and false
		assertTrue(Check);

	}
	
	@Test
	@Order(12) 
	@SpiraTestCase(testCaseId = 11474)
	//12- Locate terms of service check box and click. then click checkout. 
	public void TermsTest() {
		driver.findElement(By.id("cgv")).click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  
		driver.findElement(By.xpath("//*[text()='\n" + 
				"								Proceed to checkout\n" + 
				"								']")).click();
		
		element = driver.findElement(By.xpath("//div[@id='HOOK_PAYMENT']/div[1]/div/p/a")); 
		
		if (element.isEnabled())
		{
			Check = true ;
		}
		else
		{
			Check = false ;
		}
		// Checking by true and false
		assertTrue(Check);
	}
	
	@Test
	@Order(13) 
	@SpiraTestCase(testCaseId = 11475)
	//13- Locate pay by bank wire button and click. 
	public void PayTest() {
		driver.findElement(By.xpath("//div[@id='HOOK_PAYMENT']/div[1]/div/p/a")).click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		element =driver.findElement(By.xpath("//*[text()='I confirm my order']"));
		// here to check the button is enabled or not 
		if (element.isEnabled())
		{
			Check = true ;
		}
		else
		{
			Check = false ;
		}
		// Checking by true and false
		assertTrue(Check);
	}
	
	@Test
	@Order(14) 
	@SpiraTestCase(testCaseId = 11480)
	//14- Locate confirm button and click. 
	public void confirmTest() {
		driver.findElement(By.xpath("//*[text()='I confirm my order']")).click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Checking by the page title. 
		expectedResult = "Order confirmation - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	@Order(15) 
	@SpiraTestCase(testCaseId = 11484)
	//15- Locate sign out button and click. 
	public void signoutTest() {
		driver.findElement(By.xpath("//*[text()='\n" + 
				"			Sign out\n" + 
				"		']")).click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Checking by the page title. 
		expectedResult = "Login - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	}

	
	
	
	@AfterAll
	// closing or quitting the browser after the test
	public static void closeBrowser() {
		   driver.close();
		// driver.quit();
	}
}
