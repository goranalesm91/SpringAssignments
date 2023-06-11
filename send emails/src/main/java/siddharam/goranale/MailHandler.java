package siddharam.goranale;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {
    void sendmail(){
         Properties sysProperties= System.getProperties();
        System.out.println(sysProperties);
        sysProperties.put("mail.smtp.host",MailMetaData.HostServer);
        sysProperties.put("mail.smtp.port",MailMetaData.port);
        sysProperties.put(MailMetaData.sslpropertuies,"true");
        sysProperties.put(MailMetaData.authpermission,"true");


        Authenticator mailAuth=new MailAuth();
        Session session=Session.getInstance(sysProperties,mailAuth);

        MimeMessage mailMessage=new MimeMessage(session);
        try {


            mailMessage.setFrom(MailMetaData.myUserEmail);
            mailMessage.setSubject("this is my first email");
            mailMessage.setText("this is my first email using to send java");
            Address receiverEmail = new InternetAddress(MailMetaData.receiverMail);
            mailMessage.setRecipients(Message.RecipientType.TO, String.valueOf(receiverEmail));
            Transport.send(mailMessage);
        }catch (Exception e){
        System.out.println("Error Occurd");
        }
    }
}
