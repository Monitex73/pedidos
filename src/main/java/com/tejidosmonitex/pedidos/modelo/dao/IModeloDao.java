package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Modelo;

/**
*
* @author Jenny Luna
*/
@Local
public interface IModeloDao {

	public List<Modelo> obtenerModelos();
	public List<Modelo> obtenerAllModelos();
	public void guardarModelo(Modelo m);
	public Modelo buscarModeloPorNombre(String nombreModelo);	
	public void actualizarModelo (Modelo m);
	
}
