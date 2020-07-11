package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.google.j2objc.annotations.Property;

public class data_access {
	public Properties property=new Properties();
	File file=new File("test_data.propertise");
	
	public data_access(){
		try {
			FileInputStream input_file =new FileInputStream(file);
			try {
				property.load(input_file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
