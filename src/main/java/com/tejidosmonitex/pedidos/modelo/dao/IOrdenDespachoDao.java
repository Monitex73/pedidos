package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespacho;

/**
*
* @author Jenny Luna
*/
@Local
public interface IOrdenDespachoDao {
	
	public List<Ordendespacho> obtenerOrdenesDespacho();
	public void guardarOrdenDespacho(Ordendespacho OD);
	public void actualizarOrdenDespacho(Ordendespacho OD);

}
