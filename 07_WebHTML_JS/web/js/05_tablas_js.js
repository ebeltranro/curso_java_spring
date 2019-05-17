/* GPL 1.0 --> significa que es licencia libre
 */
console.log("Generando tabla...");
var lista = new Array();
lista = [["Vaina: ", "Peine", "15 €", "7"]]; //la notación de JS para un array de 2 dimensiones
lista[1] = ["Vaina: ", "Quitapelos", "30 €", "1"]; //segundo elemento
lista[2] = ["Vaina: ", "Un coche estropeao", "200 €", "2"];

generarTabla();
function generarTabla() {
    var table = document.getElementsByTagName("table");//obtiene a los elementos por su etiqueta
    table = table[0];
    var nombrePrecio = "Precio";
    var nombreStock = "Stock";
    table.innerHTML = "<caption> Lista de vainas </caption>";
    table.innerHTML += ` <thead>
       <tr>
        <th>Tipo </th>
        <th>Nombre</th>
        <th> ${nombrePrecio} </th> 
        <th> ${nombreStock} </th> 
       </tr>
    </thead>
    `;
//usando $ te coge la variable definida texto
//el + es para añadirlo detrás de la caption

    for (var i = 0; i < lista.length; i++) {
        //veamos una manera de crear la tabla, aunque no se hace así
        var nodoTR = document.createElement("tr");
        table.appendChild(nodoTR); //crea filas de la tabla   
        for (var columna of lista[i]) {
            var nodoCol = document.createElement("td"); //crea columnas de cada fila
            nodoTR.appendChild(nodoCol); //otra manera de hacerlo, añadir al padre o heredar al hijo
            var textoCol = document.createTextNode(columna); //le da contenido a cada celda
            nodoCol.appendChild(textoCol);
        }
    }


}

/*
//de otra manera

function agregarCosasDirectamente() {
    var table = document.getElementsByTagName("table");//obtiene a los elementos por su etiqueta
    table = table[0];
    var nombre = document.getElementById("elemento1").value;
    var tipo = document.getElementById("elemento2").value;
    var precio = document.getElementById("elemento3").value;
    var stock = document.getElementById("elemento4").value;
    var datosFila = [nombre, tipo, precio + " €", stock];


    var nodoTR = document.createElement("tr");
    table.appendChild(nodoTR); //crea filas de la tabla   
    for (var columna of datosFila) {
        var nodoCol = document.createElement("td"); //crea columnas de cada fila
        nodoTR.appendChild(nodoCol); //otra manera de hacerlo, añadir al padre o heredar al hijo
        var textoCol = document.createTextNode(columna); //le da contenido a cada celda
        nodoCol.appendChild(textoCol);
    }
}


//otra forma
function agregarCosasDirectamente2() {
    var table = document.getElementsByTagName("table");
    table = table[0];
    var nombre = document.getElementById("elemento1").value;
    var tipo = document.getElementById("elemento2").value;
    var precio = document.getElementById("elemento3").value;
    var stock = document.getElementById("elemento4").value;
        table.innerHTML += `<tr>
        <td>${nombre}</td> <td> ${tipo}</td><td>${precio + " €"}</td> <td> ${stock}</td>
    </tr>`;
}

*/
function pasarParametros() {
    var nombre = document.getElementById("elemento1").value;
    var tipo = document.getElementById("elemento2").value;
    var precio = document.getElementById("elemento3").value;
    var stock = document.getElementById("elemento4").value;
    var long = lista.length;
    //otra opcion lista.push([nombre,tipo,precio,stoch]); .push hace lo mismo que .add en java
    lista[long] = [nombre, tipo, precio + " €", stock];
    generarTabla();
}
function borrar() {

    if (lista.length > 3) {
        var listanew = new Array();
        for (var i = 0; i < lista.length - 1; i++) {
            listanew[i] = lista[i];
        }
        delete(lista);
        lista = listanew;
        generarTabla();

        //otra forma de Miriam
        //long = lista.length;
        //lista.splice((long-1),1);
        //generarTable;
    } else {
        generarTabla();
    }

}

function borrarToda() {
    var listaInicial = new Array();
    for (var i = 0; i < 3; i++) {
        listaInicial[i] = lista[i];
    }
    delete(lista);
    lista = listaInicial;
    generarTabla();
}












