var alPulsarModificar = function () {
    antesDeEnviar(); //función callback porque es llamada cuando el usuario hace click
    var nombre = document.getElementById("nombre").value;
    var email = document.getElementById("email").value;
    var edad = document.getElementById("edad").value;
    var password = document.getElementById("password_encrip").value;
    var activo = document.getElementById("activo").checked;
    activo = activo ? "on" : "off"; //en el servidor esperamos on/off que luego convierte en 0 / 1

    // convertimos los datos en JSON
    //construimos el cliente con el formato de JSON
    var cliente = {
        "nombre": nombre,
        email: email,
        'edad': edad
    };
    //todas estas formas son válidas de asignar parámetros
    cliente.password = password; //otra forma de construirlo
    cliente["activo"] = activo; //otra forma de construirlo



    var clienteJSON = JSON.stringify(cliente);// Convertir obj en JSON
    alert("Enviando...\n" + clienteJSON);
    //ver mozilla XMLHttpReques!!
    // ActiveX para IE 7
    var peticionHTTP = new XMLHttpRequest(); // Objeto AJAX
    // ¿Que tiene que hacer al recibir la respuesta?
    peticionHTTP.onreadystatechange = function () {
        //se envía cuando cambia de estado. en este caso 2 veces, cuando se conecta con el servidor y cuando se recibe la solicitud
        alert("Hemos recibido algo, nivel " + peticionHTTP.readyState);
        // alert("Ha cambiado de estado");
        //readyState -- > estado interno de la petición
        //onreadystatechange se invoca cada vez que cambia de estado
        if (this.readyState === 4 && this.status === 200) { //estado interno de AJAX es 4; el estado 200 es porque ha encontrado la página bien
            // //3 iguales para decir que tiene que ser igual el tipo
            alert("Hemos recibido algo!!!!" + this.responseText);
            var jsonResp = this.responseText;
            var objResp = JSON.parse(jsonResp); //Deserializar el JSON en un objeto JS
            alert(" Email recibido? " + objResp.email + "\n" + "Y el nombre? " + objResp["nombre"] + "\n"
                    + " Y la password? " + objResp.password + "\n" + " Está activo? " + objResp.activo
                    + "\n" + " Y el ID? " + objResp.id);

            document.getElementById("nombre_cli").innerHTML = objResp.nombre;
            document.getElementById("email_cli").innerHTML = objResp.email;
            document.getElementById("id_cli").innerHTML = objResp.id;
            document.getElementById("edad_cli").innerHTML = objResp.edad;
            document.getElementById("activo_cli").innerHTML = objResp.activo;

        } /*else {
         alert("Aun NO hemos recibido nada!");
         }*/
    };
    // Definimos la petición
    peticionHTTP.open("POST", "http://localhost:8084/WebVentas/clientes2.do", true); //cuando hacemos open llama a onreadystatechange porque cambia de estado
    peticionHTTP.setRequestHeader("Content-type",
            "application/x-www-form-urlencoded");//enviamos el formulario así mediante js. volvemos a llamar a onreadystatechange
    // lanzamos la petición
    var form1 = document.getElementById("form1");
    var formData = new FormData(form1);
    var cadenaEnvio =
            "nombre=" + encodeURIComponent(document.getElementById("nombre").value)
            + "&email=" + encodeURIComponent(document.getElementById("email").value)
            + "&password_encrip=" + encodeURIComponent(document.getElementById("password_encrip").value)
            + "&activo=" + encodeURIComponent(document.getElementById("activo").value)
            + "&edad=" + encodeURIComponent(document.getElementById("edad").value);

    alert("¿Qué se va a enviar?\n" + cadenaEnvio);
    peticionHTTP.send(cadenaEnvio); //vuelve a llamar a onready
};
//document.getElementById("btn_modificar").addEventListener("click", alPulsarModificar ); //si pasamos la función como referencia va sin paréntesis!!
//función callback

document.getElementById("btn_modificar").onclick = alPulsarModificar; //esto significa que cuando hacemos click el navegador ejecute esa función;

//no es lo mismo que poner poner () porque no queremos el resultado de la función




