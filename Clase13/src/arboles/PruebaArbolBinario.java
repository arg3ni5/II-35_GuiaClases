/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author fbarg
 */
public class PruebaArbolBinario {

    public static void main(String[] args) {
        // Crear un árbol binario
        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        // Prueba de inserción
        System.out.println("Insertando elementos en el árbol:");
        arbol.insertar(5);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(7);

        // Mostrar la raíz del árbol
        System.out.println("Raíz del árbol: " + arbol.getRaiz().getDato());
//
        // Prueba de recorrido en orden
        System.out.println("\nRecorrido en orden (in-order):");
        arbol.inOrden(arbol.getRaiz());
//
        // Prueba de recorrido preorden
        System.out.println("\nRecorrido preorden (pre-order):");
        arbol.preOrden(arbol.getRaiz());
//
        // Prueba de recorrido postorden
        System.out.println("\nRecorrido postorden (post-order):");
        arbol.postOrden(arbol.getRaiz());
//
//        // Obtener nodos en orden
//        System.out.println("\nNodos en orden (in-order) como arreglo:");
//        Nodo<Integer>[] nodosEnOrden = arbol.obtenerNodosEnOrden();
//        for (Nodo<Integer> nodo : nodosEnOrden) {
//            System.out.print(nodo.getDato() + " ");
//        }
//
//        // Obtener nodos en orden
//        System.out.println("\nNodos Queue:");
//        Queue<Nodo<Integer>> nodos = arbol.obtenerNodos();
//        for (Nodo<Integer> nodo : nodos) {
//            System.out.print(nodo.getDato() + " ");
//        }
//
//        // Contar nodos
//        int totalNodos = arbol.contarNodos();
//        System.out.println("\n\nTotal de nodos en el árbol: " + totalNodos);
//
//        // Calcular altura del árbol
//        int altura = arbol.altura();
//        System.out.println("Altura del árbol: " + altura);
//
//        // Prueba de inserción con comparador personalizado
//        ArbolBinario<String> arbolString = new ArbolBinario<>();
//
//        System.out.println("\nInsertando elementos en un árbol de cadenas:");
//        arbolString.insertar("banana");
//        arbolString.insertar("manzana");
//        arbolString.insertar("kiwi");
//
//        System.out.println("Raíz del árbol de cadenas: " + arbolString.getRaiz().getDato());
//
//        System.out.println("\nRecorrido en orden (in-order) del árbol de cadenas:");
//        arbolString.inOrden(arbolString.getRaiz());
//
////        Queue<Nodo<Integer>> colaNodos = new LinkedList<>();
////        colaNodos.add(new Nodo(5));
////        colaNodos.add(new Nodo(3));
////        colaNodos.add(new Nodo(7));
////        colaNodos.add(new Nodo(2));
////        colaNodos.add(new Nodo(4));
////        colaNodos.add(new Nodo(6));
////        colaNodos.add(new Nodo(8));
//        System.out.println("buscar(10)" + arbol.buscar(10));
//        System.out.println("buscar(7)" + arbol.buscar(7));
//
//        arbol.eliminar(7);
//        arbol.eliminar(2);
//        
//        // Obtener nodos en orden
//        System.out.println("\nNodos Queue:");
//        Queue<Nodo<Integer>> nodos2 = arbol.obtenerNodos();
//        for (Nodo<Integer> nodo : nodos2) {
//            System.out.print(nodo.getDato() + " ");
//        }
//        
        
    }
}
