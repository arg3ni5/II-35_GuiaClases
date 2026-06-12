package clase8;

import java.util.Stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author fbarg
 * @param <T>
 */
public class ListaEnlazada<T> {

    private Nodo cabeza;// Primer  nodo de la lista   
    private Stack<T> eliminados; //Pila con los eliminados

    public ListaEnlazada() {
        this.cabeza = null; // Lista vacia
        this.eliminados = new Stack<T>();
    }


    public void agregar(T dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (getCabeza() == null) {
            cabeza = nuevoNodo; //Si la lista esta vacia
        } else {
            Nodo actual = getCabeza();

            while (actual.siguiente != null) {
                actual = actual.siguiente; //Avanzar hasta el ultimo nodo
            }

            actual.siguiente = nuevoNodo;
        }
        mostrar();
    }

    public void mostrar() {
        Nodo actual = getCabeza();
        while (actual != null) {
            System.out.print(actual.dato + "->"); // Mostrar el dato
            actual = actual.siguiente; //Avanzar al siguiente nodo
        }
        System.out.println("[]");
    }

    public Nodo buscarNodo(T dato) {
        Nodo actual = getCabeza(); //Comenzamos con el tope o cabeza

        while (actual != null) { // Recorrer hasta el final de lista
            if (actual.dato == dato) { //Comparamos el dato con el dato del nodo actual
                return actual;
            }
            // actual se convierte en el siguiente nodo(refencia)
            actual = actual.siguiente;
        }

        return null; // Si no se encuentra
    }

    public String buscar(T dato) {
        Nodo actual = getCabeza(); //Comenzamos con el tope o cabeza

        while (actual != null) { // Recorrer hasta el final de lista
            if (actual.dato == dato) { //Comparamos el dato con el dato del nodo actual
                return "Elemento " + dato + " encontrado en la lista.";
            }
            // actual se convierte en el siguiente nodo(refencia)
            actual = actual.siguiente;
        }

        return "Elemento " + dato + " no encontrado en la lista."; // Si no se encuentra
    }

    public boolean eliminar(T dato) {
        // Vacio no se puede eliminar
        if (isEmpty()) {
            return false;
        }

        // Caso 1: Eliminar la cabeza
        if (getCabeza().dato == dato) {            
            eliminados.push((T) getCabeza().dato);
            cabeza = getCabeza().siguiente; // Moviendo la cabeza al siguiente nodo 
            return true;
        }
        // Caso 2: Buscar el nodo a eliminar        
        Nodo actual = getCabeza();
        Nodo anterior = getCabeza();

        while (actual != null && actual.dato != dato) {
            anterior = actual; //Guardar referencia  al nodo anterior
            actual = actual.siguiente; //Avanzar al siguiente nodo
        }

        // Si no se encontró el nodo
        if (actual == null) {
            return false; // Dato no encontrado, no se puede eliminar
        }

        // Eliminando lo encontrado
        eliminados.push((T) actual.dato);
        anterior.siguiente = actual.siguiente; //Saltar el nodo actual       

        mostrar();
        return true;
    }

    /**
     * @return the cabeza
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public Stack<T> getEliminados() {
        return eliminados;
    }

}
