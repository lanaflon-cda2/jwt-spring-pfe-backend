package org.isi.service;

import java.util.Properties;

import org.isi.entities.AppUser;
import org.isi.entities.BusinessCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	private JavaMailSender javaMailsender ;
	
	 @Autowired 
	
	public NotificationService(JavaMailSender javaMailsender) {
		 this.javaMailsender = javaMailsender;
		
	}
	
	 
	 public void sendNotification(BusinessCase businessCase ) {
		 //send email
		 SimpleMailMessage mail = new SimpleMailMessage();
		 mail.setTo("etudiant.elkefi.marouen@uvt.tn");
		 mail.setFrom("marouen.elkefi1981@gmail.com");
		 mail.setSubject("Bussiness Case "+businessCase.getCasenumber());
		 mail.setText("new Bussiness case "+businessCase.getCasenumber()
		 +"has been opned "+"          "+"with Status"+businessCase.getStatus()
		 +"          "+"this is the summary"+businessCase.getSummary()
				 
				 );
		 Properties props = new Properties();
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable", "true");
		 
		 
		 javaMailsender.send(mail); 
		 
	 }
	
	
	 public void sendNotificationDelete(BusinessCase businessCase ) {
		 //send email
		 SimpleMailMessage mail = new SimpleMailMessage();
		 mail.setTo("etudiant.elkefi.marouen@uvt.tn");
		 mail.setFrom("marouen.elkefi1981@gmail.com");
		 mail.setSubject("Bussiness Case "+businessCase.getCasenumber());
		 mail.setText(" Bussiness case "+businessCase.getCasenumber()
		 +"has been deleted "+"          "+"with Status"+businessCase.getStatus()
		 +"          "+"this is the summary"+businessCase.getSummary()
				 
				 );
		 Properties props = new Properties();
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable", "true");
		 
		 
		 javaMailsender.send(mail); 
		 
	 }

	 public void sendNotificationUpdate(BusinessCase businessCase ) {
		 //send email
		 SimpleMailMessage mail = new SimpleMailMessage();
		 mail.setTo("etudiant.elkefi.marouen@uvt.tn");
		 mail.setFrom("marouen.elkefi1981@gmail.com");
		 mail.setSubject("Bussiness Case "+businessCase.getCasenumber());
		 mail.setText(" Bussiness case "+businessCase.getCasenumber()
		 +"has been updated "+"          "+"with Status"+businessCase.getStatus()
		 +"          "+"this is the summary"+businessCase.getSummary()
				 
				 );
		 Properties props = new Properties();
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable", "true");
		 
		 
		 javaMailsender.send(mail); 
		 
	 }
	
	

}
