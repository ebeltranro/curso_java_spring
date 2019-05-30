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
@WebServlet(asyncSupported = true, urlPatterns = "/api.productos") //indicamos que admite comunicación asíncrona 
//vamos a hacer algunas coass un poco diferentes para practicar
public class ProductoRestConntroller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
        
        producto.setNombre(producto.getNombre());
        producto.setPrecio("500 bolivares");
        //transformamos a formato JSON para enviar la respuesta
        String jsonRespuesta = gson.toJson(producto);
        
        escritorRespuesta.println(jsonRespuesta);

    }

}
