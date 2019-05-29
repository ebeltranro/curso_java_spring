/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*queremos encriptar la contraseña antes de enviarla*/
/*método de encriptación separa la contraseña caracter a caracter, le da la vuelta y la une*/
function encriptar(valor) {
    var splitString = valor.split(""); /*separa el String caracter a caracter (si le ponemos uno específico entre "" lo separa por ese caracter)*/
    var reverseArray = splitString.reverse();
    var joinArray = reverseArray.join(""); /*lo une sin añadir caracteres*/
    joinArray = "K7" + joinArray + "Up";

    /*función de encriptación  de internet*/

    md5(joinArray);
    var hash = md5.create();
    hash.update(joinArray);
    return hash.hex();
    /*hemos hecho una encriptación propia*/
}


function antesDeEnviar() {
    var passwd = document.getElementById("password").value;
    document.getElementById("password_encrip").value = encriptar(passwd);
    document.getElementById("password").value = ""; /*vaciamos el campo para que no se guarde la password original. solo se envia la encriptada*/
}

var form1 = document.getElementById("form1");/*le pasamos la función antesDeEnviar como función callback*/
form1.addEventListener("submit", antesDeEnviar); /*addEventListener añade una función al form, en ese caso cuando el usuario le dé a submit 
 * ejecuta la función antesDeEnviar*/
/*OJO!!! no le ponemos los paréntesis a la función porque la ejecuta el navegador, en lugar de nosotros*/
/*una función callback es una función SIN PARÉNTESIS*/
/*lo ejecuta el navegador antes de que le demos a submit*/



