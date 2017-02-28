package com.app.util;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class CommonUtil {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toAddr,String subject,String text,final CommonsMultipartFile file){
		try {
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			
			//construction of message
			helper.setSubject(subject);
			helper.setText(text);
			helper.setTo(toAddr);
			//helper.setCc(cc);
			//helper.setBcc(bcc);
			
			//if input files are available then add attachment
			if(file!=null){
				helper.addAttachment(file.getOriginalFilename(), new InputStreamSource() {
					
					@Override
					public InputStream getInputStream() throws IOException {
						return file.getInputStream();
					}
				});
			}
			
			//send email
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//overloaded method without attachement
	public void sendEmail(String toAddr,String subject,String text){
		sendEmail(toAddr, subject, text, null);
	}
		
}

