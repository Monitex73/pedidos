package com.tejidosmonitex.pedidos.controlador;


import javax.ejb.Local;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;

@Local
public interface ILoginControlador {
	
	public Usuario iniciarSesion (Usuario u);
    public Usuario iniciarSesion (String email, String clave);
        	
}
