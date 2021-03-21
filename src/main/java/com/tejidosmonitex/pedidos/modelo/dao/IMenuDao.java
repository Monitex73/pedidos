package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Menu;

/**
*
* @author Jenny Luna
*/
@Local
public interface IMenuDao {
	
	public List<Menu> obtenerMenus();
	public void guardarMenu(Menu m);
	
}
