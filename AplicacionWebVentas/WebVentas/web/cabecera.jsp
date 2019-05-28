<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header> <h1> Web ventas </h1> </header>
<nav> 
    <%-- se puede hacer con java y un if getAttribute, pero vamos a verlo con jstl --%>
    <c:if test="${login != 'ok'}">
        <a href="registro.jsp">Nuevo cliente </a>
        <a href="login.jsp">Login </a>
        <form name="form2" method="GET" action="clientes.do">
            <label for="nombre_busq"> Busca el nombre: </label> 
            <input id="nombre_busq" name="nombre_busq" type="text"/>
            <input type="submit" value="Buscar"/>
        </form>
    </c:if>
    <%--TODO: poner el editar dentro de login --%>
    <a href="editar.jsp">Editar AJAX + REST </a>
    <a href="borrar.jsp">Borrar AJAX + REST </a>
    <c:if test="${login == 'ok'}">

        <a href="listado.jsp">Listado clientes </a>
        <a href="listado_sql.jsp">Listado JSTL - SQL </a>
        <a href="clientes.do">Listado JSTL y JavaBeans </a>  <!--si solo tenemos acceso al servicio pero no a la bbdd -->


        <br/>
        <br/>
        <%-- Cookie con EL (Expression Language) --%>
        <span>Cookie del servidor: <%= request.getCookies().length <= 1 ? "" : request.getCookies()[1].getValue()%></span> 
        <br/>
        <br/>
        <span>Cookie del servidor: ${cookie.nombre_busqueda.value}</span> <%-- la cookie del lado del servidor va con retraso porque cogemos la
        cookie con la petición --%>
        <br/>
        <br/>
        <%-- la cookie del lado del cliente va al tiempo --%>
        <span id="span_cookie_nom_2"> </span> 
        <br/>
        <br/>
        <span id="span_cookie_nom"> </span> <%-- sin nombre_busqueda --%>
        <br/>
        <br/>
        <form name="form2" method="GET" action="clientes.do">
            <label for="nombre_busq"> Busca el nombre: </label> 
            <input id="nombre_busq" name="nombre_busq" type="text"/>
            <input type="submit" value="Buscar"/>
        </form>

    </c:if>
</nav>
<script src="js/cookies.js"></script>