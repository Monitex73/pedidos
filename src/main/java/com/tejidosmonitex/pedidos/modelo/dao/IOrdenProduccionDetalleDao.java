package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproducciondetalle;

/**
*
* @author Jenny Luna
*/
@Local
public interface IOrdenProduccionDetalleDao {
	
	public void guardarProduccionDetalle(Ordenproducciondetalle op);
	public List<Ordenproducciondetalle> obtenerProduccionDetalle();
	public List<Ordenproducciondetalle> produccionDetallePorId(Integer idProduccion);
	public void actualizarProduccionDetalle(Ordenproducciondetalle op);
	
}
