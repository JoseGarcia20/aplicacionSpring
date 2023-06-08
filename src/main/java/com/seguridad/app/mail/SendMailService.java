package com.seguridad.app.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService 
{
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(String from, String to, String mensaje)
	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject("Solicitud Contactenos: Cliente Pagina Web");
		mailMessage.setText(mensaje);
		
		javaMailSender.send(mailMessage);
	}
}
