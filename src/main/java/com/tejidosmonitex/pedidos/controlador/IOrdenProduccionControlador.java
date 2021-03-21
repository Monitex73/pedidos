package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproduccion;

@Local
public interface IOrdenProduccionControlador {

	public List<Ordenproduccion> obtenerOrdenesProduccion();
	public void guardarOrdenProduccion(Ordenproduccion OP);
	public void actualizarOrdenProduccion(Ordenproduccion OP);
	
}
