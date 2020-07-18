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
	public String url;
	public String name;
	public String fname;
	public String email;
	public String phone;
	public String password;
	public String product;
	public boolean agree;
	data_access test_data;

	@BeforeTest
	public void before(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		test_data=new data_access();
		url=test_data.property.getProperty("url");
		product=test_data.property.getProperty("product");
		name=test_data.property.getProperty("name");
		fname=test_data.property.getProperty("fname");
		email=test_data.property.getProperty("email");
		phone=test_data.property.getProperty("phone");
		password=test_data.property.getProperty("password");
		
	}
	
	
	@Test(priority=1)
	public void varify_registration_no_firstname_test() throws InterruptedException{
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,"",name,email,phone,password,password,true);
		
		registration_page register=new registration_page(driver);
		Assert.assertEquals(register.fname_status(), "First Name must be between 1 and 32 characters!");
		
	}
	
	@Test(priority=2)
	public void varify_registration_no_lastname_test() throws InterruptedException{
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,fname,"",email,phone,password,password,true);
		
		registration_page register=new registration_page(driver);
		Assert.assertEquals(register.name_status(), "Last Name must be between 1 and 32 characters!");
		
	}
	
	@Test(priority=3)
	public void varify_registration_no_email_test() throws InterruptedException{
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,fname,name,"",phone,password,password,true);
		
		registration_page register=new registration_page(driver);
		Assert.assertEquals(register.email_error_status(), "E-Mail Address does not appear to be valid!");
		
	}
	
	
	@Test(priority=4)
	public void varify_registration_no_phone_test() throws InterruptedException{
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,fname,name,email,"",password,password,true);
		
		registration_page register=new registration_page(driver);
		Assert.assertEquals(register.phone_error_status(), "Telephone must be between 3 and 32 characters!");
		
	}
	
	@Test(priority=5)
	public void varify_registration_no_password_test() throws InterruptedException{
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,fname,name,email,phone,"",password,true);
		
		registration_page register=new registration_page(driver);
		Assert.assertEquals(register.password_error_status(), "Password must be between 4 and 20 characters!");
		
	}
	
	@Test(priority=6)
	public void varify_registration_no_matching_password_test() throws InterruptedException{
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,fname,name,email,phone,password,"000000",true);
		
		registration_page register=new registration_page(driver);
		Assert.assertEquals(register.matching_password_error_status(), "Password confirmation does not match password!");
		
	}
	
	@Test(priority=7)
	public void varify_registration_no_privacy_check_test() throws InterruptedException{
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,fname,name,email,phone,password,"000000",false);
		
		registration_page register=new registration_page(driver);
		Assert.assertEquals(register.privacy_error_status(),  "Warning: You must agree to the Privacy Policy!");
		
	}
	
	@Test(priority=8)
	public void varify_registration_duplicate_email_test() throws InterruptedException{
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		
		register_fun(driver,fname,name,"unknown101010@hotmail.com",phone,password,password,true);
		
		registration_page register=new registration_page(driver);
		Assert.assertEquals(register.demail_error_status(), "Warning: E-Mail Address is already registered!");
		
	}
	

	@Test(priority=9)
	public void varify_registration_pos_test() throws InterruptedException{
		System.out.println(url);
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
		
		register_fun(driver,fname,name,email,phone,password,password,true);
		
		registration_page register=new registration_page(driver);
		Assert.assertEquals(register.registration_status(), "Your Account Has Been Created!");
		
		time(1);
		register.click_account_dd_btn();
		time(1);
		register.click_logout_btn();
		time(1);
		
//		driver.quit();
		
	}
	
	@Test(priority=10)
	public void login_test() throws InterruptedException{
		System.out.println(url);
		driver.get(url);
		System.out.println("Link Opened");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login-Test-started");
		
//		email=test_data.property.getProperty("email");
//		password=test_data.property.getProperty("password");
		login(driver,email,password);
		
//		driver.quit();
	}
	
	@Test(priority=11)
	public void varify_product_search_test() throws InterruptedException{
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Search-Test-started");

		Search home=new Search(driver);
		Thread.sleep(3000);
		home.type_search_value(product);
		Thread.sleep(3000);
		home.click_search_btn();
		boolean product_status=home.product_status();
		Assert.assertEquals(product_status, true);
	}
	
	@Test(priority=12)
	public void varify_product_view_test() throws InterruptedException{
		
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Search-Test-started");

		Search home=new Search(driver);
		Thread.sleep(3000);
		home.type_search_value(product);
		Thread.sleep(3000);
		home.click_search_btn();

		home.click_product_detail_link();
		
		String view_status=home.view_status();
		Assert.assertEquals(view_status, product);
	}
	
	
	@Test(priority=13)
	public void varify_search_to_wishlist_test() throws InterruptedException{
		

		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Search-Test-started");

		Search home=new Search(driver);
		Thread.sleep(3000);
		home.type_search_value(product);
		Thread.sleep(3000);
		home.click_search_btn();

		home.click_product_detail_link();
		home.click_wish_btn();
		String wish_status=home.wish_status();
		
//		boolean login_status=home.login_status();
//		if(login_status){
//			email=test_data.property.getProperty("email");
//			password=test_data.property.getProperty("password");
//			login(driver,email,password);
//		}
		Assert.assertEquals(wish_status, product);
//		String email="datatest"+RandomStringUtils.randomAlphanumeric(5)+"@gamil.com";
//		driver.quit();
	}
	
	@Test(priority=14)
	public void varify_search_to_add_to_cart_test() throws InterruptedException{
		

		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Search-Test-started");

		Search home=new Search(driver);
		Thread.sleep(3000);
		home.type_search_value(product);
		Thread.sleep(3000);
		home.click_search_btn();

		home.click_product_detail_link();
		
		home.click_add_to_cart_btn();
		String add_status=home.add_status();
		
		Assert.assertEquals(add_status, "product");
	}
	

