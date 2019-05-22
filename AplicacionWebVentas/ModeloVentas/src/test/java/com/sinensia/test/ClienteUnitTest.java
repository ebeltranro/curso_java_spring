package com.sinensia.test;

import com.sinensia.modelo.Cliente;
import com.sinensia.modelo.dao.ClienteDAO;
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
public class ClienteUnitTest {

    public ClienteUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before //se ejecuta antes de cada método de Testing
    public void setUp() {
    }

    @After  //se ejecuta después de cada método de Testing
    public void tearDown() {
    }

    @Test
    public void probarJUnit() { //comprueba si los dos valores tienen el mismo valor
        assertEquals(10, 10);
        assertEquals("Texto", "Texto");
        //assertEquals("texto", "TExto"); da error en Test Results
        assertNotEquals("texto", "TExto");
    }
    
    @Test
    public void probarClienteDAO(){
        ClienteDAO daoCli = new ClienteDAO();
        
        daoCli.insertar(new Cliente(1,"Pru","pru@pru.com",(short) 20, (short) 1,"Pru123")); //casting de entero a short porque en la clase Cliente están decla
        //rados como short
        daoCli.insertar(new Cliente(2,"Pru2","pru2@pru.com",(short) 22, (short) 0,"Pru123"));
        
        assertEquals(daoCli.obtenerTodos().size(),2); //test para ver si el tamaño de la lista es 2
        Cliente cli = daoCli.obtenerUno(2);
        assertTrue(cli.getEmail().equals("pru2@pru.com"));
        assertSame(cli, cli);
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
