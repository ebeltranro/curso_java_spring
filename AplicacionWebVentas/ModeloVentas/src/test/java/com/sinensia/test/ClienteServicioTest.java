/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.test;

import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.logica.ServicioClientes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ClienteServicioTest {

    private static ServicioClientes servCli;

    @BeforeClass
    public static void setUpClass() {
        servCli = new ServicioClientes();
    }

    @Test
    public void clienteOk_1() {
        // assert = afirmar/asegurar
        assertNotNull(servCli.insertar("Ok", "email@ok.com", "ok12", "30", "on"));
        assertEquals(servCli.obtenerUno("email@ok.com").getNombre(), "Ok");
        servCli.eliminar("email@ok.com");
        assertNull(servCli.obtenerUno("email@ok.com"));
    }

    @Test
    public void clienteOk_2() {
        servCli.insertar("Cliente Ok", "email_1@ok.com", "ok12", "30", "on");
        servCli.insertar("Cliente Ok", "email_2@ok.com", "ok12", "25", "on");
        assertEquals(servCli.obtenerUno("email_1@ok.com").getEdad(), 30);
        assertTrue(servCli.obtenerUno("email_2@ok.com").getActivo() == 1);
        servCli.eliminar("email_1@ok.com");
        servCli.eliminar("email_2@ok.com");
        assertNull(servCli.obtenerUno("email_1@ok.com"));
        assertNull(servCli.obtenerUno("email_2@ok.com"));
    }

    @Test
    public void clienteMal_Nombre() {
        servCli.insertar("", "clienteMal_1@ok.com", "ok12", "30", "on"); //no hay nombre
        assertNull(servCli.obtenerUno("clienteMal_1@ok.com"));
    }

    @Test
    public void clienteMal_OtrosCampos() {
        servCli.insertar("Nombre bien", "", "ok12", "30", "on"); //no hay email
        assertNull(servCli.obtenerUno(""));
        servCli.insertar("Bien", "clien@ok.com", "", "30", "on"); //no hay password
        servCli.insertar("Ok", "client_2@ok.com", "ok12", "-2", "on"); //edad negativa
        servCli.insertar("Ok", "client_3@ok.com", "ok12", "NoNUM", "on"); //edad no num
        assertNull(servCli.obtenerUno("clien@ok.com"));
        assertNull(servCli.obtenerUno("client_2@ok.com"));
        assertNull(servCli.obtenerUno("client_3@ok.com"));
    }

    @Test
    public void clienteBien_Modificar() {
        assertNotNull(servCli.insertar("hola", "hola@ok.com", "1234", "35", "on"));
        Cliente cliente = servCli.obtenerUno("hola@ok.com");
        assertNotNull(servCli.modificar(cliente.getId(), "holacambiado", "hola2@ok.com", "123456", "28", "of"));
        assertEquals(servCli.obtenerUno("hola2@ok.com").getNombre(), "holacambiado");
        assertEquals(servCli.obtenerUno("hola2@ok.com").getPassword(), "123456");
        assertEquals(servCli.obtenerUno("hola2@ok.com").getEdad(), 28);
        assertTrue(servCli.obtenerUno("hola2@ok.com").getActivo() == 0);
        servCli.eliminar("hola2@ok.com");
        assertNull(servCli.obtenerUno("hola2@ok.com"));
    }

    @Test
    public void clienteMal_Modificar() {
        assertNotNull(servCli.insertar("hola", "hola@ok.com", "1234", "35", "on"));
        assertNull(servCli.modificar(servCli.obtenerUno("hola@ok.com").getId(), "", "hola@ok.com", "1234", "35", ""));
        assertNull(servCli.modificar(servCli.obtenerUno("hola@ok.com").getId(), "hola2", "", "1234", "35", ""));
        assertNull(servCli.modificar(servCli.obtenerUno("hola@ok.com").getId(), "hola2", "hola@ok.com", "", "35", ""));
        assertNull(servCli.modificar(servCli.obtenerUno("hola@ok.com").getId(), "hola2", "hola@ok.com", "1234", "0", ""));
        
        assertEquals(servCli.obtenerUno("hola@ok.com").getEdad(),35);
        servCli.eliminar("hola@ok.com");
        assertNull(servCli.obtenerUno("hola@ok.com"));

    }
}
