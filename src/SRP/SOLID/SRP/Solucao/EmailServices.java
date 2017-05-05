package SRP.SOLID.SRP.Solucao;

import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;

import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.smtp.*;


public class EmailServices {
    
	public static Boolean IsValid(String email){
		
		return email.contains("@");
		
	}

	public static void Enviar(String de, String para, String assunto, String mensagem) throws AddressException, MessagingException{
//     http://stackoverflow.com/questions/73580/how-do-i-send-an-smtp-message-from-java
		    Properties props = System.getProperties(); 
		    props.put("mail.smtps.host","smtp.gmail.com");
	        props.put("mail.smtps.auth","true");
	        Session session = Session.getInstance(props, null);
	        Message msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(para));;
	        msg.setRecipients(Message.RecipientType.TO,
	        InternetAddress.parse("tov.are.jacobsen@iss.no", false));
	        msg.setSubject("Heisann "+System.currentTimeMillis());
	        msg.setText(mensagem);
	        msg.setHeader("X-Mailer", "Tov Are's program");
	        msg.setSentDate(new Date());
	        SMTPTransport t =
	            (SMTPTransport)session.getTransport("smtps");
	        t.connect("smtp.gmail.com", de, "<insert password here>");
	        t.sendMessage(msg, msg.getAllRecipients());
	        System.out.println("Response: " + t.getLastServerResponse());
	        t.close();
		
		
		
	}
	
}
