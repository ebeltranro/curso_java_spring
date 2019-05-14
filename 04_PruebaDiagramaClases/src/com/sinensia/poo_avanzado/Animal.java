package com.sinensia.poo_avanzado;

public abstract class Animal {

    protected int patas;

    protected boolean aerobico;

    protected boolean acuatico;

    protected String nombre;

    protected float tamanho;

    public Animal(String nombre, float tamanho) {
    }

    public Animal(int patas, boolean aerobico, boolean acuatico, String nombre, float tamanho) {
    }

    public abstract void mover();

    public abstract void volar();

    public abstract void comer();

    public boolean isAnfibio() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getPatas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int setPatas(int patas) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isAerobico() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean setAerobico(boolean aerobico) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isAcuatico() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean setAcuatico(boolean acuatico) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String setNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float getTamanho() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float setTamanho(float tamanho) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Cliente setPropietario(Cliente yo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
