package page_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
	protected WebDriver driver;
	
	public Search(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(xpath="//INPUT[@type='text']") public WebElement search_input;
	@FindBy(xpath="//*[@id='search']/span/button") public WebElement search_btn;
	
	public void type_search_value(String input_value){
		search_input.sendKeys(input_value);
	}
	
	public void click_search_btn(){
		search_btn.click();
	}

}
