<%-- 
    Document   : listado
    Created on : 24-may-2019, 9:29:57
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- los comentarios en jsp van con este símbolo; la diferencia con los comentarios de html es que estos no se envía mientras que los de html se envían
aunque el navegadot los ignore --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.sinensia.modelo.logica.*" %>
<%@page import="com.sinensia.modelo.Cliente" %>
<%! ServicioClientes srvCli;%> <%--en lugar de hacer un new, los objetos se pueden declarar así con ! --%>
<% srvCli = new ServicioClientes();
    List<Cliente> clientes = srvCli.obtenerTodos();
%> <%-- este símbolo vale para todo --%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado clientes</title>
    </head>
    <body>
        <%@include file="cabecera.jsp"%>
        <h2>Listado clientes</h2>
        <table border = "2">
            <thead> 
                <tr>
                    <th>Nombre</th>
                    <th>Email </th>
                    <th>Edad </th>
                    <th>Activo </th>
                </tr>
            </thead>
            <tbody>
                <%-- manera 1 JSP medio cutre --%>
                <%  for (int i = 0; i < clientes.size(); i++) {%>
                <tr>
                    <td><%= (clientes.get(i).getNombre())%></td>
                    <td><%= (clientes.get(i).getEmail())%></td> 
                    <td><%= (clientes.get(i).getEdad())%></td>
                    <td><%= (clientes.get(i).getActivo())%></td>                    
                </tr>
                <% }%>
                <%-- manera 2 servlet cutre --%>
                <%  for (Cliente cli: clientes) {
                    out.println("<tr><td>" + cli.getNombre() +"</td>");
                    out.println("<td>" + cli.getEmail() +"</td>");
                    out.println("<td>" + cli.getEdad() +"</td>");
                    out.println("<td>" + cli.getActivo() +"</td></tr>");
  
                }%>
                <%-- existe una 3 manera de hacerlo usando una libreria de JSTL (ver listado_sql)--%>
                
                
            </tbody>
        </table>
    </body>
</html>
