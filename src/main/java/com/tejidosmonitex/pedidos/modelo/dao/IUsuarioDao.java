package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;

@Local
public interface IUsuarioDao {

	public Usuario iniciarSesion(Usuario u);

	public Usuario inciarSesion(String email, String clave);

	public void guardarUsuario(Usuario u);
	
	public Usuario buscarUsuarioCorreo (String email);
	
	public List<Usuario> obtenerUsuarios();
	
	public List<Usuario> obtenerAllUsuarios();
	
	public void actualizarUsuario(Usuario u);
	
	public Usuario buscarUsuarioToken (String token);

}
