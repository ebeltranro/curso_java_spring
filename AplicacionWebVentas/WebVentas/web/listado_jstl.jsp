<%-- 
    Document   : listado_jstl
    Created on : 24-may-2019, 13:50:12
    Author     : Admin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sinensia.modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- List<Cliente> listaCliPorNombre = (ArrayList<Cliente>) request.getAttribute("listaPorNombre"); %> trae el bean del controlador --%>
<%-- cogido de la bolsa de petición. <jsp:useBean id="listaPorNombre" type="java.util.ArrayList<Cliente>" scope="request"> otra manera de coger el bean de la petición--%>
<%-- cogido de la bolsa de sesión. esta bolsa guarda la búsqueda en listado_jstl.jsp--%> 
<jsp:useBean id="listaPorNombre" type="java.util.ArrayList<Cliente>" scope="session">
    <jsp:getProperty property="*" name="listaPorNombre"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista con Beans</title>
    </head>
    <body>
        <%@include file="cabecera.jsp"%>

        <h2>Lista con Beans</h2>

        <table border = "2">
            <thead> 
                <tr>
                    <th>Nombre</th>
                    <th>Email </th>
                    <th>Edad</th>
                    <th>Activo </th>
                </tr>
            </thead>
            <%--  for (int i = 0; i < listaCliPorNombre.size(); i++) {--%>
            <c:forEach items="${listaPorNombre}" var="cli">
                <%-- <tr>
                     <td><%= (listaCliPorNombre.get(i).getNombre())%></td>
                     <td><%= (listaCliPorNombre.get(i).getEmail())%></td>                
                 </tr> --%>
                <tr><td>${cli.nombre}</td>
                    <td>${cli.email}</td> 
                    <td>${cli.edad}</td>
                    <td>${cli.activo}</td>
                </tr>     
                <%-- }--%>
            </c:forEach>

        </table>
    </body>
</html>
