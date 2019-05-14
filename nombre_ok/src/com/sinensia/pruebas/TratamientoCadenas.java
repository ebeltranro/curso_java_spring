/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia.pruebas;

/**
 *
 * @author Admin - Elena
 */
public class TratamientoCadenas {
    public static void pruebasString(){
        String quijote = "En un lugar de la Mancha...";
        if (quijote.contains("Mancha")){
            System.out.println("Contiene mancha");
        }
        if (quijote.contains("mancHa")){
            System.out.println("Contiene mancHa");
        } else{
            System.out.println("No contiene mancHa");
        }
        
        if (quijote.toLowerCase().contains("mancHa".toLowerCase())){
            System.out.println("Contiene mancHa - versión minúsculas".toLowerCase());
        } else{
            System.out.println("No contiene mancHa");
        }
        
        if (quijote.startsWith("En un lugar")){
            System.out.println("Comienza con \"En un lugar \"");
        }
        if (quijote.endsWith("la Mancha...")){
            System.out.println("Termina con \"la Mancha...\"");
        }
        
        System.out.println("charAt(6) = " + quijote.charAt(6));
        
        System.out.println(String.format("El texto '%s' tiene '%d' caracteres", quijote, quijote.length())); // s para texto, d para enteros
        
        System.out.println(String.format("%.1f, %.5f, %.1f, %.2f €, %.3f", 1.1f ,2.2f, 3.3f, 4.4f, 5.5f));
        
        
        System.out.println("Mancha está en la posición " + quijote.indexOf("Mancha"));
        
        if (!quijote.isEmpty()){
            System.out.println("Quijote NO está vacía");
        } 
        
        System.out.println("La última 'a' está en " + quijote.lastIndexOf("a"));
        
        System.out.println("Trozo cadena: " + quijote.substring(6, 14));
        
        String palabras[] = quijote.split(" ");//divide la cadena separada por espacios
        for (String palabra: palabras){
            System.out.println(" PAL: " + palabra);
        }
        
        String strCSV = "Elena, 693 934 , C/Magnolias, 6, Doctora";
        for (String dato: strCSV.split(",")){
            System.out.println(" DATO: " + dato);
            System.out.println(" DATO: " + dato.trim());//trim quita los espacios laterales
        }
      
      
    }

}
