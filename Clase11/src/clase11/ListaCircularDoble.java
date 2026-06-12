/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase11;

/**
 *
 * @author fbarg
 */
public class ListaCircularDoble<T> {

    private NodoDoble<T> cabeza = null;
    private NodoDoble<T> cola = null;

    public void agregar(T dato) {
        NodoDoble nuevo = new NodoDoble(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            nuevo.siguiente = cabeza;
            nuevo.anterior = cola;

            cola.anterior = nuevo;
            cola.siguiente = nuevo;

            cola = nuevo;
        }
    }

    public void mostrarAdelante() {
        if (cabeza == null) {
            System.out.println("Lista vacia.");
            return;
        }

        System.out.print("\nLista hacia Adelante: ");
        NodoDoble actual = cabeza;
        do {
            System.out.print(actual.dato + "<-->");
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void mostrarAtras() {
        if (cola == null) {
            System.out.println("Lista vacia.");
            return;
        }

        System.out.print("\nLista hacia Atras: ");
        NodoDoble actual = cola;
        do {
            System.out.print(actual.dato + "<-->");
            actual = actual.anterior;
        } while (actual != cola);
        System.out.print(cabeza.dato + "<-->");
    }

}
