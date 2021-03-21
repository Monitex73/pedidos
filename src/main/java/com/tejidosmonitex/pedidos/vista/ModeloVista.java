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

import com.tejidosmonitex.pedidos.controlador.IModeloControlador;
import com.tejidosmonitex.pedidos.modelo.entidades.Modelo;
import com.tejidosmonitex.pedidos.modelo.entidades.Rol;

@Named
@ViewScoped
@Stateful
public class ModeloVista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IModeloControlador modeloControlador;
	
	private List<Modelo> listaModelos;
	private String nombreModelo;
	
	@PostConstruct
	public void init() {
		listaModelos = modeloControlador.obtenerAllModelos();
	}

	public List<Modelo> getListaModelos() {
		return listaModelos;
	}

	public void setListaModelos(List<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}

	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}
	
	public void guardarModelo() {
		FacesContext context = FacesContext.getCurrentInstance();
		Modelo modelo = new Modelo();
		modelo.setNombre(nombreModelo);
		modelo.setEstado('A');
		modeloControlador.guardarModelo(modelo);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Modelo Registrado"));
		this.setNombreModelo(null);
		listaModelos = modeloControlador.obtenerAllModelos();
	}
	
	public void cambiarEstadoModelo(Modelo m) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (m.getEstado() == 'A') {
			m.setEstado('X');
		} else {
			m.setEstado('A');
		}

		modeloControlador.actualizarModelo(m);

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Modelo Actualizado"));
	}
	
	
	
}
