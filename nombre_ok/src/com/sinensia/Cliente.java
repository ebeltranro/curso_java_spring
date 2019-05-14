package com.sinensia;



public class Cliente extends Entidad implements Comparable<Cliente>{ //para que adquiera el método getId //Comparable es una
    //interfaz que contiene java
    
   //las propiedades de una clase siempre privadas o protected
   //protected long id; /*todos los campos privados para evitar lios*/ Lo quitamos porque lo tiene la clase Entidad
   protected String nombre; /*Sring es cadena de texto*/ //protected solo publico para los hijos
   private String email; 
   private boolean activo;
   private char genero; /*char es una letra*/

   
   /*   
    otra opcion es crear un constructor que no reciba parámetros
   
   public cliente () {
   
   }
   */
            
    //constructor
    public Cliente(long id, String nombre, String email)  {
        super(id);//mejor llamamos al constructor del padre
        //this.id = id; /*la palabra this para refererirnos al objeto pero puede 
        /*confundir con el parámetro. this al campo, sin this al valor
        */

        this.nombre = nombre;
                if (nombre == null  || nombre == "") { //si no hay nombre que pare el programa
                System.err.println("Nombre del cliente invalido");
                        }
        this.email = email;
        this.activo = true; /*no está añadido como opción*/
    }
    

    
    /*otra opcion
        public cliente(long nid, String nom, String em) {
        id = nd;
        nombre = nom;
        email = em;
        activo = true;
    }
    */
        


    public String getNombre() {
        return nombre;
    } //String es el tipo de dato que devuelve

    public String getEmail() {
        return email;
    }

    public boolean isActivo() {
        return activo;
    } //los booleanos uasn is en lugar de get

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setEmail(String email) {
        this.email = email;
    } //void es lo que devuelve; en este caso vacío porque es setter

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void mostrar() {
        System.out.println("MOSTRAR CLIENTE NORMAL ");
        System.out.println("Cliente " + nombre);//aunque sea privado, al estar en la misma clase podemos acceder; pero el fichero principal no puede acceder
        System.out.println("Id " + this.id);//se puede poner el this o no; es igual
        System.out.println("Email " + this.getEmail());//getEmail es publico asi que puede acceder el fichero principal
    }

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "Cliente [" + id + "," + nombre + ", " + email + "]";
    }

    
    
    public void setDuracionMax(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override //sobreescribimos el método de la interfaz
    public int compareTo(Cliente otrocli) {
        //Comparamos por nombre
        if (nombre.compareTo(otrocli.nombre) == 0){
        //Si son iguales comparamos por email
            return email.compareTo(otrocli.email);
        } else{ //Si son distintos devolvemos la comparación del nombre
            return nombre.compareTo(otrocli.nombre);
        }
            
    }

}

