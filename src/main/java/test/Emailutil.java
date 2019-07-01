package test;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Emailutil {
    private String from;
    private String to;
    private String subject;
    private String info;
    private String username;
    private String password;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void send(){
        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol","smtp");
        Session session = Session.getDefaultInstance(prop);
        session.setDebug(true);
        Message message = new MimeMessage(session);
        try {
            message.setSubject(subject);
            message.setContent(info,"text/html;charset=utf-8");
            message.setFrom(new InternetAddress(from));
            Transport transport = session.getTransport();
            transport.connect(type,username,password);
            transport.sendMessage(message,new InternetAddress[]{new InternetAddress(to)});
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
