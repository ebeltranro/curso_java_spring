package com.sinensia;

import com.google.gson.Gson;
import com.sinensia.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sinensia.modelo.MySQLCliente;
import java.io.BufferedReader;
import java.io.Reader;

/**
 * Los servlets heredan de la clase HttpServlet
 *
 * @author Admin - Elena
 */
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) //lo que queremos que haga en la petición get
            throws ServletException, IOException {
        respuesta.setContentType("text/html;charset=UTF-8");
        //otra forma de hacer el try sin el catch
        //esto devuelve un código html. el servidor devuelve al cliente un código html cuando se envía el 
        //formulario
        try (PrintWriter salida = respuesta.getWriter()) {
            salida.println("<html><head>");
            salida.println("<title>Web servlet desde Java</title>");
            salida.println("</head><body>");
            salida.println("<h1>Respuesta al registro</h1>");
            salida.println("<h2> Ruta del servlet: " + peticion.getContextPath()
                    + ", método: " + peticion.getMethod() + "</h2>");
            salida.println("<ul>");
            for (int i = 0; i < 3; i++) {
                salida.println("<li>Num " + i + "</li>");
            }
            salida.println("</ul>");
            String nombre = peticion.getParameter("nombre"); //viene del NAME! nombre
            //todos los parámetros se envían como String aunque fuesen números
            String strEdad = peticion.getParameter("edad");
            //le hacemos un parseo para cambiarlo a la forma que queremos
            int edad = Integer.parseInt(strEdad);
            String email = peticion.getParameter("email");
            String strActivo = peticion.getParameter("activo");
            boolean activo = false;
            if (strActivo != null) {
                activo = true;
            }
            //boolean activo = strActivo != null; otra forma
            salida.println("<p>nombre=" + nombre + "</p>");
            salida.println("<p>edad=" + edad + "</p>");
            salida.println("<p>email=" + email + "</p>");
            salida.println("<p>activo=" + activo + "</p>");

            MySQLCliente bdCliente = new MySQLCliente();
            if (bdCliente.crear(nombre, email, email + "1234", edad, activo)) {
                salida.println("<p>Guardado correctamente </p>");
            } else {
                salida.println("<p> Guardado erroneamente </p>");
            }

            salida.println("</body></html>");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8"); //la respuesta tiene formato JSON

        try (PrintWriter salida = response.getWriter()) {

            BufferedReader bufreader = request.getReader();
            String lectura = bufreader.readLine();      
                       
            Cliente cli = new Gson().fromJson(lectura, Cliente.class);
            
            cli.setNombre(cli.getNombre().toUpperCase());
            cli.setEmail(cli.getEmail().toUpperCase());
            
           boolean activo = false;
           if (cli.getActivo() == 1){
               activo = true;
           }
           String email = cli.getEmail();
           String nombre= cli.getNombre();
           String password = cli.getPassword();
           short edad = cli.getEdad();

            MySQLCliente servCli = new MySQLCliente();
            servCli.crear(nombre, email, password, edad, activo);
            
            String jsonCli = null;

            if (servCli.crear(nombre, email, password, edad, activo)) {
                jsonCli = "se ha guardado el nuevo cliente: " + "\n email: " + email + "\n nombre: " + nombre;
            } else {
                jsonCli = "no se ha podido crear el nuevo cliente";

            }
           
           
            
            String jsonCli2 = new Gson().toJson(cli);
            
            salida.print(jsonCli2);
            

        }

    }

    @Override
    public String getServletInfo() {
        return "Registro clientes";
    }

}
