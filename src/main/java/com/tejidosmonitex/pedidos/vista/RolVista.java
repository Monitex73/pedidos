package com.tejidosmonitex.pedidos.vista;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.tejidosmonitex.pedidos.controlador.IRolControlador;
import com.tejidosmonitex.pedidos.modelo.entidades.Rol;

@Named
@ViewScoped
@Stateful
public class RolVista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
    private IRolControlador rolControlador;
	
	private List<Rol> listaRoles;
	private Rol rolNuevo = new Rol();
	private String nombreRol;
	
	@PostConstruct
	public void init() {
		listaRoles = rolControlador.obtenerAllRoles();
	}
	
	public Rol getRolNuevo() {
		return rolNuevo;
	}

	public void setRolNuevo(Rol rolNuevo) {
		this.rolNuevo = rolNuevo;
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}
	
	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public void guardarRol() {
		FacesContext context = FacesContext.getCurrentInstance();
		/*
		Rol rol = new Rol();
		rol.setNombre(nombreRol.toUpperCase());
		rol.setEstado('A');
		rolControlador.guardarRol(rol);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Rol Registrado"));
		this.setNombreRol("");
		this.init();
		*/

		rolNuevo.setEstado('A');
		rolControlador.guardarRol(rolNuevo);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Rol Registrado"));
		listaRoles = rolControlador.obtenerAllRoles();
		try {
			context.getExternalContext().redirect("./rol.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void limpiarCampos() {
		rolNuevo = null;
	}
	
	public void cambiarEstadoRol(Rol r) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (r.getEstado() == 'A') {
			r.setEstado('X');
		} else {
			r.setEstado('A');
		}

		rolControlador.actualizarRol(r);

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Rol Actualizado"));
	}
}
