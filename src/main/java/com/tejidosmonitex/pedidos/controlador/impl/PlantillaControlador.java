package com.tejidosmonitex.pedidos.controlador.impl;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;

@Named
@ViewScoped
public class PlantillaControlador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void sesionUsuario() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogin");
	
			if(us.getIdusuario() != null) {
				System.out.println("Ingreso Correcto!");
			}else {
				context.getExternalContext().redirect("access-denied.xhtml");
			}
		}catch(Exception e){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error..."));
		}
		
	}

}
