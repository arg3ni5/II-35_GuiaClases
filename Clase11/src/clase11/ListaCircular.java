/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase11;

/**
 *
 * @author fbarg
 */
public class ListaCircular<T> {

    private Nodo<T> cabeza;

    public ListaCircular() {
        cabeza = null;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void agregar(T dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza; // Apunta a sí mismo
            cabeza.anterior = cabeza; // Apunta a sí mismo
        } else {
            Nodo actual = cabeza.anterior; // Último nodo
            actual.siguiente = nuevoNodo;
            
            nuevoNodo.anterior = actual;
            nuevoNodo.siguiente = cabeza; // Conectar al inicio
            cabeza.anterior = nuevoNodo; // Conectar el inicio al nuevo nodo
        }
    }

    // Método para buscar un elemento en la lista
    public boolean buscar(T valor) {
        if (cabeza == null) {
            return false; // La lista está vacía
        }

        Nodo actual = cabeza;
        do {
            if (actual.dato == valor) {
                return true; // Valor encontrado
            }
            actual = actual.siguiente; // Moverse al siguiente nodo
        } while (actual != cabeza); // Continuar hasta volver al inicio

        return false; // Valor no encontrado
    }
    
        // Método para buscar un elemento en la lista
    public Nodo buscarNodo(T valor) {
        if (cabeza == null) {
            return null; // La lista está vacía
        }

        Nodo actual = cabeza;
        do {
            if (actual.dato == valor) {
                return actual; // Valor encontrado
            }
            actual = actual.siguiente; // Moverse al siguiente nodo
        } while (actual != cabeza); // Continuar hasta volver al inicio

        return null; // Valor no encontrado
    }

    // Método para mostrar todos los elementos de la lista
    public void mostrar() {
        if (cabeza != null) {
            Nodo actual = cabeza;
            do {
                System.out.print(actual.dato + "<-"); // Mostrar el dato del nodo actual
                actual = actual.siguiente; // Moverse al siguiente nodo
            } while (actual != cabeza); // Continuar hasta volver al inicio
            System.out.println();
        } else {
            System.out.println("La lista está vacía.");
        }
    }

}
