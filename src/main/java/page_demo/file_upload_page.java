package page_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class file_upload_page {
	WebDriver driver;
	public file_upload_page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//*[@id='fine-uploader']/div/div/input") public WebElement file_input;
	@FindBy(xpath="//*[@id='fine-uploader']/div/ul/li/div/strong") public WebElement upload_status;
	
	public void file_input(String value){
		file_input.sendKeys(value);
	}
	
	public void upload_status(){
		if(upload_status.getText().contentEquals("Upload success.")){
			System.out.println("File Upload success");
		}
		else{
			System.out.println("File Upload Failed");
		}
	}
}
