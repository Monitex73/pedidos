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

import com.tejidosmonitex.pedidos.modelo.entidades.Rol;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;
import com.tejidosmonitex.pedidos.controlador.IRolControlador;
import com.tejidosmonitex.pedidos.controlador.IUsuarioControlador;

@Named
@ViewScoped
@Stateful
public class UsuarioVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IUsuarioControlador usuarioControlador;
	@EJB
	private IRolControlador rolControlador;

	private List<Usuario> listaUsuarios;
	private List<Usuario> listaUsuariosFiltrados;
	private List<Rol> listaRoles;

	private Usuario usr;

	private String nombreRol;
	private String clave;
	private String email;
	private String token="";
	
	private Boolean verActualizarUsuario = false;

	@PostConstruct
	public void init() {
		usr = new Usuario();
		listaUsuarios = usuarioControlador.obtenerAllUsuarios();
		listaRoles = rolControlador.obtenerRolesInternos();
	}

	public List<Usuario> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}

	public void setListaUsuariosFiltrados(List<Usuario> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Boolean getVerActualizarUsuario() {
		return verActualizarUsuario;
	}

	public void setVerActualizarUsuario(Boolean verActualizarUsuario) {
		this.verActualizarUsuario = verActualizarUsuario;
	}

	public void guardarUsuario() {
		Usuario us = new Usuario();
		Rol rol;
		FacesContext context = FacesContext.getCurrentInstance();
		rol = rolControlador.buscarRolPorNombre(nombreRol);

		usr.setIdrol(rol);
		usr.setEstado('A');

		usuarioControlador.guardarUsuario(usr);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario Registrado"));

		try {
			context.getExternalContext().redirect("./usuario.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cambiarEstadoUsuario(Usuario u) {

		FacesContext context = FacesContext.getCurrentInstance();
		if (u.getEstado() == 'A') {
			u.setEstado('X');
		} else {
			u.setEstado('A');
		}

		usuarioControlador.actualizarUsuario(u);

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario Actualizado"));
	}
	
	public void cambiarContrasena() {
		Usuario us;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(token.equals("")) {
			
			}else {
				us = usuarioControlador.buscarUsuarioToken(token);
				if(us != null) {
					us.setContrasena(clave);
					us.setEstado('A');
					usuarioControlador.actualizarUsuario(us);
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Contraseña Usuario Actualizada"));
					context.getExternalContext().redirect("./login.xhtml");
				}
			}

		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error..."));
		}
	}

	public void verActualizarUsuario(Usuario u) {
		this.setUsr(u);
		this.setVerActualizarUsuario(true);
	}
	
	public void actualizarUsuario() {
		FacesContext context = FacesContext.getCurrentInstance();
		usuarioControlador.actualizarUsuario(usr);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario Actualizado"));

	}
	
	public void datosCambioContraseña() {
		Usuario us;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(token.equals("")) {
			
			}else {
				us = usuarioControlador.buscarUsuarioToken(token);
				if(us != null) {
					email = us.getCorreoelectronico();
				}
			}

		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error..."));
		}
	}

}
