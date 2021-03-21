package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Talla;

/**
*
* @author Jenny Luna
*/
@Local
public interface ITallaDao {
	
	public List<Talla> obtenerTallas();
	public List<Talla> obtenerAllTallas();
	public void guardarTalla(Talla t);
	public Talla buscarTallaPorNombre (String nombreTalla);
	public void actualizarTalla(Talla t);

}
