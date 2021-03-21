package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IModeloControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IModeloDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Modelo;

@Stateless
public class ModeloControladorImpl implements IModeloControlador {

	@EJB
	private IModeloDao modeloDao;
	
	@Override
	public List<Modelo> obtenerModelos() {
		return modeloDao.obtenerModelos();
	}

	@Override
	public void guardarModelo(Modelo m) {
		modeloDao.guardarModelo(m);
	}

	@Override
	public Modelo buscarModeloPorNombre(String nombreModelo) {
		return modeloDao.buscarModeloPorNombre(nombreModelo);
	}

	@Override
	public void actualizarModelo(Modelo m) {
		modeloDao.actualizarModelo(m);		
	}

	@Override
	public List<Modelo> obtenerAllModelos() {
		return modeloDao.obtenerAllModelos();
	}

}
