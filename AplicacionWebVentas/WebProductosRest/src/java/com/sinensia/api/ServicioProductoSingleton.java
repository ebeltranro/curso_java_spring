package com.sinensia.api;

import java.util.ArrayList;

/*
 * Clase patrón Singleton, solo puede haber una instancia (objeto)
en toda la aplicación de este tipo de clase
 */
//la única instancia es privada
public class ServicioProductoSingleton {
    //una única variable estática y privada
    public ArrayList<Producto> listaProductos;
    
    public void insertar (Producto p){
        listaProductos.add(p);
    }
    
    public Producto modificar (Producto p){
        p.setNombre(p.getNombre() + " - Modificado");
        p.setPrecio(p.getPrecio() + " - Modificado");
        return p;
    }
    
    public ArrayList obtenerTodos() {
        //return (Producto[]) listaProductos.toArray(); //un cast para que los productos con forma objeto que salen del Array pasen a forma producto
        return listaProductos;
    }
    public void eliminar(int indice){
        listaProductos.remove(indice);
    }
    private static ServicioProductoSingleton instancia = null;

    //los singleton tienen constructores privados; nadie puede hacer new dentro de esta clase
    //puede ser protected
    private ServicioProductoSingleton() {
        //igual que poner super() --> constructor de Object
        this.listaProductos = new ArrayList<>();
    }
    //La primera vez que se llama al método, se crea la instancia
    //A partir de ese momento hasta que la aplicación termine,
    //la instancia seguirá viva y es devuelta por el método
    //venga de donde venga la llamada.
    //La instancia nunca es nula
    public static ServicioProductoSingleton getInstancia() {
        if (instancia == null)
            instancia = new ServicioProductoSingleton(); //igual al único objeto de la clase SercicioProductoSingleton. 
        return instancia;
    }

}
