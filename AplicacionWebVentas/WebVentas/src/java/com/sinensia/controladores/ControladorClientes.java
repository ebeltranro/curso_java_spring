/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.controladores;

import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.logica.ServicioClientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ControladorClientes extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //las peticiones get se piden con url. se suele usar para pedir métodos al servidor 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        nombre = nombre != null ? nombre : "";
        
        Cookie galleta = new Cookie("nombre_busqueda",nombre);
        galleta.setMaxAge(10000); //fijamos que la cookie dure mucho tiempo en lugar de que se borre al acabar la sesión
        response.addCookie(galleta); //lo añadimos a la respuesta 
        
        
        ServicioClientes srvCli = new ServicioClientes();
        List<Cliente> listado = srvCli.obtenerTodos();
        List<Cliente> listaPorNombre = new ArrayList<>();
        for (Cliente cliente : listado) { //se podría hacer con un SELECT en el servicio (sería lo suyo)
            if (cliente.getNombre().contains(nombre)) {
                listaPorNombre.add(cliente);
            }
        }
        //vamos a enviar la lista listaPorNombre a la vista lista_jstl.jsp usando java beans
       //pedido por peticion(bolsa de peticion) request.setAttribute("listaPorNombre", listaPorNombre); //enviando cosas a listado_jstl
       //pedido por la bolsa de sesión; dura mucho más tiempo 
       request.getSession().setAttribute("listaPorNombre", listaPorNombre); //enviando cosas a listado_jstl
       request.getRequestDispatcher("listado_jstl.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //las peticiones post se hacen mediante formulario. como estos paramétros los enviamos por un form usamos este método
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { //el form llama al método doPost
        //processRequest(request, response);
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String edad = request.getParameter("edad");
        String activo = request.getParameter("activo");

        ServicioClientes servCli;
        servCli = new ServicioClientes();
        Cliente cli = servCli.insertar(nombre, email, password, edad, activo); //ahora lo enviamos a la vista para ver el cliente
        if (cli == null) {
            request.getRequestDispatcher("error_registro.jsp").forward(request, response); //si no hay cliente creado redireccionar a html de error
        } else {
            request.getRequestDispatcher("registro_ok.jsp").forward(request, response);

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
