package pkg01_ejemplojava;

public class Main {

    public static void main(String[] args) {
        boolean condicion = 5 == 5 && true;
        if (3 > 5){
        if (condicion || false){
            System.out.println("Es verdadero");
      }
            
      } else if (5 > 7) {
            System.out.println("No se ejecuta");
      } else if (8 > 9) {
            System.out.println("No se ejecuta");
      } else {
          System.out.println("Cualquier otro caso");
      }
        
       char letra = 'B';
       switch (letra){
           case 'A':
               System.out.println("AAAAA");
           case 'B':
               System.out.println("BBBBB");/*como coincide lo ejecuta todo*/
           case 'C':
               System.out.println("CCCC"); 
       }
       
         switch (letra){
           case 'A':
               System.out.println("AAAAA");
               break;
           case 'B':
               System.out.println("BBBBB");
               break; /*hay que poner breaks*/
           case 'C':
               System.out.println("CCCC");
               break;
       }
         String formateado = nombreApell("German","Caballero Rodríguez");
         System.err.println(formateado);
 
    Tucan miPajaro; /*declarar la variable*/
    miPajaro = new Tucan();/*crear un objeto de tipo tucan*/
    miPajaro.longitud = 20.5F;
    System.out.println("Long tucan: " + miPajaro.longitud);
      
    Tucan otroPajaro;
    otroPajaro = new Tucan();
    otroPajaro.longitud = 30.9F; 

    
    System.out.println("Mi tucan: " + miPajaro.longitud);
    System.out.println("Otro tucan: " + otroPajaro); /*guardamos la referencia, no el objeto*/
    System.out.println("Otro tucan: " + otroPajaro.longitud);   
 
    otroPajaro = miPajaro;  /*los dos objetos van destinados a la misma memoria*/
    System.out.println("Otro tucan: " + otroPajaro.longitud); 
   
    miPajaro.longitud = 67.6F;
    System.out.println("Otro tucan: " + otroPajaro.longitud);
    
    otroPajaro.edad = 11;
    System.out.println("Edad de mi pájaro: " + miPajaro.edad);

    otroPajaro.piar();
    miPajaro.piar();

    Tucan nuevoTuc = new Tucan();
        System.out.println("longitud del recien nacido: " + 
                nuevoTuc.longitud);
    }  
    
        
 /*funcion*/
 static String nombreApell(String nombre,String apellidos){
         return apellidos + ", " + nombre;
    
    }
}
