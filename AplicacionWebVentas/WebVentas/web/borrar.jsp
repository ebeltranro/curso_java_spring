<%-- 
    Document   : borrar
    Created on : 28-may-2019, 16:24:27
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrar con REST</title>
    </head>
    <body>
        <h1>Borrar con  REST</h1>

        <form name="form2" id="form2">

            <label for="email"> Email: </label> 
            <input id="email" name="email" type="email" required="required" size="50" maxlength="250"/>
            <br/>
            <br/>
            <input type="reset" value="Limpiar"/>
            <input id="btn_borrar" type="button" value="Borrar"/>

        </form>
        <div id="div_info" style="display: none">
            <p>  <span id="mensaje">...</span> </p>
        </div>
        <script src="js/borrar.js"></script>
    </body>
</html>
