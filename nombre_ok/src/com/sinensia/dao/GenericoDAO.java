package com.sinensia.dao;


import com.sinensia.Entidad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin - Elena
 */
//creemos una clase genérica basda en ProbandoDAO
public class GenericoDAO<T extends Entidad>  implements InterfazDAO<T>{ //importante saber que el Tipo T hereda de Entidad, para poder usar el método getId()
    
   
    HashMap<Long, T> mapa;
    public GenericoDAO(){
        mapa = new HashMap<>();
    }
    
    @Override
    public void poner(T cli){
        if (cli == null){
            System.err.println("No se pueden añadir nulos");
        } else{
        mapa.put(cli.getId(), cli);
        return;
        }
        
    }
    
    @Override
    public T leerUno(long id){
        if (mapa.containsKey(id)){
            return mapa.get(id);
        } else {
            System.err.println("Clave/ID no encontrada " + id);
            return null;
        }
    }

    @Override
    public void eliminar(T valor) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        mapa.remove(valor.getId());//borra todo, clave y valor. podriamos poner también getNombre() pero lo habitual es usar el Id porque es unico
    }

    @Override
    public void eliminar(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        mapa.remove(id); //borra todo, clave y valor
    }

    @Override
    public List<T> leerTodos() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    ArrayList<T> listaleida;
    listaleida= new ArrayList<>();
    
    for (Map.Entry<Long,T> parClaveValor : mapa.entrySet()){
        T Tvalue = parClaveValor.getValue();
        listaleida.add(Tvalue);
     }
    //List listaleidaLista = (List) listaleida; //no es necesario
    return listaleida; //no hace falta hacer el cast porque ArrayList es hija de List. Ya hace el cast implícito
    }

    /*@Override //lo quitamos porque la clase genérica no tendrá activo ni email
    public T modificar(T nuevoValor) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      T clienteModificado = mapa.get(nuevoValor.getId());
      String nuevoEmail = nuevoValor.getEmail();
      clienteModificado.setEmail(nuevoEmail);
      clienteModificado.setNombre(nuevoValor.getNombre());
      clienteModificado.setActivo(nuevoValor.isActivo());
      //System.out.println(mapa.get(nuevoValor.getId()).getNombre());
      //return true; //con boolean
      return clienteModificado;        
    }
    */

    //otra forma usando replace
    @Override
    public void modificar2(T nuevoValor) {
       mapa.replace(nuevoValor.getId(),nuevoValor);
    }
    
    
    
}


