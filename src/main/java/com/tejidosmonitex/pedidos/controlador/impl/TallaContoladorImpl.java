package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.ITallaControlador;
import com.tejidosmonitex.pedidos.modelo.dao.ITallaDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Talla;

@Stateless
public class TallaContoladorImpl implements ITallaControlador {

	@EJB
	private ITallaDao tallaDao;
	
	@Override
	public List<Talla> obtenerTallas() {
		return tallaDao.obtenerTallas();
	}

	@Override
	public void guardarTalla(Talla T) {
		tallaDao.guardarTalla(T);
	}

	@Override
	public Talla buscarTallaPorNombre(String nombreTalla) {
		return tallaDao.buscarTallaPorNombre(nombreTalla);
	}

	@Override
	public List<Talla> obtenerAllTallas() {
		return tallaDao.obtenerAllTallas();
	}

	@Override
	public void actualizarTalla(Talla t) {
		tallaDao.actualizarTalla(t);
	}

}
