//window.onload = function () { //función que se llama mientras se está cargando la página
var alPulsarRegistrar = function () {
    //var btn_reg = document.getElementById("btn_registro_ajax");

    var nombre = document.getElementById("nombre").value;
    var email = document.getElementById("email").value;
    var edad = document.getElementById("edad").value;
    var activo = document.getElementById("activo").checked;


    activo = activo ? 1 : 0; //en el servidor esperamos on/off que luego convierte en 0 / 1

    var cliente = {
        "nombre": nombre,
        email: email,
        'edad': edad,
        activo: activo,
        password: nombre
    };
    //todas estas formas son válidas de asignar parámetros



    var clienteJSON = JSON.stringify(cliente);// Convertir obj en JSON
    alert("Enviando...\n" + clienteJSON);


    var peticionHTTP = new XMLHttpRequest();

    peticionHTTP.onreadystatechange = function () {
        alert("Mensaje en Cliente (JS). Hemos recibido algo, nivel " + peticionHTTP.readyState);

        if (this.readyState === 4 && this.status === 200) {

            var jsonResp = this.responseText;
            var objResp = JSON.parse(jsonResp);
            
            alert("Hemos recibido algo!!!!" + jsonResp + objResp);
            var divInfo = document.getElementById("div_info");
            divInfo.style = "display:block";
            var spanSalidaNombre = document.getElementById("salida_nombre");
            spanSalidaNombre.innerHTML = objResp.nombre;
            var spanSalidaEmail = document.getElementById("salida_email");
            spanSalidaEmail.innerHTML = objResp.email;

        }
    };

    peticionHTTP.open("POST", "registro", true);
    //peticionHTTP.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    peticionHTTP.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    /* var cadenaEnvio =
     "nombre=" + encodeURIComponent(document.getElementById("nombre").value)
     + "&email=" + encodeURIComponent(document.getElementById("email").value)
     + "&password=" + encodeURIComponent(document.getElementById("email").value)
     + "&activo=" + encodeURIComponent(activo)
     + "&edad=" + encodeURIComponent(document.getElementById("edad").value);*/

    //alert("¿Qué se va a enviar?\n" + clienteJSON);
    //peticionHTTP.send(cadenaEnvio);

    peticionHTTP.send(clienteJSON);

};

document.getElementById("btn_registro_ajax").onclick = alPulsarRegistrar;
//};


