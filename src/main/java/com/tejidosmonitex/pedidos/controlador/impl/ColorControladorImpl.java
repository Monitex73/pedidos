package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IColorControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IColorDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Color;

@Stateless
public class ColorControladorImpl implements IColorControlador {

	@EJB
	private IColorDao colorDao;

	@Override
	public List<Color> obtenerColores() {
		return colorDao.obtenerColores();
	}

	@Override
	public void guardarColor(Color c) {
		colorDao.guardarColor(c);
	}

	@Override
	public Color obetnerColorPorNombre(String nombre) {
		return colorDao.obetnerColorPorNombre(nombre);
	}

	@Override
	public List<Color> obtenerAllColores() {
		return colorDao.obtenerAllColores();
	}

	@Override
	public void actualizarColor(Color c) {
		colorDao.actualizarColor(c);
	}

	@Override
	public Color obetnerColorPorId(Integer idColor) {
		return colorDao.obetnerColorPorId(idColor);
	}

}
