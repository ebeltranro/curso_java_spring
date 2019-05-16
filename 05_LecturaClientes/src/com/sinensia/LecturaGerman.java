/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia;

/**
 *
 * @author Admin - Elena
 */

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LecturaGerman {



    /**
     * @param args the command line arguments
     */
    public static void leerGerman() {
        File fichRutaRelativa = new File("../Ejercicio_ficheros.txt");
        Scanner escaner = null;
        HashMap<Long, Cliente> mapaDat = new HashMap<>();
        try {
            //System.out.println("Leyendo fich");
            escaner = new Scanner(fichRutaRelativa);
            while (escaner.hasNextLine()) { // Hasta el siguiente \n
                String linea = escaner.nextLine();
                //System.out.println(">>>> \"" + linea + "\"");
                try {
                        Cliente cliente=parsearCliente(linea);
                        mapaDat.put(cliente.getId(), cliente);
                    }
                 catch (Exception ex) {
                    System.err.println("Error en parseo: " + ex.getMessage());
                }
            }
            for (Map.Entry<Long, Cliente> ent : mapaDat.entrySet()) {
                System.out.println("Cliiiiiiiiiiii: " + ent.getValue().toString());
            }
        } catch (Exception ex) {
            System.err.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                if (escaner != null) {
                    escaner.close();
                }
            } catch (Exception ex2) {
                System.err.println("Mensaje al cerrar: " + ex2.getMessage());
            }
        }

    }

    static Cliente parsearCliente(String linea) {
        Cliente cliente = null;

        String campos[] = linea.split(",");

        if (campos.length == 4 || campos.length == 5) {
            long id = Integer.parseInt(campos[0]);
            String nombre = campos[1];
            String email = campos[2];
            boolean activo = campos[3].equals("true") ? true : false;
            int duracionMax = 0;
            if (campos.length == 5) {
                duracionMax = Integer.parseInt(campos[4]);
                cliente = new ClienteInvitado(id, nombre, email);
                ((ClienteInvitado) cliente).setDuracionMax(duracionMax);
            } else {
                cliente = new Cliente(id, nombre, email);
            }
            cliente.setActivo(activo);

        }
        return cliente;
    }

}

    
    
