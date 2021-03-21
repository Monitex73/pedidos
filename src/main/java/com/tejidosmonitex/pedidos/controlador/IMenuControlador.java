package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Menu;

@Local
public interface IMenuControlador {
	
	public List<Menu> obtenerMenus();
	public void guardarMenu(Menu m);

}
