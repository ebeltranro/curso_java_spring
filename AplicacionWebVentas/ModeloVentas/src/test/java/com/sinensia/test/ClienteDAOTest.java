package com.sinensia.test;

import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.dao.InterfazDAO;
import com.sinensia.modelo.dao.MySQLClienteDAO;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ClienteDAOTest {
//vamos a usar este test para testear el MySQLClienteDAO
    private static MySQLClienteDAO daoCli; //esto significa que podemos crear tanto MySQLClienteDAO y ClienteDAO

    @BeforeClass
    public static void setUpClass() {
        daoCli = new MySQLClienteDAO();
        assertNotNull("Error inicialización DAO", daoCli); //si daoCli daría error y saldría ese mensaje
    }

    @Test
    public void clienteBien_1() {
        //ya lo hacemos bien sin meter el id
        assertNotNull(daoCli.insertar(new Cliente(null, "Pru", "pruxxxxxxxxx@pru.com", (short) 20, (short) 1, "Pru123")));
        assertEquals("pruxx@pru.com", daoCli.obtenerUno("pruxx@pru.com").getEmail());
        daoCli.eliminar("pruxx@pru.com");
        assertNull(daoCli.obtenerUno("pruxx@pru.com")); //si es nulo pasa la prueba
    }

    @Test
    public void clienteMal_1() {
        assertNull(daoCli.insertar(new Cliente(null, "", "prux@pru.com", (short) 20, (short) 1, "Pru123"))); //mal porque no tiene nombre
        assertEquals("", daoCli.obtenerUno("prux@pru.com").getNombre());
        daoCli.eliminar("prux@pru.com");
        assertNull(daoCli.obtenerUno("prux@pru.com")); //si es nulo pasa la prueba
    }

    /*@Test
    public void leyendoClientes() {
        assertEquals(daoCli.obtenerTodos().size(),4);
        assertEquals(daoCli.obtenerUno(3).getEmail(),"pru2@pru.com");
    }*/
}
