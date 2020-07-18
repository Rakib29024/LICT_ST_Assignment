package page_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registration_page {
	WebDriver driver;
	public registration_page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//*[@id='logo']/h1/a") public WebElement home;
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a") public WebElement account_dd;
	@FindBy(css="#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a") public WebElement register_link;
	@FindBy(css="input[name=firstname]") public WebElement firstname;
	@FindBy(css="input[name=lastname]") public WebElement lastname;
	@FindBy(css="input[name=email]") public WebElement email;
	@FindBy(css="input[name=telephone]") public WebElement telephone;
	@FindBy(css="input[name=password]") public WebElement password;
	@FindBy(css="input[name=confirm]") public WebElement confirm;
	@FindBy(css="input[name=agree]") public WebElement agree;
	@FindBy(css="input[type=submit]") public WebElement submit;
	@FindBy(xpath="//*[@id='content']/h1") public WebElement status;
	@FindBy(xpath="//*[@id='account-register']/div[1]") public WebElement failed_status;
	@FindBy(xpath="//*[@id='content']/form/fieldset[2]/div[2]/div/div") public WebElement password_status;
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/ul/li[5]/a") public WebElement logout_link;
	
	
	@FindBy(xpath="//*[@id='account']/div[2]/div/div") public WebElement fname_error;
	@FindBy(xpath="//*[@id='account']/div[3]/div/div") public WebElement name_error;
	@FindBy(xpath="//*[@id='account']/div[4]/div/div") public WebElement email_error;
	@FindBy(xpath="//*[@id='account-register']/div[1]") public WebElement demail_error;
	@FindBy(xpath="//*[@id='account']/div[5]/div/div") public WebElement phone_error;
	@FindBy(xpath="//*[@id='content']/form/fieldset[2]/div[1]/div/div") public WebElement password_error;
	@FindBy(xpath="//*[@id='content']/form/fieldset[2]/div[2]/div/div") public WebElement matching_password_error;
	@FindBy(xpath="//*[@id='account-register']/div[1]") public WebElement privacy_error;
	
	
	public void home(){
		home.click();
	}
	public void click_account_dd_btn(){
		account_dd.click();
	}
	public void click_register_link_btn(){
		register_link.click();
	}
	public void click_logout_btn(){
		logout_link.click();
	}
//	form
	public void firstname(String value){
		firstname.sendKeys(value);
	}
	public void lastname(String value){
		lastname.sendKeys(value);
	}
	public void email(String value){
		email.sendKeys(value);
	}
	public void telephone(String value){
		telephone.sendKeys(value);
	}
	public void password(String value){
		password.sendKeys(value);
	}
	public void confirm(String value){
		confirm.sendKeys(value);
	}
	public void agree(){
		agree.click();
	}
	public void submit(){
		submit.click();
	}
	
	public String registration_status(){
		return status.getText();
	}
	
	public String fname_status(){
		return fname_error.getText();
	}
	
	public String name_status(){
		return name_error.getText();
	}
	
	public String email_error_status(){
		return email_error.getText();
	}
	
	public String demail_error_status(){
		return demail_error.getText();
	}
	
	public String phone_error_status(){
		return phone_error.getText();
	}
	
	public String password_error_status(){
		return password_error.getText();
	}
	
	public String matching_password_error_status(){
		return matching_password_error.getText();
	}
	
	public String privacy_error_status(){
		return privacy_error.getText();
	}
//	public void password_status(){
//		if(password_status.getText().contentEquals("Password confirmation does not match password!")){
//			System.out.println("Account Createation Failed due to :"+password_status.getText());
//		}
//	}

}
