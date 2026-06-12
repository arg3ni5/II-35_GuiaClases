/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase11;

/**
 *
 * @author fbarg
 */
public class Clase11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaCircular<Character> lista = new ListaCircular();
        lista.agregar('A');
        lista.agregar('B');
        lista.agregar('C');
        System.out.println(lista.getCabeza().dato);
        System.out.println("anterior:"+lista.getCabeza().anterior.dato);
        System.out.println("siguiente:"+lista.getCabeza().siguiente.dato);
        
        Nodo sig = lista.getCabeza().siguiente;
        System.out.println(sig.dato);
        System.out.println("anterior:"+sig.anterior.dato);
        System.out.println("siguiente:"+sig.siguiente.dato);
        
        Nodo sigSig = sig.siguiente;
        System.out.println(sigSig.dato);
        System.out.println("anterior:"+sigSig.anterior.dato);
        System.out.println("siguiente:"+sigSig.siguiente.dato);
//        lista.mostrar();
//        ListaCircularSimple<Integer> lista = new ListaCircularSimple<>();
//
//        // Agregar elementos a la lista
//        lista.agregar(10);
//        lista.agregar(20);
//        lista.agregar(30);
//
////        lista.agregar(30);
////        lista.agregar(40);
////        lista.agregar(50);
//        lista.mostrar();
//        
//        System.out.println("Cabeza dato" + lista.getCabeza().dato);        
//        System.out.println("Anterior Cabeza dato:" + lista.getCabeza().anterior.dato);
//        
//        
//        System.out.println("Encontrado: " + lista.buscar(20));
//        System.out.println("Nodo: " + lista.buscarNodo(20));
//        System.out.println("Encontrado: " + lista.buscar(100));

//        ListaCircularDoble<Integer> listad = new ListaCircularDoble<>();
//        listad.agregar(10);
//        listad.agregar(20);
//        listad.agregar(30);
//
//        listad.mostrarAdelante();
//        listad.mostrarAtras();
    }

}
