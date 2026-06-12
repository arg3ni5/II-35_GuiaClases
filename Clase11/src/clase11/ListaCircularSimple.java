/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase11;

/**
 *
 * @author fbarg
 */
public class ListaCircularSimple<T> {

    private NodoSimple<T> cabeza = null;
    private NodoSimple<T> cola = null;

    public void agregar(T dato) {
        NodoSimple nuevo = new NodoSimple(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacia.");
            return;
        }

        System.out.print("Lista: ");
        NodoSimple actual = cabeza;
        do {
            System.out.print(actual.dato + "-->");
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public NodoSimple<T> getCabeza() {
        return cabeza;
    }
    
    
}
