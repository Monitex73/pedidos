package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproducciondetalle;

/**
*
* @author Jenny Luna
*/
@Local
public interface IOrdenProduccionDetalleControlador {

	public void guardarProduccionDetalle(Ordenproducciondetalle op);
	public List<Ordenproducciondetalle> obtenerProduccionDetalle();
	public List<Ordenproducciondetalle> produccionDetallePorId(Integer idProduccion);
	public void actualizarProduccionDetalle(Ordenproducciondetalle op);
	
}
