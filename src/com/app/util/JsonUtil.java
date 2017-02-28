package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {
	/**
	 * This Method is used to convert given json string
	 * to given class type object
	 * it uses JACKSON conversion  
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object convertJsonToObj(String json,Class cls){
		Object ob=null;
		try {
			ObjectMapper om=new ObjectMapper();
			 ob=om.readValue(json, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}
	/**
	 * This method is used to convert given object to
	 * json string using JACKSON
	 */
	public String convertObjToJson(Object ob){
		String json=null;
		try {
			ObjectMapper om=new ObjectMapper();
			json=om.writeValueAsString(ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}	
}
