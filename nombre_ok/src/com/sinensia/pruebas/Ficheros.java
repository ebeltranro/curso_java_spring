package com.sinensia.pruebas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin - Elena
 */
public class Ficheros {

    public static void probarEscritura() throws IOException {

        String[] lineasTexto = {"Línea primera", "Línea segunda", "Tercera línea"};

        FileWriter fichero = null; //creación de un fichero
        //cuando trabajamos con ficheros debemos usar la sentencia try cath en caso de que haya excepciones
        //puede que falle el disco duro o cosas ajenas a nosotros y debemos usar esto

        try {
            fichero = new FileWriter("fichero_texto.txt");
            //para añadir debajo del fichero usar: fichero = new FileWriter("fichero_texto.txt",true);

            for (String linea : lineasTexto) {
                fichero.write(linea + "\r\n"); //el bloc de notas de windows necesita \r\n en lugar de \n para saltar la línea
            }
            fichero.close(); //hace falta cerrar el fichero para que se guarden los datos

        } catch (Exception ex) {
            System.err.println("Mensaje error: " + ex.getMessage());

        } finally {
            fichero.close();
            System.out.println("Fichero cerrado");
        }

        /*finally{ try { //por defecto te lo da java
            //si fallta alguna linea de escritura el if te devuelve al catch y el fichero no se cerraría; mejor poner un finally
            //también puedes escribirlo en el main
            fichero.close();
            } catch (IOException ex) { 
                // Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, null, ex);
            }
    }*/
    }

    //otra manera de escribir usando flujo de datos
    public static void escrituraStream() {
        //Stream: flujo de datos. Esto es un flujo de datos que van pasando de un lado a otro
        String[] lineasTexto = {"Línea primera", "Línea segunda", "Tercera línea"};
        Writer out = null;
        try {

            FileOutputStream streamFich;
            streamFich = new FileOutputStream("fich_2.txt"); //flujo de salida hacia un fichero. Recibe bytes vengan de donde
            //vengan y los escribe en ese fichero
            OutputStreamWriter streamWriter = new OutputStreamWriter(streamFich, "UTF-8");
            //escritor de flujo de datos; crea el flujo vaya a donde vaya (en este caso a streamFich;
            //y tiene la capacidad de decir la codificación del flujo
            out = new BufferedWriter(streamWriter);
            //este buffer recibe datos y los envía al stream de salida (streamWriter)

            for (String linea : lineasTexto) {

                try {
                    out.write(linea + "\r\n");
                } catch (IOException ex) {
                    System.err.println("Error al escribir fich: " + ex.getMessage());
                }
            }

        } catch (UnsupportedEncodingException | FileNotFoundException ex2) {
            //por si acaso no encuentra el fichero o no reconece los caracteres
            System.out.println("Error 2: " + ex2.getMessage());
        } finally {
            try {
                out.close();
            } catch (IOException ex2) {
                System.out.println("Error en cierre fich: " + ex2.getMessage());
            }
        }

    }

    public static void lecturaFich() {
        File fichFormWind = new File("C:\\Users\\Admin\\Desktop\\CURSO_JAVA\\curso_java_spring.git\\nombre_ok\\fichero_texto.txt");
        //windows es usa la contrabarra pero en java podemos usar la barra normal porque es multiplataforam
        File fichFormJava = new File("C:/Users/Admin/Desktop/CURSO_JAVA/curso_java_spring.git/nombre_ok/fichero_texto.txt");
        File fichRutaRelativa = new File("fichero_texto.txt");// basta con esto porque estamos en la carpeta
        Scanner escaner = null; //objeto que es capaz de leer datos y formatearlos. puede venir de la consola o de un fichero

        try {
            System.out.println("Leyendo fichero");
            escaner = new Scanner(fichFormWind);

            while (escaner.hasNextLine()) { //busca hasta el siguiente retorno de carro(\n)
                String linea = escaner.nextLine();
                System.out.println(" >>>>> \"" + linea + "\"");
                //comparación por orden alfabético. La T está detras de la L y la p antes de la s
                if (linea.compareTo("Línea segunda") < 0) //si linea es menor que "Linea segunda" el método compareTo devuelve -1; si es mayor devuelve +1
                {

                    System.out.println("      es menor");
                } else if (linea.compareTo("Línea segunda") > 0){
                    System.out.println("      es mayor");
                } else System.out.println("      son iguales");
            }

        } catch (Exception ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                if (escaner != null) {
                    escaner.close();
                }
            } catch (Exception ex2) {
                System.err.println("Mensaje al cerrar:" + ex2.getMessage());
            }
        }

    }

}
