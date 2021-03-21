package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproduccion;

/**
*
* @author Jenny Luna
*/
@Local
public interface IOrdenProduccionDao {
	
	public List<Ordenproduccion> obtenerOrdenesProduccion();
	public void guardarOrdenProduccion(Ordenproduccion OP);
	public void actualizarOrdenProduccion(Ordenproduccion OP);

}
