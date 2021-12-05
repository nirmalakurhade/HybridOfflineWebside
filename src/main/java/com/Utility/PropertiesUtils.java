package com.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.BaseClass.Testbase;

public class PropertiesUtils extends Testbase{
	FileInputStream fi = null;
	Properties prop=null;
	public String ReadProperty(String key) {
		Properties  prop = new Properties();
		try {
			fi = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			  prop.load(fi);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		  
		System.out.println("property file found");
		return prop.getProperty(key);
		
	}
	
}
