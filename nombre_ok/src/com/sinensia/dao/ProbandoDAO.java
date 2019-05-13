/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia.dao;

import com.sinensia.Cliente;
import com.sinensia.ClienteInvitado;
import com.sinensia.Producto;
import java.util.List;

/**
 *
 * @author Admin - Elena
 */
public class ProbandoDAO {
    
    public static void probarCliente(){
        GenericoDAO<Cliente> repoCli = new GenericoDAO();
        Cliente clienteCambiado = new Cliente(1, " Ana"," anitalokita@gmail.com");
        
        
        repoCli.poner(new Cliente (1," Ana ", "ana@gmail.com"));
        repoCli.poner(new ClienteInvitado(2," Juan ","juan@gmail.com")); //se pueden añadir también invitado y vip
        repoCli.poner(new ClienteInvitado(3, "Bea ", "bea@gmail.com"));
        System.out.println("Juan: " + repoCli.leerUno(2).toString()); //como ClienteInvitado es un hijo de Cliente puede acceder a sus métodos (leerUno)
        System.out.println("Juan: " + repoCli.leerUno(3).toString());
        System.out.println(repoCli.leerTodos());
        //repoCli.modificar(clienteCambiado);
       // System.out.println("Cliente modificado: " + repoCli.modificar(clienteCambiado).toString());
        Cliente mod = repoCli.leerUno(1);
        System.out.println("Cliente leído modificado: " + mod.toString());
        
        Cliente clienteCambiado2 = new Cliente(3, " pruebisima"," miriam_sabe_mucho@yahoo.com");
        repoCli.modificar2(clienteCambiado2);
        Cliente mod2= repoCli.leerUno(3);
        System.out.println("Cliente remodificado: " + mod2.toString());
        
        repoCli.eliminar(1);
        System.out.println(repoCli.leerTodos());
        
        
        List<Cliente> lista = repoCli.leerTodos();
        
        for (Cliente cli:lista){
            System.out.println("Clientes: " + cli.toString());
        }
  
    }
    
    public static void probarProducto(){
        
        GenericoDAO<Producto> repoPro = new GenericoDAO<>();
        
        Producto prod = new Producto(1,"movil",100,25);
        repoPro.poner(prod);
        System.out.println("Movil: " + repoPro.leerUno(1).toString()); 
        
    }

}
