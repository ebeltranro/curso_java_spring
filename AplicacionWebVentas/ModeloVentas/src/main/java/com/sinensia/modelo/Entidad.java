/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.modelo;

/**
 *
 * @author Admin - Elena
 */
public class Entidad { //clase anidada, clase dentro de otra.

    protected Integer id; 

    public Entidad() {
    }

    public Entidad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
