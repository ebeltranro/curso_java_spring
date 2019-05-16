/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import com.sinensia.Cliente;
import com.sinensia.ClienteInvitado;
import java.util.Map;

/**
 *
 * @author Admin - Elena
 */
public class LecturaEjercicio {

    public static void leer() {

        HashMap<String, Cliente> MapaLeido = new HashMap<>();

        File fich = new File("C:\\Users\\Admin\\Desktop\\CURSO_JAVA\\curso_java_spring.git\\05_LecturaClientes\\Ejercicio_ficheros.txt");
        Scanner escaner = null;

        try {
            System.out.println("Leyendo fichero");
            escaner = new Scanner(fich);

            while (escaner.hasNextLine()) { //busca hasta el siguiente retorno de carro(\n)
                String linea = escaner.nextLine();
                //System.out.println(linea);

                String palabras[] = linea.split(",");
                int length = palabras.length;

                if (length == 4) {
                    //long id = Integer.parseInt(palabras[0]); parseInt igual que valueOf
                    //String nombre = palabras[1];
                    //String email = palabras[2];
                    //boolean activo = palabras[3].equals("true") ? true: false; si el resultado es true devuelve true y si no devuelve falso

                    Cliente clinuevo = new Cliente(Integer.valueOf(palabras[0]), palabras[1], palabras[2], Boolean.valueOf(palabras[3]));
                    MapaLeido.put(palabras[0], clinuevo);
                }

                if (length == 5) {
                    ClienteInvitado clinuevo = new ClienteInvitado(Integer.valueOf(palabras[0]), palabras[1], palabras[2],
                            Boolean.valueOf(palabras[3]), Integer.valueOf(palabras[4]));
                    MapaLeido.put(palabras[0], clinuevo);
                }

            }
            for (Map.Entry<String, Cliente> parClaveValor : MapaLeido.entrySet()) {
                System.out.println("Clave " + parClaveValor.getKey());
                Cliente Clientevalue = parClaveValor.getValue();
                System.out.println(Clientevalue.toString());
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
