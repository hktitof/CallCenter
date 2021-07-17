package Mail;

import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.istack.internal.logging.Logger;
import com.sun.jmx.snmp.tasks.Task;
import com.sun.org.apache.xerces.internal.parsers.CachingParserPool.SynchronizedGrammarPool;

import FXML_Controlers.Controller_verfication_code;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;




public class JavaMail extends javafx.concurrent.Task<Integer>{
	public static boolean send=false;
	private String recepient;
	@Override
	public Integer call() throws Exception  {
		// TODO Auto-generated method stub
		send=false;
		sendMail();
		while(send==false) {
			
		}
		if(send) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	
	public JavaMail(String recepient) {
		this.recepient=recepient;
		
	}
	


	public Boolean sendMail() throws Exception {
			send=false;
	        System.out.println("Preparing to send email");
	        Properties properties = new Properties();

	        //Enable authentication
	        properties.put("mail.smtp.auth", "true");
	        //Set TLS encryption enabled
	        properties.put("mail.smtp.starttls.enable", "true");
	        //Set SMTP host
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        //Set smtp port
	        properties.put("mail.smtp.port", "587");
	        
	        properties.put("mail.smtp.ssl.trust", "*");
	        //Your gmail address
	        String myAccountEmail = "upm.anaflous.amrani@gmail.com";
	        //Your gmail password
	        String password = "@hotmail10";

	        //Create a session with account credentials
	        Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(myAccountEmail, password);
	            }
	        });

	        //Prepare email message
	        Message message = prepareMessage(session, myAccountEmail, recepient);

	        //Send mail
	        Transport.send(message);
	        System.out.println("Messaage is sent");
	       
	        System.out.println("the value of send is "+send);
	        send=true;
	        return send;
	    }

	    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(myAccountEmail));
	            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
	            message.setSubject("Hello guys");	
	            message.setContent(HTMLcode.code, "text/html");
	            return message;
	        } catch (Exception ex) {
	            Logger.getLogger(JavaMail.class.getName(), null).log(Level.SEVERE, null, ex);
	            
	        }
	        return null;
	    }


		


		

}
	
