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
 *         3- Locate the create an account field and insert the email. 
 *         4- Locate the create an account button and click. 
 *         5- Locate the radio button of Mr. and click.  
 *         6- Locate the first name field and insert the name. 
 *         7- Locate the Last name field and insert the name.
 *         8- Locate the sent section and validate the sent email.
 *         9- Locate the password field and insert pass.
 *         10-Locate the date day and select a value.
 *         11-Locate the date month and select a value.
 *         12-Locate the date year and select a value.
 *         13-Checking the box of the newsletter.
 *         14-Checking the box of receviving special offers.
 *         15-Locate the address field and insert the value.
 *         16-Locate the city field and insert the value.
 *         17-Locate the small arrow and click then select the state from the dropdown list.
 *         18-Locate the postal code and insert the value.
 *         19-Locate the small arrow and click then select the Country.
 *         20-Locate the Mobile phone field and insert the number.
 *         21-Locate the address alias field  then delete the text that exist there and insert the address alias.
 *         22-Click on Register button.
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
public class FirstScenario{
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
	@SpiraTestCase(testCaseId = 9694)
	//3- Locate the create an account field and insert the email.
	public void EmailButtonTest() {
		driver.findElement(By.xpath("//*[@id='email_create']")).click() ;
		element =driver.findElement(By.xpath("//*[@id='email_create']"));
		// Here a bug .. Users can just enter the email by English
		element.sendKeys("اختبارtest@hotmail.com"); 
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expectedResult = element.getAttribute("value");
		actualResult= "اختبارtest@hotmail.com";
	    assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	@Order(4) 
	@SpiraTestCase(testCaseId = 9543)
	// 4- Locate the create an account button and click.  
	public void CreateButtonTest() {
		driver.findElement(By.xpath("//*[@name='SubmitCreate']")).click();
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		// Checking by the page title. 
		
		
		expectedResult = driver.getCurrentUrl();
		actualResult = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	    // Checking by true and false
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Test
	@Order(5) 
	@SpiraTestCase(testCaseId = 9544)
	// 5- Locate the radio button of Mr. and click. 
	public void RiadoButtonTest() {
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		element = driver.findElement(By.xpath("//input[@id='id_gender1']"));
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		if (element.isSelected())
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
	@Order(6) 
	@SpiraTestCase(testCaseId = 9657)
	// 6- Locate the first name field and insert the name. 
	public void FirstNameTest() {
		element = driver.findElement(By.xpath("//*[@id='customer_firstname']"));
	    element.sendKeys("FirstName"); 
		expectedResult = element.getAttribute("value");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		actualResult = "FirstName";
		assertEquals(expectedResult, actualResult);
	
	}
	
	@Test
	@Order(7) 
	@SpiraTestCase(testCaseId = 9706)
	// 7- Locate the Last name field and insert the name.
	public void LastNameTest() {
		element = driver.findElement(By.xpath("//*[@id='customer_lastname']"));
	    element.sendKeys("LastName"); 
		expectedResult = element.getAttribute("value");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		actualResult = "LastName";
		assertEquals(expectedResult, actualResult);
	
	}
	
	@Test
	@Order(8) 
	@SpiraTestCase(testCaseId = 9705)
	// 8- Locate the sent section and validate the sent email.
	public void EmailValidateTest() {
		element = driver.findElement(By.xpath("//input[@id='email']"));
	    element.click(); 
		expectedResult = element.getAttribute("value");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		//cecking
		actualResult= "اختبارtest@hotmail.com";
		assertEquals(expectedResult, actualResult);
	
	}
	
	@Test
	@Order(9) 
	@SpiraTestCase(testCaseId = 9707)
	// 9- Locate the password field and insert pass.
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
	@Order(10) 
	@SpiraTestCase(testCaseId = 9715)
	// 10-Locate the date day and select a value.
	public void DayTest() {
		s = new Select(driver.findElement(By.id("days")));
	    s.selectByValue("3");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		actualResult= "3";
		
		element= driver.findElement(By.id("days"));
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
	@Order(11) 
	@SpiraTestCase(testCaseId = 9755)
	//  11-Locate the date month and select a value.
	public void MonthTest() {
		s = new Select(driver.findElement(By.id("months")));
		s.selectByValue("10");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		actualResult= "10";
		element= driver.findElement(By.id("months"));
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
	@Order(12) 
	@SpiraTestCase(testCaseId = 9756)
	// 12-Locate the date year and select a value.
	public void YearTest() {
		s = new Select(driver.findElement(By.id("years")));
		s.selectByValue("1992");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		actualResult= "1992";
		element= driver.findElement(By.id("years"));
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
	@Order(13) 
	@SpiraTestCase(testCaseId = 9757)
	// 13-Checking the box of the newsletter.
	public void NewsletterTest() {
		act.moveToElement(driver.findElement(By.xpath("//*[@id='newsletter']"))).click().build().perform();
		element = driver.findElement(By.xpath("//*[@id='newsletter']"));
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		if (element.isSelected())
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
	@SpiraTestCase(testCaseId = 9758)
	// 14-Checking the box of receviving special offers.
	public void SpecialOffersTest() {
		act.moveToElement(driver.findElement(By.xpath("//input[@name='optin']"))).click().build().perform();
		element = driver.findElement(By.xpath("//input[@name='optin']"));
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		if (element.isSelected())
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
	@Order(15) 
	@SpiraTestCase(testCaseId = 9762)
	// 15-Locate the address field.
	public void AddressTest() {
		element = driver.findElement(By.xpath("//*[@id='address1']"));
	    element.sendKeys("RMIT");
		expectedResult = element.getAttribute("value");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		actualResult = "RMIT";
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	@Order(16) 
	@SpiraTestCase(testCaseId = 9763)
	// 16-Locate the city field.
	public void CityTest() {
		element = driver.findElement(By.xpath("//*[@id='city']"));
	    element.sendKeys("Melbourne");
		expectedResult = element.getAttribute("value");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		actualResult = "Melbourne";
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	@Order(17) 
	@SpiraTestCase(testCaseId = 9764)
	// 17-Locate the small arrow and click then select the state from the dropdown list.
	public void StateTest() {
		driver.findElement(By.xpath("//*[@id='id_state']")).click();
		s = new Select(driver.findElement(By.id("id_state")));
		s.selectByValue("5");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		actualResult= "California";
		expectedResult = s.getFirstSelectedOption().getText();
		
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
	@Order(18) 
	@SpiraTestCase(testCaseId = 9765)
	// 18-Locate the postal code and insert the value.
	public void PostalTest() {
		element = driver.findElement(By.xpath("//*[@id='postcode']"));
	    element.sendKeys("12345"); 
		expectedResult = element.getAttribute("value");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		actualResult = "12345";
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	@Order(19) 
	@SpiraTestCase(testCaseId = 9766)
	// 19-Locate the small arrow and click then select the Country.
	public void CountryTest() {
		driver.findElement(By.xpath("//*[@id='id_country']")).click();
		s = new Select(driver.findElement(By.id("id_country")));
		s.selectByValue("21");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		actualResult= "United States";
		expectedResult = s.getFirstSelectedOption().getText();
	
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
	@Order(20) 
	@SpiraTestCase(testCaseId = 9768)
	// 20-Locate the Mobile phone field and insert the number.
	public void MobileTest() {
		element = driver.findElement(By.xpath("//*[@id='phone_mobile']")); 
		// There is a bug here Numbers can not be just one number
	    element.sendKeys("1"); 
		expectedResult = element.getAttribute("value");
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		actualResult = "1";
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	@Order(21) 
	@SpiraTestCase(testCaseId = 9769)
	// 21-Locate the address alias field  then delete the text that exist there and insert the address alias.
	public void AliasTest() {
		driver.findElement(By.xpath("//*[@id='alias']")).clear(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		element = driver.findElement(By.xpath("//*[@id='alias']"));
		element.sendKeys("CBD");
		expectedResult = element.getAttribute("value");
		actualResult = "CBD";
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	@Order(22) 
	@SpiraTestCase(testCaseId = 9920)
	// 21-Locate the address alias field  then delete the text that exist there and insert the address alias.
	public void RegisterTest() {

		driver.findElement(By.xpath("//*[text()='Register']")).click(); 
		// Waiting 5 seconds. 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		// Checking by the page title. 
		expectedResult = driver.getTitle();
		actualResult = "My account - My Store";
		assertEquals(expectedResult, actualResult);
		
	}
	
	
	
	
	@AfterAll
	// closing or quitting the browser after the test
	public static void closeBrowser() {
		driver.close();
		// driver.quit();
	}
}

