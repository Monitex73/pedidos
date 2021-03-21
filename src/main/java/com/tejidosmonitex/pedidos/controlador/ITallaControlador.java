package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Talla;

@Local
public interface ITallaControlador {
	public List<Talla> obtenerTallas();
	public List<Talla> obtenerAllTallas();
	public void guardarTalla(Talla t);
	public void actualizarTalla(Talla t);
	public Talla buscarTallaPorNombre (String nombreTalla);
}
