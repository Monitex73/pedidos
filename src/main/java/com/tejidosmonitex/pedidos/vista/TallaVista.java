package com.tejidosmonitex.pedidos.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.tejidosmonitex.pedidos.controlador.ITallaControlador;
import com.tejidosmonitex.pedidos.modelo.entidades.Modelo;
import com.tejidosmonitex.pedidos.modelo.entidades.Talla;

@Named
@ViewScoped
@Stateful
public class TallaVista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ITallaControlador tallaControlador;
	
	private List<Talla> listaTallas;
	private String nombreTalla;
	private String descripcionTalla;
	
	@PostConstruct
	public void init() {
		listaTallas = tallaControlador.obtenerAllTallas();
	}

	public String getDescripcionTalla() {
		return descripcionTalla;
	}

	public void setDescripcionTalla(String descripcionTalla) {
		this.descripcionTalla = descripcionTalla;
	}

	public List<Talla> getListaTallas() {
		return listaTallas;
	}

	public void setListaTallas(List<Talla> listaTallas) {
		this.listaTallas = listaTallas;
	}

	public String getNombreTalla() {
		return nombreTalla;
	}

	public void setNombreTalla(String nombreTalla) {
		this.nombreTalla = nombreTalla;
	}
	
	public void guardarTalla() {
		FacesContext context = FacesContext.getCurrentInstance();
		Talla talla = new Talla();
		talla.setNombre(nombreTalla);
		talla.setDescripcion(descripcionTalla);
		talla.setEstado('A');
		tallaControlador.guardarTalla(talla);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Talla Registrada"));
		this.setNombreTalla(null);
		this.setDescripcionTalla(null);
		listaTallas = tallaControlador.obtenerAllTallas();
	}
	
	public void cambiarEstadoTalla(Talla t) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (t.getEstado() == 'A') {
			t.setEstado('X');
		} else {
			t.setEstado('A');
		}

		tallaControlador.actualizarTalla(t);

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Talla Actualizada"));
	}
	
	
}
