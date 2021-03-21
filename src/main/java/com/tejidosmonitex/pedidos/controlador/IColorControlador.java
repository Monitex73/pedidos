package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Color;

@Local
public interface IColorControlador {

	public List<Color> obtenerColores();
	public List<Color> obtenerAllColores();
	public void guardarColor(Color c);
	public void actualizarColor(Color c);
	public Color obetnerColorPorNombre(String nombre);
	public Color obetnerColorPorId(Integer idColor);
}
