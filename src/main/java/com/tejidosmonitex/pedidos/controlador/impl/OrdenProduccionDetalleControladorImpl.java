package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IOrdenProduccionDetalleControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IOrdenProduccionDetalleDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproducciondetalle;

@Stateless
public class OrdenProduccionDetalleControladorImpl implements IOrdenProduccionDetalleControlador {

	@EJB
	private IOrdenProduccionDetalleDao produccionDao;
	
	@Override
	public void guardarProduccionDetalle(Ordenproducciondetalle op) {
		produccionDao.guardarProduccionDetalle(op);
	}

	@Override
	public List<Ordenproducciondetalle> obtenerProduccionDetalle() {
			return produccionDao.obtenerProduccionDetalle();
	}

	@Override
	public List<Ordenproducciondetalle> produccionDetallePorId(Integer idProduccion) {
		return produccionDao.produccionDetallePorId(idProduccion);
	}

	@Override
	public void actualizarProduccionDetalle(Ordenproducciondetalle op) {
		produccionDao.actualizarProduccionDetalle(op);
	}

}
