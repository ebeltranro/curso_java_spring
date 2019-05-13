/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia.genericos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin - Elena
 */
public class ProbandoGenericos {
    public static void probarMetodo(){
        //diferencia entre tipo primitivo (int) y objeto (Integer)
        int num = 10; //tipo primitivo
        Integer objNum = new Integer(10); //objeto, empiza por mayuscula
        //objNum.   tiene métodos por ser un objeto; pero num.   no!
       
        String texto = "" + String.valueOf(num);
        String texto2 = "" + objNum.toString();
        
        int otroNum = num;
        num = 20;
        System.out.println("otroNum = " + otroNum);
        
        Integer otroObjNum = objNum;
        otroObjNum = 20;
        System.out.println("otroObjNum = " + otroObjNum);
        
        ArrayList<Integer> listaInt = new ArrayList<>();
        insertarDoble(listaInt,10);
        insertarDoble(listaInt,15);
        System.out.println("Enteros: " + listaInt.toString());
        
        ArrayList<String> listaStr = new ArrayList<>();
        insertarDobleGenerico(listaStr,"texto1");
        insertarDobleGenerico(listaStr,"texto2");
        System.out.println("Cadenas: " + listaStr.toString());
        
        ArrayList<Date> listaDate = new ArrayList<>();
        insertarDobleGenerico(listaDate,new Date(82,4,12));
        insertarDobleGenerico(listaDate,new Date(84,9,20));
        System.out.println("Fechas: " + listaDate.toString());
         
        
        
    }
    
    public static void insertarDoble (ArrayList<Integer> lista, int valor){
        lista.add(valor);
        lista.add(valor); //lo inserta 2 veces
        
    }
    
    public static void insertarDoble (ArrayList<String> lista, String valor){ //estamos sobrecargando el método
        lista.add(valor);
        lista.add(valor); 
        
    }
   
    //veamos cómo crear un método genérico "Clase"
    public static<Clase> void insertarDobleGenerico(ArrayList<Clase> lista, Clase valor){
        lista.add(valor);
        lista.add(valor);         
    }

}
