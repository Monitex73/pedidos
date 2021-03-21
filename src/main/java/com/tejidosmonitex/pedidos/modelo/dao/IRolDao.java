/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.modelo.dao;

import com.tejidosmonitex.pedidos.modelo.entidades.Rol;

import java.util.List;

import javax.ejb.Local;

/**
 *
 * @author Jenny Luna
 */
@Local
public interface IRolDao {
    
    public Rol buscarRolPorNombre(String nombre);
    
    public List<Rol> obtenerRoles();
    
    public List<Rol> obtenerAllRoles();
    
    public List<Rol> obtenerRolesInternos();
    
    public void guardarRol (Rol r);
    
    public void actualizarRol (Rol r);
    
}
