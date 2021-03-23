package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Productosolicitado;

/**
*
* @author Jenny Luna
*/

@Local
public interface IProductoSolicitadoControlador {

	public List<Productosolicitado> obtenerProductosSolicitados();
	public void guardarProductoSolicitado(Productosolicitado ps);
	public List<Productosolicitado> obtenerProductosSolicitadosPorUsuario(Integer idUsuario);
	public void actualizarProductoSolicitado(Productosolicitado ps);
	public Productosolicitado productoPorID(Integer idProducto);
	
}
