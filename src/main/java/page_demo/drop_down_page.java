package page_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class drop_down_page {
	
	WebDriver driver;
	public drop_down_page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//*[@id='content']/p[2]/select") public WebElement file_input;
	@FindBy() public WebElement submit;
	
	public void dd_input(String value){
		try {
			Select select=new Select(file_input);
			select.selectByValue(value);
			System.out.println(value +" Selection Successful");
		} catch (Exception e) {
			System.out.println("Error has been occured during selection from DD due to:"+e);		}
		
	}
	
	public void select(){
		
	}
	
	public void submit(){
		
	}
		
	

}
