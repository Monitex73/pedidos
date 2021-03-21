/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IRolControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IRolDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Rol;

/**
 *
 * @author Jenny Luna
 */
@Stateless
public class RolControlador implements IRolControlador {

	@EJB
	private IRolDao rolDao;

	@Override
	public Rol buscarRolPorNombre(String nombre) {
		return rolDao.buscarRolPorNombre(nombre);
	}

	@Override
	public List<Rol> obtenerRoles() {
		return rolDao.obtenerRoles();
	}

	@Override
	public void guardarRol(Rol r) {
		rolDao.guardarRol(r);
	}

	@Override
	public List<Rol> obtenerRolesInternos() {
		return rolDao.obtenerRolesInternos();
	}

	@Override
	public void actualizarRol(Rol r) {
		rolDao.actualizarRol(r);
	}

	@Override
	public List<Rol> obtenerAllRoles() {
		return rolDao.obtenerAllRoles();
	}

}
