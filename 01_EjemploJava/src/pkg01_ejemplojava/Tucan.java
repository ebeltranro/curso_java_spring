package pkg01_ejemplojava;


/**clase para tucan*/
public class Tucan {
    
    String[] colores;
    float longitud;
    int edad;
    
  /*el constructor Object que es el por defecto los pone a 0, pero ahora
    los valores iniciales son los del constructor Tucan
    */
    
public Tucan(){ /*constructor, valores iniciales de la clase*/
/*valores de los tucanes al nacer*/
    this.edad = 0; /*redundante porque ya era 0*/
    longitud = 5f; /*da igual this. que sin this*/
    colores = new String[] {"blanco","marron"};
    
}
/**pajaro dice pio pio y la edad*/

public void piar(){ /*metodo*/
    System.out.println("Pio pio " + edad + " años");
}


}