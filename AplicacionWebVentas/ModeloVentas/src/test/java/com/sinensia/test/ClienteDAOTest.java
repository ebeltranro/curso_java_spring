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
public class ClienteDAOTest {

    private static ClienteDAO daoCli;

    @BeforeClass
    public static void setUpClass() {
        daoCli = new ClienteDAO();
        assertNotNull("Error inicialización DAO", daoCli); //si daoCli daría error y saldría ese mensaje
    }

    /* @Test
    public void creandoClientes() {

        //veamos qué pasa siponemos el id (cuando se supone que lo tiene que añadir por defecto la bbdd)
        //hay bastantes errores...emails iguales, nombre nulo, la variable activo booleano igual a 1; sin embargo nos lo da como correcto
      daoCli.insertar(new Cliente(1,"Pru","pru@pru.com",(short) 20, (short) 1,"Pru123"));
        daoCli.insertar(new Cliente(2,"Pru2","pru2@pru.com",(short) 22, (short) 0,"Pru123"));
       
        //creemos varios clientes que estén mal
        daoCli.insertar(new Cliente(3,null,"pru2@pru.com",(short) 22, (short) 0,"Pru123"));
        daoCli.insertar(new Cliente(4,"Pru","pru2@pru.com",(short) 22, (short) 4,"Pru123"));
        assertEquals(daoCli.obtenerTodos().size(),4);
        assertEquals(daoCli.obtenerUno(3).getEmail(),"pru2@pru.com");
        //creemos 4 clientes que estén bien
    }*/
    @Test
    public void clienteBien_1() {
        //ya lo hacemos bien sin meter el id
        daoCli.insertar(new Cliente(null, "Pru", "pru@pru.com", (short) 20, (short) 1, "Pru123"));
        assertEquals("pru@pru.com", daoCli.obtenerUno(3).getEmail());
        daoCli.eliminar(1);
        assertNull(daoCli.obtenerUno(1)); //si es nulo pasa la prueba
    }

    @Test
    public void clienteMal_1() {
        daoCli.insertar(new Cliente(null, "", "pru@pru.com", (short) 20, (short) 1, "Pru123")); //mal porque no tiene nombre
        assertEquals("", daoCli.obtenerUno(3).getNombre());
        daoCli.eliminar(1);
        assertNull(daoCli.obtenerUno(1)); //si es nulo pasa la prueba
    }

    /*@Test
    public void leyendoClientes() {
        assertEquals(daoCli.obtenerTodos().size(),4);
        assertEquals(daoCli.obtenerUno(3).getEmail(),"pru2@pru.com");
    }*/
}
