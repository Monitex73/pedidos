package com.tejidosmonitex.pedidos.controlador.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.ILoginControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IUsuarioDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;

@Stateless
public class LoginControladorImpl implements ILoginControlador {

    @EJB
    private IUsuarioDao usuarioDao;

    @Override
    public Usuario iniciarSesion(Usuario u) {
        return usuarioDao.iniciarSesion(u);
    }

    @Override
    public Usuario iniciarSesion(String email, String clave) {
        return usuarioDao.inciarSesion(email, clave);
    }

}
