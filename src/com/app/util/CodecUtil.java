package com.app.util;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class CodecUtil {
	
	public String doEncode(String originalString)
	     {
	/*
	* Base64 class is used to encode and to decode the String.
	* The method encodeBase64(byte[] data) is used to encode the data. To this
	method we must pass binary(byte) data.
	*/
	  byte[] encoded= Base64.encodeBase64(originalString. getBytes());
	/*
	* here encoded data in byte[] is again converted to String , because to store this
	encoded data in Database.
	*/
	        return new String(encoded);
	      }
	
	public String doDecode(String encodedString)
	     {
	  byte[] decoded=Base64.decodeBase64(encodedString);
	    return new String(decoded);
	     }
	}

