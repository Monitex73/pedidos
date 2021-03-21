package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IMenuControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IMenuDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Menu;

@Stateless
public class MenuControladorImpl implements IMenuControlador {

	@EJB
	private IMenuDao menuDao;
	
	
	@Override
	public List<Menu> obtenerMenus() {
		return menuDao.obtenerMenus();
	}

	@Override
	public void guardarMenu(Menu m) {
		menuDao.guardarMenu(m);
	}

}
