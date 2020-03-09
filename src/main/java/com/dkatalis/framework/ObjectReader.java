package com.dkatalis.framework;

import java.io.File;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ObjectReader {
	
	public String getObjectLocator(String objectName,String locatorType){
		File fileObject = null;
		JsonParser jsonParser =null;
		JsonObject jsonObject = null;
		String jsonFilePath;
		String locator= null;
		jsonFilePath = System.getProperty("user.dir")+ Framework.prop.getProperty("JsonFilePath");
		fileObject =new File(jsonFilePath);
		try{
			FileReader reader =new FileReader(fileObject);
			jsonParser = new JsonParser();
			Object object = jsonParser.parse(reader);
			jsonObject = (JsonObject)object;
			JsonObject property =(JsonObject) jsonObject.get(objectName);
			if(locatorType.equalsIgnoreCase("xpath")){
				locator = property.get("XPATH").toString();				
			}else if(locatorType.equalsIgnoreCase("ID")){
				locator = property.get("ID").toString();	
			}else{
				locator = property.get("CLASSNAME").toString();
			}
		}catch(Exception exception){
			System.out.println("Function failed with Exception : "+ exception);		
		}
		return locator;
	}
	
}
