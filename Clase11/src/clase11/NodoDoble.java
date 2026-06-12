/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase11;

/**
 *
 * @author fbarg
 */
public class NodoDoble<T> {
    
    T dato; // Tipo genérico
    NodoDoble<T> siguiente;
    NodoDoble<T> anterior;

    public NodoDoble(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", siguiente=" + siguiente + ", anterior=" + anterior + '}';
    }    
}
