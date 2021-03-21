/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;

/**
 *
 * @author Jenny Luna
 */

@Local
public interface IUsuarioControlador {
	public void guardarUsuario(Usuario u);

	public Usuario buscarUsuarioCorreo(String email);

	public List<Usuario> obtenerUsuarios();
	
	public List<Usuario> obtenerAllUsuarios();
	
	public void actualizarUsuario(Usuario u);
	
	public Usuario buscarUsuarioToken(String token);
}
