<header> <h1> Web ventas </h1> </header>
<nav> 
    <a href="registro.jsp">Nuevo cliente </a>
    <a href="listado.jsp">Listado clientes </a>
    <a href="listado_sql.jsp">Listado JSTL - SQL </a>
    <a href="clientes.do">Listado JSTL y JavaBeans </a>  <!--si solo tenemos acceso al servicio pero no a la bbdd -->
    <form name="form2" method="GET" action="clientes.do">
        <label for="nombre"> Busca el nombre: </label> 
        <input id="nombre" name="nombre" type="text"/>
        <input type="submit" value="Buscar"/>
    </form>


</nav>
