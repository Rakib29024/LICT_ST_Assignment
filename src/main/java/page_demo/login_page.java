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
	
	public void click_account_dd_btn(){
		account_dd.click();
	}
}
