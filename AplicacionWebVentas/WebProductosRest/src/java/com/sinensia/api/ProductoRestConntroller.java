/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.api;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin - Elena
 */
//en lugar de crear un servlet, hemos creado una clase extendiendo a HttpServlet
//vamos a usar unas anotaciones para indicar que esto es un servlet (decoradores)
@WebServlet(asyncSupported = true, urlPatterns = "/api/productos") //indicamos que admite comunicación asíncrona 
//vamos a hacer algunas coass un poco diferentes para practicar
public class ProductoRestConntroller extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter escritorRespuesta = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");

        BufferedReader bufRead = request.getReader(); //para leer JSON; un buffer es una especie de memoria

        StringBuilder textoJson = new StringBuilder();

        for (String lineaJson = bufRead.readLine(); lineaJson != null; lineaJson = bufRead.readLine()) { //condición de finalización del bucle que sea nulo, 
            //el último elemento es el iterador, añadiendo líneas
            textoJson.append(lineaJson);
        }

        bufRead.close();

        //pasamos de JSON a java para modificar (a clase producto)
        Gson gson = new Gson();

        Producto producto = gson.fromJson(textoJson.toString(), Producto.class);

        //llamamos a un servicio que se encarga de hacer la transformación
        ServicioProductoSingleton sps = ServicioProductoSingleton.getInstancia(); //el unico objeto de esta clase
        sps.modificar(producto);

        /*producto.setNombre(producto.getNombre());
        producto.setPrecio("500 bolivares");*/
        //transformamos a formato JSON para enviar la respuesta
        String jsonRespuesta = gson.toJson(producto);

        escritorRespuesta.println(jsonRespuesta);

    }

    //vamos a hacer un método POST para insertar producto
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter escritorRespuesta = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");

        BufferedReader bufRead = request.getReader();

        StringBuilder textoJson = new StringBuilder();

        for (String lineaJson = bufRead.readLine(); lineaJson != null; lineaJson = bufRead.readLine()) {
            textoJson.append(lineaJson);
        }

        bufRead.close();
        Producto producto = null;

        Gson gson = new Gson();
        producto = gson.fromJson(textoJson.toString(), Producto.class);

        ServicioProductoSingleton sps = ServicioProductoSingleton.getInstancia();

        String mensaje = null;

        if (producto.getNombre() != null && producto.getPrecio() != null) {
            sps.insertar(producto);
            mensaje = "se ha insertado correctamente";
        } else {
            mensaje = "no se ha insertado correctamente";
        }

        String jsonRespuesta = gson.toJson(mensaje);
        escritorRespuesta.println(jsonRespuesta);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter escritorRespuesta = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");

        ArrayList<Producto> listaLeida = new ArrayList<Producto>();
        ServicioProductoSingleton sps = ServicioProductoSingleton.getInstancia();
        listaLeida = sps.obtenerTodos();

        //Producto productoLeido = listaLeida.get(0);
        //Producto productoLeido1 = listaLeida.get(1);
        Gson gson = new Gson();
        //System.out.println("brea");
        //System.out.println(productoLeido.getNombre() + productoLeido1.getNombre());

        String jsonRespuesta = gson.toJson(listaLeida);
        escritorRespuesta.println(jsonRespuesta);
        //String jsonRespuesta = gson.toJson(sps.obtenerTodos());
        //escritorRespuesta.println(jsonRespuesta);

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter escritorRespuesta = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");

        BufferedReader bufRead = request.getReader();
        String strIndice = bufRead.readLine();
        int indice = Integer.parseInt(strIndice);
        ServicioProductoSingleton sps = ServicioProductoSingleton.getInstancia();
        sps.eliminar(indice);
        
        String mensaje = "ya lo he eliminado";
        

    }
}
