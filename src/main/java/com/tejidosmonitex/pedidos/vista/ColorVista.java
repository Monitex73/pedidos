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

import com.tejidosmonitex.pedidos.controlador.IColorControlador;
import com.tejidosmonitex.pedidos.modelo.entidades.Color;
import com.tejidosmonitex.pedidos.modelo.entidades.Modelo;

@Named
@ViewScoped
@Stateful
public class ColorVista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IColorControlador colorControlador;
	
	private List<Color> listaColores;
	private String nombreColor;
	
	@PostConstruct
	public void init() {
		listaColores = colorControlador.obtenerAllColores();
	}

	public List<Color> getListaColores() {
		return listaColores;
	}

	public void setListaColores(List<Color> listaColores) {
		this.listaColores = listaColores;
	}

	public String getNombreColor() {
		return nombreColor;
	}

	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}
	
	public void guardarColor() {
		FacesContext context = FacesContext.getCurrentInstance();
		Color color = new Color();
		color.setNombre(nombreColor.toUpperCase());
		color.setEstado('A');
		colorControlador.guardarColor(color);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Color Registrado"));
		this.setNombreColor(null);
		listaColores = colorControlador.obtenerAllColores();
	}
	
	public void cambiarEstadoColor(Color c) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (c.getEstado() == 'A') {
			c.setEstado('X');
		} else {
			c.setEstado('A');
		}

		colorControlador.actualizarColor(c);

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Color Actualizado"));
	}
	
}
