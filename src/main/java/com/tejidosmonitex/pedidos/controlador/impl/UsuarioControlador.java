/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IUsuarioControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IUsuarioDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;


/**
 *
 * @author Jenny Luna
 */

@Stateless
public class UsuarioControlador implements IUsuarioControlador{

    @EJB
	private IUsuarioDao usuarioDao;
    
    @Override
    public void guardarUsuario(Usuario u) {
       usuarioDao.guardarUsuario(u);
    }

	@Override
	public Usuario buscarUsuarioCorreo(String email) {
		return usuarioDao.buscarUsuarioCorreo(email);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return usuarioDao.obtenerUsuarios();
	}

	@Override
	public List<Usuario> obtenerAllUsuarios() {
		return usuarioDao.obtenerAllUsuarios();
	}

	@Override
	public void actualizarUsuario(Usuario u) {
		usuarioDao.actualizarUsuario(u);
	}

	@Override
	public Usuario buscarUsuarioToken(String token) {
		return usuarioDao.buscarUsuarioToken(token);
	}
    
    
}
