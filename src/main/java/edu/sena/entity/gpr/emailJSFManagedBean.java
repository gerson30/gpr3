/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.gpr;

import java.util.Properties;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Gerson Jimenez
 */
@Named(value = "emailJSFManagedBean")
@RequestScoped
public class emailJSFManagedBean {

    private String to;
    private String from;
    private String subject;
    private String descr;
    private String username;
    private String password;
    private String smtp;
    private int port;

    public emailJSFManagedBean() {
        this.to = null;
        this.from = null;
        this.subject = null;
        this.descr = null;
        this.username = "gersonjimenez84@gmail.com";
        this.password = "Sistemas2023";
        this.smtp = "smtp.gmail.com";
        this.port = 587; //25 puerto 587 para que habilite el correo Gmail
        this.descr = "Escriba algo";
    }

    /*  Implementar el método ValidateEmail, el cual recibe tres parámetros y se
    encarga Comprobar si el valor es null o vacío. si el valor es null o vacío, el
    método establece la propiedad válida del componente false y establece el
    mensaje de error de E-mail que se requiere.
    En el caso que no sea null o vacio, el método comprueba si los caracteres
    “@”y el punto (.) están contenidos en el valor. En el caso que no estén
    incluido, el método establece la propiedad válida del componente “false” y
    establece el mensaje de error de “E-mail no es válido”.*/
    public void validateEmail(FacesContext context, UIComponent toValidate, Object value) {
        String message = "";
        String email = (String) value;
        if ((email == null) || (email.equals(""))) {
            ((UIInput) toValidate).setValid(false);
            message = "Correo Requerido";
            context.addMessage(toValidate.getClientId(context), new FacesMessage(message));
        } else if ((!email.contains("@")) || (!email.contains("."))) {
            ((UIInput) toValidate).setValid(false);
            message = "Email invalido";
            context.addMessage(toValidate.getClientId(context), new FacesMessage(message));
        }

    }

    /* Implementar el método submitEmail
        El cual se encargar de enviar un email usando JavaMail, primero se inicia una instancia de la
    session email con la clase Session, la sesión email es el punto inicial para la API JavaMail, Se utiliza
    la clase java.util.properties para obtener información, como por ejemplo el servidor de
    correoelectrónico, el usuario y la contraseña, que puede ser compartido en todo el resto de la
    aplicación*/
    public String submitEmail() throws MessagingException {
        Properties props = null;
        Session session = null;
        MimeMessage message = null;
        Address fromAddress = null;
        Address toAddress = null;

        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtp);
        props.put("mail.smtp.port", port);

        session = Session.getInstance(props, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        message = new MimeMessage(session);
        try {
            message.setContent(getDescr(), "text/plain");
            message.setSubject(getSubject());
            fromAddress = new InternetAddress(getFrom());
            message.setFrom(fromAddress);
            //envío masivo
            String correo=getTo();
            String[] correos_destinos = correo.split(";");
            
            //se declara una variable receptores
            Address[] receptores = new Address[correos_destinos.length];
            //con la expresion receptores uqedan almacenados los correos que pongamos. ahora debemos recorrer ee arreglo con un ciclo
            int j=0;
            while(j<correos_destinos.length){
                receptores[j]=new InternetAddress(correos_destinos[j]);
                j++;
            }
            
            //toAddress = new InternetAddress(getTo());
            
            //Cuando se envia a un solo correo es... llamando la variable toAddress
           // message.setRecipient(Message.RecipientType.TO, toAddress);
            //Cuando se envia a un solo correo es... llamando la variable receptores
            message.setRecipients(Message.RecipientType.TO, receptores);
            message.saveChanges();

            Transport transport = session.getTransport("smtp");
            transport.connect(this.smtp, this.port, this.username, this.password);
            if (!transport.isConnected()) {
                return "EmailFal";
            }
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException me) {
            return "EmailFal";
        }
        return "emailOk";

    }

//se llama gett and setter de las variables creadas
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
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

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;

    }

}
