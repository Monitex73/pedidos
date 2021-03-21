package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IPrecioControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IPrecioDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Precio;

/**
*
* @author Jenny Luna
*/
@Stateless
public class PrecioControladorImpl implements IPrecioControlador {

	@EJB
	private IPrecioDao precioDao;
	
	@Override
	public void guardarPrecio(Precio p) {
		precioDao.guardarPrecio(p);
	}

	@Override
	public void actualizarPrecio(Precio p) {
		precioDao.actualizarPrecio(p);

	}

	@Override
	public List<Precio> obtenerPrecio() {
		return precioDao.obtenerPrecio();
	}

	@Override
	public Precio precioPorId(Integer idPrecio) {
		return precioDao.precioPorId(idPrecio);
	}

}
