package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IProductoSolicitadoControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IProductoSolicitadoDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Productosolicitado;

/**
*
* @author Jenny Luna
*/

@Stateless
public class ProductoSolicitadoControladorImpl implements IProductoSolicitadoControlador {

	@EJB
	private IProductoSolicitadoDao productoSolicitadoDao;
	
	
	@Override
	public List<Productosolicitado> obtenerProductosSolicitados() {
		return productoSolicitadoDao.obtenerProductosSolicitados();
	}

	@Override
	public void guardarProductoSolicitado(Productosolicitado ps) {
		productoSolicitadoDao.guardarProductoSolicitado(ps);

	}

	@Override
	public List<Productosolicitado> obtenerProductosSolicitadosPorUsuario(Integer idUsuario) {
		return productoSolicitadoDao.obtenerProductosSolicitadosPorUsuario(idUsuario);
	}

	@Override
	public void actualizarProductoSolicitado(Productosolicitado ps) {
		productoSolicitadoDao.actualizarProductoSolicitado(ps);
	}

}
