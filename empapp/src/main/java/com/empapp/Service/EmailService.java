package com.empapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	public void sendEmail(String to, String sub, String message) {
		SimpleMailMessage smm= new SimpleMailMessage(); 
		smm.setTo(to);
		smm.setSubject(sub);
		smm.setText(message);
		javaMailSender.send(smm);
	}
}
