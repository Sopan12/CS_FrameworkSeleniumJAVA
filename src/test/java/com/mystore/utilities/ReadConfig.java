package com.mystore.utilities;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadConfig {
	
	Properties properties; //object creation
	
	String path = "C:\\Users\\Admin\\eclipse-workspace\\MyStoreV1\\Configuration\\config.properties";
	
	
	public ReadConfig()
	{
		try 
	{
		
			properties = new Properties();
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getBaseUrl()
	{
		String value = properties.getProperty("baseUrl");//properties file cha baseUrl
		
		if(value!=null)                //for showing runtime exception if file is not 
		      return value;       
		else                                 
			  throw new RuntimeException("url is not specified in config file");
	}
	
	
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser is not specified in config file");
	}
	
	
	public String getEmail()
	{
		String value = properties.getProperty("username");//properties file cha baseUrl
		
		if(value!=null)                //for showing runtime exception if file is not 
		      return value;       
		else                                 
			  throw new RuntimeException("url is not specified in config file");
	}
	
	public String getPassword()
	{
		String value = properties.getProperty("password");//properties file cha baseUrl
		
		if(value!=null)                //for showing runtime exception if file is not 
		      return value;       
		else                                 
			  throw new RuntimeException("url is not specified in config file");
	}
	

}
