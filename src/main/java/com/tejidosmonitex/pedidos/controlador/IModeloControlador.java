package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Modelo;

@Local
public interface IModeloControlador {
	public List<Modelo> obtenerModelos();
	public List<Modelo> obtenerAllModelos();
	public void guardarModelo(Modelo m);
	public Modelo buscarModeloPorNombre(String nombreModelo);
	public void actualizarModelo(Modelo m);
}
