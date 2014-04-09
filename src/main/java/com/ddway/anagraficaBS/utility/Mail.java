package com.ddway.anagraficaBS.utility;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	
	private static String SERVER_HOST = "";
	
	private static String FROM_ADDRESS = "";
	
	private static String PASSWORD = "";
	
	public static void send(String toAddress, String subject, String text) throws UnsupportedEncodingException, MessagingException{
		 Properties props = System.getProperties( );
		  
			   //Impostazioni email server
			   props.put("mail.smtp.host", SERVER_HOST);
			   props.put("mail.smtp.auth","true");
			  
			   //Creo sessione
			   Session session = Session.getDefaultInstance(props);
			  
			   //Autenticazione	
			   session.setPasswordAuthentication(new URLName("smtp",SERVER_HOST,25,"INBOX","",""), new PasswordAuthentication(FROM_ADDRESS,PASSWORD));
			   MimeMessage msg = new MimeMessage(session);
			   msg.setFrom(new InternetAddress(FROM_ADDRESS));
			   msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
			   msg.setSubject(subject);
			   msg.setText(text);
				  
			   //invio il messaggio
			   Transport tr = session.getTransport("smtp");
			   tr.connect(SERVER_HOST, FROM_ADDRESS, PASSWORD);
			   tr.sendMessage(msg, msg.getAllRecipients());
			   tr.close();
	}

}
