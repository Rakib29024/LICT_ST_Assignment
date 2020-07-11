package testng01.list_lestng;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bsh.Console;
import data.data_access;
import io.github.bonigarcia.wdm.WebDriverManager;
import page_demo.Search;
import page_demo.drop_down_page;
import page_demo.file_upload_page;
import page_demo.login_page;
import page_demo.registration_page;

public class apptest{
	
	public WebDriver driver;

	@BeforeTest
	public void before(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

	}
	
	@Test
	public void varify_search_test() throws InterruptedException{
		
		data_access test_data=new data_access();
		System.out.println(test_data.property.getProperty("url"));
		
		
//		driver.get("http://demo.opencart.com");
//		System.out.println("Link Opened");
//		driver.manage().window().maximize();
//		System.out.println("Max Window Size");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		System.out.println("Search-Test-started");
//		
//		Search home=new Search(driver);
//		Thread.sleep(3000);
//		home.type_search_value("iPhone");
//		Thread.sleep(3000);
//		home.click_search_btn();
		
		
//		Assert.assertEquals(actual, expected);
//		String email="datatest"+RandomStringUtils.randomAlphanumeric(5)+"@gamil.com";
	}
	
	@Test
	public void varify_registration_pos_test() throws InterruptedException{
		driver.get("http://demo.opencart.com");
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,"Unkown1","unknown1234567@hotmail.com","12345","12345");
		
	}
	
	@Test
	public void varify_registration_neg_email_test() throws InterruptedException{
		driver.get("http://demo.opencart.com");
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,"Unkown1","unknown1234567@hotmail.com","12345","12345");
		
	}
	
	@Test
	public void varify_registration_neg_password_test() throws InterruptedException{
		driver.get("http://demo.opencart.com");
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,"Unkown1","unknown12345678@hotmail.com","12345","123467");
		
	}
	
//	@Test
//	public void login_test() throws InterruptedException{
//		
//		login_page login=new login_page(driver);
//		Thread.sleep(3000);
//		login.click_account_dd_btn();
//		
//		
//
//	}

	@Test
	public void file_upload_test() throws InterruptedException{
		System.out.println("Test-Started");
		driver.get("https://www.file.io/");
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Upload-Test-started");
		
		file_upload_page upload=new file_upload_page(driver);
		Thread.sleep(3000);
		upload.file_input("C:/Users/TuRniNG/Downloads/02700b81fd8d18f6c93a6a1dd7ee3b01.jpg");
		Thread.sleep(3000);
		upload.upload_status();
	}
	
	@Test
	public void drop_down_test() throws InterruptedException{
		System.out.println("Test-Started");
		driver.get("https://www.mediacollege.com/internet/samples/html/country-list.html");
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Search-Test-started");
		
		drop_down_page dd=new drop_down_page(driver);
		Thread.sleep(3000);
		dd.dd_input("BD");
		Thread.sleep(3000);
		dd.select();
		Thread.sleep(3000);
		dd.submit();
	}
	
	
	@AfterTest
	public void after() throws InterruptedException{
		Thread.sleep(3000);
		System.out.println("Test-closed");
		driver.quit();
	}
	
	
	//functions
	public static void time(int t) throws InterruptedException{
		Thread.sleep(t*1000);
	}
	
	public static void register_fun(WebDriver driver,String name,String email,String password,String confirm) throws InterruptedException{
		
		registration_page register=new registration_page(driver);
		

		Thread.sleep(3000);
		register.click_account_dd_btn();
		Thread.sleep(3000);
		register.click_register_link_btn();
		Thread.sleep(3000);
		register.firstname("MR.");
		Thread.sleep(3000);
		register.lastname(name);
		Thread.sleep(3000);
		register.email(email);
		Thread.sleep(3000);
		register.telephone("01770000000");
		Thread.sleep(3000);
		register.password(password);
		Thread.sleep(3000);
		register.confirm(confirm);
		Thread.sleep(3000);
		register.agree();
		Thread.sleep(3000);
		register.submit();
		Thread.sleep(3000);
		register.status();
		register.password_status();
		
	}
}


