package com.sinensia.dao;

import com.sinensia.Cliente;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin - Elena
 */
public class ClienteDAO implements InterfazDAO<Cliente>{
    HashMap<Long, Cliente> mapa;
    public ClienteDAO(){
        mapa = new HashMap<>();
    }
    
    @Override
    public void poner(Cliente cli){
        if (cli == null){
            System.err.println("No se pueden añadir nulos");
        } else{
        mapa.put(cli.getId(), cli);
        return;
        }
        
    }
    
    @Override
    public Cliente leerUno(long id){
        if (mapa.containsKey(id)){
            return mapa.get(id);
        } else {
            System.err.println("Clave/ID no encontrada " + id);
            return null;
        }
    }

    @Override
    public void eliminar(Cliente valor) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        mapa.remove(valor.getId());//borra todo, clave y valor. podriamos poner también getNombre() pero lo habitual es usar el Id porque es unico
    }

    @Override
    public void eliminar(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        mapa.remove(id); //borra todo, clave y valor
    }

    @Override
    public List<Cliente> leerTodos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    ArrayList<Cliente> listaleidaClientes;
    listaleidaClientes = new ArrayList<Cliente>();
    
    for (Map.Entry<Long,Cliente> parClaveValor : mapa.entrySet()){
        Cliente Clientevalue = parClaveValor.getValue();
        listaleidaClientes.add(Clientevalue);
     }
    List listaleidaLista = (List) listaleidaClientes; //como lista no puede instanciarse (es abstracta) lo hacemos en ArrayList y le hacemos un casting a List
    return listaleidaLista; 
    }

    @Override
    public Cliente modificar(Cliente nuevoValor) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      Cliente clienteModificado = mapa.get(nuevoValor.getId());
      String nuevoEmail = nuevoValor.getEmail();
      clienteModificado.setEmail(nuevoEmail);
      clienteModificado.setNombre(nuevoValor.getNombre());
      //System.out.println(mapa.get(nuevoValor.getId()).getNombre());
      //return true; //con boolean
      return clienteModificado;
        
    }
}
