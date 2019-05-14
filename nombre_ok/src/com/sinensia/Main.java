package com.sinensia;

import com.sinensia.poo_avanzado.ProbandoAnimales;
import static com.sinensia.pruebas.Herencia.ProbandoHerencia; //otra manera de importar la clase y el método. luego usar el método directamente
import static com.sinensia.pruebas.Colecciones.ejemploListas;
import static com.sinensia.pruebas.Colecciones.ejemploHashMap;
import static com.sinensia.pruebas.Colecciones.ejemploSet;
import static com.sinensia.pruebas.Colecciones.comparaciones;
import com.sinensia.pruebas.Polimorfismo;
import static com.sinensia.pruebas.Polimorfismo.polimorfeando;
import static com.sinensia.pruebas.Polimorfismo.arrayclientes;
import static com.sinensia.pruebas.Polimorfismo.hashmapclientes;
import static com.sinensia.genericos.ProbandoGenericos.probarMetodo;
import static com.sinensia.dao.ProbandoDAO.probarCliente;
import static com.sinensia.dao.ProbandoDAO.probarProducto;
import com.sinensia.pruebas.Ficheros;
import static com.sinensia.pruebas.Ficheros.probarEscritura;
import static com.sinensia.pruebas.Ficheros.escrituraStream;
import static com.sinensia.pruebas.Ficheros.lecturaFich;
import static com.sinensia.pruebas.TratamientoCadenas.pruebasString;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        //com.sinensia.pruebas.Fechas.probar(); //la manera de llamar a una funcion estática dentro de una clase
        // ProbandoHerencia();
        // ejemploListas();
        // ejemploHashMap();
        // polimorfeando();
        //arrayclientes();
        //hashmapclientes();
        //ejemploSet();
        //ProbandoAnimales.probarClasesAbstractas();
        //probarCliente();
        //probarProducto();
        //escrituraStream();
        //lecturaFich();
        //comparaciones();
        pruebasString();

        /*try{            
            probarEscritura();     
         } catch(IOException ex) { 
           Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        }*/
    }
}
