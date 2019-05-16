/* GPL 1.0 --> significa que es licencia libre
 */
console.log("Generando tabla...");
generarTabla();

function generarTabla() {
    var table = document.getElementsByTagName("table");//obtiene a los elementos por su etiqueta
    table = table[0];
    var nombrePrecio = "Precio";
    var nombreStock ="Stock";
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

    var lista = new Array();
    lista = [  ["Vaina: ", "Peine", "15 €", "7"]  ] ; //la notación de JS para un array de 2 dimensiones
    lista[1] = ["Vaina: ", "Quitapelos", "30 €","1"]; //segundo elemento
    lista[2] = ["Vaina: ", "Un coche estropeao", "200 €","2"];

    for (var i = 0;  i < lista.length; i++){
        //veamos una manera de crear la tabla, aunque no se hace así
        var nodoTR = document.createElement("tr");
        table.appendChild(nodoTR); //crea filas de la tabla   
        for (var columna of lista[i]){
            var nodoCol = document.createElement("td"); //crea columnas de cada fila
            nodoTR.appendChild(nodoCol); //otra manera de hacerlo, añadir al padre o heredar al hijo
            var textoCol = document.createTextNode(columna); //le da contenido a cada celda
            nodoCol.appendChild(textoCol);
        }
    }

}





