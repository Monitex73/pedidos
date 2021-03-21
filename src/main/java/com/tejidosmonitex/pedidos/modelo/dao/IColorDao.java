package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Color;

/**
*
* @author Jenny Luna
*/
@Local
public interface IColorDao {
	
	public List<Color> obtenerColores();
	public List<Color> obtenerAllColores();
	public void guardarColor(Color c);
	public Color obetnerColorPorNombre(String nombre);
	public Color obetnerColorPorId(Integer idColor);
	public void actualizarColor(Color c);
	
}
