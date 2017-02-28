package com.app.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CodeUtil {
	
	private String getCommonStr(int size){
		return UUID.randomUUID()
				.toString()
				.replace("-", "")
				.substring(0,size);
	}
	public String  getPwd(){
		return getCommonStr(6);
	}
	public String getToken(){
		return getCommonStr(8);
	}

}
