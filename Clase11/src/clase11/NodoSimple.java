/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase11;

/**
 *
 * @author fbarg
 */
public class NodoSimple<T> {
    T dato; // Tipo genérico
    NodoSimple siguiente;

    public NodoSimple(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        return "NodoSimple{" + "dato=" + dato + ", siguiente=" + siguiente + '}';
    }    
}
