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
	@FindBy(css="#content > div.row > div:nth-child(1) > div > div.image > a") public WebElement product_check;
	@FindBy(css="#content > div:nth-child(8) > div:nth-child(1) > div > div:nth-child(2) > div.caption > h4 > a") public WebElement product_detail_link;
	@FindBy(css="#content > div > div.col-sm-4 > div.btn-group > button:nth-child(1)") public WebElement wish_btn;
	@FindBy(xpath="//*[@id='product-product']/div[1]/a[1]") public WebElement login_status;
	@FindBy(xpath="//*[@id='content']/div[1]/div[2]/h1") public WebElement view_status;//
	@FindBy(xpath="//*[@id='product-product']/div[1]/a[1]") public WebElement wish_status;// Success: You have added 
	@FindBy(xpath="//*[@id='button-cart']") public WebElement add_to_cart_btn;
	@FindBy(xpath="//*[@id='product-product']/div[1]/a[1]") public WebElement add_status;
	
	
	public void type_search_value(String input_value){
		search_input.sendKeys(input_value);
	}
	
	public void click_search_btn(){
		search_btn.click();
	}
	
	public boolean product_status(){
		return product_check.isDisplayed();
	}
	
	public void click_product_detail_link(){
		product_detail_link.click();
	}
	
	public void click_wish_btn(){
		wish_btn.click();
	}
	
	public void click_add_to_cart_btn(){
		add_to_cart_btn.click();
	}
	
	public boolean login_status(){
		return login_status.isDisplayed();
	}
	
	public String view_status(){
		return view_status.getText();
	}
	
	public String add_status(){
		return add_status.getText();
	}
	
	public String wish_status(){
		return wish_status.getText();
	}

}
