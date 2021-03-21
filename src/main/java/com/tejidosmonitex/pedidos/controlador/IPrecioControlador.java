package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Precio;

/**
*
* @author Jenny Luna
*/

@Local
public interface IPrecioControlador {

	public void guardarPrecio(Precio p);
	public void actualizarPrecio(Precio p);
	public List<Precio> obtenerPrecio();
	public Precio precioPorId(Integer idPrecio);
	
}
