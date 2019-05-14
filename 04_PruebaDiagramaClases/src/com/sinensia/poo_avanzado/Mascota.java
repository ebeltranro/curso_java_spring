package com.sinensia.poo_avanzado;

public abstract class Mascota extends Animal {

    protected Cliente propietario;

    public Mascota(int patas, boolean aerobico, boolean acuatico, String nombre, float tamanho) {
    }

    public void pedirComida() {
    }

    public abstract void saludarPropietario();

    public Cliente getPropietario() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Cliente setPropietario(Cliente propietario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
