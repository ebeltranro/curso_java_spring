package com.sinensia;

import com.sinensia.poo_avanzado.ProbandoAnimales;
import static com.sinensia.pruebas.Herencia.ProbandoHerencia; //otra manera de importar la clase y el método. luego usar el método directamente
import static com.sinensia.pruebas.Colecciones.ejemploListas;
import static com.sinensia.pruebas.Colecciones.ejemploHashMap;
import static com.sinensia.pruebas.Colecciones.ejemploSet;
import com.sinensia.pruebas.Polimorfismo;
import static com.sinensia.pruebas.Polimorfismo.polimorfeando;
import static com.sinensia.pruebas.Polimorfismo.arrayclientes;
import static com.sinensia.pruebas.Polimorfismo.hashmapclientes;
import static com.sinensia.genericos.ProbandoGenericos.probarMetodo;
import static com.sinensia.dao.ProbandoDAO.probarCliente;
import static com.sinensia.dao.ProbandoDAO.probarProducto;




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
       
        probarCliente();
        probarProducto();
  }
  
     
  
  }
  
