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
 *         6- Locate the home button and click.
 *         7- Locate the Best Sellers button and click.
 *         8- Locate Dresses button and click.
 *         9- Locate the Summer Dresses button and click.
 *         10-Locate the list button and click to change the page view.
 *         11-Locate more button and click it.
 *         12-Locate the Add wishlist button and click.
 *         13-Click to the account name button ( which is hello hello ) on the top right of the header.
 *         14-Locate the My wishlists button and click.
 *         15-Locate & Click to the wishlist text (button) to see all your wish's products.  
 *         16-Locate the priority ans select a value which is "high" .
 *         17-Locate save button for save changes and click. 
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
public class SecondScenario{
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
	@SpiraTestCase(testCaseId = 10158)
	// 6- Locate the home button and click.
	public void HomeTest() {
		
		driver.findElement(By.xpath("//*[text()=' Home']")).click(); 
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		// Checking by the page title. 
		expectedResult = driver.getTitle();
		actualResult = "My Store";
		assertEquals(expectedResult, actualResult);
		
     	
	}
	
	@Test
	@Order(7) 
	@SpiraTestCase(testCaseId = 10159)
	// 7- Locate the Best Sellers button and click.
	public void BestSellersTest() {
		
		driver.findElement(By.xpath("//*[text()='Best Sellers']")).click(); 
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		 
		element = driver.findElement(By.xpath("//*[text()='Best Sellers']"));
		
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
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
	}
	
	@Test
	@Order(8) 
	@SpiraTestCase(testCaseId = 10160)
	// 8- Locate Dresses button and click.
	public void DressesTest() {
		
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		 
		expectedResult = "Dresses - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);

	}
	
	@Test
	@Order(9) 
	@SpiraTestCase(testCaseId = 10229)
	// 9- Locate the Summer Dresses button and click.
	public void SummerTest() {
		
		driver.findElement(By.xpath("//div[@id='subcategories']/ul/li[3]/h5/a")).click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		expectedResult = "Summer Dresses - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);
	

	}
	
	@Test
	@Order(10) 
	@SpiraTestCase(testCaseId = 11015)
	// 10- Locate the list button and click to change the page view.
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
	@Order(11) 
	@SpiraTestCase(testCaseId = 10239)
	// 11- Locate more button and click it .
	public void MorebuttonTest() {
		
		element =driver.findElement(By.xpath("//div[@id='center_column']/ul/li[1]/div/div/div[3]/div/div[2]/a[2]"));
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		act.moveToElement(element).click().build().perform();
		
		expectedResult = "Printed Summer Dress - My Store";
		actualResult = driver.getTitle();
		assertEquals(expectedResult, actualResult);

	}
	
	@Test
	@Order(12) 
	@SpiraTestCase(testCaseId = 10941)
	// 12- Locate the Add wishlist button and click.
	public void AddWishlistTest() {
		
		element =driver.findElement(By.xpath("//*[text()='\n" + 
				"		Add to wishlist\n" + 
				"	']"));
		element.click(); 
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
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
	@Order(13) 
	@SpiraTestCase(testCaseId = 10945)
	// 13- Click to the account name button ( which is hello hello ) on the top right of the header
	public void ClickTheAccountButtonTest() {
		
		element =driver.findElement(By.xpath("//header[@id='header']/div[2]/div/div/nav/div[1]/a"));
		element.click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		expectedResult = driver.getTitle();
		actualResult = "My account - My Store";
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	@Order(14) 
	@SpiraTestCase(testCaseId = 10963)
	// 14- Locate the My wishlists button and click.
	public void WishListTest() {
		
		element =driver.findElement(By.xpath("//*[text()='My wishlists']"));
		element.click(); 
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		expectedResult = driver.getTitle();
		actualResult = "My Store";
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	@Order(15) 
	@SpiraTestCase(testCaseId = 10964)
	// 15- Locate & Click to the wishlist text (button) to see all your wish's products.  
	public void ListTest() {
		
		element =driver.findElement(By.xpath("//*[text()='\n" + 
				"										My wishlist\n" + 
				"									']"));
		element.click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
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
	@Order(16) 
	@SpiraTestCase(testCaseId = 10971)
	// 16- Locate the priority and select a value which is "high" .
	public void priorityTest() {
		
		s = new Select(driver.findElement(By.id("priority_5_19")));
	    s.selectByValue("0");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
        actualResult= "0";
        element= driver.findElement(By.id("priority_5_19"));
		expectedResult = element.getAttribute("value");
	
		
		if (actualResult.equals(expectedResult))
		{
			Check = true ;
		}
		else
		{
			Check = false ;
		}
		assertTrue(Check);
	
	}
	
	@Test
	@Order(17) 
	@SpiraTestCase(testCaseId = 10975)
	// 17- Locate save button for save changes and click. 
	public void SaveTest() {
		
		element =driver.findElement(By.xpath("//div[@id='mywishlist']/div[2]/div/div/ul/li/div/div[2]/div/div[2]/a"));
		element.click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		// after clicking we can check if the priority is saved or not 
		actualResult= "0";
        element= driver.findElement(By.id("priority_5_19"));
    	expectedResult = element.getAttribute("value");
		if (actualResult.equals(expectedResult))
		{
			Check = true ;
		}
		else
		{
			Check = false ;
		}
		assertTrue(Check);
		
		
	}


	
	@AfterAll
	// closing or quitting the browser after the test
	public static void closeBrowser() {
		 driver.close();
		// driver.quit();
	}
}

