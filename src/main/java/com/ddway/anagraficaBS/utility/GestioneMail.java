package com.ddway.anagraficaBS.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class GestioneMail {	
	
	private static final Logger log = LoggerFactory.getLogger(GestioneMail.class);	
	
	public static void sendEmail(String toAddress, String subject, String text) throws Exception{
		log.info("Inizio metodo GestioneMail.sendEmail!");
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties props;
		Properties filePprops;
		String presenza_password;
		String password;
		String server_host;
		String from_address;
		String port_server_host;		
		
		try{
			String path = System.getProperty("jboss.server.config.url");	    				  
		    String[] indirizzo = path.split("file:");			
//		   Leggo file di proprieta' esterno
		   filePprops = getFileProperties(indirizzo[1]+"properties/email.properties");
		   presenza_password = filePprops.getProperty("presenza_password");
		   password = filePprops.getProperty("password");
		   server_host = filePprops.getProperty("server_host");
		   port_server_host = filePprops.getProperty("port_server_host");
		   from_address = filePprops.getProperty("from_address");		   
		   
		   props = System.getProperties( );
		   props.put("mail.smtp.starttls.enable","true");
		   props.put("mail.smtp.auth",presenza_password.equalsIgnoreCase("SI") ? "true" : "false");	
		   
		   mailSender.setHost(server_host);
           mailSender.setPort(Integer.parseInt(port_server_host));           
           mailSender.setUsername(from_address);
           if(presenza_password.equalsIgnoreCase("SI"))
        	   mailSender.setPassword(password);             
           mailSender.setProtocol("smtp");		   
		   mailSender.setJavaMailProperties(props);	      	   

           MimeMessage msg = mailSender.createMimeMessage();
           msg.setFrom(new InternetAddress(from_address));
		   msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
		   msg.setSubject(subject);
		   msg.setText(text);		   
		   mailSender.send(msg);		   
		}catch(Exception e){
			log.error(e.getMessage()+" on GestioneMail.sendEmail!");
			throw e;
			}
		}	
	
	public static Properties getFileProperties(String path) throws Exception{
		log.debug("Start GestioneMail.getFileProperties method");
		
		Properties props = new Properties();
		
		try{
			File file = new File(path);
	        file.createNewFile();				
			props.load(new FileInputStream(file));
		}catch(Exception e){
			log.error("Exception invoked in method WebServiceCall.getFileProperties: "+e.toString());
			e.printStackTrace();
			throw e;
			}		
		return props;
		}
	}

