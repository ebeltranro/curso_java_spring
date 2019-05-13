/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia;

/**
 *
 * @author Admin - Elena
 */
public class Producto extends Entidad{

    //private long id; lo coge de Entidad
    private String nombre;
    private int stock;
    private double precio;

    public Producto(long id, String nombre, int stock, double precio) {
        super(id);
        //this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    /*public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/ //los quitamos porque los hereda de Entidad

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    


    
}
