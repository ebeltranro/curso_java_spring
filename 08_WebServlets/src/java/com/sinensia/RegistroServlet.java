package com.sinensia;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**Los servlets heredan de la clase HttpServlet
 *
 * @author Admin - Elena
 */
public class RegistroServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) //lo que queremos que haga en la petición get
    throws ServletException, IOException
    {
        respuesta.setContentType("text/html;charset=UTF-8");
        //otra forma de hacer el try sin el catch
        //esto devuelve un código html. el servidor devuelve al cliente un código html cuando se envía el 
        //formulario
        try (PrintWriter salida =respuesta.getWriter()){
            salida.println("<html><head>");
            salida.println("<title>Web servlet desde Java</title>");
            salida.println("</head><body>");
            salida.println("<h1>Respuesta al registro</h1>");
            salida.println("</body></html>");
            salida.println("");
        }
    }
    
    
    @Override
    public String getServletInfo(){
        return "Registro clientes";
    }
}
