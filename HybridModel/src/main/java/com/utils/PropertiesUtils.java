package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.base.BaseClass;

public class PropertiesUtils extends BaseClass {
	
	public static FileInputStream fis;
	
	public static String readProperty(String key) throws Exception{
		log.info("reading property file for a key :- "+key);
		String path=System.getProperty("user.dir")+"/src/main/resources/config.properties";
		Properties prop=new Properties();
		try {
		fis=new FileInputStream(path);
		}
		catch(Exception e) {
			log.error("file is not available at givenocATION");
		}
		
		prop.load(fis);
		
		
		return prop.getProperty(key);
	}

} 
