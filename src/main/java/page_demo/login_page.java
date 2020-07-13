package page_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {
	WebDriver driver;
	
	public login_page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a")
	public WebElement account_dd;
	
	@FindBy(css="#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a")
	public WebElement login_btn;
	
	@FindBy(id="input-email")
	public WebElement email;
	
	@FindBy(id="input-password")
	public WebElement password;
	
	@FindBy(xpath="//*[@id='content']/div/div[2]/div/form/input")
	public WebElement submit_btn;
	
	@FindBy(xpath="//*[@id='content']/h2[1]")
	public WebElement status;
	
	public void click_account_dd_btn(){
		account_dd.click();
	}
	
	public void click_login_btn(){
		login_btn.click();
	}
	
	public void input_email(String value){
		email.sendKeys(value);
	}
	
	public void input_password(String value){
		password.sendKeys(value);
	}
	
	public void click_submit_btn(){
		submit_btn.click();
	}
	
	public String login_status(){
		return status.getText();
	}
}