//	
//	@Test
//	public void varify_registration_neg_password_test() throws InterruptedException{
//		driver.get(url);
//		System.out.println("Link Opened");
//		driver.manage().window().maximize();
//		System.out.println("Max Window Size");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		System.out.println("Registeration-Test-started");
//		
//		
//		register_fun(driver,"Unkown1","unknown12345678@hotmail.com","12345","123467");
//		driver.quit();
//		
//	}
	
//	@Test
//	public void file_upload_test() throws InterruptedException{
//		System.out.println("Test-Started");
//		driver.get("https://www.file.io/");
//		System.out.println("Link Opened");
//		driver.manage().window().maximize();
//		System.out.println("Max Window Size");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		System.out.println("Upload-Test-started");
//		
//		file_upload_page upload=new file_upload_page(driver);
//		Thread.sleep(3000);
//		upload.file_input("C:/Users/TuRniNG/Downloads/02700b81fd8d18f6c93a6a1dd7ee3b01.jpg");
//		Thread.sleep(3000);
//		upload.upload_status();
//	}
//	
//	@Test
//	public void drop_down_test() throws InterruptedException{
//		System.out.println("Test-Started");
//		driver.get("https://www.mediacollege.com/internet/samples/html/country-list.html");
//		System.out.println("Link Opened");
//		driver.manage().window().maximize();
//		System.out.println("Max Window Size");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		System.out.println("Search-Test-started");
//		
//		drop_down_page dd=new drop_down_page(driver);
//		Thread.sleep(3000);
//		dd.dd_input("BD");
//		Thread.sleep(3000);
//		dd.select();
//		Thread.sleep(3000);
//		dd.submit();
//	}
//	
	
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
	
	public static void login(WebDriver driver,String email,String password) throws InterruptedException{
		login_page login=new login_page(driver);
		Thread.sleep(3000);
		login.click_account_dd_btn();
		Thread.sleep(3000);
		login.click_login_btn();
		Thread.sleep(3000);
		login.input_email(email);
		Thread.sleep(3000);
		login.input_password(password);
		Thread.sleep(3000);
		login.click_submit_btn();
		Thread.sleep(3000);
		String login_status=login.login_status();
		Assert.assertEquals(login_status, "My Account");
	}
	
	public static void register_fun(WebDriver driver,String fname,String name,String email,String phone,String password,String confirm, boolean agree) throws InterruptedException{
		

		registration_page register=new registration_page(driver);
		

		time(1);
		register.click_account_dd_btn();
		time(1);
		register.click_register_link_btn();
		time(1);
		register.firstname(fname);
		time(1);
		register.lastname(name);
		time(1);
		register.email(email);
		time(1);
		register.telephone(phone);
		time(1);
		register.password(password);
		time(1);
		register.confirm(confirm);
		time(1);
		if(agree){
			register.agree();
			time(1);
		}
		register.submit();
		time(1);

		
	}
}


