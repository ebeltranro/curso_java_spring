/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.dao;

import java.util.ArrayList;
import java.util.List;


/**
 * Interfaz Dara Access Object para toda la app
 * @author Admin
 * @param <T> 
 */

//creemos una interfaz genérica para que pueda ser usado por la entidad Cliente y la futura entidad Producto
public interface InterfazDAO<T> {
    
    void poner(T valor);
    T leerUno(long id);
    List<T> leerTodos();
    void eliminar(T valor);
    void eliminar (long id);
    T modificar(/*lond id,*/T nuevoValor); //como el id no se cambia, ya conociendo los datos del nuevo valor conocemos el id del cliente al que nos referimos
    
}
