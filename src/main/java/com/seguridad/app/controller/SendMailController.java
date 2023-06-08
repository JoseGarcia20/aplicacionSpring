package com.seguridad.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seguridad.app.mail.*;

@Controller

public class SendMailController 

	{
		@Autowired
		private SendMailService sendMailservice;
		
		@GetMapping(value="/mail")
		public String mail()
		{
			return "mail";
		}
		
		@PostMapping("/sendMail")
		public String sendMail(@RequestParam("nombre")String nombre, @RequestParam("apellido")String apellido, @RequestParam("telefono")String telefono, @RequestParam("correo")String correoReceptor, @RequestParam("mensaje")String mensaje)
		{	
			String correoRemitente = "jamesapp01.contact@gmail.com";
			String cuerpoCorreo = "Datos del Cliente:\n\n" + "Nombre: " + nombre + " " + apellido + "\nTelefono: " + telefono + "\nCorreo electronico: " + correoReceptor + "\n\nSolicitud:\n\n" + mensaje;
			try 
			{
				sendMailservice.sendMail(correoRemitente, correoReceptor, cuerpoCorreo);
			}catch (Exception ex)
			{
				ex.printStackTrace();
			}
			return "redirect:mail";
		}
	}

