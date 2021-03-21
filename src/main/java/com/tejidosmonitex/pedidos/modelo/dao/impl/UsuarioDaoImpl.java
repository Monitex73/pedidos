package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tejidosmonitex.pedidos.modelo.dao.IUsuarioDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;
import javax.persistence.Query;

@Stateless
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario> implements IUsuarioDao {

    @PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
    private EntityManager em;

    @Override
    public Usuario iniciarSesion(Usuario u) {

        Query q = em.createQuery("select u from Usuario u where u.correoelectronico = :usuario and u.contrasena = :contrasena");
        q.setParameter("usuario", u.getCorreoelectronico());
        q.setParameter("contrasena", u.getContrasena());

        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
            return (Usuario) q.getResultList().get(0);
        } else {
            return new Usuario();
        }

    }

    @Override
    public Usuario inciarSesion(String email, String clave) {
        Query q = em.createQuery("select u from Usuario u where u.correoelectronico = :usuario and u.contrasena = :contrasena and u.estado = :estado");
        q.setParameter("usuario", email);
        q.setParameter("contrasena", clave);
        q.setParameter("estado", 'A');

        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
            return (Usuario) q.getResultList().get(0);
        } else {
            return new Usuario();
        }
    }

    @Override
    public void guardarUsuario(Usuario u) {
        em.persist(u);
    }

	@Override
	public Usuario buscarUsuarioCorreo(String email) {
	       Query q = em.createQuery("select u from Usuario u where u.correoelectronico = :usuario and u.estado = :estado");
	        q.setParameter("usuario", email);
	        q.setParameter("estado", 'A');

	        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
	            return (Usuario) q.getResultList().get(0);
	        } else {
	            return new Usuario();
	        }
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
        Query q = em.createQuery("select u from Usuario u where u.estado = :estado");
        q.setParameter("estado", 'A');
        return q.getResultList();
	}

	@Override
	public List<Usuario> obtenerAllUsuarios() {
        Query q = em.createQuery("select u from Usuario u");
        return q.getResultList();
	}

	@Override
	public void actualizarUsuario(Usuario u) {
		em.merge(u);		
	}

	@Override
	public Usuario buscarUsuarioToken(String token) {
        Query q = em.createQuery("select u from Usuario u where u.contrasena = :token and u.estado = :estado");
        q.setParameter("token", token);
        q.setParameter("estado", 'X');

        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
            return (Usuario) q.getResultList().get(0);
        } else {
            return new Usuario();
        }
	}

}
