/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia.dao;

import com.sinensia.Cliente;
import com.sinensia.ClienteInvitado;

/**
 *
 * @author Admin - Elena
 */
public class ProbandoDAO {
    
    public static void probarCliente(){
        ClienteDAO repoCli = new ClienteDAO();
        repoCli.poner(new Cliente (1," Ana ", "ana@gmail.com"));
        repoCli.poner(new ClienteInvitado(2," Juan ","juan@gmail.com")); //se pueden añadir también invitado y vip
        repoCli.poner(new ClienteInvitado(3, "Bea ", "bea@gmail.com"));
        System.out.println("Juan: " + repoCli.leerUno(2).toString()); //como ClienteInvitado es un hijo de Cliente puede acceder a sus métodos (leerUno)
        System.out.println("Juan: " + repoCli.leerUno(4));
        System.out.println(repoCli.leerTodos());
    }

}
