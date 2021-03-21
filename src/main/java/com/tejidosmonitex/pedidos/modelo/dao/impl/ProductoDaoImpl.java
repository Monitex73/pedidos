package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.primefaces.shaded.commons.io.IOUtils;

import com.tejidosmonitex.pedidos.modelo.dao.IProductoDao;
import com.tejidosmonitex.pedidos.modelo.dto.ProductoDto;
import com.tejidosmonitex.pedidos.modelo.entidades.Producto;
import com.tejidosmonitex.pedidos.modelo.entidades.Rol;

@Stateless
public class ProductoDaoImpl implements IProductoDao {

	@PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
	private EntityManager em;

	@Override
	public List<Producto> obtenerProductos() {
		Query q = em.createQuery("select p from Producto p where p.estado = :estado");
		q.setParameter("estado", 'A');
		return q.getResultList();
	}

	@Override
	public void guardarProducto(Producto p) {
		em.persist(p);
	}

	@Override
	public void actualizarProducto(Producto p) {
		em.merge(p);
	}

	@Override
	public List<Producto> obtenerAllProductos() {
		Query q = em.createQuery("select p from Producto p");
		return q.getResultList();
	}

	
	@Override
	public List<ProductoDto> productosDisponibles() {
		final StringBuilder sql = new StringBuilder();
		sql.append("select p.idproducto, p.nombre as Producto, m.nombre as Modelo, t.nombre as Talla, s.cantidad, pr.valor, p.estado, p.imagen ");
		sql.append("from producto p ");
		sql.append("inner join modelo m on p.idmodelo = m.idmodelo ");
		sql.append("inner join talla t on p.idtalla = t.idtalla ");
		sql.append("inner join stock s on p.idstock = s.idstock ");
		sql.append("inner join precio pr on p.idprecio = pr.idprecio ");
		sql.append("where pr.Estado = 'A' and s.Estado = 'A'");
		
		final Query q = em.createNativeQuery(sql.toString());
		final List<Object[]> listaObjeto = q.getResultList();
        List<ProductoDto> listaRespuesta = new ArrayList<>(0);
        for (Object[] object : listaObjeto) {
        	ProductoDto producto = new ProductoDto();
        	producto.setIdProducto((Integer) object[0]);
        	producto.setNombre(object[1].toString().trim());
            producto.setModelo(object[2].toString().trim());
            producto.setTalla(object[3].toString().trim());
            producto.setCantidad((Integer) object[4]);
            producto.setPrecio((Double) object[5]);
            producto.setEstado(object[6].toString().trim());
            producto.setImagen(object[7].toString().trim());
            listaRespuesta.add(producto);
        }
        return listaRespuesta;
		
	}

	@Override
	public Producto productoPorID(Integer idProducto) {
        Query q = em.createQuery("select p from Producto p where p.idproducto = :id");
        q.setParameter("id", idProducto) ;
        
        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
            return (Producto) q.getResultList().get(0);
        } else {
            return new Producto();
        } 
	}

	@Override
	public List<ProductoDto> productosActivos() {
		final StringBuilder sql = new StringBuilder();
		sql.append("select p.idproducto, p.nombre as Producto, m.nombre as Modelo, t.nombre as Talla, s.cantidad, pr.valor, p.estado, p.imagen ");
		sql.append("from producto p ");
		sql.append("inner join modelo m on p.idmodelo = m.idmodelo ");
		sql.append("inner join talla t on p.idtalla = t.idtalla ");
		sql.append("inner join stock s on p.idstock = s.idstock ");
		sql.append("inner join precio pr on p.idprecio = pr.idprecio ");
		sql.append("where pr.Estado = 'A' and s.Estado = 'A' and p.estado = 'A'");
		
		final Query q = em.createNativeQuery(sql.toString());
		final List<Object[]> listaObjeto = q.getResultList();
        List<ProductoDto> listaRespuesta = new ArrayList<>(0);
        for (Object[] object : listaObjeto) {
        	ProductoDto producto = new ProductoDto();
        	producto.setIdProducto((Integer) object[0]);
        	producto.setNombre(object[1].toString().trim());
            producto.setModelo(object[2].toString().trim());
            producto.setTalla(object[3].toString().trim());
            producto.setCantidad((Integer) object[4]);
            producto.setPrecio((Double) object[5]);
            producto.setEstado(object[6].toString().trim());
            producto.setImagen(object[7].toString().trim());
            listaRespuesta.add(producto);
        }
        return listaRespuesta;
	}

	@Override
	public void guardarImagen(InputStream inputStream, File file) {
		OutputStream output;
		try {
			output = new FileOutputStream(file);
			IOUtils.copy(inputStream, output);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
