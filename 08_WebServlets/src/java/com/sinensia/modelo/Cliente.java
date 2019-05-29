/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.modelo;

import java.io.Serializable;

public class Cliente implements Serializable {

    public static final long serialVersionUID = 1L;
    public String nombre;
    public String email;
    public short edad;
    public short activo;
    public String password;
    //private List<Compra> compraList; //porque hemos puesto que los datos los guarde en Lista



    public Cliente(String nombre, String email, short edad, short activo, String password) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.activo = activo;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

   