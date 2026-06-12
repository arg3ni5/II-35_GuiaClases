/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase10;

/**
 *
 * @author fbarg
 */
public class Clase10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ListaDoble<Cancion> 
        ListaDoble<Character> lista = new ListaDoble<>();
        
        //Ejemplo 1
        // Agregar elementos al final
//        lista.agregarEnCabeza('A');
//        lista.agregarEnCabeza('B');
//        lista.agregarEnCabeza('C');
//        
//        lista.mostrarDesdeCabeza();
//        lista.mostrarDesdeCola();

        //Ejemplo 2
//        // Agregar elementos a la lista
//        lista.agregarEnCabeza('A');        
//        lista.agregarEnCola('B');        
//        lista.agregarEnCola('C');        
//        lista.agregarEnCabeza('D');
//        
//        System.out.println("RESULTADO FINAL");
//        lista.mostrarDesdeCabeza();
//        lista.mostrarDesdeCola();
//        System.out.println(lista.getCola().anterior.dato);
//        System.out.println(lista.getCabeza().anterior);
        

//        lista.agregarEnCabeza('D');
//        lista.agregarEnCabeza('E');
//        lista.mostrarDesdeCabeza();
//        lista.mostrarDesdeCola();
//        
//        System.out.println(lista.buscar('B'));
//        
//        lista.eliminar('C');
//        lista.mostrarDesdeCabeza();
//        lista.mostrarDesdeCola();
//        System.out.println(lista.getCola().anterior.dato);
//        lista.agregarEnCola('B');
//        lista.agregarEnCola('C');
//        lista.agregarEnCola('D');
//        lista.agregarEnCola('A');

          //FABIAN
          Character f = 'F';
          Character a = 'A';
          Character b = 'B';
          Character i = 'I';
          Character n = 'N';          
          
          lista.agregarEnCabeza(b);
          lista.agregarEnCola(i);
          lista.agregarEnCabeza(a);
          lista.agregarEnCola(a);
          lista.agregarEnCabeza(f);
          lista.agregarEnCola(n);
          
          lista.unir();
          
          //Palindromo RADAR
          Character r = 'R'; 
          Character d = 'D'; 
          ListaDoble<Character> listaPal = new ListaDoble<>();
          listaPal.agregarEnCabeza(r);
          listaPal.agregarEnCabeza(a);
          listaPal.agregarEnCabeza(d);
          listaPal.agregarEnCabeza(a);
          listaPal.agregarEnCabeza(r);
          listaPal.unir();
    }

}
