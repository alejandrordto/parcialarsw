/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author AsusPC
 */
public class treahd implements Runnable {

    public treahd(String destinatario) {
        this.destinatario = destinatario;
    }
    
    
    String destinatario;
    @Override
    public void run() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException ex) {
            Logger.getLogger(treahd.class.getName()).log(Level.SEVERE, null, ex);
        }
        String remitente = "arswalejandro";  //Para la dirección nomcuenta@gmail.com

        Properties props = System.getProperties();

        props.put(
                "mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put(
                "mail.smtp.user", remitente);
        props.put(
                "mail.smtp.clave", "arsw2019");    //La clave de la cuenta
        props.put(
                "mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put(
                "mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put(
                "mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipients(Message.RecipientType.TO, destinatario);
            
            message.setSubject("Adicion de libro");
            message.setText("has añadido el libro satisfactoriamente");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, "arsw2019");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }

}
